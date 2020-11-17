//package com.lwl;
//
//import com.netflix.client.ClientRequest;
//import com.netflix.client.IResponse;
//import com.netflix.client.RequestSpecificRetryHandler;
//import com.netflix.client.config.IClientConfig;
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.springframework.cloud.netflix.ribbon.ServerIntrospector;
//import org.springframework.cloud.netflix.ribbon.support.AbstractLoadBalancingClient;
//import org.springframework.stereotype.Service;
//
///**
// * <p>Title: MyRequestInterceptor</p>
// * <p>Description: MyRequestInterceptor</p>
// * <p>Company: sanjieke</p>
// *
// * @author liuweilong
// * @version 1.0
// * @date 2020/7/26
// */
//@Service
//public class MyLoadBalacingClient extends AbstractLoadBalancingClient {
//    protected MyLoadBalacingClient(IClientConfig config, ServerIntrospector serverIntrospector) {
//        super(config, serverIntrospector);
//    }
//
//    protected MyLoadBalacingClient(Object delegate, IClientConfig config, ServerIntrospector serverIntrospector) {
//        super(delegate, config, serverIntrospector);
//    }
//
//    @Override
//    protected Object createDelegate(IClientConfig config) {
//        return null;
//    }
//
//    @Override
//    public RequestSpecificRetryHandler getRequestSpecificRetryHandler(ClientRequest request, IClientConfig requestConfig) {
//        return null;
//    }
//
//    @Override
//    public IResponse execute(ClientRequest request, IClientConfig requestConfig) throws Exception {
//        return null;
//    }
//}
