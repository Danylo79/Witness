package dev.dankom.witness.util.reflection;

import dev.dankom.type.ReflectionData;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReflectionUtil {

    /**
     * @param dir  Package to get the classes from
     * @param type Derivative to look for
     * @return All the classes that implement/extend a type
     */
    public static <T> Set<Class<? extends T>> getAllClasses(String dir, Class<T> type) {
        Reflections reflection = new Reflections(dir);
        return reflection.getSubTypesOf(type);
    }

    /**
     * @param dir Package to get the classes from
     * @return All the classes
     */
    public static <T> Set<Class<?>> getAllClasses(String dir) {
        return getAllClasses(dir, Object.class);
    }

    /**
     * @param dir Package to get the classes from
     * @return All the types in the package
     */
    public static <T> Set<String> getAllTypes(String dir) {
        Reflections reflection = new Reflections(dir);
        return reflection.getAllTypes();
    }

    /**
     * @param m The method to extract the data from
     * @return The ReflectionData of the method
     * @see ReflectionData
     */
    public static ReflectionData getMethodData(Method m) {
        return new ReflectionData(m);
    }

    /**
     * @param c The class to extract the data from
     * @return The ReflectionData of the class
     * @see ReflectionData
     */
    public static ReflectionData getClassData(Class c) {
        return new ReflectionData(c);
    }

    /**
     * @param f The field to extract the data from
     * @return The ReflectionData of the field
     * @see ReflectionData
     */
    public static ReflectionData getFieldData(Field f) {
        return new ReflectionData(f);
    }

    public static <T> T newInstance(Class<T> clazz, Object... parameters) {
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor(inferArgumentTypes(parameters));
            constructor.setAccessible(true);
            return (T) constructor.newInstance(parameters);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T, C> T invokeMethod(Class<C> clazz, C instance, String name, Object... args) {
        try {
            Method m = clazz.getMethod(name, inferArgumentTypes(args));
            m.setAccessible(true);
            return (T) m.invoke(instance, args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T, C> T invokeMethod(Class<C> clazz, String name, Object... args) {
        try {
            Method m = clazz.getMethod(name, inferArgumentTypes(args));
            m.setAccessible(true);
            return (T) m.invoke(newInstance(clazz), args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <C> Class<C> classForName(String name) {
        try {
            return (Class<C>) Class.forName(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class[] inferArgumentTypes(Object... parameters) {
        List<Class> parameterTypes = new ArrayList<>();
        for (Object o : parameters) {
            parameterTypes.add(o.getClass());
        }
        return parameterTypes.toArray(new Class[] {});
    }
}
