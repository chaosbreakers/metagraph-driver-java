package io.metagraph.driver.resultmodel.metagraph;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * response.
 * Created by (zhaoliang@metagraph.io) on (17-2-9).
 */
public class MetagraphResponse {

    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("graph_name")
    private String graphName;

    private List<Result> result;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getGraphName() {
        return graphName;
    }

    public void setGraphName(String graphName) {
        this.graphName = graphName;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "MetagraphResponse{" +
                "requestId='" + requestId + '\'' +
                ", graphName='" + graphName + '\'' +
                ", result=" + result +
                '}';
    }
}
