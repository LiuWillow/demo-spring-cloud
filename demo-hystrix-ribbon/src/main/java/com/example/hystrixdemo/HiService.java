package com.example.hystrixdemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * date  2018/6/14
 * author liuwillow
 **/
@Service
public class HiService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(){
        return restTemplate.getForObject("http://service-hi/hi", String.class);
    }

    private String hiError(){
        return "hi-service error";
    }
}
