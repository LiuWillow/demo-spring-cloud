package com.lwl.websocket.interceptor;

import com.lwl.common.CommonConst;
import com.lwl.common.UserInfoDTO;
import com.lwl.websocket.cache.LoginCache;
import com.lwl.websocket.constant.AttributeConst;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author wangjiawei
 * @date 2020/5/12
 **/
@Component
@Slf4j
public class LoginHandshakeInterceptor extends HttpSessionHandshakeInterceptor {
    @Resource
    private LoginCache loginCache;

    private static final String TOKEN_PREFIX = "token=";

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception{
        // 验证是否登录   如果已经登录   建立连接  通过   如果未登录   不让其建立连接   断开
        String cookie = request.getHeaders().getFirst(HttpHeaders.COOKIE);
//        if (StringUtils.isBlank(cookie) || !StringUtils.contains(cookie, CommonConst.TOKEN)) {
//            response.setStatusCode(HttpStatus.FORBIDDEN);
//            log.warn("[握手]没有cookie或者没有token, 拒绝握手, {}", cookie);
//            return false;
//        }
        //  如果登录了 那么将用户信息设置到attr里面，并且以用户ID为Key，将通道存入到map里面
        String token = null;
        String[] cookies = cookie.split(CommonConst.SEMICOLON_ENGLISH);
        if ( cookies.length > 0) {
            for (String s : cookies) {
                if (s != null && StringUtils.contains(s, CommonConst.TOKEN)) {
                    token = s.replace(TOKEN_PREFIX, CommonConst.EMPTY_STRING).trim();
                    break;
                }
            }
        }
        if (token == null) {
            token = LoginCache.DEFAULT_TOKEN;
//            response.setStatusCode(HttpStatus.FORBIDDEN);
//            log.warn("[握手]没有token, 拒绝握手, {}", cookie);
//            return false;
        }

        final UserInfoDTO userInfoDTO = loginCache.getLoginByToken(token);
        attributes.put(AttributeConst.LOGIN_INFO, userInfoDTO);
        log.info("[握手]成功握手, 用户  {} : {} ", userInfoDTO.getUserId(), userInfoDTO.getUsername());
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }
}