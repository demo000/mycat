/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : db1

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-06-10 12:53:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bookinfo`
-- ----------------------------
DROP TABLE IF EXISTS `bookinfo`;
CREATE TABLE `bookinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `author` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of bookinfo
-- ----------------------------
INSERT INTO `bookinfo` VALUES ('1', '骆驼祥子', '1005560778448834560');
INSERT INTO `bookinfo` VALUES ('2', '茶馆', '1005560778448834560');

-- ----------------------------
-- Table structure for `mycat_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `mycat_sequence`;
CREATE TABLE `mycat_sequence` (
  `name` varchar(50) NOT NULL,
  `current_value` int(11) NOT NULL,
  `increment` int(11) NOT NULL DEFAULT '100',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mycat_sequence
-- ----------------------------
INSERT INTO `mycat_sequence` VALUES ('BOOKINFO', '1000', '100');
INSERT INTO `mycat_sequence` VALUES ('ORDER', '1000', '100');
INSERT INTO `mycat_sequence` VALUES ('ORDERITEM', '1000', '100');
INSERT INTO `mycat_sequence` VALUES ('PRODUCT', '1000', '100');
INSERT INTO `mycat_sequence` VALUES ('PRODUCTITEM', '1000', '100');
INSERT INTO `mycat_sequence` VALUES ('USERINFO', '1000', '100');

-- ----------------------------
-- Table structure for `orderinfo`
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `total` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `addressId` bigint(20) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0' COMMENT '0待发货,1已发货,2已签收,3退款,4退货,5已完成,6作废',
  `payStatus` tinyint(1) DEFAULT '0' COMMENT '0未支付,1已支付',
  `payno` varchar(100) DEFAULT NULL COMMENT '支付单号',
  `expressNo` varchar(50) DEFAULT NULL COMMENT '快递单号',
  `express` varchar(50) DEFAULT NULL COMMENT '快递公司code',
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES ('1', '订单1', '1000000', '1005560778448834560', '2018-06-10 12:46:38', '北京', '1001', null, '1', '1', '1001001', '1212', '顺丰', '2018-06-10 12:46:38');

-- ----------------------------
-- Table structure for `orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `productName` varchar(50) DEFAULT NULL,
  `unit` varchar(50) DEFAULT NULL,
  `spec` varchar(50) DEFAULT NULL,
  `orderId` bigint(20) DEFAULT NULL,
  `num` int(5) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `total` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('1', 'iphonex', '台', '黑色', '1', '1', '1000000', '1000000');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `type` tinyint(2) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'iphonex', '1', 'iphone x全新设计');
INSERT INTO `product` VALUES ('2', 'iphone8', '1', 'iphone 8全新设计');

-- ----------------------------
-- Table structure for `productitem`
-- ----------------------------
DROP TABLE IF EXISTS `productitem`;
CREATE TABLE `productitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spec` varchar(50) DEFAULT NULL,
  `productName` varchar(50) DEFAULT NULL,
  `productId` bigint(20) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of productitem
-- ----------------------------
INSERT INTO `productitem` VALUES ('1', '红色', 'iphonex', '1', '台', '1000000');
INSERT INTO `productitem` VALUES ('2', '黑色', 'iphonex', '1', '台', '1100000');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `author` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1005560778448834561 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1005551099173801984', '广州', '张三', '98', null);
INSERT INTO `userinfo` VALUES ('1005560778448834560', '北京', '老舍', '100', null);

-- ----------------------------
-- Function structure for `mycat_seq_currval`
-- ----------------------------
DROP FUNCTION IF EXISTS `mycat_seq_currval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `mycat_seq_currval`(seq_name VARCHAR(50)) RETURNS varchar(64) CHARSET latin1
    DETERMINISTIC
BEGIN
    DECLARE retval VARCHAR(64);
    SET retval="-1,0";
    SELECT concat(CAST(current_value AS CHAR),",",CAST(increment AS CHAR) ) INTO retval 
        FROM MYCAT_SEQUENCE  WHERE name = seq_name;
    RETURN retval ;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `mycat_seq_nextval`
-- ----------------------------
DROP FUNCTION IF EXISTS `mycat_seq_nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `mycat_seq_nextval`(seq_name VARCHAR(50)) RETURNS varchar(64) CHARSET latin1
    DETERMINISTIC
BEGIN
    DECLARE retval VARCHAR(64);
    DECLARE val BIGINT;
    DECLARE inc INT;
    DECLARE seq_lock INT;
    set val = -1;
    set inc = 0;
    SET seq_lock = -1;
    SELECT GET_LOCK(seq_name, 15) into seq_lock;
    if seq_lock = 1 then
      SELECT current_value + increment, increment INTO val, inc 
          FROM MYCAT_SEQUENCE WHERE name = seq_name for update;
      if val != -1 then
          UPDATE MYCAT_SEQUENCE SET current_value = val WHERE name = seq_name;
      end if;
      SELECT RELEASE_LOCK(seq_name) into seq_lock;
    end if;
    SELECT concat(CAST((val - inc + 1) as CHAR),",",CAST(inc as CHAR)) INTO retval;
    RETURN retval;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `mycat_seq_setval`
-- ----------------------------
DROP FUNCTION IF EXISTS `mycat_seq_setval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `mycat_seq_setval`(seq_name VARCHAR(50), value INTEGER) RETURNS varchar(64) CHARSET latin1
    DETERMINISTIC
BEGIN
    DECLARE retval VARCHAR(64);
    DECLARE inc INT;
    SET inc = 0;
    SELECT increment INTO inc FROM MYCAT_SEQUENCE WHERE name = seq_name;
    UPDATE MYCAT_SEQUENCE SET current_value = value WHERE name = seq_name;
    SELECT concat(CAST(value as CHAR),",",CAST(inc as CHAR)) INTO retval;
    RETURN retval;
END
;;
DELIMITER ;
