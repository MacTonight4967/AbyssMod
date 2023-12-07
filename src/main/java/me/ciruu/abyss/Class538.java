package me.ciruu.abyss;

import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;
import me.ciruu.abyss.Class35;
import me.ciruu.abyss.Class498;
import me.ciruu.abyss.Class537;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.EventHook;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.MethodRefListener;

public final class Class538
extends Module {
    private final Setting Field3403 = new Setting("X", "X", (Module)this, (Object)10, 0, 1000);
    private final Setting Field3404 = new Setting("Y", "Y", (Module)this, (Object)10, 0, 1000);
    private String Field3405 = "";
    @EventHandler
    private final Listener Field3406;

    public Class538() {
        super("AutoCrystalComponent", "", Class11.HUD);
        Listener listener;
        Function1 function1 = new Class537(this);
        Class538 class538 = this;
        int n = 0;
        boolean bl = false;
        Function1 function12 = function1;
        class538.Field3406 = listener = (Listener)new MethodRefListener<Class35>(Class35.class, (EventHook)new Class498(function12), n, new Predicate[0]);
        this.Method4077(this.Field3403);
        this.Method4077(this.Field3404);
    }

    public static final String Method2443(Class538 class538) {
        return class538.Field3405;
    }

    public static final void Method2442(Class538 class538, String string) {
        class538.Field3405 = string;
    }

    public static final Setting Method2444(Class538 class538) {
        return class538.Field3403;
    }

    public static final Setting Method2445(Class538 class538) {
        return class538.Field3404;
    }
}
