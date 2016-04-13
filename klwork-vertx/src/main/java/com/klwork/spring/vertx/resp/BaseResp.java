package com.klwork.spring.vertx.resp;

import org.weakref.jmx.Managed;

/**
 * Created by young on 15/12/31.
 */
public class BaseResp<T extends Object> {

    private int code = 100;
    private String msg;
    private T data;

    @Managed
    public int getCode() {
        return code;
    }

    @Managed
    public void setCode(int code) {
        this.code = code;
    }

    @Managed
    public String getMsg() {
        return msg;
    }

    @Managed
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
