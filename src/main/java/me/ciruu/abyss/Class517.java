package me.ciruu.abyss;

import me.ciruu.abyss.Class29;
import me.ciruu.abyss.Class52;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.player.EventPlayerJump;
import me.ciruu.abyss.events.player.EventPlayerMove;
import me.ciruu.abyss.events.player.EventPlayerUpdate;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import me.ciruu.abyss.modules.movement.Speed;
import net.minecraft.entity.Entity;
import net.minecraft.init.MobEffects;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class Class517
extends Class52 {
    private int Field2019 = 1;
    private double Field2020;
    private double Field2021 = this.Method2455();
    private boolean Field2022 = true;

    private double Method2455() {
        int n;
        double d = 0.2873;
        if (((Boolean)Speed.strict.getValue()).booleanValue()) {
            d = ((Float)Speed.strictspeed.getValue()).floatValue();
        }
        if (Globals.mc.player == null) {
            return d;
        }
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

    public void Method2456(EventPlayerUpdate eventPlayerUpdate) {
    }

    public void Method2457(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        if (eventPlayerUpdateWalking.Method100() != Class53.PRE || Globals.mc.player == null) {
            return;
        }
        double d = Globals.mc.player.posX - Globals.mc.player.prevPosX;
        double d2 = Globals.mc.player.posZ - Globals.mc.player.prevPosZ;
        this.Field2020 = Math.sqrt(d * d + d2 * d2);
    }

    public void Method2458(EventPlayerJump eventPlayerJump) {
    }

    public void Method2459(EventPlayerMove eventPlayerMove) {
        if (eventPlayerMove.Method2162() != Class53.PRE || eventPlayerMove.isCancelled() || Globals.mc.player == null) {
            return;
        }
        if (Globals.mc.player.fallDistance > 4.0f) {
            return;
        }
        if (Class29.Method2460(Globals.mc.player.posY - (double)((int)Globals.mc.player.posY), 3) == Class29.Method2460(0.138, 3)) {
            Globals.mc.player.motionY -= 1.0;
            eventPlayerMove.Method105(eventPlayerMove.Method985() - 0.0931);
            eventPlayerMove.cancel();
            Globals.mc.player.posY -= 0.0931;
        }
        if (this.Field2019 == 1 && (Globals.mc.player.moveForward != 0.0f || Globals.mc.player.moveStrafing != 0.0f)) {
            boolean bl = this.Method2461();
            eventPlayerMove.Method105(bl ? 0.42 : 0.4);
            eventPlayerMove.cancel();
            Globals.mc.player.motionY = bl ? 0.41936 : 0.39936;
            this.Field2022 = !this.Field2022;
            this.Field2021 *= this.Field2022 ? 1.685 : 1.395;
        } else if (this.Field2019 == 2) {
            double d = 0.66 * (this.Field2020 - this.Method2455());
            this.Field2021 = this.Field2020 - d;
        } else {
            if (Globals.mc.world.getCollisionBoxes((Entity)Globals.mc.player, Globals.mc.player.getEntityBoundingBox().offset(0.0, Globals.mc.player.motionY, 0.0)).size() > 0 || Globals.mc.player.collidedVertically) {
                this.Field2019 = 0;
            }
            this.Field2021 = this.Field2020 - this.Field2020 / 159.0;
        }
        this.Field2021 = Math.max(this.Field2021, this.Method2455());
        eventPlayerMove.cancel();
        this.Field2021 = Math.max(this.Field2021, this.Method2455());
        float f = Globals.mc.player.movementInput.moveForward;
        float f2 = Globals.mc.player.movementInput.moveStrafe;
        float f3 = Globals.mc.player.rotationYaw;
        if (f == 0.0f && f2 == 0.0f) {
            eventPlayerMove.Method107(0.0);
            eventPlayerMove.Method108(0.0);
        } else if (f != 0.0f) {
            if (f2 >= 1.0f) {
                f3 += (float)(f > 0.0f ? -45 : 45);
                f2 = 0.0f;
            } else if (f2 <= -1.0f) {
                f3 += (float)(f > 0.0f ? 45 : -45);
                f2 = 0.0f;
            }
        }
        if (f > 0.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = -1.0f;
        }
        if (f2 > 0.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = -1.0f;
        }
        double d = Math.cos(Math.toRadians(f3 + 90.0f));
        double d2 = Math.sin(Math.toRadians(f3 + 90.0f));
        eventPlayerMove.Method107((double)f * this.Field2021 * d + (double)f2 * this.Field2021 * d2);
        eventPlayerMove.Method108((double)f * this.Field2021 * d2 - (double)f2 * this.Field2021 * d);
        ++this.Field2019;
    }

    private boolean Method2461() {
        int n = MathHelper.floor((double)Globals.mc.player.getEntityBoundingBox().minX);
        while ((double)n < (double)MathHelper.floor((double)Globals.mc.player.getEntityBoundingBox().maxX) + 1.0) {
            int n2 = MathHelper.floor((double)Globals.mc.player.getEntityBoundingBox().minY);
            while ((double)n2 < (double)MathHelper.floor((double)Globals.mc.player.getEntityBoundingBox().maxY) + 1.0) {
                int n3 = MathHelper.floor((double)Globals.mc.player.getEntityBoundingBox().minZ);
                while ((double)n3 < (double)MathHelper.floor((double)Globals.mc.player.getEntityBoundingBox().maxZ) + 1.0) {
                    if (Globals.mc.world.getBlockState(new BlockPos(n, n2, n3)).getMaterial().blocksMovement()) {
                        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double)n, (double)n2, (double)n3, (double)(n + 1), (double)(n2 + 1), (double)(n3 + 1));
                        if (Globals.mc.player.getEntityBoundingBox().intersects(axisAlignedBB)) {
                            return true;
                        }
                    }
                    ++n3;
                }
                ++n2;
            }
            ++n;
        }
        return false;
    }

    public void Method2462() {
        this.Field2019 = 0;
        this.Field2020 = 0.0;
    }
}
