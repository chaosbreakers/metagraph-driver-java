package io.metagraph.driver.restservice;

import io.vertx.ext.web.RoutingContext;

public class GraphApiRouter extends AbstractApiRouter {

    private static final String requestURL = GRAPH_API_URL_BASE + "/:id/traversal";

    @Override
    public void api() {
        this.router.get(requestURL).handler(this::gremlin);
        this.router.post(requestURL).handler(this::traversal);
    }

    private void gremlin(RoutingContext ctx) {

    }

    private void traversal(RoutingContext ctx) {
    }
}
