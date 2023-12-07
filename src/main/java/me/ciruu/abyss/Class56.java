package me.ciruu.abyss;

import me.ciruu.abyss.Globals;
import me.ciruu.abyss.events.player.EventPlayerMove;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.MobEffects;
import net.minecraft.util.MovementInput;

public class Class56 {
    public static float Method3161() {
        return (float)Math.sqrt(Globals.mc.player.motionX * Globals.mc.player.motionX + Globals.mc.player.motionZ * Globals.mc.player.motionZ);
    }

    public static void Method3162() {
        Class56.Method3163(Class56.Method3161());
    }

    public static boolean Method103() {
        return Globals.mc.player != null && (Globals.mc.player.movementInput.moveForward != 0.0f || Globals.mc.player.movementInput.moveStrafe != 0.0f);
    }

    public static boolean Method2451() {
        return Globals.mc.player.motionX != 0.0 && Globals.mc.player.motionZ != 0.0 && Globals.mc.player.motionY != 0.0;
    }

    public static void Method3163(float f) {
        if (!Class56.Method103()) {
            return;
        }
        double d = Class56.Method3164();
        Globals.mc.player.motionX = -Math.sin(d) * (double)f;
        Globals.mc.player.motionZ = Math.cos(d) * (double)f;
    }

    public static void Method3165(double d) {
        double d2 = Math.toRadians(Globals.mc.player.rotationYaw);
        Globals.mc.player.setPosition(Globals.mc.player.posX + -Math.sin(d2) * d, Globals.mc.player.posY, Globals.mc.player.posZ + Math.cos(d2) * d);
    }

    public static double Method3164() {
        float f = Globals.mc.player.rotationYaw;
        if (Globals.mc.player.moveForward < 0.0f) {
            f += 180.0f;
        }
        float f2 = 1.0f;
        if (Globals.mc.player.moveForward < 0.0f) {
            f2 = -0.5f;
        } else if (Globals.mc.player.moveForward > 0.0f) {
            f2 = 0.5f;
        }
        if (Globals.mc.player.moveStrafing > 0.0f) {
            f -= 90.0f * f2;
        }
        if (Globals.mc.player.moveStrafing < 0.0f) {
            f += 90.0f * f2;
        }
        return Math.toRadians(f);
    }

    public static EntityPlayerSP Method3166() {
        return Globals.mc.player;
    }

    public static MovementInput Method3167() {
        return Class56.Method3166().movementInput;
    }

    public static double Method3168() {
        return Class56.Method3166().posX;
    }

    public static void Method3169(double d) {
        Class56.Method3166().posX = d;
    }

    public static double Method3170() {
        return Class56.Method3166().posY;
    }

    public static void Method3171(double d) {
        Class56.Method3166().posY = d;
    }

    public static double Method3172() {
        return Class56.Method3166().posZ;
    }

    public static void Method3173(double d) {
        Class56.Method3166().posZ = d;
    }

    public static float Method3174() {
        return Class56.Method3166().rotationYaw;
    }

    public static void Method3175(float f) {
        Class56.Method3166().rotationYaw = f;
    }

    public static float Method3176() {
        return Class56.Method3166().rotationPitch;
    }

    public static void Method3177(float f) {
        Class56.Method3166().rotationPitch = f;
    }

    public static void Method3178(EventPlayerMove eventPlayerMove, double d) {
        double d2 = Class56.Method3167().moveForward;
        double d3 = Class56.Method3167().moveStrafe;
        float f = Class56.Method3174();
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

    public static double Method3179() {
        int n;
        double d = 0.2873;
        if (Globals.mc.player.isPotionActive(MobEffects.SPEED)) {
            n = Globals.mc.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
            d *= 1.0 + 0.2 * (double)(n + 1);
        }
        if (Globals.mc.player.isPotionActive(MobEffects.JUMP_BOOST)) {
            n = Globals.mc.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
            d /= 1.0 + 0.2 * (double)(n + 1);
        }
        return d;
    }

    public static double[] Method3180(double d) {
        double d2 = Class56.Method3167().moveForward;
        double d3 = Class56.Method3167().moveStrafe;
        float f = Class56.Method3174();
        double[] dArray = new double[2];
        if (d2 == 0.0 && d3 == 0.0) {
            dArray[0] = 0.0;
            dArray[1] = 0.0;
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
            dArray[0] = d2 * d * Math.cos(Math.toRadians(f + 90.0f)) + d3 * d * Math.sin(Math.toRadians(f + 90.0f));
            dArray[1] = d2 * d * Math.sin(Math.toRadians(f + 90.0f)) - d3 * d * Math.cos(Math.toRadians(f + 90.0f));
        }
        return dArray;
    }
}
