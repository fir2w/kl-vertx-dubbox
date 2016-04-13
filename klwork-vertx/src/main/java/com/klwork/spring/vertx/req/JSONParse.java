package com.klwork.spring.vertx.req;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.klwork.spring.vertx.req.client.UserLoginRequestParam;
import com.klwork.spring.vertx.req.client.DeviceRequestParam;
import com.klwork.spring.vertx.req.client.GPSSyncData;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by young on 15/11/25.
 */
public class JSONParse {
    public static void main(String[] args) {
        JsonReq<UserLoginRequestParam> reqparam = new JsonReq<UserLoginRequestParam>();
        reqparam.setToken("TOKEN12312");
        UserLoginRequestParam param = new UserLoginRequestParam();
        param.setUsername("chenyang");
        param.setPassword("123213");
        reqparam.setParam(param);
        String jsonString = JSON.toJSONString(reqparam);
        System.out.println(jsonString);


        JsonReq<DeviceRequestParam> obj = JSON.parseObject(jsonString, new TypeReference<JsonReq<DeviceRequestParam>>() {
        });

        String gps = "[\n" +
                "  [\n" +
                "    469913969,\n" +
                "    20151127,\n" +
                "    95543,\n" +
                "    37385455,\n" +
                "    0,\n" +
                "    460143,\n" +
                "    0,\n" +
                "    14800,\n" +
                "    788000\n" +
                "  ],\n" +
                "  [\n" +
                "    525236411,\n" +
                "    20151127,\n" +
                "    95541,\n" +
                "    37377919,\n" +
                "    0,\n" +
                "    482769,\n" +
                "    0,\n" +
                "    27300,\n" +
                "    5213000\n" +
                "  ]]";

        JSONArray jsonArr = JSON.parseArray(gps);
        List<GPSSyncData> list = new ArrayList<GPSSyncData>(jsonArr.size());
        for (Object array : jsonArr) {
            JSONArray gpsArray = JSON.parseArray(String.valueOf(array));
            GPSSyncData data = new GPSSyncData();
            data.setSerialNumber(String.valueOf(gpsArray.get(0)));
            data.setYearMonthDate(String.valueOf(gpsArray.get(1)));
            data.setHourMinuteSecond(String.valueOf(gpsArray.get(2)));
            data.setLongitude(Long.valueOf(String.valueOf(gpsArray.get(3))));
            data.setEastOrwest(Integer.parseInt(String.valueOf(gpsArray.get(4))));
            list.add(data);
        }
        System.out.println(obj.getParam().getImei());
        for (GPSSyncData data : list) {
            getPool().getResource().set(data.getSerialNumber() + ":" + data.getYearMonthDate() + ":" + data.getHourMinuteSecond(), data.getLongitude() + "," + data.getLatitude()
                    + "," + data.getEastOrwest() + "," + data.getDirection() + "," + data.getSpeed() + "," + data.getNorthOrsouth());
        }
    }

    public static JedisPool getPool() {
        JedisPool pool = null;
        JedisPoolConfig config = new JedisPoolConfig();
        config.setTestOnBorrow(true);
        pool = new JedisPool(config, "localhost", 6379);
        return pool;
    }
}
