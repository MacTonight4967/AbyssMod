package me.ciruu.abyss;

import java.util.LinkedList;
import java.util.function.Predicate;
import me.ciruu.abyss.AbyssMod;
import me.ciruu.abyss.Class26;
import me.ciruu.abyss.Class30;
import me.ciruu.abyss.Globals;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listenable;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Class254
implements Listenable {
    public Entity Field676 = null;
    private int Field677 = 20;
    private LinkedList Field678 = new LinkedList();
    private Vec3d Field679 = new Vec3d(0.0, 0.0, 0.0);
    private Vec3d Field680 = new Vec3d(0.0, 0.0, 0.0);
    @EventHandler
    private Listener Field681 = new Listener<Class26>(this::Method961, new Predicate[0]);

    public void Method962() {
        AbyssMod.EVENT_BUS.subscribe(this);
    }

    public Vec3d Method963(Entity entity) {
        return entity.getPositionVector().subtract(entity.prevPosX, entity.prevPosY, entity.prevPosZ);
    }

    public Vec3d Method964() {
        double d = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;
        for (Vec3d vec3d : this.Field678) {
            d += vec3d.x;
            d2 += vec3d.y;
            d3 += vec3d.z;
        }
        return new Vec3d(d, d2, d3).scale(1.0 / (double)this.Field678.size());
    }

    public Vec3d Method965(int n, boolean bl) {
        Vec3d vec3d = this.Method966(n, bl);
        float f = bl ? this.Method967() : 1.0f;
        this.Method966(n, bl);
        return this.Field676 != null ? (this.Method966(n, bl) != null ? Class30.Method968(this.Field676, f).add(vec3d) : null) : null;
    }

    public Vec3d Method966(int n, boolean bl) {
        if (this.Field676 != null && Globals.mc.world != null) {
            float f = 1.0f;
            if (bl) {
                f = this.Method967();
            }
            Vec3d vec3d = this.Field679.add(this.Field680.subtract(this.Field679).scale((double)f));
            Vec3d vec3d2 = new Vec3d(0.0, 0.0, 0.0);
            for (int i = 0; i < n; ++i) {
                if (this.Method969((World)Globals.mc.world, this.Field676.boundingBox, vec3d2.add(vec3d))) {
                    vec3d2.add(vec3d);
                    continue;
                }
                if (!this.Method969((World)Globals.mc.world, this.Field676.boundingBox, vec3d2.add(vec3d.x, 0.0, vec3d.z))) break;
                vec3d2.add(vec3d.x, 0.0, vec3d.z);
            }
            return vec3d2;
        }
        return null;
    }

    private boolean Method969(World world, AxisAlignedBB axisAlignedBB, Vec3d vec3d) {
        return !world.collidesWithAnyBlock(axisAlignedBB.offset(vec3d));
    }

    public void Method970() {
        this.Field678.clear();
        this.Field679 = new Vec3d(0.0, 0.0, 0.0);
        this.Field680 = new Vec3d(0.0, 0.0, 0.0);
    }

    private float Method967() {
        if (Globals.mc.isGamePaused) {
            return Globals.mc.renderPartialTicksPaused;
        }
        return Globals.mc.getRenderPartialTicks();
    }

    private void Method961(Class26 class26) {
        if (Globals.mc.player == null || Globals.mc.world == null) {
            return;
        }
        if (this.Field676 != null) {
            this.Field678.add(this.Method963(this.Field676));
            while (this.Field678.size() > this.Field677) {
                this.Field678.pollFirst();
            }
            this.Field679 = this.Field680;
            this.Field680 = this.Method964();
        }
    }
}
