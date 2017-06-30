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

package io.metagraph.driver;

/**
 * @author Ranger Tsao(https://github.com/boliza)
 */
public class MetagraphOptions {

    private static final int DEFAULT_HTTP_PORT = 8080;
    private static final int DEFAULT_WS_PORT = 8182;
    private static final String DEFAULT_HOST = "localhost";

    private int httpPort;
    private int wsPort;
    private String host;

    private String username;
    private String password;

    //TODO connection settings

    public MetagraphOptions() {
        this.host = DEFAULT_HOST;
        this.httpPort = DEFAULT_HTTP_PORT;
        this.wsPort = DEFAULT_WS_PORT;
    }

    public int getHttpPort() {
        return httpPort;
    }

    public MetagraphOptions setHttpPort(int httpPort) {
        this.httpPort = httpPort;
        return this;
    }

    public int getWsPort() {
        return wsPort;
    }

    public MetagraphOptions setWsPort(int wsPort) {
        this.wsPort = wsPort;
        return this;
    }

    public String getHost() {
        return host;
    }

    public MetagraphOptions setHost(String host) {
        this.host = host;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public MetagraphOptions setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public MetagraphOptions setPassword(String password) {
        this.password = password;
        return this;
    }
}
