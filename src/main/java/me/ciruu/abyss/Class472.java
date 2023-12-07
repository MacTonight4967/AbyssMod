package me.ciruu.abyss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import me.ciruu.abyss.Class457;
import me.ciruu.abyss.Class527;
import me.ciruu.abyss.Class555;
import me.ciruu.abyss.Class620;
import me.ciruu.abyss.Class98;
import me.ciruu.abyss.Class99;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class535;
import me.ciruu.abyss.modules.client.VoiceAssistant;

public class Class472 {
    private List Field3355 = new ArrayList();
    private String[] Field3356;

    public void Method2019() {
        this.Field3355.add(new Class457("friend"));
        this.Field3355.add(new Class527("module"));
        this.Field3355.add(new Class620(""));
        this.Field3355.add(new Class98("open"));
        this.Field3355.add(new Class555("what"));
    }

    public void Method2165(String string) {
        String string2 = string.replaceAll("[\\[\\]<>()|+*]", "");
        String[] stringArray = string2.split("");
        boolean bl = true;
        for (String string3 : stringArray) {
            if (string3.matches(" *") || Manager.Field255.Method257().isWord(string3)) continue;
            bl = false;
        }
        if (!bl) {
            return;
        }
        this.Field3356 = ((VoiceAssistant)Manager.moduleManager.getModuleByClass(VoiceAssistant.class)).mode.getValue() == Class535.Strict ? Arrays.copyOfRange(stringArray, 1, stringArray.length) : stringArray;
        if (((Boolean)((VoiceAssistant)Manager.moduleManager.getModuleByClass(VoiceAssistant.class)).debug.getValue()).booleanValue()) {
            Globals.printChatMessage(stringArray.length + " elements");
        }
        for (Class99 class99 : this.Field3355) {
            if (!class99.Method3349(this.Field3356)) continue;
            class99.Method3346(this.Field3356);
            break;
        }
    }

    private Queue Method4022(Queue queue) {
        ArrayList arrayList = new ArrayList(queue);
        Collections.reverse(arrayList);
        return new LinkedList(arrayList);
    }
}
