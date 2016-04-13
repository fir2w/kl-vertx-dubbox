package com.klwork.spring.vertx.auth;

import com.klwork.spring.vertx.auth.impl.SoloAuthProviderImpl;
import com.klwork.spring.vertx.service.RedisCacheService;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.UserSessionHandler;

/**
 * Created by young on 15/12/1.
 */
@VertxGen
@ProxyGen
public interface SoloAuthProvider extends Handler<RoutingContext> {
    // A couple of factory methods to create an instance and a proxy

    static UserSessionHandler create(Vertx vertx, RedisCacheService redisCacheService) {
        return new SoloAuthProviderImpl(vertx, redisCacheService);
    }


}
