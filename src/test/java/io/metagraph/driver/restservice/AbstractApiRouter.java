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
