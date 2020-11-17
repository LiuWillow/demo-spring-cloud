package com.lwl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * date  2018/6/13
 * author liuwillow
 **/
@FeignClient(value = "service-hi")
@Service
@RequestMapping("/service")
public interface HiClient {
    @PostMapping(value = "/hi")
    String serviceHi(@RequestBody TestParam testParam, @RequestHeader("lbKey") Object lbKey);
}

