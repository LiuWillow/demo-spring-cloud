package com.example.servicezuul;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 判断用户是否登录
 */
@Component
public class TestFilter extends ZuulFilter {

    private final Logger Logger = LoggerFactory.getLogger(getClass());

    /**
     * 前置过滤器
     * zuul中定义了四种不同生命周期的过滤器类型：
     * 1、pre：可以在请求被路由之前调用；
     * 2、route：在路由请求时候被调用；
     * 3、post：在route和error过滤器之后被调用；
     * 4、error：处理请求时发生错误时被调用；
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤的优先级，数字越大，优先级越低。
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 3;
    }

    /**
     * 是否执行该过滤器
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestUri = request.getRequestURI();

        //如果请求和/lalala匹配，则需要执行该过滤器.
        return "/lalala".equals(requestUri);
    }

    /**
     * 过滤器的具体逻辑。
     */
    @Override
    public Object run() {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            HttpServletRequest request = ctx.getRequest();
            HttpSession session = request.getSession();
            Object userId = session.getAttribute("userId");

            if (userId == null) {
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(200);
                ctx.setResponseBody("401");
            } else {
                ctx.addZuulRequestHeader("userId", userId.toString());
            }
        }catch (Exception e){
            Logger.error(" fail : {}",e);
        }

        return null;
    }
}