package me.ciruu.abyss;

import me.ciruu.abyss.Class29;
import me.ciruu.abyss.Class52;
import me.ciruu.abyss.Class56;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.player.EventPlayerMove;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import me.ciruu.abyss.modules.movement.Speed;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.util.MovementInput;

public class Class51
extends Class52 {
    private int Field132;
    private double Field133;
    private double Field134;
    private float Field135 = 0.0f;
    private boolean Field136 = true;
    private boolean Field137 = false;

    public void Method99(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        if (eventPlayerUpdateWalking.Method100() != Class53.PRE || Globals.mc.player == null) {
            return;
        }
        double d = Globals.mc.player.posX - Globals.mc.player.prevPosX;
        double d2 = Globals.mc.player.posZ - Globals.mc.player.prevPosZ;
        this.Field133 = Math.sqrt(d * d + d2 * d2);
    }

    public void Method101(EventPlayerMove eventPlayerMove) {
        if (eventPlayerMove.Method102() != MoverType.SELF || Globals.mc.player.fallDistance > 4.0f || Globals.mc.player.getRidingEntity() != null) {
            return;
        }
        switch (this.Field132) {
            case 0: {
                if (Class56.Method103()) {
                    ++this.Field132;
                    this.Field134 = (double)1.18f * Class52.Method104() - 0.01;
                    this.Field133 = 0.0;
                }
                if (this.Field137) {
                    this.Field137 = false;
                    return;
                }
            }
            case 1: {
                if (!Class56.Method103() || !Globals.mc.player.onGround) break;
                Globals.mc.player.motionY = 0.40123128;
                eventPlayerMove.Method105(0.40123128);
                this.Field134 *= (double)((Float)Speed.speedboost.getValue()).floatValue();
                double d = this.Field135 / ((Float)Speed.reduction.getValue()).floatValue();
                this.Field134 += d;
                ++this.Field132;
                break;
            }
            case 2: {
                this.Field134 = this.Field133 - 0.76 * (this.Field133 - Class52.Method104());
                ++this.Field132;
                break;
            }
            case 3: {
                if (Globals.mc.world.getCollisionBoxes((Entity)Globals.mc.player, Globals.mc.player.getEntityBoundingBox().offset(0.0, Globals.mc.player.motionY, 0.0)).size() > 0 || Globals.mc.player.collidedVertically && this.Field132 > 0) {
                    this.Field132 = 0;
                }
                this.Field134 = this.Field133 - this.Field133 / 159.0;
            }
        }
        this.Field134 = Math.max(this.Field134, Class52.Method104());
        this.Method106(eventPlayerMove, this.Field134);
    }

    private void Method106(EventPlayerMove eventPlayerMove, double d) {
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

    public void Method109() {
        this.Method110();
    }

    public void Method111(SPacketEntityVelocity sPacketEntityVelocity) {
        if (Math.abs((double)sPacketEntityVelocity.getMotionY() / 8000.0) < 0.1) {
            return;
        }
        if (this.Field136) {
            this.Field135 = (float)this.Method112((double)sPacketEntityVelocity.getMotionX() / 8000.0, (double)sPacketEntityVelocity.getMotionY() / 8000.0, (double)sPacketEntityVelocity.getMotionZ() / 8000.0);
            this.Field136 = false;
        }
        Globals.printChatMessage("x:" + (double)sPacketEntityVelocity.getMotionX() / 8000.0 + " y:" + (double)sPacketEntityVelocity.getMotionY() / 8000.0 + " z:" + (double)sPacketEntityVelocity.getMotionZ() / 8000.0);
        Globals.printChatMessage(String.valueOf(this.Field135));
    }

    private double Method112(double d, double d2, double d3) {
        return Math.sqrt(Class29.Method114(d) + Class29.Method114(d2) + Class29.Method114(d3));
    }

    private double Method115(double d, double d2, double d3) {
        return Math.sqrt(Math.abs(d) + Math.abs(d2) + Math.abs(d3));
    }

    private void Method110() {
        this.Field132 = 0;
        this.Field133 = 0.0;
        this.Field135 = 0.0f;
        this.Field136 = true;
        this.Field134 = 0.2873;
        this.Field137 = true;
    }
}
