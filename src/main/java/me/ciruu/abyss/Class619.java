package me.ciruu.abyss;

import java.awt.Color;
import java.util.function.Predicate;
import me.ciruu.abyss.Class26;
import me.ciruu.abyss.Class35;
import me.ciruu.abyss.Class50;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

public class Class619
extends Module {
    private final Setting Field2681 = new Setting("Color1", "", this, new Color(255, 0, 0, 255));
    private final Setting Field2682 = new Setting("Color2", "", this, new Color(0, 255, 0, 255));
    private final Setting Field2683 = new Setting("Speed", "", (Module)this, (Object)Float.valueOf(0.001f), Float.valueOf(0.001f), Float.valueOf(0.01f));
    private Color Field2684;
    private boolean Field2685 = false;
    private float[] Field2686 = new float[3];
    @EventHandler
    private Listener Field2687 = new Listener<Class26>(this::Method3312, new Predicate[0]);
    @EventHandler
    private Listener Field2688 = new Listener<Class35>(this::Method3313, new Predicate[0]);

    public Class619() {
        super("ColorTest", "", Class11.CLIENT);
        this.Method3314(this.Field2681);
        this.Method3314(this.Field2682);
        this.Method3314(this.Field2683);
    }

    public void Method3315() {
        super.Method13();
        Globals.printChatMessage("WARNING! SATURATION AND BRIGHTNESS MUST HAVE THE SAME VALUE IN BOTH COLORS!");
        this.Field2684 = (Color)this.Field2681.getValue();
        this.Field2685 = false;
        this.Field2686 = new float[3];
    }

    private void Method3313(Class35 class35) {
        Class50.Method92(0.0f, 0.0f, 200.0f, 200.0f, this.Field2684.getRGB());
    }

    private void Method3312(Class26 class26) {
        if (this.Field2685) {
            return;
        }
        Color.RGBtoHSB(this.Field2684.getRed(), this.Field2684.getGreen(), this.Field2684.getBlue(), this.Field2686);
        float[] fArray = new float[3];
        Color.RGBtoHSB(((Color)this.Field2682.getValue()).getRed(), ((Color)this.Field2682.getValue()).getGreen(), ((Color)this.Field2682.getValue()).getBlue(), fArray);
        if (this.Field2686[0] == fArray[0]) {
            this.Field2685 = true;
        }
        float f = this.Field2686[0];
        this.Field2686[0] = this.Field2686[0] + ((Float)this.Field2683.getValue()).floatValue();
        if (this.Field2686[0] < fArray[0] && fArray[0] - f <= ((Float)this.Field2683.getValue()).floatValue() || this.Field2686[0] > fArray[0] && this.Field2686[0] - fArray[0] <= ((Float)this.Field2683.getValue()).floatValue()) {
            this.Field2686[0] = fArray[0];
            this.Field2685 = true;
            Globals.printChatMessage("Done!");
        }
        if (!this.Field2685) {
            this.Field2684 = new Color(Color.HSBtoRGB(this.Field2686[0], this.Field2686[1], this.Field2686[2]));
        }
    }
}
