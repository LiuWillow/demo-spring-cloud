package com.lwl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * date  2018/6/13
 * author liuwillow
 **/
@Service
public class HiService {
    @Autowired
    private RestTemplate restTemplate;

    public String hi(){
        return restTemplate.getForObject("http://service-hi/hi", String.class);
    }
}
