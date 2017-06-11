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

package io.metagraph.driver;

import java.util.List;

import io.vertx.core.json.JsonObject;

/**
 * @author Ranger Tsao(https://github.com/boliza)
 */
class MetagraphImpl implements Metagraph {

    private MetagraphOptions options;

    MetagraphImpl(MetagraphOptions options) {
        this.options = options;
    }

    @Override
    public List<MgitGraph> list() {
        return null;
    }

    @Override
    public MgitGraph get(String id) {
        return null;
    }

    @Override
    public MgitGraph open(String id) {
        return new MgitGraph(id, this);
    }

    @Override
    public MgitGraph create(String id, JsonObject jsonObject) {
        return null;
    }

    @Override
    public MgitGraph update(String id, JsonObject metadata) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void close() {

    }
}
