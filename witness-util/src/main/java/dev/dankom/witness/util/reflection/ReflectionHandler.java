package dev.dankom.witness.util.reflection;

import dev.dankom.type.ReflectionData;
import dev.dankom.util.reflection.ReflectionUtil;

public class ReflectionHandler {

    private final Class<?> clazz;

    public ReflectionHandler(Class<?> clazz) {
        this.clazz = clazz;
    }

    public ReflectionData getMethodData(String name, Class<?>... obj) {
        try {
            return dev.dankom.util.reflection.ReflectionUtil.getMethodData(clazz.getDeclaredMethod(name, obj));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ReflectionData getFieldData(String name) {
        try {
            return dev.dankom.util.reflection.ReflectionUtil.getFieldData(clazz.getDeclaredField(name));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ReflectionData getClassData() {
        return ReflectionUtil.getClassData(clazz);
    }

    public Class<?> getClazz() {
        return clazz;
    }
}
