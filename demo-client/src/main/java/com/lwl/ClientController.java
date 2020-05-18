package com.lwl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/hi")
    public String home() {
        return "port:" + port;
    }

    @RequestMapping("/header/route")
    public String headerRoute(String lalal, @RequestBody String hah) {
        return "header route port:" + port + "  " + lalal + "  " + hah;
    }

    /**
     * 出异常就调用defaultStores
     */
    @HystrixCommand(fallbackMethod = "defaultStores")
    public Object getStores(Map<String, Object> parameters) {
        //do stuff that might fail
        return "success";
    }

    public Object defaultStores(Map<String, Object> parameters) {
        return "error";
    }
}