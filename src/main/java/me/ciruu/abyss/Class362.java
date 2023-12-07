package me.ciruu.abyss;

import net.minecraft.network.Packet;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class Class362
extends Event {
    private final Packet Field2560;

    public Class362(Packet packet) {
        this.Field2560 = packet;
    }

    public final Packet getPacket() {
        return this.Field2560;
    }
}
