package com.mod.mycat.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DruidProperties {
    private String url;
    private String username;
    private String password;
    @Value("${spring.datasource.driverClassName}")
    private String driverClass;
    private int maxActive;//最大连接数
    private int minIdle;//最小连接数
    private int initialSize;//初始化数量和
    private boolean testOnBorrow;
    private Long timeBetweenEvictionRunsMillis;//心跳
}
