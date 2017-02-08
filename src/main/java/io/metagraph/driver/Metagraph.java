package io.metagraph.driver;

import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * metagraph.
 * <p>
 * Created by (zhaoliang@metagraph.io) on (17-2-7).
 */
public class Metagraph {

    private URL url;

    private static String REQUEST_PATH_OPEN = "";
    private static String REQUEST_PATH_CREATE = "";
    private static String REQUEST_PATH_CLOSE = "";
    private static String REQUEST_PATH_DELETE = "";
    private static String REQUEST_PATH_CLONE = "";

    public Metagraph(URL url) {
        this.url = url;
    }

    /**
     * open a graph
     *
     * @param url graph address.
     * @return a graph object.
     * @throws IOException
     */
    public Graph open(URL url) throws IOException {
        Request.Get(url.toString() + REQUEST_PATH_OPEN)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnContent()
                .asString();
        return null;
    }

    /**
     * create a graph on metagraph server.
     *
     * @return the created graph if success.
     * @throws IOException
     * @throws URISyntaxException
     */
    public Graph create() throws IOException, URISyntaxException {
        Request.Get(url.toString() + REQUEST_PATH_CREATE)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnContent()
                .asString();
        return null;
    }

    /**
     * 断开与metagraph的连接。
     *
     * @throws IOException
     */
    public void close() throws IOException {
        Request.Get(url.toString() + REQUEST_PATH_CLOSE)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnContent()
                .asString();
    }

    /**
     * delete a graph in metagraph.
     *
     * @throws IOException
     */
    public void delete() throws IOException {
        Request.Get(url.toString() + REQUEST_PATH_DELETE)
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
}
