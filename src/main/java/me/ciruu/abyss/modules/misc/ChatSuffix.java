package me.ciruu.abyss.modules.misc;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.function.Predicate;
import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Class39;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.events.network.EventNetworkPostPacketEvent;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.client.CPacketChatMessage;

public class ChatSuffix
extends Module {
    private final Setting main = new Setting("Main", "", this, new Class25("Main Settings"));
    private final Setting custom = new Setting("Custom", "", this, true);
    private final Setting suffix = new Setting("Suffix", "Suffix", (Module)this, (Object)"Abyss", this.main, this.custom::getValue);
    @EventHandler
    private Listener Field3223 = new Listener<EventNetworkPostPacketEvent>(this::Method3899, new Predicate[0]);

    public ChatSuffix() {
        super("ChatSuffix", "Display a custom message after the player sends a message.", Class11.MISC, "NONE");
        this.Method3900(this.custom);
        this.Method3900(this.suffix);
    }

    public String Method3901() {
        return ChatFormatting.WHITE + (String)this.suffix.getValue();
    }

    private void Method3899(EventNetworkPostPacketEvent eventNetworkPostPacketEvent) {
        if (eventNetworkPostPacketEvent.Method16() instanceof CPacketChatMessage && !(Globals.mc.currentScreen instanceof Class39)) {
            if (((CPacketChatMessage)eventNetworkPostPacketEvent.Method16()).getMessage().startsWith("/")) {
                return;
            }
            String string = ((CPacketChatMessage)eventNetworkPostPacketEvent.Method16()).getMessage();
            String string2 = string + "" + ((Boolean)this.custom.getValue() != false ? ((String)this.suffix.getValue()).trim() : "?????");
            if (string2.length() > 255) {
                return;
            }
            ((CPacketChatMessage)eventNetworkPostPacketEvent.Method16()).message = string2;
        }
    }
}
