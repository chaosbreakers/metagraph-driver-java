package io.metagraph.driver;

import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.remote.DriverRemoteConnection;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.util.empty.EmptyGraph;

/**
 * Created by Utopia on 2017-06-20.
 */
public class GremlinDriverTest {

    public static void main(String[] args) {
        Cluster cluster = Cluster.build().addContactPoint("192.168.94.11").port(8182).create();
        Graph graph = EmptyGraph.instance();
        GraphTraversalSource g = graph.traversal().withRemote(DriverRemoteConnection.using(cluster, "metagraph"));
        System.out.println("test---" + g.V().count().next().longValue());
        g.addV("test");
        //CompletableFuture<List<Result>> results = client.submit("[1,2,3,4]").all();
        //System.out.println("test"+results.toString());
    }

}
