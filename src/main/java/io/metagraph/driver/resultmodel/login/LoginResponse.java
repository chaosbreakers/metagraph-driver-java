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

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    private Result result;
    private AccessToken accessToken;



}






