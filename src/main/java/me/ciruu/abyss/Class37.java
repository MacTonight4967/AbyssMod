package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import me.ciruu.abyss.Class39;
import me.ciruu.abyss.Class40;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.events.network.EventNetworkPostPacketEvent;
import me.ciruu.abyss.modules.client.WebChat;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
static final class Class37
extends Lambda
implements Function1 {
    final WebChat Field95;

    public Object invoke(Object object) {
        this.invoke((EventNetworkPostPacketEvent)object);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull EventNetworkPostPacketEvent eventNetworkPostPacketEvent) {
        Packet packet = eventNetworkPostPacketEvent.Method16();
        if (packet instanceof CPacketChatMessage && Globals.mc.currentScreen instanceof Class39) {
            String string = ((CPacketChatMessage)packet).getMessage();
            if (!Class40.Field96.Method64(string)) {
                Globals.printNewChatMessage(ChatFormatting.GOLD + this.Field95.Method65() + ChatFormatting.RED + " Unable to send message");
            }
            eventNetworkPostPacketEvent.cancel();
        }
    }

    Class37(WebChat webChat) {
        this.Field95 = webChat;
        super(1);
    }
}
