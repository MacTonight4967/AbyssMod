package me.ciruu.abyss;

import me.ciruu.abyss.Class202;
import me.ciruu.abyss.Class29;
import me.ciruu.abyss.Class84;
import me.ciruu.abyss.Globals;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class Class195 {
    private float Field2861;
    private float Field2862;

    public void Method3532() {
        this.Field2861 = Globals.mc.player.rotationYaw;
        this.Field2862 = Globals.mc.player.rotationPitch;
    }

    public void Method3533() {
        Globals.mc.player.rotationYaw = this.Field2861;
        Globals.mc.player.rotationYawHead = this.Field2861;
        Globals.mc.player.rotationPitch = this.Field2862;
    }

    public void Method523(float f, float f2) {
        Globals.mc.player.rotationYaw = f;
        Globals.mc.player.rotationYawHead = f;
        Globals.mc.player.rotationPitch = f2;
    }

    public void Method3534(float f) {
        Globals.mc.player.rotationYaw = f;
        Globals.mc.player.rotationYawHead = f;
    }

    public void Method3535(BlockPos blockPos) {
        float[] fArray = Class29.Method1501(Globals.mc.player.getPositionEyes(Globals.mc.getRenderPartialTicks()), new Vec3d((double)((float)blockPos.getX() + 0.5f), (double)((float)blockPos.getY() + 0.5f), (double)((float)blockPos.getZ() + 0.5f)));
        this.Method523(fArray[0], fArray[1]);
    }

    public void Method1265(Vec3d vec3d) {
        float[] fArray = Class29.Method1501(Globals.mc.player.getPositionEyes(Globals.mc.getRenderPartialTicks()), new Vec3d(vec3d.x, vec3d.y, vec3d.z));
        this.Method523(fArray[0], fArray[1]);
    }

    public void Method3536(double d, double d2, double d3) {
        Vec3d vec3d = new Vec3d(d, d2, d3);
        this.Method1265(vec3d);
    }

    public void Method2897(Entity entity) {
        float[] fArray = Class29.Method1501(Globals.mc.player.getPositionEyes(Globals.mc.getRenderPartialTicks()), entity.getPositionEyes(Globals.mc.getRenderPartialTicks()));
        this.Method523(fArray[0], fArray[1]);
    }

    public void Method3537(Entity entity) {
        float[] fArray = Class29.Method1501(Globals.mc.player.getPositionEyes(Globals.mc.getRenderPartialTicks()), entity.getPositionEyes(Globals.mc.getRenderPartialTicks()));
        Class202.Method934(fArray[0], fArray[1]);
    }

    public void Method3538(float f) {
        Globals.mc.player.rotationPitch = f;
    }

    public float Method3539() {
        return this.Field2861;
    }

    public void Method3540(float f) {
        this.Field2861 = f;
    }

    public float Method3541() {
        return this.Field2862;
    }

    public void Method3542(float f) {
        this.Field2862 = f;
    }

    public int Method3543() {
        return Class84.Method1287();
    }

    public String Method1968(boolean bl) {
        return Class84.Method3237(bl);
    }
}
