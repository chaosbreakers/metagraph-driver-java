package io.metagraph.driver;

import org.apache.http.client.fluent.Request;

import java.io.IOException;

/**
 * graph.
 * Created by (zhaoliang@metagraph.io) on (17-2-7).
 */
public class Graph {

    private Strategies strategy = Strategies.standard;
    private String host;
    private String graphId;
    private String requestUrl;

    private String format = "/graphs/%s/traversal";

    public Graph(String host, String graphId) {
        this.host = host;
        this.graphId = graphId;
        this.requestUrl = format(graphId);
    }

    public void gremlin(String gremlinScript) throws IOException {
        Request.Get(format(graphId) + "?gremlin=" + gremlinScript)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnContent()
                .asString();
    }

    public void traversal(String gremlinScript) {

    }

    public static void main(String[] args) {
        Graph graph = new Graph("http://localhost:8080", "string");
    }

    private String format(String graphId) {
        return String.format(host + format, graphId);
    }
}
