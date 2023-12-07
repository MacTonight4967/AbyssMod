package me.ciruu.abyss;

import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ciruu.abyss.Class498;
import me.zero.alpine.listener.EventHook;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.MethodRefListener;
import org.jetbrains.annotations.NotNull;

public final class Class675 {
    @NotNull
    public static final Listener Method4234(int n, @NotNull Function1 function1) {
        boolean bl = false;
        Intrinsics.reifiedOperationMarker(4, "T");
        Object object = function1;
        if (object != null) {
            Function1 function12 = object;
            object = new Class498(function12);
        }
        return new MethodRefListener<Object>(Object.class, (EventHook)object, n, new Predicate[0]);
    }

    public static Listener Method4235(int n, Function1 function1, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 0;
        }
        n2 = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        Object object2 = function1;
        if (object2 != null) {
            object = object2;
            object2 = new Class498((Function1)object);
        }
        return new MethodRefListener<Object>(Object.class, (EventHook)object2, n, new Predicate[0]);
    }
}
