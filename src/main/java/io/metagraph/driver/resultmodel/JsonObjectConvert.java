package io.metagraph.driver.resultmodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

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
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.disable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, false);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, false);
        objectMapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, false);
    }

    public Object convert(ReturnType type,String json) {
        switch (type) {
            case list:
                break;
            case open:
                break;
            case close:
                break;
            case create:
                break;
            case update:
                break;
            case delete:
                break;
            case gremlin:
                break;
            case traversal:
                break;
        }
        return null;
    }
}
