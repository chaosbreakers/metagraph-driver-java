package io.metagraph.driver;

import io.metagraph.driver.restservice.RestApiVerticle;
import io.vertx.core.Vertx;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URL;

/**
 * test for {@link Metagraph}
 * Created by (zhaoliang@metagraph.io) on (17-2-8).
 */
public class MetagraphTest {

    private static Vertx vertx;
    private static String deployId;
    private static Metagraph metagraph;

    @BeforeClass
    public static void setUp() throws Exception {
        System.out.println("enter setUp");
        vertx = Vertx.vertx();
        vertx.deployVerticle(new RestApiVerticle(), res -> {
            if (res.succeeded()) {
                System.out.println("Deployment id is: " + res.result());
                deployId = res.result();
            } else {
                System.out.println("Deployment failed!");
            }
        });
        metagraph = new Metagraph(new URL("http://localhost:12345"), "name", "password");
    }

    @AfterClass
    public static void tearDown() throws Exception {
//        vertx.undeploy("io.metagraph.driver.restservice.RestApiVerticle");
    }

    @Test
    public void list() throws Exception {
//        String graphs = metagraph.graphs();
//        System.out.println(graphs);

    }

    @Test
    public void open() throws Exception {
        Thread.sleep(900090L);

    }

    @Test
    public void create() throws Exception {

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