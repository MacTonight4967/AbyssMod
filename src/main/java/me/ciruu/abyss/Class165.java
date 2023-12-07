package me.ciruu.abyss;

import me.ciruu.abyss.Class52;
import me.ciruu.abyss.Class56;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import me.ciruu.abyss.modules.movement.Speed;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

public class Class165
extends Class52 {
    public void Method453(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        if (eventPlayerUpdateWalking.Method100() != Class53.PRE || Globals.mc.player == null) {
            return;
        }
        if (!Class56.Method103() || Globals.mc.player.isInWater() && Globals.mc.player.isInLava() || Globals.mc.player.collidedHorizontally) {
            return;
        }
        if (Globals.mc.player.onGround) {
            Manager.Field298.Method337(1.15f);
            Globals.mc.player.jump();
            this.Method455((EntityLivingBase)Globals.mc.player, Class165.Method454() + (double)(((Float)Speed.yportspeed.getValue()).floatValue() / 10.0f));
        } else {
            Globals.mc.player.motionY = -1.0;
            Manager.Field298.Method337(1.0f);
        }
    }

    public void Method456() {
        Manager.Field298.Method337(1.0f);
    }

    private void Method455(EntityLivingBase entityLivingBase, double d) {
        double[] dArray = this.Method457(d);
        entityLivingBase.motionX = dArray[0];
        entityLivingBase.motionZ = dArray[1];
    }

    public static double Method454() {
        double d = 0.2873;
        if (Globals.mc.player != null && Globals.mc.player.isPotionActive(Potion.getPotionById((int)1))) {
            int n = Globals.mc.player.getActivePotionEffect(Potion.getPotionById((int)1)).getAmplifier();
            d *= 1.0 + 0.2 * (double)(n + 1);
        }
        return d;
    }

    private double[] Method457(double d) {
        float f = Globals.mc.player.movementInput.moveForward;
        float f2 = Globals.mc.player.movementInput.moveStrafe;
        float f3 = Globals.mc.player.prevRotationYaw + (Globals.mc.player.rotationYaw - Globals.mc.player.prevRotationYaw) * Globals.mc.getRenderPartialTicks();
        if (f != 0.0f) {
            if (f2 > 0.0f) {
                f3 += (float)(f > 0.0f ? -45 : 45);
            } else if (f2 < 0.0f) {
                f3 += (float)(f > 0.0f ? 45 : -45);
            }
            f2 = 0.0f;
            if (f > 0.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = -1.0f;
            }
        }
        double d2 = Math.sin(Math.toRadians(f3 + 90.0f));
        double d3 = Math.cos(Math.toRadians(f3 + 90.0f));
        double d4 = (double)f * d * d3 + (double)f2 * d * d2;
        double d5 = (double)f * d * d2 - (double)f2 * d * d3;
        return new double[]{d4, d5};
    }
}
