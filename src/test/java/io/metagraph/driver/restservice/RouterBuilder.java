/*
 *
 *   Copyright (C) 2015-2017 Monogram Inc.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
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
