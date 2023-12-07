package me.ciruu.abyss;

import me.ciruu.abyss.events.MinecraftEvent;
import net.minecraft.entity.EntityLivingBase;

public class Class660
extends MinecraftEvent {
    private EntityLivingBase Field3238;
    private double Field3239;
    private double Field3240;
    private double Field3241;

    public Class660(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        this.Field3238 = entityLivingBase;
        this.Field3239 = d;
        this.Field3240 = d2;
        this.Field3241 = d3;
    }

    public EntityLivingBase Method3911() {
        return this.Field3238;
    }

    public double Method3912() {
        return this.Field3239;
    }

    public double Method3913() {
        return this.Field3240;
    }

    public double Method3914() {
        return this.Field3241;
    }
}
