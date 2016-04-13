package com.klwork.spring.vertx.vertx;

import com.klwork.spring.vertx.service.RedisCacheService;
import io.vertx.core.AbstractVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * SmsVerticle
 *
 * @author Young
 * @date 2015/11/24 0024
 */
@Component
public class SmsVerticle extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsVerticle.class);

    @Autowired
    private RedisCacheService redisCacheService;


    public void start() {
        LOGGER.info("start.");

        vertx.eventBus().consumer("sms", message -> {
            LOGGER.info("Received a message: {}, {}", message.body(), message.headers());
            try {
                //semd message
                String mobile = (String) message.body();
                String randomStr = getSix();
                redisCacheService.put("SMS_CODE_" + mobile, randomStr, 5 * 60);
                message.reply("success");
            } catch (Exception e) {
                LOGGER.error("convert error.", e);
            }
        });
    }

    public static String getSix() {
        Random rad = new Random();

        String result = rad.nextInt(1000000) + "";

        if (result.length() != 6) {
            return getSix();
        }
        return result;
    }

}
