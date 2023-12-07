package me.ciruu.abyss;

import me.ciruu.abyss.Class29;
import me.ciruu.abyss.Class353;
import me.ciruu.abyss.Class41;
import me.ciruu.abyss.Globals;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class Class84 {
    public static Class41 Field2627 = new Class41(0.0f, 0.0f);

    public static Vec3d Method1233() {
        return new Vec3d(Globals.mc.player.posX, Globals.mc.player.posY + (double)Globals.mc.player.getEyeHeight(), Globals.mc.player.posZ);
    }

    public static double[] Method538(double d, double d2, double d3, EntityPlayer entityPlayer) {
        double d4 = entityPlayer.posX - d;
        double d5 = entityPlayer.posY - d2;
        double d6 = entityPlayer.posZ - d3;
        double d7 = Math.sqrt(d4 * d4 + d5 * d5 + d6 * d6);
        double d8 = Math.asin(d5 /= d7);
        double d9 = Math.atan2(d6 /= d7, d4 /= d7);
        d8 = d8 * 180.0 / Math.PI;
        d9 = d9 * 180.0 / Math.PI;
        return new double[]{d9 += 90.0, d8};
    }

    public static float[] Method1240(Vec3d vec3d) {
        Vec3d vec3d2 = Class84.Method1233();
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float)Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(d2, d4)));
        return new float[]{Globals.mc.player.rotationYaw + MathHelper.wrapDegrees((float)(f - Globals.mc.player.rotationYaw)), Globals.mc.player.rotationPitch + MathHelper.wrapDegrees((float)(f2 - Globals.mc.player.rotationPitch))};
    }

    public static void Method3234(float f, float f2) {
        Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(f, f2, Globals.mc.player.onGround));
    }

    public static void Method1260(Vec3d vec3d, boolean bl) {
        float[] fArray = Class84.Method1240(vec3d);
        Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(fArray[0], bl ? (float)MathHelper.normalizeAngle((int)((int)fArray[1]), (int)360) : fArray[1], Globals.mc.player.onGround));
    }

    public static void Method3235(Entity entity) {
        float[] fArray = Class29.Method1501(Globals.mc.player.getPositionEyes(Globals.mc.getRenderPartialTicks()), entity.getPositionEyes(Globals.mc.getRenderPartialTicks()));
        Class84.Method3234(fArray[0], fArray[1]);
    }

    public static float[] Method3236(Entity entity) {
        return Class29.Method1501(Globals.mc.player.getPositionEyes(Globals.mc.getRenderPartialTicks()), entity.getPositionEyes(Globals.mc.getRenderPartialTicks()));
    }

    public static int Method1287() {
        return MathHelper.floor((double)((double)(Globals.mc.player.rotationYaw * 4.0f / 360.0f) + 0.5)) & 3;
    }

    public static int Method539(float f) {
        return MathHelper.floor((double)((double)(f * 4.0f / 360.0f) + 0.5)) & 3;
    }

    public static int Method540(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 90;
        }
        if (n == 2) {
            return 180;
        }
        if (n == 3) {
            return 270;
        }
        return 0;
    }

    public static String Method3237(boolean bl) {
        int n = Class84.Method1287();
        if (n == 0) {
            return "South (+Z)";
        }
        if (n == 1) {
            return "West (-X)";
        }
        if (n == 2) {
            return (bl ? "?c" : "") + "North (-Z)";
        }
        if (n == 3) {
            return "East (+X)";
        }
        return "Loading...";
    }

    public static Class353 Method1492(BlockPos blockPos) {
        if (blockPos == null) {
            return null;
        }
        Class353 class353 = null;
        for (double d = 0.1; d < 0.9; d += 0.1) {
            for (double d2 = 0.1; d2 < 0.9; d2 += 0.1) {
                for (double d3 = 0.1; d3 < 0.9; d3 += 0.1) {
                    Vec3d vec3d = new Vec3d(Globals.mc.player.posX, Globals.mc.player.getEntityBoundingBox().minY + (double)Globals.mc.player.getEyeHeight(), Globals.mc.player.posZ);
                    Vec3d vec3d2 = new Vec3d((Vec3i)blockPos).add(d, d2, d3);
                    double d4 = vec3d.distanceTo(vec3d2);
                    double d5 = vec3d2.x - vec3d.x;
                    double d6 = vec3d2.y - vec3d.y;
                    double d7 = vec3d2.z - vec3d.z;
                    double d8 = MathHelper.sqrt((double)(d5 * d5 + d7 * d7));
                    Class41 class41 = new Class41(MathHelper.wrapDegrees((float)((float)Math.toDegrees(Math.atan2(d7, d5)) - 90.0f)), MathHelper.wrapDegrees((float)((float)(-Math.toDegrees(Math.atan2(d6, d8))))));
                    Vec3d vec3d3 = Class84.Method3238(class41);
                    Vec3d vec3d4 = vec3d.add(vec3d3.x * d4, vec3d3.y * d4, vec3d3.z * d4);
                    RayTraceResult rayTraceResult = Globals.mc.world.rayTraceBlocks(vec3d, vec3d4, false, false, true);
                    if (rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK) continue;
                    Class353 class3532 = new Class353(vec3d2, class41);
                    if (class353 != null && !(Class84.Method3239(class3532.Method1494()) < Class84.Method3239(class353.Method1494()))) continue;
                    class353 = class3532;
                }
            }
        }
        return class353;
    }

    public static Vec3d Method3238(Class41 class41) {
        float f = MathHelper.cos((float)(-class41.Method70() * ((float)Math.PI / 180) - (float)Math.PI));
        float f2 = MathHelper.sin((float)(-class41.Method70() * ((float)Math.PI / 180) - (float)Math.PI));
        float f3 = -MathHelper.cos((float)(-class41.Method69() * ((float)Math.PI / 180)));
        float f4 = MathHelper.sin((float)(-class41.Method69() * ((float)Math.PI / 180)));
        return new Vec3d((double)(f2 * f3), (double)f4, (double)(f * f3));
    }

    public static double Method3239(Class41 class41) {
        return Field2627 == null ? 0.0 : Class84.Method3240(class41, Field2627);
    }

    public static double Method3240(Class41 class41, Class41 class412) {
        return Math.hypot(Class84.Method3241(class41.Method70(), class412.Method70()), class41.Method69() - class412.Method69());
    }

    private static float Method3241(float f, float f2) {
        return ((f - f2) % 360.0f + 540.0f) % 360.0f - 180.0f;
    }

    public static boolean Method205(BlockPos blockPos) {
        return blockPos != null && (Globals.mc.player.getDistanceSq(blockPos) < 4.0 || Class84.Method3242(blockPos) < (double)(Class84.Method3243() + 2.0f));
    }

    public static boolean Method3244(Entity entity) {
        return entity != null && (Globals.mc.player.getDistanceSq(entity) < 4.0 || Class84.Method3245(entity) < (double)(Class84.Method3243() + 2.0f));
    }

    public static double Method3242(BlockPos blockPos) {
        if (blockPos != null) {
            Vec3d vec3d = new Vec3d((Vec3i)blockPos).subtract(Globals.mc.player.getPositionEyes(Globals.mc.getRenderPartialTicks()));
            double d = Math.abs((double)Globals.mc.player.rotationYaw - (Math.toDegrees(Math.atan2(vec3d.z, vec3d.x)) - 90.0)) % 360.0;
            return d > 180.0 ? 360.0 - d : d;
        }
        return 0.0;
    }

    public static double Method3245(Entity entity) {
        if (entity != null) {
            Vec3d vec3d = entity.getPositionVector().add(0.0, (double)(entity.getEyeHeight() / 2.0f), 0.0).subtract(Globals.mc.player.getPositionEyes(Globals.mc.getRenderPartialTicks()));
            double d = Math.abs((double)Globals.mc.player.rotationYaw - (Math.toDegrees(Math.atan2(vec3d.z, vec3d.x)) - 90.0)) % 360.0;
            return d > 180.0 ? 360.0 - d : d;
        }
        return 0.0;
    }

    public static float Method3246() {
        return Globals.mc.gameSettings.fovSetting;
    }

    public static float Method3243() {
        return Class84.Method3246() / 2.0f;
    }
}
