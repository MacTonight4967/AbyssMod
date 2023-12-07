package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.ciruu.abyss.Class163;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;

public class Class493
extends Class163 {
    public Class493() {
        super("Item", "List with items for InventoryInteract", "");
    }

    public void Method2140(String string) {
        String[] stringArray = string.split("");
        if (stringArray == null || stringArray.length <= 1) {
            this.Method2141("Invalid Input");
            return;
        }
        if (stringArray[1] != null && stringArray[2] != null) {
            if (stringArray[1].toLowerCase().startsWith("w")) {
                if (stringArray[2].toLowerCase().startsWith("a")) {
                    Manager.Field1255.Method2142(stringArray[3], false);
                } else if (stringArray[2].toLowerCase().startsWith("d")) {
                    Manager.Field1255.Method2143(stringArray[3], false);
                } else if (stringArray[2].toLowerCase().startsWith("s")) {
                    Manager.Field1255.Method2144(false);
                } else {
                    Globals.printChatMessage(ChatFormatting.RED + "Invalid action!");
                }
            } else if (stringArray[1].toLowerCase().startsWith("b")) {
                if (stringArray[2].toLowerCase().startsWith("a")) {
                    Manager.Field1255.Method2142(stringArray[3], true);
                } else if (stringArray[2].toLowerCase().startsWith("d")) {
                    Manager.Field1255.Method2143(stringArray[3], true);
                } else if (stringArray[2].toLowerCase().startsWith("s")) {
                    Manager.Field1255.Method2144(true);
                } else {
                    Globals.printChatMessage(ChatFormatting.RED + "Invalid action!");
                }
            } else {
                Globals.printChatMessage(ChatFormatting.RED + "Invalid mode!");
            }
        } else {
            Globals.printChatMessage(ChatFormatting.RED + "Invalid arguments!");
        }
    }
}
