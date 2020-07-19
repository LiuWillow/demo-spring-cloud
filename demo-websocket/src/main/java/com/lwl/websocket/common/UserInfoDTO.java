package com.lwl.websocket.common;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Title: UserInfo</p>
 * <p>Description: UserInfo</p>
 * <p>Company: sanjieke</p>
 *
 * @author liuweilong
 * @version 1.0
 * @date 2020/7/19
 */
@Data
public class UserInfoDTO implements Serializable {
    private Long userId;
    private String username;
}
