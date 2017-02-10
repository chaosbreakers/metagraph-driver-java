/*
 * Copyright (c) 2016 monogram
 */

package io.metagraph.driver.restservice;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

import static io.metagraph.driver.restservice.AbstractApiRouter.CONTENT_TYPE_JSON;


/**
 * @author Ranger Tsao(cao.zhifu@gmail.com)
 */
public class RouterBuilder {

    private Vertx vertx;
    private Router router;
    private EventBus eventBus;

    public RouterBuilder(Vertx vertx) {
        this.vertx = vertx;
        this.eventBus = vertx.eventBus();
        this.router = Router.router(vertx);

        router.route("/*").handler(BodyHandler.create());

        /* 注册Content-type */
        router.route().produces(CONTENT_TYPE_JSON).handler(ctx -> {
            ctx.response().putHeader("content-type", CONTENT_TYPE_JSON);
            ctx.next();
        });
        router.route().consumes(CONTENT_TYPE_JSON);
    }

    public RouterBuilder router(Router router) {
        this.router = router;
        return this;
    }

    public RouterBuilder route(AbstractApiRouter api) {
        api.define(vertx, router, eventBus);
        return this;
    }

    public Router router() {
        return router;
    }

    public Vertx vertx() {
        return vertx;
    }

}
