package com.solodream;

import com.alibaba.fastjson.JSON;
import com.klwork.spring.vertx.common.HttpUtils;
import com.klwork.spring.vertx.req.BaseReq;
import com.klwork.spring.vertx.req.client.TokenRequestParam;
import com.klwork.spring.vertx.req.client.UserLoginRequestParam;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by young on 15/12/31.
 */
public class LoginServerTest {
    @Test
    public void testLogin() throws Exception {
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("Content-Type", "application/json"));
        BaseReq<UserLoginRequestParam> request = new BaseReq<UserLoginRequestParam>();
        request.setToken("403b87da81e25c5e9cf8b091481464bb");
        UserLoginRequestParam param = new UserLoginRequestParam();
        param.setDeviceId("123456788");
        param.setUsername("tesla");
        param.setPassword("password");
        param.setSmsCode("12345");
        request.setParam(param);
        String parameter = JSON.toJSONString(request);
        System.out.println(parameter);

        String tokenPrefix = parameter.split("\"token\":\"")[1];

        System.out.println(HttpUtils.post("http://127.0.0.1:18080/client/login", headers, parameter));
    }
    @Test
    public void testGetAccessToken()throws  Exception{
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("Content-Type", "application/json"));

        BaseReq<TokenRequestParam> request = new BaseReq<TokenRequestParam>();
        request.setToken("");

        TokenRequestParam param = new TokenRequestParam();
        param.setRefreshToken("403b87da81e25c5e9cf8b091481464bb");

        request.setParam(param);
        String parameter = JSON.toJSONString(request);


        System.out.println(parameter);

        System.out.println(HttpUtils.post("http://127.0.0.1:18080/client/getAccessToken/", headers, parameter));
    }
}
