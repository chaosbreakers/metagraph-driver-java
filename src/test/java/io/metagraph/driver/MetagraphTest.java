package io.metagraph.driver;

import io.metagraph.driver.resultmodel.metagraph.MetagraphResponse;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URL;

/**
 * test for {@link Metagraph}
 * Created by (zhaoliang@metagraph.io) on (17-2-8).
 */
public class MetagraphTest {

    private static Metagraph metagraph;
    private String graphId = null;

    @BeforeClass
    public static void setUp() throws Exception {
//        metagraph = new Metagraph(new URL("http://localhost:8080"), "openmg", "openmg");
        metagraph = new Metagraph(new URL("http://192.168.199.189:8080"), "openmg", "openmg");
    }

    @AfterClass
    public static void tearDown() throws Exception {
    }

    @Test
    public void token() throws Exception {
        String token = metagraph.getToken();
        System.out.println(token);
        Assert.assertNotNull(token);
        Assert.assertTrue(token.length() > 0);
    }

    @Test
    public void graphs() throws Exception {
        MetagraphResponse graphs = metagraph.graphs();
        System.out.println(graphs);

    }

    @Test
    public void create() throws Exception {
        Graph graph = metagraph.create("testGraph");
        graphId = graph.getGraphId();
        Assert.assertNotNull(graphId);
        Assert.assertTrue(graphId.length() > 0);
    }

    @Test
    public void open() throws Exception {
        Graph graph = metagraph.open(graphId);
    }

    @Test
    public void close() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void cloneGraph() throws Exception {

    }

    @Test
    public void cloneGraph1() throws Exception {

    }

    @Test
    public void branch() throws Exception {

    }

    @Test
    public void fork() throws Exception {

    }

}