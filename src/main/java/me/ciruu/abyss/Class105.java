package me.ciruu.abyss;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import me.ciruu.abyss.Class106;
import me.ciruu.abyss.Class207;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.client.VoiceAssistant;
import org.lwjgl.input.Keyboard;

public class Class105 {
    public int Field1773;
    private Class106 Field1774;
    private List Field1775 = new ArrayList();
    private Path Field1776;

    public void Method2018() {
        Manager.logger.debug("Initializing recognizer.");
        this.Field1774 = new Class106();
    }

    public void Method2164() {
        if (Keyboard.isKeyDown((int)((Class207)((VoiceAssistant)Manager.moduleManager.getModuleByClass(VoiceAssistant.class)).pushToTalkKey.getValue()).Method592())) {
            if (!this.Field1774.Field1761) {
                this.Field1774.Field1761 = true;
                this.Field1773 = (Integer)((VoiceAssistant)Manager.moduleManager.getModuleByClass(VoiceAssistant.class)).tickBuffer.getValue();
            }
        } else if (this.Field1774.Field1761) {
            if (this.Field1773 <= 0) {
                this.Field1774.Field1761 = false;
            } else {
                --this.Field1773;
            }
        }
        while (this.Field1774.getQueueSize() > 0 && !this.Field1774.Field1761) {
            String string = this.Field1774.popString();
            string = string.toLowerCase();
            Manager.logger.info("Command recognized:" + string);
            if (((Boolean)((VoiceAssistant)Manager.moduleManager.getModuleByClass(VoiceAssistant.class)).debug.getValue()).booleanValue()) {
                Globals.printChatMessage(string);
            }
            Manager.Field1649.Method2165(string);
        }
    }

    public Class106 Method257() {
        return this.Field1774;
    }
}
