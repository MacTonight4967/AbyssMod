package me.ciruu.abyss;

import java.awt.Color;
import java.util.function.Predicate;
import me.ciruu.abyss.Class35;
import me.ciruu.abyss.Class423;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

public class Class554
extends Module {
    private Setting Field2126 = new Setting("Active", "Activates the feature", this, true);
    private Setting Field2127 = new Setting("X", "X", (Module)this, (Object)0, -2000, 2000);
    private Setting Field2128 = new Setting("Y", "Y", (Module)this, (Object)0, -2000, 2000);
    private Setting Field2129 = new Setting("W", "X", (Module)this, (Object)0, -2000, 2000);
    private Setting Field2130 = new Setting("H", "X", (Module)this, (Object)0, -2000, 2000);
    private Setting Field2131 = new Setting("Radius", "", (Module)this, (Object)1, 0, 500);
    private Setting Field2132 = new Setting("Amount", "", (Module)this, (Object)50, 0, 720);
    private Setting Field2133 = new Setting("Color", "", this, new Color(5, 255, 164, 184));
    private Setting Field2134 = new Setting("ColorOutline", "", this, new Color(5, 255, 164, 255));
    private Setting Field2135 = new Setting("Rainbow", "", this, false);
    private final Setting Field2136 = new Setting("LineWidth", "", (Module)this, (Object)Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(10.0f));
    @EventHandler
    private Listener Field2137 = new Listener<Class35>(this::Method2613, new Predicate[0]);

    public Class554() {
        super("Example", "Renders the Aeterna logo on screen", Class11.COMBAT, "NONE");
        this.Method2614(this.Field2126);
        this.Method2614(this.Field2127);
        this.Method2614(this.Field2128);
        this.Method2614(this.Field2129);
        this.Method2614(this.Field2130);
        this.Method2614(this.Field2131);
        this.Method2614(this.Field2132);
        this.Method2614(this.Field2133);
        this.Method2614(this.Field2134);
        this.Method2614(this.Field2135);
        this.Method2614(this.Field2136);
    }

    private void Method2613(Class35 class35) {
        if (((Boolean)this.Field2135.getValue()).booleanValue()) {
            Class423.Method2615((Integer)this.Field2127.getValue(), (Integer)this.Field2128.getValue(), (Integer)this.Field2131.getValue(), (Color)this.Field2133.getValue(), (Integer)this.Field2132.getValue(), ((Float)this.Field2136.getValue()).floatValue());
        } else {
            Class423.Method1794((Integer)this.Field2127.getValue(), (Integer)this.Field2128.getValue(), (Integer)this.Field2129.getValue(), (Integer)this.Field2130.getValue(), (Integer)this.Field2131.getValue(), ((Color)this.Field2133.getValue()).getRGB());
            Class423.Method1795((Integer)this.Field2127.getValue(), (Integer)this.Field2128.getValue(), (Integer)this.Field2129.getValue(), (Integer)this.Field2130.getValue(), (Integer)this.Field2131.getValue(), ((Float)this.Field2136.getValue()).floatValue(), ((Color)this.Field2134.getValue()).getRGB());
        }
    }
}
