package com.lwl.gateway.config;

import com.google.errorprone.annotations.concurrent.LazyInit;
import com.lwl.gateway.filter.ServiceHiLBGatewayFilter;
import com.lwl.gateway.rule.ServiceHiRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

/**
 * <p>Title: ServiceHiRibbonCOnfig</p>
 * <p>Description: ServiceHiRibbonCOnfig</p>
 * <p>Company: sanjieke</p>
 *
 * @author liuweilong
 * @version 1.0
 * @date 2020/7/21
 */
public class ServiceHiRibbonConfig {
    @Bean
    public IRule rule() {
        return new ServiceHiRule();
    }
}
