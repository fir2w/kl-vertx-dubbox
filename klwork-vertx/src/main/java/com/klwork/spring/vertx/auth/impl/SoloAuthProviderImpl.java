package com.klwork.spring.vertx.auth.impl;

import com.klwork.spring.vertx.common.ResultCode;
import com.klwork.spring.vertx.service.RedisCacheService;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.UserSessionHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by young on 15/12/1.
 */
public class SoloAuthProviderImpl implements UserSessionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SoloAuthProviderImpl.class);

    private static final String SESSION_USER_HOLDER_KEY = "__vertx.userHolder";

    private Vertx vertx;

    private RedisCacheService redisCacheService;

    public SoloAuthProviderImpl(Vertx vertx, RedisCacheService redisCacheService) {
        this.redisCacheService = redisCacheService;
        this.vertx = vertx;
    }

    @Override
    public void handle(RoutingContext routingContext) {
        LOGGER.info(">>>>>>>>>>>>>>>  Any request have to be intercept");
        JsonObject jsonString = routingContext.getBodyAsJson();
        String requestStr = jsonString.toString();
        String tokenPrefix = requestStr.split("\"token\":\"")[1];
        String keyToken = tokenPrefix.split("\"")[0];
        LOGGER.info("Token is " + keyToken);

//        redisCacheService.put(keyToken,keyToken);
        String value = redisCacheService.get(keyToken);
        if (StringUtils.isEmpty(value)) {
            LOGGER.info("this token didn't exit redis cache");
            routingContext.fail(ResultCode.TOKEN_NOT_EXIT.code());
        } else {
            routingContext.next();
        }
//        Session session = routingContext.session();
//        if (session != null) {
//            LOGGER.info("session is not exit ,please u have to login");
//            User user = null;
//            UserHolder holder = session.get(SESSION_USER_HOLDER_KEY);
//            if (holder != null) {
//                RoutingContext prevContext = holder.context;
//                if (prevContext != null) {
//                    user = prevContext.user();
//                } else if (holder.user != null) {
//                    user = holder.user;
//                    // user.setAuthProvider(authProvider);
//                    holder.context = routingContext;
//                    holder.user = null;
//                }
//                holder.context = routingContext;
//            } else {
//                session.put(SESSION_USER_HOLDER_KEY, new UserHolder(routingContext));
//            }
//            if (user != null) {
//                routingContext.setUser(user);
//            }
//        }


    }

}

