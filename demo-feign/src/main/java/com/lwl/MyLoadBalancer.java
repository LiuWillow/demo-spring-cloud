package com.lwl;

import com.netflix.client.ClientException;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import org.springframework.cloud.netflix.ribbon.ServerIntrospector;
import org.springframework.cloud.openfeign.ribbon.FeignLoadBalancer;
import org.springframework.util.CollectionUtils;

import javax.annotation.Nullable;
import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.Map;

/**
 * <p>Title: MyLoadBalancer</p>
 * <p>Description: MyLoadBalancer</p>
 * <p>Company: sanjieke</p>
 *
 * @author liuweilong
 * @version 1.0
 * @date 2020/11/17
 */
public class MyLoadBalancer extends FeignLoadBalancer {


    public MyLoadBalancer(ILoadBalancer lb, IClientConfig clientConfig, ServerIntrospector serverIntrospector) {
        super(lb, clientConfig, serverIntrospector);
    }

    @Override
    protected void customizeLoadBalancerCommandBuilder(RibbonRequest request, IClientConfig config, LoadBalancerCommand.Builder<RibbonResponse> builder) {
        final Map<String, Collection<String>> headers = request.getRequest().headers();
        final Collection<String> lbKeyCollection = headers.get("lbKey");
        if (CollectionUtils.isEmpty(lbKeyCollection)) {
            return;
        }
        String lbKey = "";
        for (String s : lbKeyCollection) {
            lbKey = s;
            break;
        }
        builder.withServerLocator(lbKey);
    }
}

