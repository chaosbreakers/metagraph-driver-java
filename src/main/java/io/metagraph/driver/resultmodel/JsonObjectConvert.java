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

package io.metagraph.driver.resultmodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.metagraph.driver.resultmodel.graph.GraphResponse;
import io.metagraph.driver.resultmodel.metagraph.graphs.GraphsResponse;
import io.metagraph.driver.resultmodel.login.LoginResponse;
import io.metagraph.driver.resultmodel.metagraph.create.CreateResponse;
import io.metagraph.driver.resultmodel.metagraph.MetagraphResponse;

import java.io.IOException;

/**
 * test.
 * <p>
 * Created by (zhaoliang@metagraph.io) on (17-2-9).
 */
public class JsonObjectConvert {

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
//        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.disable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
    }

    public static GraphResponse convertToGraphResponse(String json) throws IOException {
        return objectMapper.readValue(json, GraphResponse.class);
    }

    public static MetagraphResponse convertToMetagraphResponse(String json) throws IOException {
        return objectMapper.readValue(json, MetagraphResponse.class);
    }

    public static CreateResponse convertToCreateResponse(String json) throws IOException {
        return objectMapper.readValue(json,CreateResponse.class);
    }

    public static LoginResponse convertToLoginResponse(String json) throws IOException {
        return objectMapper.readValue(json, LoginResponse.class);
    }

    public static GraphsResponse convertToGraphsResponse(String json) throws IOException {
        return objectMapper.readValue(json,GraphsResponse.class);
    }
}
