package me.ciruu.abyss;

import net.minecraft.client.entity.EntityPlayerSP;

public class Class41 {
    private float Field97;
    private float Field98;

    public Class41(float f, float f2) {
        this.Method67(f2);
        this.Method68(f);
    }

    public float Method69() {
        return this.Field97;
    }

    public void Method67(float f) {
        this.Field97 = f;
    }

    public float Method70() {
        return this.Field98;
    }

    public void Method68(float f) {
        this.Field98 = f;
    }

    public void Method71(float f) {
        float f2 = f * 0.6f + 0.2f;
        float f3 = f2 * f2 * f2 * 1.2f;
        this.Field98 -= this.Field98 % f3;
        this.Field97 -= this.Field97 % f3;
    }

    public void Method72(EntityPlayerSP entityPlayerSP) {
        entityPlayerSP.rotationYaw = this.Field98;
        entityPlayerSP.rotationPitch = this.Field97;
    }
}
