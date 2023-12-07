package me.ciruu.abyss;

import me.ciruu.abyss.Class163;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.Module;

public class Class624
extends Class163 {
    public Class624() {
        super("Bind", "Allows you to bind a mod to a key", "bind module key");
        this.Field2732.add("<module>");
        this.Field2732.add("<module> <key>");
    }

    public void Method3340(String string) {
        String[] stringArray = string.split("");
        if (stringArray == null || stringArray.length <= 1) {
            this.Method3341("Invalid Input");
            return;
        }
        Module module = Manager.moduleManager.getModuleByName(stringArray[1]);
        if (module != null) {
            if (stringArray.length <= 2) {
                this.Method3341(String.format("The key of %s is %s", module.Method491(), module.Method160()));
                return;
            }
            module.Method177(stringArray[2].toUpperCase());
            this.Method3341(String.format("Set the key of %s to %s", module.Method491(), module.Method160()));
        } else {
            this.Method3341(String.format("Could not find the module named %s", stringArray[1]));
        }
    }

    public String Method3343() {
        return "Allows you to Bind a mod";
    }
}
