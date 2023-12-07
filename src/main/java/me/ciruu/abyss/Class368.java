package me.ciruu.abyss;

import me.ciruu.abyss.events.MinecraftEvent;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;

public class Class368
extends MinecraftEvent {
    private ResourceLocation Field1223 = null;
    public AbstractClientPlayer Field1224;

    public Class368(AbstractClientPlayer abstractClientPlayer) {
        this.Field1224 = abstractClientPlayer;
    }

    public void Method1570(ResourceLocation resourceLocation) {
        this.Field1223 = resourceLocation;
    }

    public AbstractClientPlayer Method1571() {
        return this.Field1224;
    }

    public ResourceLocation Method1572() {
        return this.Field1223;
    }
}
