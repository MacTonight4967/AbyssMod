package me.ciruu.abyss;

import me.ciruu.abyss.Class99;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.client.ClickGUI;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;

public class Class98
extends Class99 {
    public Class98(String string) {
        super(string);
    }

    public void Method237(String[] stringArray) {
        if (stringArray.length < 2) {
            return;
        }
        if (stringArray[1].equalsIgnoreCase("interface")) {
            ((ClickGUI)Manager.moduleManager.getModuleByClass(ClickGUI.class)).Method238();
        } else if (stringArray[1].equalsIgnoreCase("chat") && Globals.mc.currentScreen == null) {
            Globals.mc.displayGuiScreen((GuiScreen)new GuiChat());
        }
    }

    public boolean Method239(String[] stringArray) {
        if (stringArray[0] == null) {
            return false;
        }
        return stringArray[0].equalsIgnoreCase("open");
    }
}
