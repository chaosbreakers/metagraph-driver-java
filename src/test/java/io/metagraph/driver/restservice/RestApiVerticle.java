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
