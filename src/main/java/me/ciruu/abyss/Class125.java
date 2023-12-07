package me.ciruu.abyss;

import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.misc.Timer;

public class Class125 {
    private float Field2339 = 1.0f;
    private Timer Field2340;

    public void Method2025() {
        this.Field2340 = (Timer)Manager.moduleManager.getModuleByClass(Timer.class);
    }

    public void Method2906() {
        this.Field2339 = 1.0f;
        Globals.mc.timer.tickLength = 50.0f;
    }

    public void Method2907() {
        if (this.Field2340 != null && this.Field2340.Method2908()) {
            this.Field2339 = this.Field2340.Field2104;
        }
        Globals.mc.timer.tickLength = 50.0f / (this.Field2339 <= 0.0f ? 0.1f : this.Field2339);
    }

    public void Method337(float f) {
        if (f > 0.0f) {
            this.Field2339 = f;
        }
    }

    public float Method2909() {
        return this.Field2339;
    }

    public void Method2540() {
        this.Field2339 = 1.0f;
    }
}
