package io.metagraph.driver.resultmodel.graphs;

import java.util.List;

/**
 * Created by (zhaoliang@metagraph.io) on (17-2-15).
 */
public class GraphsResponse {


    /**
     * result : [{"graph_name":["testGraph2"],"label":"graph","id":"ciz6fmldf000cvi836ta6i6g4"},{"graph_name":["testGraph2"],"label":"graph","id":"ciz6flsja0006vi8371v03m3v"},{"graph_name":["testGraph1"],"label":"graph","id":"ciz6fmlck0009vi83dpe4lazu"},{"graph_name":["testGraph2"],"label":"graph","id":"ciz6fn2i3000ivi83udcfkpcr"},{"graph_name":["testGraph1"],"label":"graph","id":"ciz6fn2hi000fvi83kzu8gn5d"},{"graph_name":["testGraph1"],"label":"graph","id":"ciz6flsi30003vi83canj07eh"}]
     * requestId : 59f85184-734e-4a8c-b3a4-ab58915b4954
     * successful : true
     */
    private List<ResultEntity> result;
    private String requestId;
    private boolean successful;

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public String getRequestId() {
        return requestId;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public class ResultEntity {
        /**
         * graph_name : ["testGraph2"]
         * label : graph
         * id : ciz6fmldf000cvi836ta6i6g4
         */
        private List<String> graph_name;
        private String label;
        private String id;

        public void setGraph_name(List<String> graph_name) {
            this.graph_name = graph_name;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getGraph_name() {
            return graph_name;
        }

        public String getLabel() {
            return label;
        }

        public String getId() {
            return id;
        }
    }
}
