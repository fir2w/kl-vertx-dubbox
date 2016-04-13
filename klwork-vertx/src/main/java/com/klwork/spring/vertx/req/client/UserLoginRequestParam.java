package com.klwork.spring.vertx.req.client;

import com.klwork.spring.vertx.req.BaseReq;

/**
 * Created by young on 15/11/25.
 */
public class UserLoginRequestParam extends BaseReq {
    private String deviceId;
    private String username;
    private String password;
    private String smsCode;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
