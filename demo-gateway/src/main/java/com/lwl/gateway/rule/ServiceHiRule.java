package com.lwl.gateway.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Title: ServiceHiRule</p>
 * <p>Description: ServiceHiRule</p>
 * <p>Company: sanjieke</p>
 *
 * @author liuweilong
 * @version 1.0
 * @date 2020/7/21
 */
@Slf4j
public class ServiceHiRule  extends AbstractLoadBalancerRule implements InitializingBean {
    @Resource
    private DiscoveryClient discoverClient;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        log.info("-----进入自定义的负载均衡规则，key:{}", key);
        final List<ServiceInstance> instances = discoverClient.getInstances("service-websocket");
        List<Server> servers = this.getLoadBalancer().getReachableServers();
        if (servers == null || servers.isEmpty()){
            return null;
        }
        return randomChoose(servers);
    }

    private Server randomChoose(List<Server> servers) {
        int randomIndex = RandomUtils.nextInt(0, servers.size() - 1);
        return servers.get(randomIndex);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        final List<ServiceInstance> instances = discoverClient.getInstances("service-hi");
        System.out.println();
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void shiyishi(){
        System.out.println("调用ssssss");
    }
}
