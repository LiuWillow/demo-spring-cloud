package com.lwl.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.gateway.config.LoadBalancerProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.LoadBalancerClientFilter;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;

/**
 * @author liuweilong
 * @date 2020/7/21
 **/
@Slf4j
public class ServiceHiLBGatewayFilter extends LoadBalancerClientFilter {

    private static final String WEBSOCKET_SCHEMA = "ws";

    private static final String WEBSOCKET_SSL_SCHEMA = "wss";

    public ServiceHiLBGatewayFilter(LoadBalancerClient loadBalancer, LoadBalancerProperties properties) {
        super(loadBalancer, properties);
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return super.filter(exchange, chain);
    }

    @Override
    protected ServiceInstance choose(ServerWebExchange exchange) {
        log.info("------进入自定义的选择器");
        URI uri =  exchange.getAttribute(GATEWAY_REQUEST_URL_ATTR);

        RibbonLoadBalancerClient client;
        if (loadBalancer instanceof RibbonLoadBalancerClient) {
            client = (RibbonLoadBalancerClient) loadBalancer;
            ServiceInstance chose = client.choose("service-hi", "lala");
            log.info("选择instance,  {}", chose);
            return chose;
        }
        return loadBalancer.choose("default");
    }

    public static void main(String[] args) {
        Flux.range(1, 10).subscribe(System.out::println);
    }
}