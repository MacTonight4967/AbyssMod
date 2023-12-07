package me.ciruu.abyss;

import me.ciruu.abyss.Class307;
import me.ciruu.abyss.Class52;
import me.ciruu.abyss.Class56;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.player.EventPlayerMove;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import me.ciruu.abyss.modules.movement.Speed;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.util.MovementInput;

public class Class520
extends Class52 {
    private int Field2231;
    private double Field2232;
    private double Field2233;

    public void Method2852(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        if (eventPlayerUpdateWalking.Method100() != Class53.PRE || Globals.mc.player == null) {
            return;
        }
        double d = Globals.mc.player.posX - Globals.mc.player.prevPosX;
        double d2 = Globals.mc.player.posZ - Globals.mc.player.prevPosZ;
        this.Field2232 = Math.sqrt(d * d + d2 * d2);
    }

    public void Method2853(EventPlayerMove eventPlayerMove) {
        if (eventPlayerMove.Method102() != MoverType.SELF || Globals.mc.player.fallDistance > 4.0f || Globals.mc.player.getRidingEntity() != null) {
            return;
        }
        switch (this.Field2231) {
            case 0: {
                if (Class56.Method103()) {
                    ++this.Field2231;
                    this.Field2233 = (double)1.18f * Class52.Method104() - 0.01;
                    this.Field2232 = 0.0;
                }
            }
            case 1: {
                if (!Class56.Method103() || !Globals.mc.player.onGround) break;
                Globals.mc.player.motionY = 0.40123128;
                eventPlayerMove.Method105(0.40123128);
                this.Field2233 *= (double)((Float)Speed.strafe2bspeed.getValue()).floatValue();
                ++this.Field2231;
                break;
            }
            case 2: {
                this.Field2233 = this.Field2232 - 0.76 * (this.Field2232 - Class52.Method104());
                ++this.Field2231;
                break;
            }
            case 3: {
                if (Globals.mc.world.getCollisionBoxes((Entity)Globals.mc.player, Globals.mc.player.getEntityBoundingBox().offset(0.0, Globals.mc.player.motionY, 0.0)).size() > 0 || Globals.mc.player.collidedVertically && this.Field2231 > 0) {
                    this.Field2231 = 0;
                }
                this.Field2233 = this.Field2232 - this.Field2232 / 159.0;
            }
        }
        this.Field2233 = Math.max(this.Field2233, Class52.Method104());
        this.Method2854(eventPlayerMove, this.Field2233);
    }

    public static Class307 Method2855(double d) {
        float f = Globals.mc.player.movementInput.moveForward;
        float f2 = Globals.mc.player.movementInput.moveStrafe;
        float f3 = Globals.mc.player.prevRotationYaw + (Globals.mc.player.rotationYaw - Globals.mc.player.prevRotationYaw) * Globals.mc.getRenderPartialTicks();
        if (f == 0.0f && f2 == 0.0f) {
            return new Class307(0.0, 0.0);
        }
        if (f != 0.0f) {
            if (f2 >= 1.0f) {
                f3 += (float)(f > 0.0f ? -45 : 45);
                f2 = 0.0f;
            } else if (f2 <= -1.0f) {
                f3 += (float)(f > 0.0f ? 45 : -45);
                f2 = 0.0f;
            }
            if (f > 0.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = -1.0f;
            }
        }
        double d2 = Math.cos(Math.toRadians(f3 + 90.0f));
        double d3 = Math.sin(Math.toRadians(f3 + 90.0f));
        double d4 = (double)f * d * d2 + (double)f2 * d * d3;
        double d5 = (double)f * d * d3 - (double)f2 * d * d2;
        return new Class307(d4, d5);
    }

    private void Method2854(EventPlayerMove eventPlayerMove, double d) {
        MovementInput movementInput = Globals.mc.player.movementInput;
        double d2 = movementInput.moveForward;
        double d3 = movementInput.moveStrafe;
        float f = Globals.mc.player.prevRotationYaw + (Globals.mc.player.rotationYaw - Globals.mc.player.prevRotationYaw) * Globals.mc.getRenderPartialTicks();
        eventPlayerMove.cancel();
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
            if (Globals.mc.player.isSneaking() && d3 != 0.0 && d2 == 0.0) {
                d3 = d3 > 0.0 ? 1.0 : -1.0;
            }
            eventPlayerMove.Method107(d2 * d * Math.cos(Math.toRadians(f + 90.0f)) + d3 * d * Math.sin(Math.toRadians(f + 90.0f)));
            eventPlayerMove.Method108(d2 * d * Math.sin(Math.toRadians(f + 90.0f)) - d3 * d * Math.cos(Math.toRadians(f + 90.0f)));
        }
    }

    public void Method2856() {
        this.Method2857();
    }

    private void Method2857() {
        this.Field2231 = 0;
        this.Field2232 = 0.0;
    }
}
