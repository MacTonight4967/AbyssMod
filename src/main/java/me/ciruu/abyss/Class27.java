package me.ciruu.abyss;

import me.ciruu.abyss.events.MinecraftEvent;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class Class27
extends MinecraftEvent {
    private final Entity Field644;
    private final World Field645;

    public Class27(Entity entity, World world) {
        this.Field644 = entity;
        this.Field645 = world;
    }

    public Entity Method46() {
        return this.Field644;
    }

    public World Method922() {
        return this.Field645;
    }
}
