package io.metagraph.driver.resultmodel.login;

/**
 * Created by (zhaoliang@metagraph.io) on (17-2-10).
 */
public class AccessToken {
    private String token;
    private long expiredIn;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiredIn() {
        return expiredIn;
    }

    public void setExpiredIn(long expiredIn) {
        this.expiredIn = expiredIn;
    }
}
