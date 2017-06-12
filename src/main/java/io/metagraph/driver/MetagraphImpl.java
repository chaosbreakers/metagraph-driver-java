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

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.metagraph.driver.json.JsonObject;


/**
 * @author Ranger Tsao(https://github.com/boliza)
 */
class MetagraphImpl implements Metagraph {

    private MetagraphOptions options;
    private RestTemplate restTemplate;

    private transient String token;

    private Map<String, MgitGraph> graphs = new ConcurrentHashMap<>();

    MetagraphImpl(MetagraphOptions options) {
        this.options = options;
        restTemplate = new RestTemplate();
        //TODO connect
    }

    @Override
    public List<MgitGraph> list() {
        return null;
    }

    @SuppressWarnings("unchecked")
    private <T> HttpEntity<String> buildHttpEntity(T body) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("Authentication", token);
        return body == null ? new HttpEntity<>(headers) : new HttpEntity(body, headers);
    }

    @Override
    public MgitGraph get(String id) {
        if (graphs.containsKey(id)) {
            return graphs.get(id);
        }
        HttpEntity<String> entity = buildHttpEntity(null);
        String json = restTemplate.exchange(String.format("http://%s:%d/graphs/{id}", options.getHost(), options.getHttpPort()), HttpMethod.GET, entity, String.class, id).getBody();
        MgitGraph graph = new MgitGraph(id, this, new JsonObject(json));
        graphs.put(id, graph);
        return graph;
    }

    @Override
    public MgitGraph create(String id, JsonObject jsonObject) {
        HttpEntity<String> entity = buildHttpEntity(jsonObject.toString());
        String json = restTemplate.exchange(String.format("http://%s:%d/graphs", options.getHost(), options.getHttpPort()), HttpMethod.POST, entity, String.class, id).getBody();
        MgitGraph graph = new MgitGraph(id, this, new JsonObject(json));
        graphs.put(id, graph);
        return graph;
    }

    @Override
    public MgitGraph update(String id, JsonObject metadata) {
        HttpEntity<String> entity = buildHttpEntity(metadata.toString());
        String json = restTemplate.exchange(String.format("http://%s:%d/graphs", options.getHost(), options.getHttpPort()), HttpMethod.PUT, entity, String.class, id).getBody();
        MgitGraph graph = new MgitGraph(id, this, new JsonObject(json));
        graphs.put(id, graph);
        return graph;
    }

    @Override
    public void delete(String id) {
        HttpEntity<String> entity = buildHttpEntity(null);
        restTemplate.exchange(String.format("http://%s:%d/graphs/{id}", options.getHost(), options.getHttpPort()), HttpMethod.DELETE, entity, String.class, id).getBody();
        graphs.remove(id);
    }

    @Override
    public void close() {

    }

    protected String getToken() {
        return token;
    }

    protected RestTemplate getRestTemplate() {
        return restTemplate;
    }
}
