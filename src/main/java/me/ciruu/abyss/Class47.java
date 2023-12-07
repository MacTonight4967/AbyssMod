package me.ciruu.abyss;

import me.ciruu.abyss.Class46;
import me.ciruu.abyss.Class502;
import me.ciruu.abyss.Globals;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector4f;

public class Class47 {
    static Matrix4f Field1805 = new Matrix4f();
    static Matrix4f Field1806 = new Matrix4f();

    private static void Method2202(Vector4f vector4f, Matrix4f matrix4f) {
        float f = vector4f.x;
        float f2 = vector4f.y;
        float f3 = vector4f.z;
        vector4f.x = f * matrix4f.m00 + f2 * matrix4f.m10 + f3 * matrix4f.m20 + matrix4f.m30;
        vector4f.y = f * matrix4f.m01 + f2 * matrix4f.m11 + f3 * matrix4f.m21 + matrix4f.m31;
        vector4f.z = f * matrix4f.m02 + f2 * matrix4f.m12 + f3 * matrix4f.m22 + matrix4f.m32;
        vector4f.w = f * matrix4f.m03 + f2 * matrix4f.m13 + f3 * matrix4f.m23 + matrix4f.m33;
    }

    public static Class46 Method2203(double d, double d2, double d3) {
        Entity entity = Globals.mc.getRenderViewEntity();
        if (entity == null) {
            return new Class46(0.0, 0.0, false);
        }
        Vec3d vec3d = ActiveRenderInfo.position;
        Vec3d vec3d2 = ActiveRenderInfo.projectViewFromEntity((Entity)entity, (double)Globals.mc.getRenderPartialTicks());
        float f = (float)(vec3d.x + vec3d2.x - (double)((float)d));
        float f2 = (float)(vec3d.y + vec3d2.y - (double)((float)d2));
        float f3 = (float)(vec3d.z + vec3d2.z - (double)((float)d3));
        Vector4f vector4f = new Vector4f(f, f2, f3, 1.0f);
        Field1805.load(ActiveRenderInfo.MODELVIEW.asReadOnlyBuffer());
        Field1806.load(ActiveRenderInfo.PROJECTION.asReadOnlyBuffer());
        Class47.Method2202(vector4f, Field1805);
        Class47.Method2202(vector4f, Field1806);
        if (vector4f.w > 0.0f) {
            vector4f.x *= -100000.0f;
            vector4f.y *= -100000.0f;
        } else {
            float f4 = 1.0f / vector4f.w;
            vector4f.x *= f4;
            vector4f.y *= f4;
        }
        ScaledResolution scaledResolution = new ScaledResolution(Globals.mc);
        float f5 = (float)scaledResolution.getScaledWidth() / 2.0f;
        float f6 = (float)scaledResolution.getScaledHeight() / 2.0f;
        vector4f.x = f5 + (0.5f * vector4f.x * (float)scaledResolution.getScaledWidth() + 0.5f);
        vector4f.y = f6 - (0.5f * vector4f.y * (float)scaledResolution.getScaledHeight() + 0.5f);
        boolean bl = true;
        if (vector4f.x < 0.0f || vector4f.y < 0.0f || vector4f.x > (float)scaledResolution.getScaledWidth() || vector4f.y > (float)scaledResolution.getScaledHeight()) {
            bl = false;
        }
        return new Class46(vector4f.x, vector4f.y, bl);
    }

    public static Class46 Method2204(Vec3d vec3d) {
        return Class47.Method2203(vec3d.x, vec3d.y, vec3d.z);
    }

    @Deprecated
    public static Class502 Method2205(double d, double d2, double d3) {
        Class46 class46 = Class47.Method2203(d, d2, d3);
        return new Class502(class46.Method76(), class46.Method77(), class46.Method78());
    }

    @Deprecated
    public static Class502 Method2206(Vec3d vec3d) {
        return Class47.Method2205(vec3d.x, vec3d.y, vec3d.z);
    }

    @Deprecated
    public static Object Method2207(Vec3d vec3d) {
        return null;
    }

    public static Vec3d Method2208(Vec3d vec3d, Vec3d vec3d2) {
        return new Vec3d(vec3d.x * vec3d2.x, vec3d.y * vec3d2.y, vec3d.z * vec3d2.z);
    }

    public static Vec3d Method2209(Vec3d vec3d) {
        return new Vec3d(vec3d.x, vec3d.y, vec3d.z);
    }

    public static double Method2210(Vec3d vec3d, Vec3d vec3d2, Vec3d vec3d3) {
        return vec3d3.subtract(vec3d).normalize().subtract(vec3d2).lengthSquared();
    }
}
