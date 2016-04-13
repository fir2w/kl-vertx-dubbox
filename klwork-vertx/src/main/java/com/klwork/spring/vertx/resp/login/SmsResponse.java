package com.klwork.spring.vertx.resp.login;

import com.klwork.spring.vertx.resp.BaseResp;

/**
 * Created by young on 15/12/31.
 */
public class SmsResponse extends BaseResp {
    private Integer expire = 300;

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }
}
