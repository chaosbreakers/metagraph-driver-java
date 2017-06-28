package io.metagraph.driver.traversal;

import org.apache.tinkerpop.gremlin.process.traversal.TraversalStrategies;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.step.map.AddVertexStartStep;
import org.apache.tinkerpop.gremlin.process.traversal.step.map.GraphStep;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;

/**
 * @author ZhaoPeng
 */
public class KuazGraphTraversalSource extends GraphTraversalSource {


    public KuazGraphTraversalSource(final Graph graph) {
        super(graph);
    }

    public KuazGraphTraversalSource(final Graph graph, final TraversalStrategies traversalStrategies) {
        super(graph, traversalStrategies);
    }

    @Override
    public KuazGraphTraversal<Vertex, Vertex> addV(final String label) {
        final GraphTraversalSource clone = this.clone();
        clone.getBytecode().addStep(GraphTraversal.Symbols.addV, label);
        final GraphTraversal.Admin<Vertex, Vertex> traversal = new KuazGraphTraversal<>(clone);
        return (KuazGraphTraversal) traversal.addStep(new AddVertexStartStep(traversal, label));
    }

    @Override
    public KuazGraphTraversal<Vertex, Vertex> addV() {
        final GraphTraversalSource clone = this.clone();
        clone.getBytecode().addStep(GraphTraversal.Symbols.addV);
        final GraphTraversal.Admin<Vertex, Vertex> traversal = new KuazGraphTraversal<>(clone);
        return (KuazGraphTraversal) traversal.addStep(new AddVertexStartStep(traversal, null));
    }

    @Override
    public KuazGraphTraversal<Vertex, Vertex> V(final Object... vertexIds) {
        final GraphTraversalSource clone = super.clone();
        clone.getBytecode().addStep(GraphTraversal.Symbols.V, vertexIds);
        final GraphTraversal.Admin<Vertex, Vertex> traversal = new KuazGraphTraversal<>(clone);
        return (KuazGraphTraversal) traversal.addStep(new GraphStep<>(traversal, Vertex.class, true, vertexIds));
    }

}