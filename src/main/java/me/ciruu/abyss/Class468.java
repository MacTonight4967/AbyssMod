package me.ciruu.abyss;

import java.util.LinkedList;
import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ciruu.abyss.AbyssMod;
import me.ciruu.abyss.Class26;
import me.ciruu.abyss.Class30;
import me.ciruu.abyss.Class498;
import me.ciruu.abyss.Class509;
import me.ciruu.abyss.Globals;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.EventHook;
import me.zero.alpine.listener.Listenable;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.MethodRefListener;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public final class Class468
implements Listenable {
    @Nullable
    private Entity Field1890;
    private final LinkedList Field1891;
    private Vec3d Field1892;
    private Vec3d Field1893;
    @EventHandler
    private final Listener Field1894;
    private final int Field1895;

    @Nullable
    public final Entity Method2258() {
        return this.Field1890;
    }

    public final void Method2259(@Nullable Entity entity) {
        if (Intrinsics.areEqual(entity, this.Field1890) ^ true) {
            this.Method2260();
            this.Field1890 = entity;
        }
    }

    private final Vec3d Method2261(Entity entity) {
        return entity.getPositionVector().subtract(entity.prevPosX, entity.prevPosY, entity.prevPosZ);
    }

    private final Vec3d Method2262() {
        double d = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;
        for (Vec3d vec3d : this.Field1891) {
            d += vec3d.x;
            d2 += vec3d.y;
            d3 += vec3d.z;
        }
        return new Vec3d(d, d2, d3).scale(1.0 / (double)this.Field1891.size());
    }

    @Nullable
    public final Vec3d Method2263(int n, boolean bl) {
        Vec3d vec3d;
        Entity entity = this.Field1890;
        if (entity != null) {
            Entity entity2 = entity;
            boolean bl2 = false;
            boolean bl3 = false;
            Entity entity3 = entity2;
            boolean bl4 = false;
            Vec3d vec3d2 = this.Method2264(n, bl);
            if (vec3d2 != null) {
                Vec3d vec3d3 = vec3d2;
                boolean bl5 = false;
                boolean bl6 = false;
                Vec3d vec3d4 = vec3d3;
                boolean bl7 = false;
                float f = bl ? this.Method2265() : 1.0f;
                vec3d = Class30.Method968(entity3, f).add(vec3d4);
            } else {
                vec3d = null;
            }
        } else {
            vec3d = null;
        }
        return vec3d;
    }

    public static Vec3d Method2266(Class468 class468, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        return class468.Method2263(n, bl);
    }

    @Nullable
    public final Vec3d Method2264(int n, boolean bl) {
        Vec3d vec3d;
        WorldClient worldClient = Globals.mc.world;
        if (worldClient != null) {
            WorldClient worldClient2 = worldClient;
            boolean bl2 = false;
            boolean bl3 = false;
            WorldClient worldClient3 = worldClient2;
            boolean bl4 = false;
            Entity entity = this.Field1890;
            if (entity != null) {
                Entity entity2 = entity;
                boolean bl5 = false;
                boolean bl6 = false;
                Entity entity3 = entity2;
                boolean bl7 = false;
                float f = bl ? this.Method2265() : 1.0f;
                Vec3d vec3d2 = this.Field1892.add(this.Field1893.subtract(this.Field1892).scale((double)f));
                Vec3d vec3d3 = new Vec3d(0.0, 0.0, 0.0);
                int n2 = 0;
                int n3 = n;
                if (n2 <= n3) {
                    while (true) {
                        Vec3d vec3d4;
                        if (this.Method2267((World)worldClient3, entity3.boundingBox, vec3d3.add(vec3d2))) {
                            vec3d4 = vec3d3.add(vec3d2);
                        } else {
                            if (!this.Method2267((World)worldClient3, entity3.boundingBox, vec3d3.add(vec3d2.x, 0.0, vec3d2.z))) break;
                            vec3d4 = vec3d3.add(vec3d2.x, 0.0, vec3d2.z);
                        }
                        vec3d3 = vec3d4;
                        if (n2 == n3) break;
                        ++n2;
                    }
                }
                vec3d = vec3d3;
            } else {
                vec3d = null;
            }
        } else {
            vec3d = null;
        }
        return vec3d;
    }

    public static Vec3d Method2268(Class468 class468, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        return class468.Method2264(n, bl);
    }

    private final boolean Method2267(World world, AxisAlignedBB axisAlignedBB, Vec3d vec3d) {
        return !world.collidesWithAnyBlock(axisAlignedBB.offset(vec3d));
    }

    public final void Method2260() {
        this.Field1891.clear();
        this.Field1892 = new Vec3d(0.0, 0.0, 0.0);
        this.Field1893 = new Vec3d(0.0, 0.0, 0.0);
    }

    public final float Method2265() {
        return Globals.mc.isGamePaused ? Globals.mc.renderPartialTicksPaused : Globals.mc.getRenderPartialTicks();
    }

    public final void Method2024() {
        AbyssMod.EVENT_BUS.subscribe(this);
    }

    public Class468(@Nullable Entity entity, int n) {
        Listener listener;
        this.Field1895 = n;
        this.Field1890 = entity;
        this.Field1891 = new LinkedList();
        this.Field1892 = new Vec3d(0.0, 0.0, 0.0);
        this.Field1893 = new Vec3d(0.0, 0.0, 0.0);
        Function1 function1 = new Class509(this);
        Class468 class468 = this;
        int n2 = 0;
        boolean bl = false;
        Function1 function12 = function1;
        class468.Field1894 = listener = (Listener)new MethodRefListener<Class26>(Class26.class, (EventHook)new Class498(function12), n2, new Predicate[0]);
    }

    public Class468(Entity entity, int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            n = 20;
        }
        this(entity, n);
    }

    public static final LinkedList Method2269(Class468 class468) {
        return class468.Field1891;
    }

    public static final Vec3d Method2270(Class468 class468, Entity entity) {
        return class468.Method2261(entity);
    }

    public static final int Method2271(Class468 class468) {
        return class468.Field1895;
    }

    public static final Vec3d Method2272(Class468 class468) {
        return class468.Field1892;
    }

    public static final void Method2273(Class468 class468, Vec3d vec3d) {
        class468.Field1892 = vec3d;
    }

    public static final Vec3d Method2274(Class468 class468) {
        return class468.Field1893;
    }

    public static final void Method2275(Class468 class468, Vec3d vec3d) {
        class468.Field1893 = vec3d;
    }

    public static final Vec3d Method2276(Class468 class468) {
        return class468.Method2262();
    }
}
