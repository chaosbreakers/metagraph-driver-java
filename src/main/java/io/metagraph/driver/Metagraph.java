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

import io.metagraph.driver.json.JsonObject;


/**
 * @author Ranger Tsao(https://github.com/boliza)
 */
public interface Metagraph extends AutoCloseable {

    static Metagraph connect(MetagraphOptions options) {
        return new MetagraphImpl(options);
    }

    List<MgitGraph> list();

    /**
     * get MgitGraph by id
     *
     * @param id graph id
     * @return MgitGraph
     */
    MgitGraph get(String id);

    /**
     * create graph by metadata
     *
     * @param id       graph id
     * @param metadata graph metadata json object
     * @return graph
     */
    MgitGraph create(String id, JsonObject metadata);

    /**
     * update graph by metadata
     *
     * @param id       graph id
     * @param metadata graph metadata json object
     * @return graph
     */
    MgitGraph update(String id, JsonObject metadata);

    /**
     * delete graph by id
     *
     * @param id graph id
     */
    void delete(String id);

}
