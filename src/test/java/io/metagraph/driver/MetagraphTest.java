package io.metagraph.driver;

import io.metagraph.driver.resultmodel.metagraph.GraphsResponse;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.net.URL;
import java.util.List;

import static org.junit.Assert.*;

/**
 * test for {@link Metagraph}
 * Created by (zhaoliang@metagraph.io) on (17-2-8).
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MetagraphTest {

    private static Metagraph metagraph;
    private String graphId = null;
    private String graphId1 = null;

    @BeforeClass
    public static void setUp() throws Exception {
//        metagraph = new Metagraph(new URL("http://localhost:8080"), "openmg", "openmg");
        metagraph = new Metagraph(new URL("http://192.168.199.189:8080"), "openmg", "openmg");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        metagraph.disConnect();
    }

    @Test
    public void test1token() throws Exception {
        String token = metagraph.getToken();
        assertNotNull(token);
        assertTrue(token.length() > 0);
    }

    @Test
    public void test2create() throws Exception {
        Graph graph = metagraph.create("testGraph1");
        graphId = graph.getGraphId();
        assertNotNull(graphId);
        assertTrue(graphId.length() > 0);

        Graph testGraph2 = metagraph.create("testGraph2");
        graphId1 = testGraph2.getGraphId();
        assertNotNull(graphId1);
        assertTrue(graphId1.length() > 0);
    }

    @Test
    public void test2graphs() throws Exception {
        GraphsResponse graphs = metagraph.graphs();
        List<GraphsResponse.ResultEntity> result = graphs.getResult();
        assertNotNull(result);
        assertTrue(result.size() == 2);
    }

    @Test
    public void test4open() throws Exception {
        metagraph.open(graphId);

    }

    @Test
    public void test5close() throws Exception {
        metagraph.close(graphId);

    }

    @Test
    public void test6delete() throws Exception {
        metagraph.delete(graphId);
        metagraph.delete(graphId1);
        GraphsResponse graphs = metagraph.graphs();
        List<GraphsResponse.ResultEntity> result = graphs.getResult();
        if (result != null) {
            assertEquals(0, result.size());
        }

    }

}