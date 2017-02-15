package io.metagraph.driver.resultmodel.metagraph.graphs;

import java.util.List;

/**
 * Created by (zhaoliang@metagraph.io) on (17-2-15).
 */
public class GraphsResponse {


    /**
     * result : [{"graph_name":["testGraph2"],"id":"ciz6natqq0006ip8314rp32pk","label":"graph"},{"graph_name":["testGraph1"],"id":"ciz6natpn0003ip83a87qavco","label":"graph"}]
     * requestId : 9c110d13-1483-4b71-9936-cbd05fb0b031
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
}
