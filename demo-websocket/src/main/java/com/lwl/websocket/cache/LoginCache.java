package com.lwl.websocket.cache;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lwl.common.UserInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>Title: TokenCache</p>
 * <p>Description: TokenCache</p>
 * <p>Company: sanjieke</p>
 *
 * @author liuweilong
 * @version 1.0
 * @date 2020/7/19
 */
@Service
@Slf4j
public class LoginCache {
    public static final String DEFAULT_TOKEN = "default";
    // 这里的缓存是登录的时候放进去的，可能是分布式缓存
    private static final Map<String, String> TOKEN_LOGIN_MAP = new ConcurrentHashMap<>();

    static {
        //为了测试方便，写一个默认的缓存
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserId(1L);
        userInfoDTO.setUsername("lwl");
        TOKEN_LOGIN_MAP.put(DEFAULT_TOKEN, JSON.toJSONString(userInfoDTO));
    }

    public UserInfoDTO getLoginByToken(String token){
        final String userInfoJSON = TOKEN_LOGIN_MAP.get(token);
        if (Objects.isNull(userInfoJSON)) {
            return null;
        }
        return JSONObject.parseObject(userInfoJSON, UserInfoDTO.class);
    }

    public void setLogin(String token, String loginInfoJson) {
        TOKEN_LOGIN_MAP.put(token, loginInfoJson);
    }
}
