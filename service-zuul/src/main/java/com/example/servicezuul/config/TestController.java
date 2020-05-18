package com.example.servicezuul.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.cloud.netflix.ribbon.apache.RibbonLoadBalancingHttpClient;
import org.springframework.cloud.netflix.zuul.filters.route.RibbonCommandFactory;
import org.springframework.cloud.netflix.zuul.filters.route.RibbonRoutingFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Field;

/**
 * author liuweilong
 * date 2020/5/12 10:02 下午
 * desc
 */
@RestController
public class TestController {
    @Resource
    private AbstractBeanFactory beanFactory;
    @Resource
    private RibbonRoutingFilter ribbonRoutingFilter;

    @RequestMapping("update")
    public String update(){
        final int i = ribbonRoutingFilter.filterOrder();
        final Class<? extends RibbonRoutingFilter> aClass = ribbonRoutingFilter.getClass();
        try {
            final Field ribbonCommandFactoryField = aClass.getDeclaredField("ribbonCommandFactory");
            ribbonCommandFactoryField.setAccessible(true);
            RibbonCommandFactory<?> factory = (RibbonCommandFactory<?>) ribbonCommandFactoryField.get(ribbonRoutingFilter);
//            factory.create()
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        final Object client = beanFactory.getBean("ribbonLoadBalancingHttpClient", RibbonLoadBalancingHttpClient.class, null);
//        final RibbonLoadBalancingHttpClient shit = context.getBean(RibbonLoadBalancingHttpClient.class);
//        final ZoneAwareLoadBalancer loadBalancer = (ZoneAwareLoadBalancer) shit.getLoadBalancer();
//        loadBalancer.updateListOfServers();
        return "success";
    }
}
