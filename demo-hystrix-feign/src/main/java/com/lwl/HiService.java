//package com.lwl;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
///**
// * date  2018/6/13
// * author liuwillow
// **/
//@FeignClient(value = "service-hi", fallback = HiServiceHystrix.class)
//@RequestMapping("/service")
//public interface HiService {
//    @PostMapping(value = "/hi")
//    String hi(@RequestBody TestParam testParam);
//}