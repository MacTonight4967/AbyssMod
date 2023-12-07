package me.ciruu.abyss;

import java.util.List;
import me.ciruu.abyss.Class29;
import me.ciruu.abyss.enums.Class319;
import me.ciruu.abyss.modules.render.Trajectories;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

/*
 * Exception performing whole class analysis ignored.
 */
final class Class318 {
    private EntityPlayerSP Field920;
    private Vec3d Field921;
    private Vec3d Field922;
    private float Field923;
    private float Field924;
    private AxisAlignedBB Field925;
    private boolean Field926;
    private RayTraceResult Field927;
    private Class319 Field928;
    final Trajectories Field929;

    Class318(Trajectories trajectories, EntityPlayerSP entityPlayerSP, Class319 class319) {
        this.Field929 = trajectories;
        this.Field920 = entityPlayerSP;
        this.Field928 = class319;
        this.Method1181(this.Field920.posX, this.Field920.posY + (double)this.Field920.getEyeHeight(), this.Field920.posZ, this.Field920.rotationYaw, this.Field920.rotationPitch);
        Vec3d vec3d = new Vec3d((double)(MathHelper.cos((float)(this.Field923 / 180.0f * (float)Math.PI)) * 0.16f), 0.1, (double)(MathHelper.sin((float)(this.Field923 / 180.0f * (float)Math.PI)) * 0.16f));
        this.Field921 = this.Field921.subtract(vec3d);
        this.Method1182(this.Field921);
        this.Field922 = new Vec3d((double)(-MathHelper.sin((float)(this.Field923 / 180.0f * (float)Math.PI)) * MathHelper.cos((float)(this.Field924 / 180.0f * (float)Math.PI))), (double)(-MathHelper.sin((float)(this.Field924 / 180.0f * (float)Math.PI))), (double)(MathHelper.cos((float)(this.Field923 / 180.0f * (float)Math.PI)) * MathHelper.cos((float)(this.Field924 / 180.0f * (float)Math.PI))));
        this.Method1184(this.Field922, this.Method1183());
    }

    public void Method1185() {
        Vec3d vec3d = this.Field921.add(this.Field922);
        RayTraceResult rayTraceResult = this.Field920.getEntityWorld().rayTraceBlocks(this.Field921, vec3d, this.Field928 == Class319.FISHING_ROD, !this.Method1186(), false);
        if (rayTraceResult != null) {
            vec3d = rayTraceResult.hitVec;
        }
        this.Method1187(vec3d, rayTraceResult);
        if (this.Field927 != null) {
            this.Field926 = true;
            this.Method1182(this.Field927.hitVec);
            return;
        }
        if (this.Field921.y <= 0.0) {
            this.Field926 = true;
            return;
        }
        this.Field921 = this.Field921.add(this.Field922);
        float f = 0.99f;
        if (this.Field920.getEntityWorld().isMaterialInBB(this.Field925, Material.WATER)) {
            float f2 = f = this.Field928 == Class319.ARROW ? 0.6f : 0.8f;
        }
        if (this.Field928 == Class319.FISHING_ROD) {
            f = 0.92f;
        }
        this.Field922 = Class29.Method1188(this.Field922, f);
        this.Field922 = this.Field922.subtract(0.0, (double)this.Method1189(), 0.0);
        this.Method1182(this.Field921);
    }

    private boolean Method1186() {
        switch (this.Field928) {
            case FISHING_ROD: 
            case NORMAL: {
                return true;
            }
        }
        return false;
    }

    private void Method1187(Vec3d vec3d, RayTraceResult rayTraceResult) {
        Entity entity = null;
        RayTraceResult rayTraceResult2 = null;
        double d = 0.0;
        List list = Minecraft.getMinecraft().world.getEntitiesWithinAABBExcludingEntity((Entity)this.Field920, this.Field925.expand(this.Field922.x, this.Field922.y, this.Field922.z).grow(1.0, 1.0, 1.0));
        for (Entity entity2 : list) {
            double d2;
            if (!entity2.canBeCollidedWith()) continue;
            float f = entity2.getCollisionBorderSize();
            AxisAlignedBB axisAlignedBB = entity2.getEntityBoundingBox().expand((double)f, (double)f, (double)f);
            RayTraceResult rayTraceResult3 = axisAlignedBB.calculateIntercept(this.Field921, vec3d);
            if (rayTraceResult3 == null || !((d2 = this.Field921.distanceTo(rayTraceResult3.hitVec)) < d) && d != 0.0) continue;
            entity = entity2;
            rayTraceResult2 = rayTraceResult3;
            d = d2;
        }
        this.Field927 = entity != null ? new RayTraceResult(entity, rayTraceResult2.hitVec) : rayTraceResult;
    }

    private float Method1183() {
        switch (this.Field928) {
            case ARROW: {
                int n = this.Field920.getHeldItem(EnumHand.MAIN_HAND).getItem().getMaxItemUseDuration(this.Field920.getHeldItem(EnumHand.MAIN_HAND)) - this.Field920.getItemInUseCount();
                float f = (float)n / 20.0f;
                f = (f * f + f * 2.0f) / 3.0f;
                if (f > 1.0f) {
                    f = 1.0f;
                }
                return f * 2.0f * this.Field928.getVelocity();
            }
        }
        return this.Field928.getVelocity();
    }

    private float Method1189() {
        return this.Field928.getGravity();
    }

    private void Method1181(double d, double d2, double d3, float f, float f2) {
        this.Field921 = new Vec3d(d, d2, d3);
        this.Field923 = f;
        this.Field924 = f2;
    }

    private void Method1182(Vec3d vec3d) {
        this.Field921 = new Vec3d(vec3d.x, vec3d.y, vec3d.z);
        double d = (this.Field928 == Class319.ARROW ? 0.5 : 0.25) / 2.0;
        this.Field925 = new AxisAlignedBB(vec3d.x - d, vec3d.y - d, vec3d.z - d, vec3d.x + d, vec3d.y + d, vec3d.z + d);
    }

    private void Method1184(Vec3d vec3d, float f) {
        this.Field922 = Class29.Method1190(vec3d, (float)vec3d.length());
        this.Field922 = Class29.Method1188(this.Field922, f);
    }

    public boolean Method1191() {
        return this.Field926;
    }

    public RayTraceResult Method1192() {
        return this.Field927;
    }

    static Vec3d Method1193(Class318 class318) {
        return class318.Field921;
    }

    static boolean Method1194(Class318 class318) {
        return class318.Field926;
    }

    static RayTraceResult Method1195(Class318 class318) {
        return class318.Field927;
    }
}
