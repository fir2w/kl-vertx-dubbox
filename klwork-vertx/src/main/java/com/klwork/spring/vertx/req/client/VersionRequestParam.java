package com.klwork.spring.vertx.req.client;

import com.klwork.spring.vertx.req.BaseReq;

/**
 * Created by young on 15/11/25.
 */
public class VersionRequestParam extends BaseReq {
    private String version_code;

    public String getVersion_code() {
        return version_code;
    }

    public void setVersion_code(String version_code) {
        this.version_code = version_code;
    }
}
