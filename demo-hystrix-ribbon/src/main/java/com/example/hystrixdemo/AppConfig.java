package com.example.hystrixdemo;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lwl
 * @date 2019/3/8 17:05
 * @description
 */
@Configuration
public class AppConfig {
    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    /**
     * 负载均衡策略，如果这个配置类在根路径下，则所有的请求都会用这个
     * @return
     */
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}