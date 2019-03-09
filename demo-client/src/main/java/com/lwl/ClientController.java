package com.lwl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String home(){
        return "port:" + port;
    }
}