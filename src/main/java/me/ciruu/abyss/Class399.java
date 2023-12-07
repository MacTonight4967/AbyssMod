package me.ciruu.abyss;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import me.ciruu.abyss.Class223;
import me.ciruu.abyss.Class224;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
static final class Class399
extends Lambda
implements Function1 {
    final Class223 Field2183;

    public Object invoke(Object object) {
        this.invoke((Class224)object);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Class224 class224) {
        Class223.Method701(this.Field2183, 7, class224.Method700());
    }

    Class399(Class223 class223) {
        this.Field2183 = class223;
        super(1);
    }
}
