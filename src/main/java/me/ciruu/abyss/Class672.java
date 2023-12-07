package me.ciruu.abyss;

import java.util.function.Predicate;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.network.EventNetworkPostPacketEvent;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketUseEntity;

public class Class672
extends Module {
    private final Setting Field3430 = new Setting("CancelUseEntity", "", this, false);
    private final Setting Field3431 = new Setting("CancelF", "", this, false);
    private final Setting Field3432 = new Setting("CancelAnimation", "", this, false);
    @EventHandler
    private Listener Field3433 = new Listener<EventNetworkPostPacketEvent>(this::Method4147, new Predicate[0]);

    public Class672() {
        super("CancelUseEntity", "", Class11.MISC);
        this.Method4148(this.Field3430);
        this.Method4148(this.Field3431);
        this.Method4148(this.Field3432);
    }

    private void Method4147(EventNetworkPostPacketEvent eventNetworkPostPacketEvent) {
        if (eventNetworkPostPacketEvent.Method1536() != Class53.PRE) {
            return;
        }
        if (eventNetworkPostPacketEvent.Method16() instanceof CPacketUseEntity && ((Boolean)this.Field3430.getValue()).booleanValue()) {
            eventNetworkPostPacketEvent.cancel();
        }
        if (((Boolean)this.Field3431.getValue()).booleanValue() && eventNetworkPostPacketEvent.Method16().getClass().getSimpleName().startsWith("f")) {
            eventNetworkPostPacketEvent.cancel();
        }
        if (((Boolean)this.Field3432.getValue()).booleanValue() && eventNetworkPostPacketEvent.Method16() instanceof CPacketAnimation) {
            eventNetworkPostPacketEvent.cancel();
        }
    }
}
