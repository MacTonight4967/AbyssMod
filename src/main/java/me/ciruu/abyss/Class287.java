package me.ciruu.abyss;

import me.ciruu.abyss.events.MinecraftEvent;
import net.minecraft.util.EnumHandSide;

public class Class287
extends MinecraftEvent {
    private final EnumHandSide Field795;

    public Class287(EnumHandSide enumHandSide) {
        this.Field795 = enumHandSide;
    }

    public EnumHandSide Method1052() {
        return this.Field795;
    }
}
