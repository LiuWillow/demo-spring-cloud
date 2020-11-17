package com.lwl.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @author wangjiawei
 * @date 2020/5/13
 **/
public class ServiceHiRibbonConfig {

    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}