package io.metagraph.driver;

import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.net.URL;

/**
 * metagraph.
 * <p>
 * Created by (zhaoliang@metagraph.io) on (17-2-7).
 */
public class Metagraph {

    private URL url;
    private String token;

    public Metagraph(URL url, String username, String password) {
        this.url = url;
        this.token = authorize(username, password);
    }

    private String authorize(String username, String password) {
        String token = "";
        /*try {
            token = Request.Get(url.toString() + REQUEST_PATH_AUTHORIZATION)
                    .connectTimeout(1000)
                    .socketTimeout(1000)
                    .execute()
                    .returnContent()
                    .asString();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
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
    private String graphs() throws IOException {
        return Request.Get(format(""))
                .addHeader("token", token)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnContent()
                .asString();
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
    public void close(String graphId) throws IOException {
        Request.Put(format(graphId) + "/close")
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnContent()
                .asString();
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

    private String getGraphIdFromJson(String json) {
        String graphId = "";
        // TODO: 17-2-8 graph id.
        return graphId;
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
