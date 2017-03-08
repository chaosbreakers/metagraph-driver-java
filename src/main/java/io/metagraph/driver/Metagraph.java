package io.metagraph.driver;

import io.metagraph.driver.resultmodel.JsonObjectConvert;
import io.metagraph.driver.resultmodel.login.LoginResponse;
import io.metagraph.driver.resultmodel.metagraph.MetagraphResponse;
import io.metagraph.driver.resultmodel.metagraph.Result;
import io.metagraph.driver.resultmodel.metagraph.create.CreateResponse;
import io.metagraph.driver.resultmodel.metagraph.graphs.GraphsResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * metagraph.
 * <p>
 * Created by (zhaoliang@metagraph.io) on (17-2-7).
 */
public class Metagraph {

    private static final Logger logger = LoggerFactory.getLogger(Graph.class);
    private static final int CONNECT_TIMEOUT = 10 * 1000;
    private static final int SOCKET_TIMEOUT = 10 * 1000;
    private URL url;
    private String token;

    public Metagraph(URL url, String username, String password) {
        this.url = url;
        this.token = connect(username, password);
    }

    public Metagraph(String url, String username, String password) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            logger.info(e.getMessage(), e);
        }
        this.token = connect(username, password);
    }

    /**
     * connect.
     * <p>
     * POST: /connect
     *
     * @param username username
     * @param password password
     * @return token
     */
    public String connect(String username, String password) {
        String token = null;
        String postParameter = "{\n" +
                "  \"username\":\"%s\",\n" +
                "  \"password\":\"%s\"\n" +
                "}";
        String resultJson = "";
        try {
            resultJson = Request.Post(url.toString() + "/connect")
                    .bodyString(String.format(postParameter, username, password), ContentType.APPLICATION_JSON)
                    .connectTimeout(CONNECT_TIMEOUT).socketTimeout(SOCKET_TIMEOUT)
                    .execute()
                    .returnContent()
                    .asString();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        try {
            LoginResponse loginResponse = JsonObjectConvert.convertToLoginResponse(resultJson);
            token = loginResponse.getResult().getAccessToken().getToken();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        logger.info("[connect][POST: /connect] connect to {} with {}={} and return the token is {}", url, username, password, token);
        return token;
    }

    /**
     * DELETE: /disconnect
     */
    public void disConnect() {
        try {
            Request.Delete(url.toString() + "/disconnect")
                    .addHeader("content-type", "application/json")
                    .addHeader("Authenticate", token)
                    .connectTimeout(CONNECT_TIMEOUT).socketTimeout(SOCKET_TIMEOUT)
                    .execute()
                    .returnContent()
                    .asString();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }


    /**
     * 获取用户对应的所有的图的信息。
     * get all the graphs of the login user
     * <p>
     * GET: /graphs
     *
     * @return json
     */
    public GraphsResponse graphs() throws IOException {
        String result = Request.Get(format(""))
                .addHeader("content-type", "application/json").addHeader("Authenticate", token)
                .connectTimeout(CONNECT_TIMEOUT).socketTimeout(SOCKET_TIMEOUT)
                .execute()
                .returnContent()
                .asString();
        logger.info("[graphs][GET: /graphs] and the result is {} ", result);
        return JsonObjectConvert.convertToGraphsResponse(result);
    }

    /**
     * create a graph on metagraph server.
     * <p>
     * POST: /graphs
     *
     * @return the created graph if success.
     */
    public Graph create(String graphName) throws IOException {
        String json = Request.Post(format(""))
                .addHeader("content-type", "application/json").addHeader("Authenticate", token)
                .bodyString(String.format("{\"graph_name\":\"%s\"}", graphName), ContentType.APPLICATION_JSON)
                .connectTimeout(CONNECT_TIMEOUT).socketTimeout(SOCKET_TIMEOUT)
                .execute()
                .returnContent()
                .asString();
        logger.info("[create][POST: /graphs] graphName={} token={} result json is {}.", graphName, token, json);
        CreateResponse createResponse = JsonObjectConvert.convertToCreateResponse(json);
        String graphId = createResponse.getResult().getGraph_id();
        return open(graphId);
    }

    /**
     * open a graph.
     * <p>
     * POST: /graphs/:gid/open
     *
     * @param graphId graph id.
     * @return a graph object.
     */
    public Graph open(String graphId) throws IOException {
        String resultJson = Request.Post(format(graphId) + "/open")
                .addHeader("content-type", "application/json")
                .addHeader("Authenticate", token)
                .connectTimeout(CONNECT_TIMEOUT).socketTimeout(SOCKET_TIMEOUT)
                .execute()
                .returnContent()
                .asString();

        logger.info("[open][POST: /graphs/:gid/open] with parameter graphId={}, result={}", graphId, resultJson);
        return new Graph();
    }

    /**
     * PUT: /graphs/:gid
     *
     * @param graphId graph id.
     */
    public void update(String graphId, String json) throws IOException {
        String resultJson = Request.Put(format(graphId))
                .bodyString(json, ContentType.APPLICATION_JSON)
                .addHeader("content-type", "application/json")
                .addHeader("Authenticate", token)
                .connectTimeout(CONNECT_TIMEOUT).socketTimeout(SOCKET_TIMEOUT)
                .execute()
                .returnContent()
                .asString();
        logger.info("[update][PUT: /graphs/:gid] with parameter graphId={} json={}, result={}", graphId, json, resultJson);

    }

    /**
     * delete a graph in metagraph.
     * <p>
     * DELETE: /graphs/:gid
     */
    public void delete(String graphId) throws IOException {
        String deleteJson = Request.Delete(format(graphId))
                .addHeader("content-type", "application/json")
                .addHeader("Authenticate", token)
                .connectTimeout(CONNECT_TIMEOUT).socketTimeout(SOCKET_TIMEOUT)
                .execute()
                .returnContent()
                .asString();
        logger.info("[delete][DELETE: /graphs/:gid] with parameter graphId={}; result={}", graphId, deleteJson);
    }

    /**
     * 断开与metagraph的连接。
     * <p>
     * PUT: /graphs/:gid/close
     * <p>
     * <p>
     * {
     * "request_id":"request_id",
     * "result":{
     * "msg":"close msg"
     * }
     * }
     */
    public boolean close(String graphId) throws IOException {
        String result = Request.Post(format(graphId) + "/close")
                .addHeader("content-type", "application/json")
                .addHeader("Authenticate", token)
                .connectTimeout(CONNECT_TIMEOUT).socketTimeout(SOCKET_TIMEOUT)
                .execute()
                .returnContent()
                .asString();
        logger.info("[close][PUT: /graphs/:gid/close] with parameter graphId={}; result={}", graphId, result);
        return StringUtils.isNotEmpty(result);

    }

    private String getGraphIdFromJson(String json) throws IOException {
        String graphId = "";
        MetagraphResponse metagraphResponse = JsonObjectConvert.convertToMetagraphResponse(json);
        List<Result> result = metagraphResponse.getResult();
        if (result != null && result.size() > 0) {
            graphId = result.get(0).getGraphId();
        }
        return graphId;
    }

    public String getToken() {
        return token;
    }

    private String format(String graphId) {
        return StringUtils.isEmpty(graphId) ? url.toString() + "/graphs" : String.format(url.toString() + "/graphs/%s", graphId);
    }
}
