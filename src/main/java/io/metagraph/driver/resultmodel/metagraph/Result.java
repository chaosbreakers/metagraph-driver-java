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

    @Override
    public String toString() {
        return "Result{" +
                "graphURL='" + graphURL + '\'' +
                ", graphId='" + graphId + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
