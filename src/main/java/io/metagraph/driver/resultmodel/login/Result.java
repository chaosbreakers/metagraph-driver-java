package io.metagraph.driver.resultmodel.login;

/**
 * Created by (zhaoliang@metagraph.io) on (17-2-10).
 */
public class Result {

    User user;

    private AccessToken accessToken;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "Result{" +
                "user=" + user +
                ", accessToken=" + accessToken +
                '}';
    }
}