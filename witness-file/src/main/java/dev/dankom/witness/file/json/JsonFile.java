package dev.dankom.witness.file.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;

public class JsonFile {
    private final File path;
    private final String name;
    private final JSONObject json;
    private final JSONObject def;

    public JsonFile(File path, String name, JSONObject def) {
        this(path, name, "json", def);
    }

    public JsonFile(File path, String name, String extension, JSONObject def) {
        this.path = path;
        this.name = name + "." + extension;
        this.def = def;
        this.json = this.def;

        generate();
    }

    public JsonFile(File path, String name) {
        this(path, name, new JsonObjectBuilder().build());
    }

    public void generate() {
        if (!isGenerated()) {
            create();
        } else {
            update();
        }
    }

    public JSONObject get() {
        if (!isGenerated()) {
            generate();
        }
        File out = new File(path, getName());
        JSONParser parser = new JSONParser();

        try {
            return (JSONObject) parser.parse(new FileReader(out));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void create() {
        JSONObject obj = json;

        if (!path.exists()) {
            path.mkdirs();
        }

        try (FileWriter file = new FileWriter(new File(path, getName()))) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update() {
        JSONObject obj = get();
        boolean updated = false;

        for (Iterator iterator = def.keySet().iterator(); iterator.hasNext(); ) {
            String key = (String) iterator.next();
            Object val = def.get(key);

            if (obj.containsKey(key)) {
                continue;
            } else {
                obj.put(key, val);
                updated = true;
            }
        }

        if (updated) {
            try (FileWriter file = new FileWriter(new File(path, getName()))) {
                file.write(obj.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isGenerated() {
        try {
            File main = new File(path, getName());
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(main));
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void purge() {
        try (FileWriter file = new FileWriter(new File(path, getName()))) {
            file.write(def.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void save() {
        purge();
        generate();
    }

    public void set(String key, Object value) {
        json.put(key, value);
        save();
    }

    public void addToArray(String array, Object o) {
        JSONArray jsonArray = (JSONArray) json.get(array);
        jsonArray.add(o);
        set(array, jsonArray);
    }

    public void removeFromArray(String array, Object o) {
        JSONArray jsonArray = (JSONArray) json.get(array);
        jsonArray.remove(o);
        set(array, jsonArray);
    }
}
