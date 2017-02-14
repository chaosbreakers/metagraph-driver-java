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

package io.metagraph.driver.resultmodel.login;

/**
 * {
 * "successful": true,
 * "requestId": "8521f438-cfe2-4809-a89e-aa7fd5ec1dbb",
 * "result": {
 * "user": {
 * "username": "openmg"
 * },
 * "accessToken": {
 * "token": "ed3fac2f-3f99-424c-8ccb-7c695534e687",
 * "expiredIn": 48000
 * }
 * }
 * }
 * Created by (zhaoliang@metagraph.io) on (17-2-10).
 */
public class LoginResponse {

    private boolean successful;
    private String requestId;
    private Result result;


    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "successful=" + successful +
                ", requestId='" + requestId + '\'' +
                ", result=" + result +
                '}';
    }
}






