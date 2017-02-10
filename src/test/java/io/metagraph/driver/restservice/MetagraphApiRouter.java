/*
 * Copyright (c) 2016 monogram
 */

package io.metagraph.driver.restservice;

import io.vertx.ext.web.RoutingContext;

public class MetagraphApiRouter extends AbstractApiRouter {

    public void api() {
        //connect && disconnect handle
        this.router.post(GRAPH_API_URL_BASE + "/connect").handler(this::connect);
        this.router.post(GRAPH_API_URL_BASE + "/disconnect").handler(this::disconnect);
    }

    private void disconnect(RoutingContext ctx) {

    }

    private void connect(RoutingContext ctx) {

    }

}
