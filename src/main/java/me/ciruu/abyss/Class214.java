package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.ciruu.abyss.Class163;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class128;
import me.ciruu.abyss.modules.hud.Notifications;

public class Class214
extends Class163 {
    public Class214() {
        super("Alias", "Change player's name client-side");
    }

    public void Method661(String string) {
        String[] stringArray = string.split("");
        if (stringArray == null || stringArray.length <= 1) {
            this.Method662("Invalid Input");
            return;
        }
        if (stringArray[1].toLowerCase().startsWith("a")) {
            if (stringArray.length >= 4) {
                try {
                    Manager.Field489.Method197(stringArray[2], stringArray[3]);
                    this.Method662(String.format("Added %s as alias %s.", stringArray[2], stringArray[3]));
                    this.Method663(Class128.Info, String.format("Added %s as alias %s.", stringArray[2], stringArray[3]));
                }
                catch (Exception exception) {
                    this.Method662(ChatFormatting.RED + "INVALID COMMAND");
                }
            } else {
                this.Method662("Usage: alias add <name> <alias>");
            }
        } else if (stringArray[1].toLowerCase().startsWith("d")) {
            if (stringArray.length >= 3) {
                if (Manager.Field489.Method198(stringArray[2])) {
                    this.Method662(String.format("Removed %s in alias.", stringArray[2]));
                    this.Method663(Class128.Warning, String.format("Removed %s in alias.", stringArray[2]));
                } else {
                    this.Method662(String.format("%s doesn't have an alias.", stringArray[2]));
                    this.Method663(Class128.Error, String.format("%s doesn't have an alias.", stringArray[2]));
                }
            } else {
                this.Method662("Usage: alias del <name>");
            }
        }
    }

    private void Method663(Class128 class128, String string) {
        if (((Boolean)((Notifications)Manager.moduleManager.getModuleByClass(Notifications.class)).alias.getValue()).booleanValue()) {
            Manager.Field424.Method342(class128, string);
        }
    }
}
