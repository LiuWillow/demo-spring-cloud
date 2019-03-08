package com.lwl;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * date  2018/6/13
 * author liuwillow
 **/
@FeignClient(value = "service-hi")
@Service
public interface HiService {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String serviceHi();
}
