package com.lwl.config;

import com.lwl.MyCachingFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * <p>Title: FeignConfig</p>
 * <p>Description: FeignConfig</p>
 * <p>Company: sanjieke</p>
 *
 * @author liuweilong
 * @version 1.0
 * @date 2020/11/13
 */
@Configuration(proxyBeanMethods = false)
public class FeignConfig {

    @Bean
    @Primary
    @ConditionalOnMissingBean
    @ConditionalOnMissingClass("org.springframework.retry.support.RetryTemplate")
    public CachingSpringLoadBalancerFactory cachingLBClientFactory(
            SpringClientFactory factory) {
        return new MyCachingFactory(factory);
    }
}
