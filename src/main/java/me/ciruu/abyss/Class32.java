package me.ciruu.abyss;

import me.ciruu.abyss.events.MinecraftEvent;
import net.minecraft.entity.EntityLivingBase;

public class Class32
extends MinecraftEvent {
    public EntityLivingBase Field72;
    public double Field73;
    public double Field74;
    public double Field75;
    public float Field76;

    public Class32(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f) {
        this.Field72 = entityLivingBase;
        this.Field73 = d;
        this.Field74 = d2;
        this.Field75 = d3;
        this.Field76 = f;
    }
}
