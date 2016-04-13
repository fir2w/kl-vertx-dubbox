package com.klwork.spring.vertx.req;

/**
 * BaseReq re
 * 
 * @author young
 * 
 */
public class BaseReq<T extends BaseReq> {

    private String token;

    private T param;

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
