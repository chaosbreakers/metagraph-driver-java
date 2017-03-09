package io.metagraph.driver;

import org.apache.tinkerpop.gremlin.driver.ResultSet;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.structure.util.empty.EmptyGraph;
import org.apache.tinkerpop.gremlin.util.function.Lambda;
import org.junit.Test;

/**
 * Created by (zhaoliang@metagraph.io) on (17-3-9).
 */
public class GraphTest {

    @Test
    public void submit() throws Exception {

        Graph graph = new Graph(null);
        graph.connect();

        org.apache.tinkerpop.gremlin.structure.Graph emptyGraph = EmptyGraph.instance();
        GraphTraversalSource g = emptyGraph.traversal().withRemote(Graph.remoteConfiguration);
        org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal<Vertex, String> label = g.V().filter(Lambda.predicate("it.get().label().equals('test')")).label();

        ResultSet submit = graph.submit(label);
        submit.forEach(System.out::println);
        graph.close();

    }
}