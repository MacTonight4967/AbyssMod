package me.ciruu.abyss;

import java.util.HashMap;
import me.ciruu.abyss.Globals;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;

public class Class177 {
    public double Field378 = 0.0;
    public double Field379 = 0.0;
    public double Field380 = 0.0;
    public double Field381 = 0.0;
    public static boolean Field382 = false;
    public static boolean Field383 = false;
    public boolean Field384 = false;
    public long Field385 = 0L;
    public boolean Field386 = true;
    public static final double Field387 = 3.0;
    public double Field388 = 0.0;
    public HashMap Field389 = new HashMap();
    private int Field390 = 20;

    public static void Method462(boolean bl) {
        Field382 = bl;
    }

    public static void Method463(boolean bl) {
        Field383 = bl;
    }

    public float Method464() {
        return (float)(Minecraft.getSystemTime() - this.Field385) / 1000.0f;
    }

    public void Method465() {
        double d = Globals.mc.player.posX - Globals.mc.player.prevPosX;
        double d2 = Globals.mc.player.posZ - Globals.mc.player.prevPosZ;
        this.Field388 = d * d + d2 * d2;
        if (Field382 && (!Globals.mc.player.onGround || Field383)) {
            if (Field382 && !this.Field384) {
                this.Field386 = this.Field379 == 0.0;
                this.Field380 = this.Field388 != 0.0 ? this.Field388 / this.Field379 - 1.0 : -1.0;
                this.Field381 = this.Field388 - this.Field379;
                this.Field385 = Minecraft.getSystemTime();
                this.Field379 = this.Field388;
                this.Field378 = this.Field386 ? this.Field379 : 0.0;
            }
            this.Field384 = Field382;
        } else {
            this.Field384 = false;
            this.Field379 = 0.0;
        }
        this.Method466();
    }

    public void Method466() {
        for (EntityPlayer entityPlayer : Globals.mc.world.playerEntities) {
            if (!(Globals.mc.player.getDistanceSq((Entity)entityPlayer) < (double)(this.Field390 * this.Field390))) continue;
            double d = entityPlayer.posX - entityPlayer.prevPosX;
            double d2 = entityPlayer.posZ - entityPlayer.prevPosZ;
            double d3 = d * d + d2 * d2;
            this.Field389.put(entityPlayer, d3);
        }
    }

    public double Method467(EntityPlayer entityPlayer) {
        if (this.Field389.get(entityPlayer) == null) {
            return 0.0;
        }
        return this.Method468((Double)this.Field389.get(entityPlayer));
    }

    public double Method468(double d) {
        return (double)MathHelper.sqrt((double)d) * 71.2729367892;
    }

    public double Method469() {
        double d = this.Method468(this.Field388);
        d = (double)Math.round(10.0 * d) / 10.0;
        return d;
    }

    public double Method470() {
        double d = this.Method468(this.Field388) / 3.6;
        d = (double)Math.round(10.0 * d) / 10.0;
        return d;
    }
}
