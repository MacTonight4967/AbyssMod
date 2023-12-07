package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.ciruu.abyss.Class163;
import me.ciruu.abyss.Class208;
import me.ciruu.abyss.Globals;

public class Class484
extends Class163 {
    public Class484() {
        super("Profile", "Allows you to switch profiles", "profile <load/create> name");
        this.Field1716.add("<load> <name>");
        this.Field1716.add("<create> <name>");
    }

    public void Method2114(String string) {
        String[] stringArray = string.split("");
        if (stringArray == null || stringArray.length <= 1) {
            this.Method2115("Invalid Input");
            return;
        }
        String string2 = stringArray[1];
        if (string2 != null) {
            if (string2.equalsIgnoreCase("reload")) {
                Class208.Method2116();
                return;
            }
            if (string2.equalsIgnoreCase("list")) {
                Class208.Method2117();
                return;
            }
            String string3 = stringArray[2];
            if (string3 != null) {
                if (string2.equalsIgnoreCase("load")) {
                    Class208.Method2118(string3);
                    return;
                }
                if (string2.equalsIgnoreCase("add")) {
                    Class208.Method2119(string3);
                    return;
                }
                if (string2.equalsIgnoreCase("del")) {
                    Class208.Method2120(string3);
                    return;
                }
                Globals.printChatMessage(ChatFormatting.RED + "Invalid name!");
            } else {
                Globals.printChatMessage(ChatFormatting.RED + "Invalid name!");
            }
        } else {
            Globals.printChatMessage(ChatFormatting.RED + "Invalid action");
        }
    }
}
