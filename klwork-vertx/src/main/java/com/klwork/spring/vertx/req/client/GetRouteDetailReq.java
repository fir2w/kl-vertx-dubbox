package com.klwork.spring.vertx.req.client;

import com.klwork.spring.vertx.req.BaseGetListReq;

public class GetRouteDetailReq extends BaseGetListReq {


    private String contractId;

    private String customerId;

    private String fromId;

    private String toId;


    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getStartlng() {
        return startlng;
    }

    public void setStartlng(String startlng) {
        this.startlng = startlng;
    }

    public String getStartlat() {
        return startlat;
    }

    public void setStartlat(String startlat) {
        this.startlat = startlat;
    }

    private String keyword;


    private java.lang.String startlng;

    private java.lang.String startlat;


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
