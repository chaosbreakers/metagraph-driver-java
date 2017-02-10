package io.metagraph.driver;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GremlinScript {

    private StringBuilder stringBuilder = new StringBuilder();

    public GremlinScript() {
        stringBuilder.append("g");
    }

    public GremlinScript V() {
        stringBuilder.append(".V()");
        return this;
    }

    public GremlinScript V(String id) {
        stringBuilder.append(".V('").append(id).append("')");
        return this;
    }

    public GremlinScript count() {
        stringBuilder.append(".count()");
        return this;
    }

    public GremlinScript as(String name) {
        stringBuilder.append(".as('").append(name).append("')");
        return this;
    }


    public GremlinScript addV(String label) {
        stringBuilder.append(".addV('").append(label).append("')");
        return this;
    }

    public GremlinScript addProperty(String key, String value) {
        stringBuilder.append(".property('").append(key).append("','").append(value).append("')");
        return this;
    }

    public GremlinScript out(String label) {
        stringBuilder.append(".out('").append(label).append("')");
        return this;
    }

    public GremlinScript property(String key, String value) {
        return property(key, value, false);
    }

    public GremlinScript outV() {
        stringBuilder.append(".outV()");
        return this;
    }

    public GremlinScript property(String key, String value, boolean valueIsMethod) {
        if (valueIsMethod) {
            stringBuilder.append(".property('").append(key).append("',").append(value).append(")");
        } else {
            stringBuilder.append(".property('").append(key).append("','").append(value).append("')");
        }
        return this;
    }

    public GremlinScript outE(String label) {
        stringBuilder.append(".outE('").append(label).append("')");
        return this;
    }

    public GremlinScript addE(String label) {
        stringBuilder.append(".addE('").append(label).append("')");
        return this;
    }

    public GremlinScript from(String name) {
        stringBuilder.append(".from('").append(name).append("')");
        return this;
    }

    public GremlinScript to(String name) {
        stringBuilder.append(".to('").append(name).append("')");
        return this;
    }

    public GremlinScript inV() {
        stringBuilder.append(".inV()");
        return this;
    }


    public GremlinScript addVertex(Map<String, String> properties) {
        if (properties != null && properties.size() > 0) {
            properties.keySet().forEach(key -> addProperty(key, properties.get(key)));
        }
        return this;
    }

    public GremlinScript hasLabel(String value) {
        stringBuilder.append(".hasLabel('").append(value).append("')");
        return this;
    }

    public GremlinScript valueMap(Set<String> keys) {
        if (keys == null || keys.size() > 0) {
            stringBuilder.append(".valueMap(");
            keys.forEach(s1 -> stringBuilder.append("'").append(s1).append("',"));
            stringBuilder = new StringBuilder(stringBuilder.substring(0, stringBuilder.length() - 1));
            stringBuilder.append(")");
        }
        return this;
    }

    public GremlinScript valueMap(String key) {
        stringBuilder.append(".valueMap('").append(key).append("')");
        return this;
    }

    public GremlinScript has(String propertyKey, String propertyValue) {
        return has(propertyKey, propertyValue, false);
    }

    public GremlinScript has(String key, String value, boolean valueIsMethod) {
        if (valueIsMethod) {
            stringBuilder.append(".has('").append(key).append("',").append(value).append(")");
        } else {
            stringBuilder.append(".has('").append(key).append("','").append(value).append("')");
        }
        return this;
    }

    public GremlinScript hasWithIn(String key, List<String> values) {
        if (values != null && values.size() > 0) {
            stringBuilder.append(".has('").append(key).append("',within(");
            values.forEach(s -> stringBuilder.append("'").append(s).append("',"));
        }
        stringBuilder = new StringBuilder(stringBuilder.substring(0,stringBuilder.length() - 1)).append("))");
        return this;
    }

    public GremlinScript values(String key) {
        stringBuilder.append(".values('").append(key).append("')");
        return this;
    }

    public GremlinScript inE(String label) {
        stringBuilder.append(".inE('").append(label).append("')");
        return this;
    }

    public GremlinScript next() {
        stringBuilder.append(".next()");
        return this;
    }

    public String build() {
        return stringBuilder.toString();
    }

}
