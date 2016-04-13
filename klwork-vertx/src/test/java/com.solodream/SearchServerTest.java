package com.solodream;

import com.alibaba.fastjson.JSON;
import com.klwork.spring.vertx.resp.poi.GetRoutePoiListResp;
import com.klwork.spring.vertx.resp.poi.RoutePoiInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by young on 16/1/7.
 */
public class SearchServerTest {

    @Test
    public void testSearch() {

        GetRoutePoiListResp resp = new GetRoutePoiListResp();

        resp.setTotal("1");

        List<RoutePoiInfo> dataList = new ArrayList<RoutePoiInfo>();
        RoutePoiInfo info=new RoutePoiInfo();

        RoutePoiInfo.RoutePoi from=new RoutePoiInfo.RoutePoi();
        from.setCompanyId("1");
        from.setAddress("hangzhou");

        RoutePoiInfo.RoutePoi to=new RoutePoiInfo.RoutePoi();
        to.setAddress("wenzhou");
        to.setCompanyId("2");
        info.setFrom(from);

        info.setTo(to);


        dataList.add(info);

        resp.setDataList(dataList);


        System.out.println(JSON.toJSONString(resp));
    }
}
