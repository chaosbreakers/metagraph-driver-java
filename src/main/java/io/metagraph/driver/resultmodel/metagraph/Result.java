package io.metagraph.driver.resultmodel.metagraph;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by (zhaoliang@metagraph.io) on (17-2-9).
 */
public class Result {

    @JsonProperty("graph_url")
    private String graphURL;

    @JsonProperty("graph_id")
    private String graphId;

    private String msg;

    public String getGraphURL() {
        return graphURL;
    }

    public void setGraphURL(String graphURL) {
        this.graphURL = graphURL;
    }

    public String getGraphId() {
        return graphId;
    }

    public void setGraphId(String graphId) {
        this.graphId = graphId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
