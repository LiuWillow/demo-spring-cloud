package com.lwl.websocket.common;

import lombok.Data;

/**
 * <p>Title: GlobalException</p>
 * <p>Description: GlobalException</p>
 * <p>Company: sanjieke</p>
 *
 * @author liuweilong
 * @version 1.0
 * @date 2020/7/19
 */
public class GlobalException extends RuntimeException{
    private int code;
    private String msg;

    public GlobalException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public GlobalException(String message, int code, String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public GlobalException(String message, Throwable cause, int code, String msg) {
        super(message, cause);
        this.code = code;
        this.msg = msg;
    }

    public GlobalException(Throwable cause, int code, String msg) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    public GlobalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, String msg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
