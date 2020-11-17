//package com.lwl.democlient.service;
//
//import com.alibaba.fastjson.JSON;
//import com.lwl.democlient.model.TestDTO;
//import com.teammark.commons.util.RedisUtils;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//
///**
// * <p>Title: TestPublish</p>
// * <p>Description: TestPublish</p>
// * <p>Company: sanjieke</p>
// *
// * @author liuweilong
// * @version 1.0
// * @date 2020/8/3
// */
//@Service
//public class TestPublishService {
//    @Resource
//    private RedisUtils redisUtils;
//
//    public void publish(){
//        final TestDTO testDTO = new TestDTO();
//        testDTO.setInstanceId("111");
//        testDTO.setInstanceName("doc-web");
//        testDTO.setStatus(TestDTO.InstanceStatus.UP);
//        redisUtils.publish("myTopic", JSON.toJSONString(testDTO));
//        redisUtils.publish("shitTopic", JSON.toJSONString(testDTO));
//    }
//}
