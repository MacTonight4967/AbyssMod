package me.ciruu.abyss;

import me.ciruu.abyss.Class163;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.client.Client;

public class Class646
extends Class163 {
    public Class646() {
        super("help", "Shows the help message", "help");
    }

    public void Method4165(String string) {
        Globals.printChatMessage("Help page for Abyss:");
        for (Class163 class163 : Manager.Field1639.Method3633()) {
            String string2 = (String)((Client)Manager.moduleManager.getModuleByClass(Client.class)).cmdprefix.getValue();
            String string3 = string2 + class163.Method3632() + "" + class163.Method4027() + " Usage:" + string2 + class163.Method4031();
            Globals.printChatMessage(string3);
        }
    }
}
