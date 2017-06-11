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

import static org.junit.Assert.assertEquals;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.util.iterator.IteratorUtils;
import org.junit.Test;

/**
 * @author Ranger Tsao(https://github.com/boliza)
 */
public class MgitGraphTest {


    @Test
    public void traversal() throws Exception {
        Graph graph = new MgitGraph("g", new MetagraphImpl(new MetagraphOptions()));
        GraphTraversalSource g = graph.traversal().withComputer();
        assertEquals(6L, IteratorUtils.count(g.V()));
    }

}