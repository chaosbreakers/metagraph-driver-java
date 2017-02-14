/*
 *
 *   Copyright (C) 2015-2017 Monogram Inc.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

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
