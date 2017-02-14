package io.metagraph.driver.resultmodel.metagraph;

/**
 * Created by (zhaoliang@metagraph.io) on (17-2-14).
 */
public class CreateResponse {

    /**
     * result : {"graph_id":"ciz5culgx00030w83h18fsd5y"}
     * requestId : 5402aa4b-3d5e-41ad-b3bd-02c63487c304
     * successful : true
     */
    private ResultEntity result;
    private String requestId;
    private boolean successful;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public ResultEntity getResult() {
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
         * graph_id : ciz5culgx00030w83h18fsd5y
         */
        private String graph_id;

        public void setGraph_id(String graph_id) {
            this.graph_id = graph_id;
        }

        public String getGraph_id() {
            return graph_id;
        }
    }
}
