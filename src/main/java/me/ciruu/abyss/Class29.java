package me.ciruu.abyss;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import me.ciruu.abyss.Globals;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class Class29 {
    private static final Random Field3144 = new Random();

    public static Vec3d Method1042(Entity entity, float f) {
        return new Vec3d(entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f, entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f, entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f);
    }

    public static int Method3797(int n, int n2) {
        return n + Field3144.nextInt(n2 - n + 1);
    }

    public static double Method3798(double d, double d2) {
        return MathHelper.clamp((double)(d + Field3144.nextDouble() * d2), (double)d, (double)d2);
    }

    public static float Method3799(float f, float f2) {
        return MathHelper.clamp((float)(f + Field3144.nextFloat() * f2), (float)f, (float)f2);
    }

    public static int Method3800(int n, int n2, int n3) {
        return n < n2 ? n2 : Math.min(n, n3);
    }

    public static float Method1894(float f, float f2, float f3) {
        return f < f2 ? f2 : Math.min(f, f3);
    }

    public static double Method3801(double d, double d2, double d3) {
        return d < d2 ? d2 : Math.min(d, d3);
    }

    public static float Method3802(float f) {
        return MathHelper.sin((float)f);
    }

    public static float Method3803(float f) {
        return MathHelper.cos((float)f);
    }

    public static float Method3804(float f) {
        return MathHelper.wrapDegrees((float)f);
    }

    public static double Method3805(double d) {
        return MathHelper.wrapDegrees((double)d);
    }

    public static Vec3d Method2752(Vec3d vec3d, int n) {
        return new Vec3d(Class29.Method2460(vec3d.x, n), Class29.Method2460(vec3d.y, n), Class29.Method2460(vec3d.z, n));
    }

    public static double Method114(double d) {
        return d * d;
    }

    public static double Method2460(double d, int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bigDecimal = BigDecimal.valueOf(d);
        bigDecimal = bigDecimal.setScale(n, RoundingMode.FLOOR);
        return bigDecimal.doubleValue();
    }

    public static float Method3806(float f) {
        float f2 = f % 360.0f;
        if (f2 >= 180.0f) {
            f2 -= 360.0f;
        }
        if (f2 < -180.0f) {
            f2 += 360.0f;
        }
        return f2;
    }

    public static Vec3d Method3807(float f) {
        return new Vec3d(Math.cos(Class29.Method3808(f + 90.0f)), 0.0, Math.sin(Class29.Method3808(f + 90.0f)));
    }

    public static float Method3809(float f, int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bigDecimal = BigDecimal.valueOf(f);
        bigDecimal = bigDecimal.setScale(n, RoundingMode.FLOOR);
        return bigDecimal.floatValue();
    }

    public static Map Method3810(Map map, boolean bl) {
        LinkedList linkedList = new LinkedList(map.entrySet());
        if (bl) {
            linkedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        } else {
            linkedList.sort(Map.Entry.comparingByValue());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : linkedList) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    public static String Method3811() {
        Calendar calendar = Calendar.getInstance();
        int n = calendar.get(11);
        if (n < 12) {
            return "Good Morning";
        }
        if (n < 16) {
            return "Good Afternoon";
        }
        return n < 21 ? "Good Evening" : "Good Night";
    }

    public static double Method3812(double d) {
        return d * (double)57.29578f;
    }

    public static double Method3808(double d) {
        return d * 0.01745329238474369;
    }

    public static double Method3813(double d, double d2) {
        double d3 = 1.0 / d2;
        return (double)Math.round(d * d3) / d3;
    }

    public static double[] Method1330(double d) {
        float f = Globals.mc.player.movementInput.moveForward;
        float f2 = Globals.mc.player.movementInput.moveStrafe;
        float f3 = Globals.mc.player.prevRotationYaw + (Globals.mc.player.rotationYaw - Globals.mc.player.prevRotationYaw) * Globals.mc.getRenderPartialTicks();
        if (f != 0.0f) {
            if (f2 > 0.0f) {
                f3 += (float)(f > 0.0f ? -45 : 45);
            } else if (f2 < 0.0f) {
                f3 += (float)(f > 0.0f ? 45 : -45);
            }
            f2 = 0.0f;
            if (f > 0.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = -1.0f;
            }
        }
        double d2 = Math.sin(Math.toRadians(f3 + 90.0f));
        double d3 = Math.cos(Math.toRadians(f3 + 90.0f));
        double d4 = (double)f * d * d3 + (double)f2 * d * d2;
        double d5 = (double)f * d * d2 - (double)f2 * d * d3;
        return new double[]{d4, d5};
    }

    public static List Method2747(Entity entity) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox();
        double d = entity.posY;
        double d2 = Class29.Method2460(axisAlignedBB.minX, 0);
        double d3 = Class29.Method2460(axisAlignedBB.minZ, 0);
        double d4 = Class29.Method2460(axisAlignedBB.maxX, 0);
        double d5 = Class29.Method2460(axisAlignedBB.maxZ, 0);
        if (d2 != d4) {
            arrayList.add(new Vec3d(d2, d, d3));
            arrayList.add(new Vec3d(d4, d, d3));
            if (d3 != d5) {
                arrayList.add(new Vec3d(d2, d, d5));
                arrayList.add(new Vec3d(d4, d, d5));
                return arrayList;
            }
        } else if (d3 != d5) {
            arrayList.add(new Vec3d(d2, d, d3));
            arrayList.add(new Vec3d(d2, d, d5));
            return arrayList;
        }
        arrayList.add(entity.getPositionVector());
        return arrayList;
    }

    public static boolean Method3814(Vec3d vec3d, Vec3d vec3d2) {
        return Class29.Method3815(vec3d, vec3d2);
    }

    public static boolean Method3815(Vec3d vec3d, Vec3d vec3d2) {
        BlockPos blockPos = new BlockPos(vec3d);
        BlockPos blockPos2 = new BlockPos(vec3d2.x, vec3d.y, vec3d2.z);
        return blockPos.equals((Object)blockPos2);
    }

    public static float[] Method1501(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d2.x - vec3d.x;
        double d2 = (vec3d2.y - vec3d.y) * -1.0;
        double d3 = vec3d2.z - vec3d.z;
        double d4 = MathHelper.sqrt((double)(d * d + d3 * d3));
        return new float[]{(float)MathHelper.wrapDegrees((double)(Math.toDegrees(Math.atan2(d3, d)) - 90.0)), (float)MathHelper.wrapDegrees((double)Math.toDegrees(Math.atan2(d2, d4)))};
    }

    public static float Method43(Collection collection) {
        int n = 0;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            int n2 = (Integer)iterator.next();
            n += n2;
        }
        return (float)n / (float)collection.size();
    }

    public static float Method45(Collection collection) {
        if (collection.isEmpty()) {
            return 0.0f;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (Integer n : collection) {
            hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
        }
        int n = 0;
        int n2 = 0;
        for (Map.Entry entry : hashMap.entrySet()) {
            if ((Integer)entry.getValue() <= n) continue;
            n = (Integer)entry.getValue();
            n2 = (Integer)entry.getKey();
        }
        if (n == 1) {
            return Class29.Method43(collection);
        }
        return n2;
    }

    public static float Method3816(Collection collection) {
        float f = Class29.Method43(collection);
        float f2 = 0.0f;
        for (Integer n : collection) {
            f2 = (float)((double)f2 + Math.pow((float)n.intValue() - f, 2.0));
        }
        return (float)Math.sqrt(f2 / (float)collection.size());
    }

    public static float Method44(Collection collection, float f) {
        int n;
        float f2 = 0.0f;
        int n2 = 0;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            n = (Integer)iterator.next();
            float f3 = Math.abs((float)n - f);
            if (!(f3 > f2)) continue;
            f2 = f3;
            n2 = n;
        }
        int n3 = 0;
        n = 0;
        Iterator iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            int n4 = (Integer)iterator2.next();
            if (n4 == n2) continue;
            n3 += n4;
            ++n;
        }
        if (n == 0) {
            return f;
        }
        return (float)n3 / (float)n;
    }

    public static Vec3d Method3817(Vec3d vec3d, Vec3d vec3d2) {
        return new Vec3d(vec3d.x * vec3d2.x, vec3d.y * vec3d2.y, vec3d.z * vec3d2.z);
    }

    public static Vec3d Method1188(Vec3d vec3d, float f) {
        return new Vec3d(vec3d.x * (double)f, vec3d.y * (double)f, vec3d.z * (double)f);
    }

    public static Vec3d Method3818(Vec3d vec3d, Vec3d vec3d2) {
        return new Vec3d(vec3d.x / vec3d2.x, vec3d.y / vec3d2.y, vec3d.z / vec3d2.z);
    }

    public static Vec3d Method1190(Vec3d vec3d, float f) {
        return new Vec3d(vec3d.x / (double)f, vec3d.y / (double)f, vec3d.z / (double)f);
    }

    public static double Method1648(float f, float f2, float f3, float f4) {
        return Math.sqrt((f - f3) * (f - f3) + (f2 - f4) * (f2 - f4));
    }

    public static Vec3d Method3819(Vec3d vec3d, Vec3d vec3d2, double d) {
        double d2 = Math.sqrt(Class29.Method3820(vec3d2.x - vec3d.x) + Class29.Method3820(vec3d2.y - vec3d.y) + Class29.Method3820(vec3d2.z - vec3d.z));
        double d3 = (vec3d2.x - vec3d.x) / d2;
        double d4 = (vec3d2.y - vec3d.y) / d2;
        double d5 = (vec3d2.z - vec3d.z) / d2;
        double d6 = vec3d.x + d3 * d;
        double d7 = vec3d.y + d4 * d;
        double d8 = vec3d.z + d5 * d;
        return new Vec3d(d6, d7, d8);
    }

    public static double Method3820(double d) {
        return d * d;
    }

    public static Vec3d Method3821(Entity entity, int n) {
        Vec3d vec3d = new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ);
        Vec3d vec3d2 = new Vec3d(entity.posX, entity.posY, entity.posZ);
        double d = Class29.Method3820(entity.motionX) + Class29.Method3820(entity.motionY) + Class29.Method3820(entity.motionZ);
        Vec3d vec3d3 = Class29.Method3819(vec3d, vec3d2, d * (double)n);
        return new Vec3d(vec3d3.x, entity.posY, vec3d3.z);
    }
}
