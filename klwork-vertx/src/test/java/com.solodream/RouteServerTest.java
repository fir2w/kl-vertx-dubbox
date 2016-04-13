package com.solodream;

import com.alibaba.fastjson.JSON;
import com.klwork.spring.vertx.common.HttpUtils;
import com.klwork.spring.vertx.req.BaseReq;
import com.klwork.spring.vertx.req.client.GetRouteDetailReq;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by young on 16/1/1.
 */
public class RouteServerTest {
    @Test
    public void testFrom()throws  Exception{
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("Content-Type", "application/json"));

        BaseReq<GetRouteDetailReq> request = new BaseReq<GetRouteDetailReq>();
        request.setToken("c7c57afdb3d397d6fa8a9189096445a2");

        GetRouteDetailReq param = new GetRouteDetailReq();
        param.setKeyword("east");

        param.setContractId("1");
//        param.setCustomerId("1");
        request.setParam(param);
        String parameter = JSON.toJSONString(request);


        System.out.println(parameter);

        System.out.println(HttpUtils.post("http://127.0.0.1:18080/shuttle/from/", headers, parameter));
    }

    @Test
    public void testTo()throws  Exception{
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("Content-Type", "application/json"));

        BaseReq<GetRouteDetailReq> request = new BaseReq<GetRouteDetailReq>();
        request.setToken("c7c57afdb3d397d6fa8a9189096445a2");

        GetRouteDetailReq param = new GetRouteDetailReq();
        param.setKeyword("east");

        param.setContractId("1");
        param.setStartlng("122.13412");
        param.setStartlat("23.123");
//        param.setCustomerId("1");
        request.setParam(param);
        String parameter = JSON.toJSONString(request);


        System.out.println(parameter);

        System.out.println(HttpUtils.post("http://127.0.0.1:18080/shuttle/to/", headers, parameter));
    }

    @Test
    public void testList()throws  Exception{
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("Content-Type", "application/json"));

        BaseReq<GetRouteDetailReq> request = new BaseReq<GetRouteDetailReq>();
        request.setToken("c7c57afdb3d397d6fa8a9189096445a2");

        GetRouteDetailReq param = new GetRouteDetailReq();
        param.setKeyword("east");

        param.setContractId("1");
//        param.setCustomerId("1");
        request.setParam(param);
        String parameter = JSON.toJSONString(request);


        System.out.println(parameter);

        System.out.println(HttpUtils.post("http://127.0.0.1:18080/shuttle/route_list/", headers, parameter));
    }


    @Test
    public void testSearch()throws  Exception{
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("Content-Type", "application/json"));

        BaseReq<GetRouteDetailReq> request = new BaseReq<GetRouteDetailReq>();
        request.setToken("c7c57afdb3d397d6fa8a9189096445a2");

        GetRouteDetailReq param = new GetRouteDetailReq();
        param.setKeyword("east");

        param.setContractId("1");
        param.setStartlng("122.13412");
        param.setStartlat("23.123");
//        param.setCustomerId("1");
        request.setParam(param);
        String parameter = JSON.toJSONString(request);


        System.out.println(parameter);

        System.out.println(HttpUtils.post("http://127.0.0.1:18080/shuttle/search/", headers, parameter));
    }
}
