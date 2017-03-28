package io.metagraph.driver;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.tinkerpop.gremlin.driver.Client;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.ResultSet;
import org.apache.tinkerpop.gremlin.process.traversal.Bytecode;
import org.apache.tinkerpop.gremlin.process.traversal.Traversal;
import org.apache.tinkerpop.gremlin.process.traversal.TraversalSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * graph.
 * Created by (zhaoliang@metagraph.io) on (17-2-7).
 */
public class Graph {

    public static final Logger logger = LoggerFactory.getLogger(Graph.class);

    private Configuration configuration;
    private Cluster cluster;
    private Client client;

    public static Configuration remoteConfiguration = new PropertiesConfiguration() {
        {
            setProperty(TraversalSource.GREMLIN_REMOTE_CONNECTION_CLASS, "org.apache.tinkerpop.gremlin.driver.remote.DriverRemoteConnection");
            setProperty("gremlin.remote.driver.sourceName", "g");
        }
    };

    /**
     * @param configuration @see <a href="http://tinkerpop.apache.org/docs/current/reference/#_configuration">configuration</a>
     */
    public Graph(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * establish connection with cluster.
     */
    public void connect() {
        if (null == configuration) {
            logger.warn("the import configuration is null, use the default configuration settings.");
            this.cluster = Cluster.open();
        } else {
            this.cluster = Cluster.open(configuration);
        }
        this.client = cluster.connect().alias("g");
    }

    public void close() {
        if (null != client) {
            client.close();
        }
        if (null != cluster) {
            cluster.close();
        }
    }

    /**
     * @param traversal {@link Traversal}
     * @return {@link ResultSet}
     */
    public ResultSet submit(final Traversal traversal) {
        return client.submit(traversal);
    }

    public ResultSet submit(String gremlin) {
        return client.submit(gremlin);
    }

    public ResultSet submit(Bytecode bytecode) {
        return client.submit(bytecode);
    }

}
