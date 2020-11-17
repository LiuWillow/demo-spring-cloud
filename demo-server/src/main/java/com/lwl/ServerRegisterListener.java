package com.lwl;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * author liuweilong
 * date 2020/2/7 10:44 上午
 * desc
 */
@Slf4j
@Component
public class ServerRegisterListener {
    @EventListener
    public void listenInstanceCanceledEvent(EurekaInstanceCanceledEvent event) {
        if (event.isReplication()) {
            log.info("服务名称:{} instanceId：{}  下线", event.getAppName(), event.getServerId());
        }
    }

    @EventListener
    public void listenInstanceRegistered(EurekaInstanceRegisteredEvent event) {
        final InstanceInfo instanceInfo = event.getInstanceInfo();
        if (InstanceInfo.InstanceStatus.UP.equals(instanceInfo.getStatus()) && event.isReplication()) {
            log.info("服务名:{} instanceId:{} 上线", instanceInfo.getAppName(), instanceInfo.getInstanceId());
        }
    }
}
