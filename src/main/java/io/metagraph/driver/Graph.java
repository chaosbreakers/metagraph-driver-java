package io.metagraph.driver;

import io.metagraph.driver.resultmodel.JsonObjectConvert;
import io.metagraph.driver.resultmodel.graph.GraphResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * graph.
 * Created by (zhaoliang@metagraph.io) on (17-2-7).
 */
public class Graph {

    public static final Logger logger = LoggerFactory.getLogger(Graph.class);
    private Strategies strategy = Strategies.standard;
    private String host;
    private String graphId;
    private String requestUrl;

    private String format = "/graphs/%s/traversal";

    public Graph(String host, String graphId) {
        this.host = host;
        this.graphId = graphId;
        this.requestUrl = format(this.graphId);
    }

    /**
     * execute gremlin script in remote graph cluster.
     *
     * @param gremlinScript for example : g.V().hasLabel('person')
     * @param mode tp or ap
     */
    public GraphResponse gremlin(String gremlinScript, String mode) throws IOException {
        String resultJson = Request.Get(requestUrl + "?gremlin=" + gremlinScript + "&mode=" + mode)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnContent()
                .asString();
        return JsonObjectConvert.convertToGraphResponse(resultJson);
    }

    /**
     * execute traversal in remote graph cluster.
     *
     * @param json :
     *             {
     *             "request_id": {
     *             "@type": "g:UUID",
     *             "@value": "id"
     *             },
     *             "op": "bytecode",
     *             "processor": "traversal",
     *             "args": {
     *             "gremlin": "string of a bytecode",
     *             "aliases": {
     *             "g": "standard or bsp"
     *             }
     *             }
     *             }
     * @return {
     * "request_id": "4f62ff27-aabb-4b8c-85df-44b0a6355870",
     * "status": {
     * "message": "",
     * "code": 200,
     * "attributes": {}
     * },
     * "result": {
     * "data": [
     * {
     * "id": 1,
     * "label": "graph",
     * "type": "vertex",
     * "properties": {
     * "name": [
     * {
     * "id": 0,
     * "value": "mg-graph"
     * }
     * ]
     * }
     * }
     * ],
     * "meta": {}
     * }
     * }
     */
    public GraphResponse traversal(String json) throws IOException {
        String resultJson = Request.Post(requestUrl).bodyString(json, ContentType.APPLICATION_JSON)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnContent()
                .asString();
        return JsonObjectConvert.convertToGraphResponse(resultJson);
    }

    /**
     * the request url of REST.
     *
     * @param graphId graph id
     * @return for example : http://www.company.com/graphs/graphId/traversal
     */
    private String format(String graphId) {
        return String.format(host + format, graphId);
    }
}
