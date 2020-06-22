package com.wyc.springcloud.config;

import com.netflix.hystrix.contrib.sample.stream.HystrixConfigSseServlet;
import com.netflix.loadbalancer.*;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletRegistration;

@Configuration
public class RibbonConfig {
    @Bean
    @LoadBalanced//负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Bean
    public IRule iRule(){
        //随机选取一个服务
        return new RandomRule();

        //return new RoundRobinRule();//轮训

//        return new PredicateBasedRule() {
//            @Override
//            public AbstractServerPredicate getPredicate() {
//                return null;
//            }
//        }
    }
//    @Bean
//    public ServletRegistrationBean hystrixMetricsStreamServlet(){
//        ServletRegistrationBean registration =
//                new ServletRegistrationBean(new HystrixConfigSseServlet());
//        registration.addUrlMappings("/actuator/hystrix.stream");
//        return  registration;
//    }
}
