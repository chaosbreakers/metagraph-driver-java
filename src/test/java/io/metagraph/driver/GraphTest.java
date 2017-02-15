package io.metagraph.driver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

/**
 * Created by (zhaoliang@metagraph.io) on (17-2-15).
 */
public class GraphTest {
    private static Metagraph metagraph;
    private static Graph open;
    private static Logger logger = LoggerFactory.getLogger(GraphTest.class);


    @BeforeClass
    public static void setUp() throws Exception {
        metagraph = new Metagraph(new URL("http://192.168.199.189:8080"), "openmg", "openmg");
        Graph testGraph = metagraph.create("testGraph3");
        open = metagraph.open(testGraph.getGraphId());

    }

    @AfterClass
    public static void tearDown() throws Exception {


    }

    @Test
    public void gremlin() throws Exception {
        logger.info("graphId={}", open.getGraphId());
        open.gremlin("g.V().count()", "tp");

    }

    @Test
    public void traversal() throws Exception {
        String jsonFormat = "{\"gremlin\": \"%s\"}";
        String parameters = String.format(jsonFormat, "g.V().count()");
        open.traversal(parameters);
    }

}