package me.ciruu.abyss;

import net.minecraft.network.Packet;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class Class93
extends Event {
    private final Packet Field245;

    public Class93(Packet packet) {
        this.Field245 = packet;
    }

    public final Packet getPacket() {
        return this.Field245;
    }
}
