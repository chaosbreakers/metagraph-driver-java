package io.metagraph.driver.traversal.dsl;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.DefaultGraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.step.map.AddVertexStep;
import org.apache.tinkerpop.gremlin.process.traversal.step.map.PropertiesStep;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Property;
import org.apache.tinkerpop.gremlin.structure.PropertyType;
import org.apache.tinkerpop.gremlin.structure.Vertex;

/**
 * @author ZhaoPeng
 */
public class MetagraphTraversal<S, E> extends DefaultGraphTraversal<S, E> {

    public MetagraphTraversal() {
        super();
    }

    public MetagraphTraversal(final GraphTraversalSource graphTraversalSource) {
        super(graphTraversalSource);
    }

    public MetagraphTraversal(final Graph graph) {
        super(graph);
    }

    public static GraphTraversal<Vertex, Vertex> addFile(GraphTraversal<Vertex, Vertex> g, Object file) {

        g.asAdmin().getBytecode().addStep("saveFile", new Object[]{file});
        return g.asAdmin().addStep(new AddVertexStep(g.asAdmin(), null));
    }

    public <E2> GraphTraversal<S, ? extends Property<Object>> readFile(GraphTraversal<S, E> g) {
        g.asAdmin().getBytecode().addStep("readFile");
        return g.asAdmin().addStep(new PropertiesStep(g.asAdmin(), PropertyType.PROPERTY));
    }

}