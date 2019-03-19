package com.lwl;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author lwl
 * @date 2019/3/8 17:06
 * @description
 */
@RestController
public class ClientController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private EurekaClient discoveryClient;

    @GetMapping("/serviceUrl")
    public String serviceUrl(){
        //可以获取到serviceUrl
        InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka("service-hi", false);
        return instanceInfo.getHomePageUrl();
    }

    @RequestMapping("/hi")
    public String home(){
        return "port:" + port;
    }

    @HystrixCommand(fallbackMethod = "defaultStores")   //出异常就调用defaultStores
    public Object getStores(Map<String, Object> parameters) {
        //do stuff that might fail
        return "success";
    }

    public Object defaultStores(Map<String, Object> parameters) {
        return "error";
    }
}