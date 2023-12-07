package me.ciruu.abyss;

import java.math.BigDecimal;
import java.math.RoundingMode;
import me.ciruu.abyss.Class52;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.player.EventPlayerJump;
import me.ciruu.abyss.events.player.EventPlayerMove;
import me.ciruu.abyss.events.player.EventPlayerUpdate;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import me.ciruu.abyss.modules.movement.Speed;

public class Class518
extends Class52 {
    private int Field2076;
    private double Field2077;
    private double Field2078;

    public void Method2500(EventPlayerUpdate eventPlayerUpdate) {
    }

    public void Method2501(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        if (eventPlayerUpdateWalking.Method100() != Class53.PRE) {
            return;
        }
        double d = Globals.mc.player.posX - Globals.mc.player.prevPosX;
        double d2 = Globals.mc.player.posZ - Globals.mc.player.prevPosZ;
        this.Field2077 = Math.sqrt(d * d + d2 * d2);
    }

    public void Method2502(EventPlayerJump eventPlayerJump) {
    }

    public void Method2503(EventPlayerMove eventPlayerMove) {
        eventPlayerMove.cancel();
        if (Globals.mc.player.onGround && (Globals.mc.player.moveForward != 0.0f || Globals.mc.player.moveStrafing != 0.0f)) {
            if (((Boolean)Speed.usetimer.getValue()).booleanValue()) {
                Manager.Field298.Method337(1.5f);
            }
        } else {
            Manager.Field298.Method337(1.0f);
        }
        Globals.mc.player.motionY = 0.31;
        eventPlayerMove.Method105(0.31);
        Globals.mc.player.motionY = 0.05;
        eventPlayerMove.Method105(0.05);
        Globals.mc.player.motionY = -0.5;
        eventPlayerMove.Method105(-0.5);
        Globals.mc.player.motionY = -0.2;
        eventPlayerMove.Method105(-0.2);
        if (Class518.Method2504(Globals.mc.player.posY - (double)((int)Globals.mc.player.posY), 3) == Class518.Method2504(0.41, 3)) {
            Globals.mc.player.motionY = -0.2;
            eventPlayerMove.Method105(-0.2);
        }
        if (this.Field2076 == 1 && (Globals.mc.player.moveForward != 0.0f || Globals.mc.player.moveStrafing != 0.0f)) {
            this.Field2078 = 2.0 * Class52.Method104() - 0.01;
        } else if (this.Field2076 == 2 && (Globals.mc.player.moveForward != 0.0f || Globals.mc.player.moveStrafing != 0.0f)) {
            Globals.mc.player.motionY = 0.4;
            eventPlayerMove.Method105(0.4);
            this.Field2078 *= Globals.mc.player.hurtResistantTime <= 3 ? 1.47 : 2.1;
        } else if (this.Field2076 == 3) {
            double d = 0.66 * (this.Field2077 - Class52.Method104());
            this.Field2078 = this.Field2077 - d;
        } else {
            if (Globals.mc.player.collidedVertically && this.Field2076 > 0) {
                this.Field2076 = Globals.mc.player.moveForward != 0.0f || Globals.mc.player.moveStrafing != 0.0f ? 1 : 0;
            }
            this.Field2078 = this.Field2077 - this.Field2077 / 200.0;
        }
        this.Field2078 = Math.max(this.Field2078, Class52.Method104());
        this.Method2505(eventPlayerMove, this.Field2078);
        if (Globals.mc.player.moveForward != 0.0f || Globals.mc.player.moveStrafing != 0.0f) {
            ++this.Field2076;
        }
    }

    public void Method2505(EventPlayerMove eventPlayerMove, double d) {
        double d2 = Globals.mc.player.moveForward;
        double d3 = Globals.mc.player.moveStrafing;
        float f = Globals.mc.player.rotationYaw;
        if (d2 == 0.0 && d3 == 0.0) {
            eventPlayerMove.Method107(0.0);
            eventPlayerMove.Method108(0.0);
        } else {
            if (d2 != 0.0) {
                if (d3 > 0.0) {
                    f += (float)(d2 > 0.0 ? -45 : 45);
                } else if (d3 < 0.0) {
                    f += (float)(d2 > 0.0 ? 45 : -45);
                }
                d3 = 0.0;
                if (d2 > 0.0) {
                    d2 = 1.0;
                } else if (d2 < 0.0) {
                    d2 = -1.0;
                }
            }
            eventPlayerMove.Method107(d2 * d * Math.cos(Math.toRadians(f + 90.0f)) + d3 * d * Math.sin(Math.toRadians(f + 90.0f)));
            eventPlayerMove.Method108(d2 * d * Math.sin(Math.toRadians(f + 90.0f)) - d3 * d * Math.cos(Math.toRadians(f + 90.0f)));
        }
    }

    public static double Method2504(double d, int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bigDecimal = new BigDecimal(d);
        bigDecimal = bigDecimal.setScale(n, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}
