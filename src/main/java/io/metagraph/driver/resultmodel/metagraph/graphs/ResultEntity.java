package io.metagraph.driver.resultmodel.metagraph.graphs;

import java.util.List;

/**
 * Created by (zhaoliang@metagraph.io) on (17-2-15).
 */
public class ResultEntity {
    /**
     * graph_name : ["testGraph2"]
     * id : ciz6natqq0006ip8314rp32pk
     * label : graph
     */
    private List<String> graph_name;
    private String id;
    private String label;

    public void setGraph_name(List<String> graph_name) {
        this.graph_name = graph_name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<String> getGraph_name() {
        return graph_name;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
}
