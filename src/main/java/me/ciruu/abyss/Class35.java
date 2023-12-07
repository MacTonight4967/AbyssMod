package me.ciruu.abyss;

import me.ciruu.abyss.events.MinecraftEvent;
import net.minecraft.client.gui.ScaledResolution;

public class Class35
extends MinecraftEvent {
    public float Field3102;
    public ScaledResolution Field3103;

    public Class35(float f, ScaledResolution scaledResolution) {
        this.Field3102 = f;
        this.Field3103 = scaledResolution;
    }

    public void Method3745(float f) {
        this.Field3102 = f;
    }

    public void Method3746(ScaledResolution scaledResolution) {
        this.Field3103 = scaledResolution;
    }

    public double Method3355() {
        return this.Field3103.getScaledWidth_double();
    }

    public double Method3356() {
        return this.Field3103.getScaledHeight_double();
    }

    public int Method2006() {
        return this.Field3103.getScaledWidth();
    }

    public int Method1967() {
        return this.Field3103.getScaledHeight();
    }
}
