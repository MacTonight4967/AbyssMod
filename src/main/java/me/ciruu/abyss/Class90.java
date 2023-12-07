package me.ciruu.abyss;

import me.ciruu.abyss.events.MinecraftEvent;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;

public class Class90
extends MinecraftEvent {
    public RenderLivingBase Field226;
    public ModelBase Field228;
    public EntityLivingBase Field227;
    public float Field229;
    public float Field230;
    public float Field2649;
    public float Field231;
    public float Field232;
    public float Field233;
    public float Field234;

    public RenderLivingBase Method3283() {
        return this.Field226;
    }

    public Class90(RenderLivingBase renderLivingBase, ModelBase modelBase, EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        this.Field226 = renderLivingBase;
        this.Field228 = modelBase;
        this.Field227 = entityLivingBase;
        this.Field229 = f;
        this.Field230 = f2;
        this.Field2649 = f3;
        this.Field231 = f4;
        this.Field232 = f5;
        this.Field233 = f6;
        this.Field234 = f7;
    }

    public ModelBase Method3284() {
        return this.Field228;
    }

    public EntityLivingBase Method3285() {
        return this.Field227;
    }

    public float Method3286() {
        return this.Field229;
    }

    public float Method3287() {
        return this.Field230;
    }

    public float Method3288() {
        return this.Field2649;
    }

    public float Method3289() {
        return this.Field231;
    }

    public float Method3290() {
        return this.Field232;
    }

    public float Method3291() {
        return this.Field233;
    }

    public float Method3292() {
        return this.Field234;
    }
}
