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
public class MetagraphFileTraversal<S, E> extends DefaultGraphTraversal<S, E> {

    private GraphTraversalSource gts;

    public MetagraphFileTraversal(final GraphTraversalSource graphTraversalSource) {
        super(graphTraversalSource);
        this.gts = graphTraversalSource;
    }

    public MetagraphFileTraversal(final Graph graph) {
        super(graph);
    }

    public GraphTraversal<Vertex, Vertex> addFile(Object file) {
        GraphTraversal<Vertex, Vertex> g = gts.V();
        g.asAdmin().getBytecode().addStep("saveFile", new Object[]{file});
        return g.asAdmin().addStep(new AddVertexStep(g.asAdmin(), null));
    }

    public <E2> GraphTraversal<S, ? extends Property<Object>> readFile() {
        GraphTraversal<Vertex, Vertex> g = gts.V();
        g.asAdmin().getBytecode().addStep("readFile");
        return g.asAdmin().addStep(new PropertiesStep(g.asAdmin(), PropertyType.PROPERTY));
    }

}