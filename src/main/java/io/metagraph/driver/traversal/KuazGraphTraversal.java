package io.metagraph.driver.traversal;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.DefaultGraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;

/**
 * @author ZhaoPeng
 */
public class KuazGraphTraversal<S, E> extends DefaultGraphTraversal<S, E> {

    public KuazGraphTraversal() {
        super();
    }

    public KuazGraphTraversal(final GraphTraversalSource graphTraversalSource) {
        super(graphTraversalSource);
    }

    public KuazGraphTraversal(final Graph graph) {
        super(graph);
    }


    public GraphTraversal<S, E> addFile(final Object bytes) {
        this.asAdmin().getBytecode().addStep("saveFile", bytes);
        //this.asAdmin().addStep(new SaveFileStep<>(this.asAdmin(), bytes));
        return this;
    }

    public GraphTraversal<S, E> hasFile() {
        this.asAdmin().getBytecode().addStep("hasFile");
        //return this.asAdmin().addStep(new HasFileStep<E>(this.asAdmin()));
        return this;
    }

    public <E2> GraphTraversal<S, ? extends E> readFile() {
        this.asAdmin().getBytecode().addStep("readFile");
        return this;
        //return this.asAdmin().addStep(new ReadFileStep<>(this.asAdmin()));
    }
}
