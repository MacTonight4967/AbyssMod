package me.ciruu.abyss.modules.client;

import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.frontend.util.Microphone;
import java.util.function.Predicate;
import me.ciruu.abyss.Class207;
import me.ciruu.abyss.Class26;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class535;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

public class VoiceAssistant
extends Module {
    public final Setting mode = new Setting("Mode", "", this, (Object)Class535.NonStrict);
    public final Setting pushToTalkKey = new Setting("PushToTalkKey", "", this, new Class207(0));
    public final Setting tickBuffer = new Setting("TickBuffer", "Minecraft ticks of the recording buffer", (Module)this, (Object)20, 1, 200);
    public final Setting debug = new Setting("Debug", "", this, false);
    private String Field2006 = "";
    private SpeechResult speechResult;
    private Microphone microphone = new Microphone();
    @EventHandler
    private Listener Field2009 = new Listener<Class26>(VoiceAssistant::Method2438, new Predicate[0]);

    public VoiceAssistant() {
        super("VoiceAssistant", "", Class11.CLIENT);
        this.Method2439(this.debug);
        this.Method2439(this.pushToTalkKey);
        this.Method2439(this.tickBuffer);
    }

    public void Method2440() {
        super.Method13();
        Manager.Field255.Method257().setEnabled(true);
    }

    public void Method2441() {
        super.Method15();
        Manager.Field255.Method257().setEnabled(false);
    }

    private static void Method2438(Class26 class26) {
        Manager.Field255.Method2164();
    }
}
