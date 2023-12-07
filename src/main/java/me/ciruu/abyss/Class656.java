package me.ciruu.abyss;

import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;
import me.ciruu.abyss.Class35;
import me.ciruu.abyss.Class498;
import me.ciruu.abyss.Class655;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.EventHook;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.MethodRefListener;

public final class Class656
extends Module {
    private final Setting Field3578 = new Setting("X", "X", (Module)this, (Object)10, 0, 1000);
    private final Setting Field3579 = new Setting("Y", "Y", (Module)this, (Object)10, 0, 1000);
    private String Field3580 = "";
    @EventHandler
    private final Listener Field3581;

    public Class656() {
        super("ACComponent", "", Class11.HUD);
        Listener listener;
        Function1 function1 = new Class655(this);
        Class656 class656 = this;
        int n = 0;
        boolean bl = false;
        Function1 function12 = function1;
        class656.Field3581 = listener = (Listener)new MethodRefListener<Class35>(Class35.class, (EventHook)new Class498(function12), n, new Predicate[0]);
        this.Method4327(this.Field3578);
        this.Method4327(this.Field3579);
    }

    public static final String Method3861(Class656 class656) {
        return class656.Field3580;
    }

    public static final void Method3860(Class656 class656, String string) {
        class656.Field3580 = string;
    }

    public static final Setting Method3862(Class656 class656) {
        return class656.Field3578;
    }

    public static final Setting Method3863(Class656 class656) {
        return class656.Field3579;
    }
}
