package me.ciruu.abyss;

import me.ciruu.abyss.Class52;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.player.EntityPlayerAttackEntityFrom;
import me.ciruu.abyss.events.player.EventPlayerJump;
import me.ciruu.abyss.events.player.EventPlayerMove;
import me.ciruu.abyss.events.player.EventPlayerUpdate;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import me.ciruu.abyss.modules.movement.Speed;
import net.minecraft.entity.MoverType;
import net.minecraft.init.MobEffects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;

public class Class516
extends Class52 {
    private float Field2330 = 1.0f;
    private boolean Field2331 = false;
    private int Field2332 = 0;

    private float Method2898() {
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
        return f * ((float)Math.PI / 180);
    }

    public void Method2899(EntityPlayerAttackEntityFrom entityPlayerAttackEntityFrom) {
        if (this.Method2900(entityPlayerAttackEntityFrom.Method1565())) {
            return;
        }
        this.Field2330 = ((Float)Speed.boost.getValue()).floatValue();
    }

    public void Method2901() {
        if (this.Field2330 != 1.0f) {
            this.Field2330 = 1.0f;
            this.Field2331 = true;
            this.Field2332 = 5;
        }
    }

    private boolean Method2900(DamageSource damageSource) {
        return damageSource == DamageSource.FALL || damageSource == DamageSource.IN_WALL || damageSource == DamageSource.IN_FIRE || damageSource == DamageSource.CRAMMING || damageSource == DamageSource.LIGHTNING_BOLT || damageSource == DamageSource.FALLING_BLOCK || damageSource == DamageSource.LAVA || damageSource == DamageSource.HOT_FLOOR || damageSource == DamageSource.DROWN || damageSource == DamageSource.STARVE || damageSource == DamageSource.FLY_INTO_WALL || damageSource == DamageSource.OUT_OF_WORLD || damageSource == DamageSource.MAGIC || damageSource == DamageSource.WITHER || damageSource == DamageSource.ANVIL || damageSource == DamageSource.DRAGON_BREATH;
    }

    public void Method2902(EventPlayerUpdate eventPlayerUpdate) {
        if (Globals.mc.player.isRiding()) {
            return;
        }
        if ((Globals.mc.player.isInWater() || Globals.mc.player.isInLava()) && !((Boolean)Speed.speedinwater.getValue()).booleanValue()) {
            return;
        }
        if (((Boolean)Speed.usetimer.getValue()).booleanValue()) {
            Manager.Field298.Method337(1.088f);
        }
        if (Globals.mc.player.moveForward != 0.0f || Globals.mc.player.moveStrafing != 0.0f) {
            if (((Boolean)Speed.autosprint.getValue()).booleanValue()) {
                Globals.mc.player.setSprinting(true);
            }
            if (Globals.mc.player.onGround) {
                if (((Boolean)Speed.autojump.getValue()).booleanValue()) {
                    Globals.mc.player.motionY = 0.405f;
                }
                float f = this.Method2898();
                Globals.mc.player.motionX -= (double)(MathHelper.sin((float)f) * 0.2f);
                Globals.mc.player.motionZ += (double)(MathHelper.cos((float)f) * 0.2f);
            }
        }
        if (Globals.mc.player.movementInput.jump && Globals.mc.player.onGround) {
            Globals.mc.player.motionY = 0.405f;
        }
    }

    public void Method2903(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
    }

    public void Method2904(EventPlayerJump eventPlayerJump) {
        eventPlayerJump.cancel();
    }

    public void Method2905(EventPlayerMove eventPlayerMove) {
        if (eventPlayerMove.Method2162() != Class53.PRE || eventPlayerMove.isCancelled() || Globals.mc.player == null || eventPlayerMove.Method102() != MoverType.SELF) {
            return;
        }
        if (this.Field2331 && this.Field2332 > 0) {
            --this.Field2332;
            return;
        }
        this.Field2331 = false;
        if ((Globals.mc.player.isInWater() || Globals.mc.player.isInLava()) && !((Boolean)Speed.speedinwater.getValue()).booleanValue()) {
            return;
        }
        if (Globals.mc.player.capabilities != null) {
            if (Globals.mc.player.capabilities.isFlying || Globals.mc.player.isElytraFlying()) {
                return;
            }
            if (Globals.mc.player.onGround) {
                return;
            }
            float f = 0.2873f;
            float f2 = Globals.mc.player.movementInput.moveForward;
            float f3 = Globals.mc.player.movementInput.moveStrafe;
            float f4 = Globals.mc.player.rotationYaw;
            if (Globals.mc.player.isPotionActive(MobEffects.SPEED)) {
                int n = Globals.mc.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
                f *= 1.0f + 0.2f * (float)(n + 1);
            }
            if (!((Boolean)Speed.strict.getValue()).booleanValue()) {
                f *= 1.0064f;
            }
            if (((Boolean)Speed.damageboost.getValue()).booleanValue()) {
                f *= this.Field2330;
            }
            if (f2 == 0.0f && f3 == 0.0f) {
                eventPlayerMove.Method107(0.0);
                eventPlayerMove.Method108(0.0);
            } else {
                if (f2 != 0.0f) {
                    if (f3 > 0.0f) {
                        f4 += (float)(f2 > 0.0f ? -45 : 45);
                    } else if (f3 < 0.0f) {
                        f4 += (float)(f2 > 0.0f ? 45 : -45);
                    }
                    f3 = 0.0f;
                    if (f2 > 0.0f) {
                        f2 = 1.0f;
                    } else if (f2 < 0.0f) {
                        f2 = -1.0f;
                    }
                }
                eventPlayerMove.Method107((double)(f2 * f) * Math.cos(Math.toRadians(f4 + 90.0f)) + (double)(f3 * f) * Math.sin(Math.toRadians(f4 + 90.0f)));
                eventPlayerMove.Method108((double)(f2 * f) * Math.sin(Math.toRadians(f4 + 90.0f)) - (double)(f3 * f) * Math.cos(Math.toRadians(f4 + 90.0f)));
            }
            eventPlayerMove.cancel();
        }
    }
}
