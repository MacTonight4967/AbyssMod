package me.ciruu.abyss.modules.hud;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import me.ciruu.abyss.Class35;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Class665;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class663;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

public class BindList
extends Module {
    private final Setting mode = new Setting("Mode", "", this, (Object)Class663.Left);
    private final Setting x = new Setting("X", "X", (Module)this, (Object)0, 0, 1920);
    private final Setting y = new Setting("Y", "Y", (Module)this, (Object)100, 0, 1080);
    private final Setting step = new Setting("Step", "", (Module)this, (Object)9, 5, 15);
    private final Setting color = new Setting("Color", "", this, Color.GREEN);
    private final List Field3362 = new ArrayList();
    @EventHandler
    private Listener Field3363 = new Listener<Class35>(this::Method4023, new Predicate[0]);
    private static Comparator Field3364 = new Class665();

    public BindList() {
        super("BindList", "", Class11.HUD);
        this.Method4024(this.mode);
        this.Method4024(this.x);
        this.Method4024(this.y);
        this.Method4024(this.step);
        this.Method4024(this.color);
    }

    private void Method4023(Class35 class35) {
        this.Field3362.clear();
        Manager.moduleManager.getModules().values().stream().filter(BindList::Method4025).forEach(this::Method4026);
        this.Field3362.sort(Field3364);
        int n = (Integer)this.y.getValue();
        boolean bl = this.mode.getValue() == Class663.Right;
        int n2 = 0;
        for (String string : this.Field3362) {
            int n3 = Class36.Method259(string);
            if (n3 <= n2) continue;
            n2 = n3;
        }
        for (String string : this.Field3362) {
            Class36.Method63(string, bl ? (float)(n2 - Class36.Method259(string) + (Integer)this.x.getValue()) : (float)((Integer)this.x.getValue()).intValue(), n, ((Color)this.color.getValue()).getRGB());
            n += ((Integer)this.step.getValue()).intValue();
        }
    }

    private void Method4026(Module module) {
        this.Field3362.add(module.Method491() + " [" + module.Method160() + "]");
    }

    private static boolean Method4025(Module module) {
        return !module.Method160().equals("NONE");
    }
}
