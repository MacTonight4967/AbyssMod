package me.ciruu.abyss;

import java.util.Locale;
import me.ciruu.abyss.Class163;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.client.Client;

public class Class645
extends Class163 {
    public Class645() {
        super("prefix", "Changes the prefix of the client", "prefix new prefix");
    }

    public void Method4253(String string) {
        String string2 = string.toLowerCase(Locale.ROOT).replace("prefix", "").replaceAll("", "");
        ((Client)Manager.moduleManager.getModuleByClass(Client.class)).cmdprefix.setValue(string2.substring(0, 1));
        Globals.printChatMessage("New prefix set to:" + string2.charAt(0));
    }
}
