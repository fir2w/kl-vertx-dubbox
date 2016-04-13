package com.klwork.spring.vertx.req.client;

import com.klwork.spring.vertx.req.BaseReq;

/**
 * Created by young on 15/11/25.
 */
public class UserLogoutRequestParam extends BaseReq {

    private String deviceId;
    private String username;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
