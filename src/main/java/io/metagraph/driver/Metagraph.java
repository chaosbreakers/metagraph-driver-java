package io.metagraph.driver;

import io.metagraph.driver.resultmodel.JsonObjectConvert;
import io.metagraph.driver.resultmodel.login.LoginResponse;
import io.metagraph.driver.resultmodel.metagraph.MetagraphResponse;
import io.metagraph.driver.resultmodel.metagraph.Result;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * metagraph.
 * <p>
 * Created by (zhaoliang@metagraph.io) on (17-2-7).
 */
public class Metagraph {

    public static final Logger logger = LoggerFactory.getLogger(Graph.class);
    private URL url;
    private String token;

    public Metagraph(URL url, String username, String password) {
        this.url = url;
        this.token = authorize(username, password);
    }

    /**
     * authorize.
     *
     * @param username username
     * @param password password
     * @return token
     */
    private String authorize(String username, String password) {
        String token = null;
        String resultJson = "";
        try {
            resultJson = Request.Get(url.toString())
                    .connectTimeout(1000)
                    .socketTimeout(1000)
                    .execute()
                    .returnContent()
                    .asString();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        try {
            LoginResponse loginResponse = JsonObjectConvert.convertToLoginResponse(resultJson);
            token = loginResponse.getAccessToken().getToken();

        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return token;
    }


    /**
     * 获取用户对应的所有的图的信息。
     * get all the graphs of the login user
     * <p>
     * GET: /graphs
     *
     * @return json
     */
    public MetagraphResponse graphs() throws IOException {
        String result = Request.Get(format(""))
                .addHeader("token", this.token)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnContent()
                .asString();
        return JsonObjectConvert.convertToMetagraphResponse(result);
    }

    /**
     * create a graph on metagraph server.
     * <p>
     * POST: /graphs
     *
     * @return the created graph if success.
     */
    public Graph create() throws IOException {
        String json = Request.Post(format(""))
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnContent()
                .asString();
        String graphId = getGraphIdFromJson(json);
        return new Graph(url.toString(), graphId);
    }

    /**
     * open a graph.
     * <p>
     * GET: /graphs/:gid
     *
     * @param graphId graph id.
     * @return a graph object.
     */
    public Graph open(String graphId) throws IOException {
        String resultJson = Request.Get(format(graphId))
                .addHeader("token", this.token)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnContent()
                .asString();

        return new Graph(url.toString(), graphId);
    }

    /**
     * PUT: /graphs/:gid
     *
     * @param graphId graph id.
     */
    public void update(String graphId) throws IOException {
        String resultJson = Request.Put(format(graphId))
                .addHeader("token", this.token)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnContent()
                .asString();
    }

    /**
     * delete a graph in metagraph.
     * <p>
     * DELETE: /graphs/:gid
     */
    public void delete(String graphId) throws IOException {
        Request.Delete(format(graphId))
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnContent()
                .asString();
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
        String result = Request.Put(format(graphId) + "/close")
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnContent()
                .asString();
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

    //------- git function --------

    public void cloneGraph(URL from, URL to) {

    }

    public void cloneGraph(URL to) {
        cloneGraph(url, to);
    }

    public void branch(URL url) {

    }

    public void fork(URL url) {

    }

    private String format(String graphId) {
        return String.format(url.toString() + "/graphs/%s", graphId);
    }
}
