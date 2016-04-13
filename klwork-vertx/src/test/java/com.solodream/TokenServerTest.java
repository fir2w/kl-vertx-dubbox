package com.solodream;

import com.alibaba.fastjson.JSON;
import com.klwork.spring.vertx.common.HttpUtils;
import com.klwork.spring.vertx.req.BaseReq;
import com.klwork.spring.vertx.req.client.UserLoginRequestParam;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by young on 15/12/31.
 */
public class TokenServerTest {
    @Test
    public void testToken() throws Exception {
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("Content-Type", "application/json"));

        BaseReq<UserLoginRequestParam> request = new BaseReq<UserLoginRequestParam>();
        request.setToken("");

        UserLoginRequestParam param = new UserLoginRequestParam();
        param.setDeviceId("123456788");
        param.setUsername("TestAccount24");
        param.setPassword("123456steven");
        param.setSmsCode("12345");

        request.setParam(param);
        String parameter = JSON.toJSONString(request);


        System.out.println(parameter);

        System.out.println(HttpUtils.get("http://127.0.0.1:18080/api/newToken", null));
    }


}
