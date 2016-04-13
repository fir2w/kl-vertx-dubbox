package com.klwork.spring.vertx.resp.poi;


import com.klwork.spring.vertx.resp.BaseResp;

import java.util.List;

/**
 * GetPoiListResp
 *
 * @author Young
 * @version 1.0
 * @since 2015-10-01 22:16:04
 */
public class GetRoutePoiListResp extends BaseResp {

    /**
     * 总数
     */
    private String total;

    /**
     * 当页数据
     */

    private List<RoutePoiInfo> dataList;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<RoutePoiInfo> getDataList() {
        return dataList;
    }

    public void setDataList(List<RoutePoiInfo> dataList) {
        this.dataList = dataList;
    }
}
