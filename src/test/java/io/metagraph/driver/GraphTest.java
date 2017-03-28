package io.metagraph.driver;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Property;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerFactory;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;
import org.junit.Test;

/**
 * Created by (zhaoliang@metagraph.io) on (17-3-9).
 */
public class GraphTest {

    @Test
    public void submit() throws Exception {

        Graph graph = new Graph(null);
        graph.connect();

//        org.apache.tinkerpop.gremlin.structure.Graph emptyGraph = EmptyGraph.instance();
//        GraphTraversalSource g = emptyGraph.traversal().withRemote(Graph.remoteConfiguration);
//        org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal<Vertex, Vertex> label = g.V()/*.filter(Lambda.predicate("it.get().label().equals('test')")).label()*/;
//        Vertex next = label.next();
//        System.out.println(next);

//        TinkerGraph tinkerGraph = TinkerFactory.createModern();
//        GraphTraversalSource g = tinkerGraph.traversal().withRemote(Graph.remoteConfiguration);
//        org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal<Vertex, Vertex> vertex = g.V()/*.filter(Lambda.predicate("it.get().label().equals('test')")).label()*/;
//        Vertex next1 = vertex.next();
//        System.out.println(next1);

        TinkerGraph tinkerGraph = TinkerFactory.createTheCrew();
        GraphTraversalSource g = tinkerGraph.traversal().withComputer().withRemote(Graph.remoteConfiguration);
        GraphTraversal<Vertex, ? extends Property<Object>> vertex = g.V().properties().properties()/*.filter(Lambda.predicate("it.get().label().equals('test')")).label()*/;

        Property<Object> next1 = vertex.next();
        System.out.println(next1);

//        graph.submit(g.addV("test"));
//        graph.submit(g.addV("test"));
//        graph.submit(g.addV("test"));
//        ResultSet submit = graph.submit(label);
//        submit.forEach(System.out::println);
//        graph.close();

    }
}