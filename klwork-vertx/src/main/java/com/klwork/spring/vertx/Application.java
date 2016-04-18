package com.klwork.spring.vertx;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.klwork.spring.vertx.vertx.HttpServerVerticle;
import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.*;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    @Autowired
    protected Environment environment;

    @Bean
    protected ObjectMapper objectMapper() {
        //如何使用ObjectMapper的方式实现Json和bean的自由转换
        return new ObjectMapper().disable(INDENT_OUTPUT)
                                 .disable(WRITE_EMPTY_JSON_ARRAYS)
                                 .disable(WRITE_NULL_MAP_VALUES)
                                 .disable(FAIL_ON_EMPTY_BEANS)
                                 .enable(WRITE_DATES_AS_TIMESTAMPS)
                                 .disable(FAIL_ON_UNKNOWN_PROPERTIES)
                                 .enable(ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
                                 .setSerializationInclusion(NON_NULL);
    }

    public static void main(String[] args) {
/*        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        final Vertx vertx = Vertx.vertx();*/

        final ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class)
                .registerShutdownHook(true)
                .logStartupInfo(true)
                .showBanner(true)
                .run(args);

        final Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(context.getBean(HttpServerVerticle.class));
    }
}
