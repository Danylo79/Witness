package dev.dankom.witness.file.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonObjectBuilder {
    private final JSONObject jsonObject;

    public JsonObjectBuilder() {
        this.jsonObject = new JSONObject();
    }

    public JsonObjectBuilder addArray(String name, Iterable<?> contents) {
        JSONArray array = new JSONArray();
        for (Object o : contents) {
            array.add(o);
        }
        jsonObject.put(name, array);
        return this;
    }

    public JsonObjectBuilder addKeyValuePair(String key, Object value) {
        jsonObject.put(key, value);
        return this;
    }

    public JSONObject build() {
        return jsonObject;
    }
}
