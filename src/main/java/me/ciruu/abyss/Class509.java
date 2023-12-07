package me.ciruu.abyss;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import me.ciruu.abyss.Class26;
import me.ciruu.abyss.Class468;
import me.ciruu.abyss.Globals;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
static final class Class509
extends Lambda
implements Function1 {
    final Class468 Field3504;

    public Object invoke(Object object) {
        this.invoke((Class26)object);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Class26 class26) {
        block2: {
            if (Globals.mc.player == null || Globals.mc.world == null) {
                return;
            }
            Entity entity = this.Field3504.Method2258();
            if (entity == null) break block2;
            Entity entity2 = entity;
            boolean bl = false;
            boolean bl2 = false;
            Entity entity3 = entity2;
            boolean bl3 = false;
            Class468.Method2269(this.Field3504).add(Class468.Method2270(this.Field3504, entity3));
            while (Class468.Method2269(this.Field3504).size() > Class468.Method2271(this.Field3504)) {
                Class468.Method2269(this.Field3504).pollFirst();
            }
            Class468.Method2273(this.Field3504, Class468.Method2274(this.Field3504));
            Class468.Method2275(this.Field3504, Class468.Method2276(this.Field3504));
        }
    }

    Class509(Class468 class468) {
        this.Field3504 = class468;
        super(1);
    }
}
