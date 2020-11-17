package com.lwl.gateway.config;

import com.lwl.gateway.filter.ServiceHiLBGatewayFilter;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.gateway.config.LoadBalancerProperties;
import org.springframework.cloud.gateway.filter.LoadBalancerClientFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: FilterConfig</p>
 * <p>Description: FilterConfig</p>
 * <p>Company: sanjieke</p>
 *
 * @author liuweilong
 * @version 1.0
 * @date 2020/7/21
 */
//@Configuration
public class FilterConfig {
    @Bean
    public LoadBalancerClientFilter webSocketLBGatewayFilter(LoadBalancerClient loadBalancerClient) {
        return new ServiceHiLBGatewayFilter(loadBalancerClient, new LoadBalancerProperties());
    }
}
