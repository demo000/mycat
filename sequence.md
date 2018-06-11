# 全局序列号

## 8.1 全局序列号介绍
在实现分库分表的情况下，数据库自增主键已无法保证自增主键的全局唯一。为此，MyCat 提供了全局sequence，并且提供了包含本地配置和数据库配置等多种实现方式。

## 8.2 本地文件方式
**原理**：此方式MyCAT将sequence配置到文件中，当使用到sequence中的配置后，MyCAT会更下classpath中的sequence_conf.properties文件中sequence当前的值。
配置方式：
在sequence_conf.properties文件中做如下配置：
 ``` 
GLOBAL_SEQ.HISIDS=
GLOBAL_SEQ.MINID=1001
GLOBAL_SEQ.MAXID=1000000000
GLOBAL_SEQ.CURID=1000
 ``` 
其中HISIDS表示使用过的历史分段(一般无特殊需要可不配置)，MINID表示最小ID值，MAXID表示最大ID值，CURID表示当前ID值。
server.xml中配置：
 ``` 
<system><property name="sequnceHandlerType">0</property></system>
 ``` 
注：sequnceHandlerType需要配置为**`0`**，表示使用本地文件方式。

使用示例：
insert into table1(id,name) values(next value for MYCATSEQ_GLOBAL,‘test’);
缺点：当MyCAT重新发布后，配置文件中的sequence会恢复到初始值。
优点：本地加载，读取速度较快。

## 8.3 数据库方式
**原理**:在数据库中建立一张表，存放sequence名称(name)，sequence当前值(current_value)，步长(increment int类型每次读取多少个sequence，假设为K)等信息；
### Sequence获取步骤：
1).当初次使用该sequence时，根据传入的sequence名称，从数据库这张表中读取current_value，和increment到MyCat中，并将数据库中的current_value设置为原current_value值+increment值；
.MyCat将读取到current_value+increment作为本次要使用的sequence值，下次使用时，自动加1，当使用increment次后，执行步骤1)相同的操作.
MyCat负责维护这张表，用到哪些sequence，只需要在这张表中插入一条记录即可。若某次读取的sequence没有用完，系统就停掉了，则这次读取的sequence剩余值不会再使用。
### 配置方式：
server.xml配置：
```markdown
<system><property name="sequnceHandlerType">1</property></system>
```
注：sequnceHandlerType 需要配置为1，表示使用数据库方式生成sequence.
### 数据库配置：
* 1 创建MYCAT_SEQUENCE表  
    * 1.1 创建存放sequence的表
```markdown
DROP TABLE IF EXISTS MYCAT_SEQUENCE;
```
name sequence名  
current_value 当前value  
increment 增长步长! 可理解为mycat在数据库中一次读取多少个sequence. 当这些用完后, 下次再从数据库中读取.
```markdown
CREATE TABLE MYCAT_SEQUENCE (name VARCHAR(50) NOT NULL,current_value INT NOT NULL,increment INT NOT NULL DEFAULT 100, PRIMARY KEY(name)) ENGINE=InnoDB;
```
插入一条sequence  
```markdown
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES (‘GLOBAL’, 100000, 100);
```

* 2 创建相关function  
    * 2.1  获取当前sequence的值 (返回当前值,增量) 
    
```markdown
DROP FUNCTION IF EXISTS mycat_seq_currval;
DELIMITER
CREATE FUNCTION mycat_seq_currval(seq_name VARCHAR(50)) RETURNS varchar(64) CHARSET utf-8
DETERMINISTIC
BEGIN
DECLARE retval VARCHAR(64);
SET retval=“-999999999,null”;
SELECT concat(CAST(current_value AS CHAR),“,”,CAST(increment AS CHAR)) INTO retval FROM MYCAT_SEQUENCE WHERE name = seq_name;
RETURN retval;
END
DELIMITER;
```

    * 2.2 设置sequence值
    
```markdown
DROP FUNCTION IF EXISTS mycat_seq_setval;
DELIMITER
CREATE FUNCTION mycat_seq_setval(seq_name VARCHAR(50),value INTEGER) RETURNS varchar(64) CHARSET utf-8
DETERMINISTIC
BEGIN
UPDATE MYCAT_SEQUENCE
SET current_value = value
WHERE name = seq_name;
RETURN mycat_seq_currval(seq_name);
END
DELIMITER;
```  
    * 2.3 获取下一个sequence值
```markdown
DROP FUNCTION IF EXISTS mycat_seq_nextval;
DELIMITER
CREATE FUNCTION mycat_seq_nextval(seq_name VARCHAR(50)) RETURNS varchar(64) CHARSET utf-8
DETERMINISTIC
BEGIN
UPDATE MYCAT_SEQUENCE
SET current_value = current_value + increment WHERE name = seq_name;
RETURN mycat_seq_currval(seq_name);
END
DELIMITER;
```

* 3 
例如：
```markdown
USER_SEQ=test_dn1
```

注意：MYCAT_SEQUENCE表和以上的3个function，需要放在同一个节点上。function请直接在具体节点的数据库上执行，如果执行的时候报：
you might want to use the less safe log_bin_trust_function_creators variable
需要对数据库做如下设置：
windows下my.ini[mysqld]加上log_bin_trust_function_creators=1
linux下/etc/my.cnf下my.ini[mysqld]加上log_bin_trust_function_creators=1
修改完后，即可在mysql数据库中执行上面的函数.
使用示例：
insert into table1(id,name) values(next value for MYCATSEQ_GLOBAL,‘test’);
##8.4 本地时间戳方式 
ID= 64位二进制 (42(毫秒)+5(机器ID)+5(业务编码)+12(重复累加) 换算成十进制为18位数的long类型，每毫秒可以并发12位二进制的累加。
111
使用方式： a. 配置server.xml
```markdown
<property name="sequnceHandlerType">2</property> 
```
 b. 在mycat下配置：sequence_time_conf.properties 
 ```markdown
WORKID=0-31
```
 任意整数 DATAACENTERID=0-31 任意整数 多个个mycat节点下每个mycat配置的 WORKID，DATAACENTERID不同，组成唯一标识，总共支持32*32=1024种组合。 ID示例：56763083475511
## 分布式ZK ID生成器
```markdown
<property name="sequnceHandlerType">3</property>
```
Zk的连接信息统一在myid.properties的zkURL属性中配置。
基于ZK与本地配置的分布式ID生成器(可以通过ZK获取集群（机房）唯一InstanceID，也可以通过配置文件配置InstanceID)
ID结构：long 64位，ID最大可占63位
* |current time millis(微秒时间戳38位,可以使用17年)|clusterId（机房或者ZKid，通过配置文件配置5位）|instanceId（实例ID，可以通过ZK或者配置文件获取，5位）|threadId（线程ID，9位）|increment(自增,6位)
* 一共63位，可以承受单机房单机器单线程1000*(2^6)=640000的并发。
* 一共63位，可以承受单机房单机器单线程1000*(2^7)=1280000的并发。
* 无悲观锁，无强竞争，吞吐量更高
配置文件：sequence_distributed_conf.properties，只要配置里面：INSTANCEID=ZK就是从ZK上获取InstanceID。

## Zk递增方式
```markdown
<property name="sequnceHandlerType">4</property>
```
Zk的连接信息统一在myid.properties的zkURL属性中配置。
4 是 zookeeper 实现递增序列号
* 配置文件：sequence_conf.properties
* 只要配置好ZK地址和表名的如下属性
* TABLE.MINID 某线程当前区间内最小值
* TABLE.MAXID 某线程当前区间内最大值
* TABLE.CURID 某线程当前区间内当前值
* 文件配置的MAXID以及MINID决定每次取得区间，这个对于每个线程或者进程都有效
* 文件中的这三个属性配置只对第一个进程的第一个线程有效，其他线程和进程会动态读取ZK








