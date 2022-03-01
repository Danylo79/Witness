package dev.dankom.witness.util.general;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptUtil {
    private static final ScriptEngineManager factory = new ScriptEngineManager();

    //Script Engines
    public static final ScriptEngine JAVASCRIPT = getScriptEngine("JavaScript");
    public static final ScriptEngine PYTHON = getScriptEngine("python");

    public static ScriptEngine getScriptEngine(String name) {
        return factory.getEngineByName(name);
    }

    public static ScriptEngineManager getScriptEngineManager() {
        return factory;
    }
}
