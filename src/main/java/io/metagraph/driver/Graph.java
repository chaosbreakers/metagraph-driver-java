package io.metagraph.driver;

import org.apache.commons.configuration.Configuration;
import org.apache.tinkerpop.gremlin.process.computer.GraphComputer;
import org.apache.tinkerpop.gremlin.process.traversal.Traversal;
import org.apache.tinkerpop.gremlin.process.traversal.TraversalStrategies;
import org.apache.tinkerpop.gremlin.process.traversal.TraversalStrategy;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Edge;
import org.apache.tinkerpop.gremlin.structure.T;
import org.apache.tinkerpop.gremlin.structure.Transaction;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.Iterator;
import java.util.List;

/**
 * graph.
 * <p>
 * Created by (zhaoliang@metagraph.io) on (17-2-7).
 */
public class Graph {

    private Strategies strategy = Strategies.standard;
    private String graphId;

    public Graph(String graphId) {
        this.graphId = graphId;
    }

    public void traversal(Strategies strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("string");
        graph.name();
    }

    public void name() {
        GraphTraversalSource g;
        g = new GraphTraversalSource(new org.apache.tinkerpop.gremlin.structure.Graph() {
            public Vertex addVertex(Object... keyValues) {
                return null;
            }

            public <C extends GraphComputer> C compute(Class<C> graphComputerClass) throws IllegalArgumentException {
                return null;
            }

            public GraphComputer compute() throws IllegalArgumentException {
                return null;
            }

            public Iterator<Vertex> vertices(Object... vertexIds) {
                return null;
            }

            public Iterator<Edge> edges(Object... edgeIds) {
                return null;
            }

            public Transaction tx() {
                return null;
            }

            public void close() throws Exception {

            }

            public Variables variables() {
                return null;
            }

            public Configuration configuration() {
                return null;
            }
        }, new TraversalStrategies() {
            public List<TraversalStrategy<?>> toList() {
                return null;
            }

            public void applyStrategies(Traversal.Admin<?, ?> traversal) {

            }

            public TraversalStrategies addStrategies(TraversalStrategy<?>[] strategies) {
                return null;
            }

            public TraversalStrategies removeStrategies(Class<? extends TraversalStrategy>[] strategyClasses) {
                return null;
            }

            public TraversalStrategies clone() {
                return null;
            }
        });


        GraphTraversal<Vertex, Vertex> hello = g.V().has(T.label, "hello");
        String s = hello.toString();
        System.out.println(s);
    }
}
