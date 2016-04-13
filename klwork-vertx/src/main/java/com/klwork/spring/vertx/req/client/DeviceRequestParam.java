package com.klwork.spring.vertx.req.client;

import com.klwork.spring.vertx.req.BaseReq;

/**
 * Created by young on 15/11/25.
 */
public class DeviceRequestParam extends BaseReq {
    private String os;
    private String version;
    private String imei;
    private String mac;
    private String sim;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }
}
