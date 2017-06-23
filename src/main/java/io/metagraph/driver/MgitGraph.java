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

import io.metagraph.driver.json.JsonObject;
import org.apache.commons.configuration.Configuration;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.remote.DriverRemoteConnection;
import org.apache.tinkerpop.gremlin.process.computer.GraphComputer;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.*;
import org.apache.tinkerpop.gremlin.structure.util.StringFactory;

import java.util.Collections;
import java.util.Iterator;


/**
 * @author Ranger Tsao(https://github.com/boliza)
 */
public class MgitGraph implements Graph {

    private final MgitGraph.MgitGraphFeatures features = new MgitGraph.MgitGraphFeatures();

    private String graphId;
    private Cluster cluster;
    private JsonObject metadata;

    public MgitGraph(String graphId, MetagraphImpl metagraph) {
        this.graphId = graphId;
        initCluster(metagraph);
    }

    public MgitGraph(String graphId, MetagraphImpl metagraph, JsonObject metadata) {
        this.graphId = graphId;
        this.metadata = metadata;
        initCluster(metagraph);
    }

    private void initCluster(MetagraphImpl metagraph) {
        cluster = Cluster.build().create();
    }

    @Override
    public Vertex addVertex(Object... keyValues) {
        throw Graph.Exceptions.vertexAdditionsNotSupported();
    }

    @Override
    public <C extends GraphComputer> C compute(Class<C> graphComputerClass) throws IllegalArgumentException {
        throw Graph.Exceptions.graphComputerNotSupported();
    }

    @Override
    public GraphComputer compute() throws IllegalArgumentException {
        throw Graph.Exceptions.graphComputerNotSupported();
    }

    @Override
    public GraphTraversalSource traversal() {
        return new GraphTraversalSource(this).withRemote(DriverRemoteConnection.using(cluster, graphId));
    }

    @Override
    public Iterator<Vertex> vertices(Object... vertexIds) {
        return Collections.emptyIterator();
    }

    @Override
    public Iterator<Edge> edges(Object... edgeIds) {
        return Collections.emptyIterator();
    }

    @Override
    public Transaction tx() {
        throw Exceptions.transactionsNotSupported();
    }

    @Override
    public void close() throws Exception {
        cluster.close();
    }

    @Override
    public Variables variables() {
        throw Exceptions.variablesNotSupported();
    }

    @Override
    public Configuration configuration() {
        return null;
    }

    @Override
    public Features features() {
        return null;
    }

    //more interfaces
    public MgitGraph merge(String target) {
        return merge(new JsonObject().put("target", target));
    }

    public MgitGraph merge(JsonObject targetOptions) {
        return null;
    }

    public MgitGraph branch(String target) {
        return branch("master", target);
    }

    public MgitGraph branch(String source, String target) {
        return null;
    }

    public MgitGraph fork() {
        return null;
    }

    @Override
    public String toString() {
        return StringFactory.graphString(this, "mgit");
    }

    public static final class MgitGraphFeatures implements Graph.Features {

        private GraphFeatures graphFeatures = new MgitGraph.MgitGraphFeatures.MgitGraphGraphFeatures();
        private VertexFeatures vertexFeatures = new MgitGraph.MgitGraphFeatures.MgitGraphVertexFeatures();
        private EdgeFeatures edgeFeatures = new MgitGraph.MgitGraphFeatures.MgitGraphEdgeFeatures();
        private EdgePropertyFeatures edgePropertyFeatures = new MgitGraph.MgitGraphFeatures.MgitGraphEdgePropertyFeatures();
        private VertexPropertyFeatures vertexPropertyFeatures = new MgitGraph.MgitGraphFeatures.MgitGraphVertexPropertyFeatures();

        private MgitGraphFeatures() {
        }

        @Override
        public GraphFeatures graph() {
            return graphFeatures;
        }

        @Override
        public VertexFeatures vertex() {
            return vertexFeatures;
        }

        @Override
        public EdgeFeatures edge() {
            return edgeFeatures;
        }

        /**
         * Graph features defined such that they support immutability but allow all other possibilities.
         */
        public final class MgitGraphGraphFeatures implements GraphFeatures {
            @Override
            public boolean supportsPersistence() {
                return false;
            }

            @Override
            public boolean supportsTransactions() {
                return false;
            }

            @Override
            public boolean supportsThreadedTransactions() {
                return false;
            }

            @Override
            public VariableFeatures variables() {
                return null;
            }

            @Override
            public boolean supportsComputer() {
                return false;
            }
        }

        /**
         * Vertex features defined such that they support immutability but allow all other possibilities.
         */
        public final class MgitGraphVertexFeatures extends MgitGraph.MgitGraphFeatures.MgitGraphElementFeatures implements VertexFeatures {
            @Override
            public VertexProperty.Cardinality getCardinality(final String key) {
                // probably not much hurt here in returning list...it's an "empty graph"
                return VertexProperty.Cardinality.list;
            }

            @Override
            public boolean supportsAddVertices() {
                return false;
            }

            @Override
            public boolean supportsRemoveVertices() {
                return false;
            }

            @Override
            public VertexPropertyFeatures properties() {
                return vertexPropertyFeatures;
            }
        }

        /**
         * Edge features defined such that they support immutability but allow all other possibilities.
         */
        public final class MgitGraphEdgeFeatures extends MgitGraph.MgitGraphFeatures.MgitGraphElementFeatures implements EdgeFeatures {
            @Override
            public boolean supportsAddEdges() {
                return false;
            }

            @Override
            public boolean supportsRemoveEdges() {
                return false;
            }

            @Override
            public EdgePropertyFeatures properties() {
                return edgePropertyFeatures;
            }
        }

        /**
         * Vertex Property features defined such that they support immutability but allow all other possibilities.
         */
        public final class MgitGraphVertexPropertyFeatures implements VertexPropertyFeatures {
            @Override
            public boolean supportsAddProperty() {
                return false;
            }

            @Override
            public boolean supportsRemoveProperty() {
                return false;
            }
        }

        /**
         * Edge property features defined such that they support immutability but allow all other possibilities.
         */
        public final class MgitGraphEdgePropertyFeatures implements EdgePropertyFeatures {
        }

        /**
         * Vertex features defined such that they support immutability but allow all other possibilities.
         */
        public abstract class MgitGraphElementFeatures implements ElementFeatures {
            @Override
            public boolean supportsAddProperty() {
                return false;
            }

            @Override
            public boolean supportsRemoveProperty() {
                return false;
            }
        }
    }

}
