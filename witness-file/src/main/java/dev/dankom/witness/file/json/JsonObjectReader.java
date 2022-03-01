package dev.dankom.witness.file.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonObjectReader {
    private final JSONObject json;
    private final JsonObjectReader instance;

    public JsonObjectReader(JSONObject json) {
        this.json = json;
        this.instance = this;
    }

    public Object get(String name) {
        return json.get(name);
    }

    public JSONArray getAsArray(String name) {
        return (JSONArray) json.get(name);
    }

    public JSONObject getAsJsonObject(String name) {
        return (JSONObject) json.get(name);
    }
}
