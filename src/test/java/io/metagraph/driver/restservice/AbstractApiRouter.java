/*
 * Copyright (c) 2016 monogram
 */

package io.metagraph.driver.restservice;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.ext.web.Router;

public abstract class AbstractApiRouter {

    public static final String GRAPH_API_URL_BASE = "/graphs";
    public static final String CONTENT_TYPE_JSON = "application/json";

    protected Vertx vertx;
    protected Router router;
    protected EventBus eventBus;

    public void define(Vertx vertx, Router router, EventBus eventBus) {
        this.vertx = vertx;
        this.router = router;
        this.eventBus = eventBus;
        api();
    }

    public abstract void api();
}
