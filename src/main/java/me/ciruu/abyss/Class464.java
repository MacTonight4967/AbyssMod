package me.ciruu.abyss;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.Module;

public class Class464 {
    private final Map Field2550 = new HashMap();

    public void Method2022() {
        for (Module module : this.Field2550.keySet()) {
            this.Method3059(Manager.moduleManager.getModuleByClass(module.getClass()));
        }
    }

    public void Method3059(Module module) {
        this.Field2550.put(module, module.Method591());
    }

    public List Method2580(Module module) {
        return Manager.moduleManager.getModuleByClass(module.getClass()).Method591();
    }
}
