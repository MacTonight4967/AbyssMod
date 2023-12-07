package me.ciruu.abyss;

import java.util.concurrent.ConcurrentHashMap;
import me.ciruu.abyss.modules.Module;

public class Class178 {
    public void Method489(Module module) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();
        concurrentHashMap.put("enabled", module.Method490() ? "true" : "false");
        concurrentHashMap.put("display", module.Method491());
        concurrentHashMap.put("keybind", module.Method160());
        concurrentHashMap.put("hidden", module.Method492() ? "true" : "false");
    }
}
