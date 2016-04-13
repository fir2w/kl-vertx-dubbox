package com.klwork.spring.vertx.req.client;

import com.klwork.spring.vertx.req.BaseReq;

/**
 * Created by young on 15/11/25.
 */
public class TokenRequestParam extends BaseReq {
    private String refreshToken;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
