package me.ciruu.abyss;

import java.text.DecimalFormat;
import java.util.Arrays;
import me.ciruu.abyss.Class22;
import me.ciruu.abyss.Globals;

public class Class469 {
    private float Field2958 = 20.0f;
    private long Field2959 = -1L;
    private final float[] Field2960 = new float[10];
    private final DecimalFormat Field2961 = new DecimalFormat("##.00#");
    private String Field2962 = "";
    private final Class22 Field2963 = new Class22();

    public void Method3654() {
        this.Field2963.Method47();
    }

    public long Method3655() {
        return this.Field2963.Method2130();
    }

    public void Method3656() {
        float f;
        long l = System.currentTimeMillis();
        if (this.Field2959 == -1L) {
            this.Field2959 = l;
            return;
        }
        long l2 = l - this.Field2959;
        float f2 = (float)l2 / 20.0f;
        if (f2 == 0.0f) {
            f2 = 50.0f;
        }
        if ((f = 1000.0f / f2) > 20.0f) {
            f = 20.0f;
        }
        System.arraycopy(this.Field2960, 0, this.Field2960, 1, this.Field2960.length - 1);
        this.Field2960[0] = f;
        double d = 0.0;
        for (float f3 : this.Field2960) {
            d += (double)f3;
        }
        if ((d /= (double)this.Field2960.length) > 20.0) {
            d = 20.0;
        }
        this.Field2958 = Float.parseFloat(this.Field2961.format(d));
        this.Field2959 = l;
    }

    public void Method3657() {
        Arrays.fill(this.Field2960, 20.0f);
        this.Field2958 = 20.0f;
    }

    public float Method2895() {
        return 20.0f / this.Field2958;
    }

    public float Method2230() {
        return this.Field2958;
    }

    public String Method2488() {
        return this.Field2962;
    }

    public void Method2313(String string) {
        this.Field2962 = string;
    }

    public int Method2389() {
        if (Globals.mc.player == null || Globals.mc.world == null) {
            return 0;
        }
        try {
            return Globals.mc.getConnection().getPlayerInfo(Globals.mc.getConnection().getGameProfile().getId()).getResponseTime();
        }
        catch (Exception exception) {
            return 0;
        }
    }
}
