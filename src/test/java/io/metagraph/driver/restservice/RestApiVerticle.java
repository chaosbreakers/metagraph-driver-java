/*
 * Copyright (c) 2016 monogram
 */

package io.metagraph.driver.restservice;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;

/**
 * @author Ranger Tsao(cao.zhifu@gmail.com)
 */
public class RestApiVerticle extends AbstractVerticle {

    private HttpServer httpServer;

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        if (startFuture.succeeded()) {
            RouterBuilder builder = new RouterBuilder(vertx);
            builder.route(new MetagraphApiRouter());
            builder.route(new MgitApiRouter());

            httpServer = vertx
                    .createHttpServer()
                    .requestHandler(builder.router()::accept).listen(12345);
        }
    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        if (stopFuture.succeeded()) {
            httpServer.close();
        }
    }
}
