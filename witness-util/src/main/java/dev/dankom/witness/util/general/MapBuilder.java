package dev.dankom.witness.util.general;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder<K, O> {
    private final Map<K, O> map = new HashMap<>();

    public Map<K, O> put(K key, O o) {
        map.put(key, o);
        return map;
    }
}
