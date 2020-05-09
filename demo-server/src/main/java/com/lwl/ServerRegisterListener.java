package com.lwl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 * author liuweilong
 * date 2020/2/7 10:44 上午
 * desc
 */
@Slf4j
@Component
public class ServerRegisterListener {

    /**
     * 服务下线事件监听
     * @param event
     */
    @EventListener
    public void listenInstanceCanceledEvent(EurekaInstanceCanceledEvent event){
        log.info("服务名称:{} ID：{}  下线",event.getAppName(),event.getServerId());
        //removeServer(event.getAppName(),event.getServerId());
    }

    /**
     * 服务注册上线事件监听
     * @param event
     */
    @EventListener
    public void listenInstanceRegistered(EurekaInstanceRegisteredEvent event) {
        log.info("服务名称:{} ID：{}  上线",event.getInstanceInfo().getAppName(),event.getInstanceInfo().getId());
        //addServer(event.getInstanceInfo().getAppName(),event.getInstanceInfo().getId());
    }

    /**
     * 服务重连事件监听
     * @param event
     */
    @EventListener
    public void listenInstanceRenewedEvent(EurekaInstanceRenewedEvent event) {
        log.info("服务名称:{} ID：{}  重连",event.getAppName(),event.getServerId(),event);
        //addServer(event.getAppName(),event.getServerId());
    }

//    /**
//     * 将服务器加入到hash环中
//     * @param serverId
//     */
//    private void addServer(String serverName,String serverId){
//        // 如果上线的是websocket服务
//        if (serverName.equals(SERVER_NAME)){
//            // 1 将新注册的服务加入到hash环中
//            Set<String> set = ConsistentHashUtils.addServer(serverId,virtualNodes);
//            log.info("服务器hash环列表:" + JSON.toJSONString(virtualNodes));
//            // 2 向redis发布新的hash环
//            redisTemplate.convertAndSend(ConsistentHashUtils.SERVER, JSON.toJSONString(virtualNodes));
//            // 3 向redis发布受影响的服务器ID
//            if (CollectionUtils.isEmpty(set)){
//                return;
//            }
//            redisTemplate.convertAndSend(ConsistentHashUtils.IMPACT_SERVER,JSON.toJSONString(set));
//        }
//    }
//
//    private void removeServer(String serverName,String serverId){
//        if (serverName.equals(SERVER_NAME)){
//            // 1 将新注册的服务加入到hash环中
//            ConsistentHashUtils.removeServer(serverId,virtualNodes);
//            // 2 向redis发布新的hash环
//            redisTemplate.convertAndSend(ConsistentHashUtils.SERVER, JSON.toJSONString(virtualNodes));
//        }
//    }
}
