package me.ciruu.abyss;

import kotlin.jvm.functions.Function1;
import me.zero.alpine.listener.EventHook;

public final class Class498
implements EventHook {
    private final Function1 Field1780;

    public Class498(Function1 function1) {
        this.Field1780 = function1;
    }

    public final void invoke(Object object) {
        this.Field1780.invoke(object);
    }
}
