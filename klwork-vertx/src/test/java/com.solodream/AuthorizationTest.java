package com.solodream;

import com.alibaba.fastjson.JSON;
import com.klwork.spring.vertx.common.HttpUtils;
import com.klwork.spring.vertx.req.BaseReq;
import com.klwork.spring.vertx.req.client.TokenRequestParam;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by young on 16/1/2.
 */
public class AuthorizationTest {
    @Test
    public void testAuthorization()throws Exception{
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("Content-Type", "application/json"));
        headers.add(new BasicHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE0NTE3MDQzNDYsImV4cCI6MTQ1MjMwOTE0Niwic3ViIjoidGVzbGEifQ==.bs-KI0lXF1LU7LAlaq9sApqYNiq_QLZx86Mw2o_snZs="));

        BaseReq<TokenRequestParam> request = new BaseReq<TokenRequestParam>();
        request.setToken("123");

        TokenRequestParam param = new TokenRequestParam();
        param.setRefreshToken("5483d6c4ebbd995e1b02c65dc0da46cb");

        request.setParam(param);
        String parameter = JSON.toJSONString(request);


        System.out.println(HttpUtils.post("http://127.0.0.1:18080/client/getDeviceId", headers, parameter));
    }
}
