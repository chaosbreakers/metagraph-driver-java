package io.metagraph.driver;

import org.apache.tinkerpop.gremlin.driver.Client;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.Result;
import org.apache.tinkerpop.gremlin.driver.ResultSet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Created by Utopia on 2017-06-20.
 */
public class GremlinDriverTest {

    public static void main(String[] args) {
        Cluster cluster = Cluster.build().addContactPoint("localhost").port(8182).create();
        Client client = cluster.connect();
        /*ResultSet results1 = client.submit("[1,2,3,4]");
        results1.stream().map(i -> i.get(Integer.class) * 2);*/

        CompletableFuture<List<Result>> results = client.submit("[1,2,3,4]").all();
        CompletableFuture<ResultSet> future = client.submitAsync("[1,2,3,4]");
        Map<String, Object> params = new HashMap<>();
        params.put("x", 4);
        client.submit("[1,2,3,x]", params);
    }

}
