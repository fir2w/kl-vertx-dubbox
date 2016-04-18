package com.klwork.spring.vertx.vertx;

import com.alibaba.fastjson.JSON;
import com.klwork.rest.filter.Request;
import com.klwork.spring.vertx.domain.model.Team;
import com.klwork.spring.vertx.domain.model.TeamQuery;
import com.klwork.spring.vertx.domain.service.TeamService;
import com.klwork.spring.vertx.render.ReportResponse;
import com.klwork.spring.vertx.render.VelocityReportRender;
import com.klwork.spring.vertx.resp.BaseResp;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.ext.web.handler.sockjs.PermittedOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HttpServerVerticle extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpServerVerticle.class);

    @Autowired
    private TeamService teamService;



    public void start() {
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.route().handler(BodyHandler.create());
        // Allow events for the designated addresses in/out of the event bus bridge


        BridgeOptions opts = new BridgeOptions()
                .addInboundPermitted(new PermittedOptions().setAddress("chat.to.server"))
                .addOutboundPermitted(new PermittedOptions().setAddress("chat.to.client"));

        //eventbus
        SockJSHandler ebHandler = SockJSHandler.create(vertx).bridge(opts);
        router.route("/eventbus/*").handler(ebHandler);
        //服务器的消息
        EventBus eb = vertx.eventBus();
        eb.consumer("chat.to.server").handler(message -> {
            // Create a timestamp string
            String timestamp = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM).format(Date.from(Instant.now()));
            // Send the message back out to all clients with the timestamp prepended.
            eb.publish("chat.to.client", timestamp + ": " + message.body());
        });

        //静态资源
        router.route("/static/*").handler(StaticHandler.create("public/dist"));
        //router.route("/assets/*").handler(statichandler.create("assets"));

        router.route("/index").handler(routingContext -> {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("server","./static");
            Request request = new Request();
            request.setUrlTemplate("/main/index");//设置模板
            VelocityReportRender render = new VelocityReportRender();
            ReportResponse renderResponse = render.render(data, request);
            routingContext.response().putHeader("content-type", "text/html").end(renderResponse.getChunk());
        });

        router.route("/teams").handler(
                req -> {
                    //JsonObject jsonString = req.getBodyAsJson();
                    TeamQuery query = TeamQuery.build();//.setName("ww");
                    List<Team> list = teamService.findTeamByQueryCriteria(query,null);
                    BaseResp<List> response = new BaseResp<List>();
                    response.setData(list);
                    req.response().putHeader("content-type", "application/json; charset=utf-8")
                            .end(JSON.toJSONString(response));
                });

        vertx.createHttpServer().requestHandler(router::accept).listen(18080);
        LOGGER.info("Started HttpServer(port=18080).");
    }
}