//package com.lwl.democlient.config;
//
//import com.lwl.democlient.service.RedisListener;
//import com.lwl.democlient.service.ShitListener;
//import com.teammark.commons.util.RedisUtils;
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.listener.PatternTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
//
//import javax.annotation.Resource;
//import java.util.Objects;
//
///**
// * <p>Title: RedisConfig</p>
// * <p>Description: RedisConfig</p>
// * <p>Company: sanjieke</p>
// *
// * @author liuweilong
// * @version 1.0
// * @date 2020/8/3
// */
//@Configuration
//public class RedisConfig implements ApplicationContextAware {
//    private ApplicationContext applicationContext;
//
//    @Resource
//    private RedisListener redisListener;
//    @Resource
//    private ShitListener shitListener;
//
//    @Bean
//    public RedisUtils redisUtils(StringRedisTemplate redisTemplate) {
//        return new RedisUtils(redisTemplate);
//    }
//
//    @Bean
//    public RedisMessageListenerContainer listenerContainer(RedisConnectionFactory redisConnectionFactory){
//        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(redisConnectionFactory);
//        container.addMessageListener(new MessageListenerAdapter(redisListener, "getMessage"),
//                new PatternTopic("myTopic"));
//        return container;
//    }
//
//    @Bean
//    public RedisMessageListenerContainer defaultContainer(RedisConnectionFactory redisConnectionFactory){
//        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(redisConnectionFactory);
//        container.addMessageListener(new MessageListenerAdapter(shitListener, "getMessage"),
//                new PatternTopic("shitTopic"));
//        return container;
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
//}