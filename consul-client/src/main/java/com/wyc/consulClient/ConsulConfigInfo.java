package com.wyc.consulClient;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
//配置类
//@JsonIgnoreProperties("$$beanFactory")
@Configuration
@ConfigurationProperties(prefix = "config")
public class ConsulConfigInfo {
    private String name;
    private String info;


}
