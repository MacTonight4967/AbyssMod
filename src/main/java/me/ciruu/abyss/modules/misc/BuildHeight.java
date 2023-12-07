package me.ciruu.abyss.modules.misc;

import java.util.function.Predicate;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.events.network.EventNetworkPostPacketEvent;
import me.ciruu.abyss.modules.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;

public class BuildHeight
extends Module {
    @EventHandler
    private Listener Field2930 = new Listener<EventNetworkPostPacketEvent>(BuildHeight::Method3607, new Predicate[0]);

    public BuildHeight() {
        super("BuildHeight", "Lets you to interact with blocks at the build height limit.", Class11.MISC);
    }

    private static void Method3607(EventNetworkPostPacketEvent eventNetworkPostPacketEvent) {
        CPacketPlayerTryUseItemOnBlock cPacketPlayerTryUseItemOnBlock;
        if (eventNetworkPostPacketEvent.Method16() instanceof CPacketPlayerTryUseItemOnBlock && (cPacketPlayerTryUseItemOnBlock = (CPacketPlayerTryUseItemOnBlock)eventNetworkPostPacketEvent.Method16()).getPos().getY() >= 255 && cPacketPlayerTryUseItemOnBlock.getDirection() == EnumFacing.UP) {
            cPacketPlayerTryUseItemOnBlock.placedBlockDirection = EnumFacing.DOWN;
        }
    }
}
