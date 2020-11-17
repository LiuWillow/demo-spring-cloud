package com.lwl.democlient.service;

import com.alibaba.fastjson.JSONObject;
import com.lwl.democlient.model.TestDTO;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * <p>Title: RedisListener</p>
 * <p>Description: RedisListener</p>
 * <p>Company: sanjieke</p>
 *
 * @author liuweilong
 * @version 1.0
 * @date 2020/8/3
 */
@Component
public class ShitListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        final String msg = new String(message.getBody());
        final String channel = new String(message.getChannel());
        System.out.println("我是不能监听,监听"+channel+",我收到消息："+msg);
        final TestDTO testDTO = JSONObject.parseObject(msg, TestDTO.class);
        System.out.println(testDTO);
    }
}