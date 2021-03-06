package com.lwl;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lwl
 * @date 2019/3/8 16:36
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
     * TODO 了解一下有哪些负载均衡策略
     * @return
     */
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}