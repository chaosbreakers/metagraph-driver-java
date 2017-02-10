package io.metagraph.driver.resultmodel.login;

/**
 * Created by (zhaoliang@metagraph.io) on (17-2-10).
 */
public class User {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}