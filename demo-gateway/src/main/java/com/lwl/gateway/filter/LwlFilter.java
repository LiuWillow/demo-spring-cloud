package com.lwl.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author liuweilong
 * @description
 * @date 2019/6/3 13:51
 * GatewayFilter，需要配置在具体的路由下面，只作用于当前路由
 */
public class LwlFilter implements GatewayFilter, Ordered {
    private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(REQUEST_TIME_BEGIN, System.currentTimeMillis());
        return chain.filter(exchange).then(
                    Mono.fromRunnable(() -> {
                        Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
                        if (startTime != null) {
                            System.out.println(exchange.getRequest().getURI().getRawPath() + ": "
                                    + (System.currentTimeMillis() - startTime) + "ms");
                        }
                    })
        );
    }

    /**
     * order越小，优先级越高
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
