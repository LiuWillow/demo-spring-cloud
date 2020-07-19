package com.lwl.websocket.handler;

import com.alibaba.fastjson.JSON;
import com.lwl.websocket.common.CommonConst;
import com.lwl.websocket.common.GlobalException;
import com.lwl.websocket.common.UserInfoDTO;
import com.lwl.websocket.constant.AttributeConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangjiawei
 * @date 2020/5/12
 **/
@Slf4j
@Component
public class TestSocketHandler extends TextWebSocketHandler {

    private static final Map<String, List<WebSocketSession>> SESSION_MAP = new ConcurrentHashMap<>();

    /**
     * 最大连接数
     */
    private static final int MAX_CONN = 100000;
    /**
     * 当前连接数
     */
    private static AtomicInteger connectNum = new AtomicInteger(0);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws IOException {
        if (connectNum.incrementAndGet() > MAX_CONN) {
            new SessionWrapper(session).sendMessage(new TextMessage("达到人数上限"));
            connectNum.decrementAndGet();
            session.close(CloseStatus.NOT_ACCEPTABLE);
            return;
        }

        UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttributes().get(AttributeConst.LOGIN_INFO);
        String userId = userInfoDTO.getUserId() + "";
        log.info("用户 {} : {} 成功建立 websocket 连接，当前人数:{}", userId, userInfoDTO.getUsername(), connectNum.get());
        SESSION_MAP.compute(userId, (k, v) -> {
            if (v == null) {
                v = new ArrayList<>();
            }
            v.add(session);
            return v;
        });
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        connectNum.decrementAndGet();
        //更新contexts数组
        //控制台输出相关信息
        InetSocketAddress socket = session.getRemoteAddress();
        assert socket != null;
        final Object loginInfo = session.getAttributes().get(AttributeConst.LOGIN_INFO);
        if (loginInfo != null) {
            UserInfoDTO userInfoDTO = (UserInfoDTO) loginInfo;
            log.info("跟踪：检测到用户:{}  name: {} 连接断开", userInfoDTO.getUserId(), userInfoDTO.getUsername());
            removePeople(userInfoDTO.getUserId() + CommonConst.EMPTY_STRING, session);
        }
        //连接关闭后的操作
        super.afterConnectionClosed(session, closeStatus);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        //收到消息后的操作
        if (message instanceof TextMessage) {
            this.handleTextMessage(session, (TextMessage) message);
        } else if (message instanceof BinaryMessage) {
            new SessionWrapper(session).sendMessage(new TextMessage("不支持二进制消息"));
        } else {
            if (!(message instanceof PongMessage)) {
                throw new IllegalStateException("Unexpected WebSocket message type: " + message);
            }
            //响应前端的ping消息
            this.handlePongMessage(session, (PongMessage) message);
        }
    }

    @Override
    public void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        new SessionWrapper(session).sendMessage(new PingMessage());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        //连接出错后的操作
        if (exception instanceof GlobalException) {
            new SessionWrapper(session).sendMessage(new TextMessage(JSON.toJSONString("error")));
        } else {
            super.handleTransportError(session, exception);
        }
    }

    private void removePeople(String userId, WebSocketSession session) {
        log.info("用户断线退出, session:{}", session.getId());
        List<WebSocketSession> sessions = SESSION_MAP.get(userId);
        if (CollectionUtils.isEmpty(sessions)) {
            return;
        }
        sessions.remove(session);
        if (CollectionUtils.isEmpty(sessions)) {
            log.info("用户所有session断线退出, userId:{}", userId);
            SESSION_MAP.remove(userId);
        }
        // 处理相关业务
    }

    private static class SessionWrapper {
        private final WebSocketSession socketSession;

        SessionWrapper(WebSocketSession socketSession) {
            this.socketSession = socketSession;
        }

        public void sendMessage(WebSocketMessage<?> message) throws IOException {
            synchronized (socketSession) {
                socketSession.sendMessage(message);
            }
        }
    }

}
