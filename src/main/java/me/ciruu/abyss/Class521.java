package me.ciruu.abyss;

import java.math.BigDecimal;
import java.math.RoundingMode;
import me.ciruu.abyss.Class52;
import me.ciruu.abyss.Class56;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.player.EventPlayerJump;
import me.ciruu.abyss.events.player.EventPlayerMove;
import me.ciruu.abyss.events.player.EventPlayerUpdate;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import me.ciruu.abyss.modules.movement.Speed;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class Class521
extends Class52 {
    private double Field2014 = 0.0;
    private int Field2015 = 4;
    private double Field2016 = 0.0;
    private int Field2017;
    private boolean Field2018;

    public void Method2446() {
        this.Field2014 = 0.2873;
        this.Field2016 = 0.0;
        this.Field2014 = 0.0;
        this.Field2015 = 4;
        this.Field2017 = 0;
        this.Field2018 = false;
    }

    public void Method2447(EventPlayerUpdate eventPlayerUpdate) {
    }

    public void Method2448(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        if (eventPlayerUpdateWalking.Method100() != Class53.PRE) {
            return;
        }
        double d = Globals.mc.player.posX - Globals.mc.player.prevPosX;
        double d2 = Globals.mc.player.posZ - Globals.mc.player.prevPosZ;
        this.Field2016 = Math.sqrt(d * d + d2 * d2);
        if (!Class56.Method103()) {
            this.Field2018 = true;
        } else if (Globals.mc.player.onGround) {
            this.Field2018 = false;
        }
    }

    public void Method2449(EventPlayerJump eventPlayerJump) {
    }

    public void Method2450(EventPlayerMove eventPlayerMove) {
        if (eventPlayerMove.Method2162() != Class53.PRE || eventPlayerMove.isCancelled()) {
            return;
        }
        eventPlayerMove.cancel();
        ++this.Field2017;
        this.Field2017 %= 5;
        if (this.Field2017 != 0) {
            if (((Boolean)Speed.usetimer.getValue()).booleanValue()) {
                Manager.Field298.Method337(1.0f);
            }
        } else if (Class56.Method2451()) {
            if (((Boolean)Speed.usetimer.getValue()).booleanValue()) {
                Manager.Field298.Method337(1.3f);
            }
            Globals.mc.player.motionX *= (double)1.02f;
            Globals.mc.player.motionZ *= (double)1.02f;
        }
        if (Globals.mc.player.onGround && Class56.Method2451()) {
            this.Field2015 = 2;
        }
        if (this.Method2452(Globals.mc.player.posY - (double)((int)Globals.mc.player.posY)) == this.Method2452(0.138)) {
            Globals.mc.player.motionY -= 0.08;
            eventPlayerMove.Method105(eventPlayerMove.Method985() - 0.09316090325960147);
            Globals.mc.player.posY -= 0.09316090325960147;
        }
        if (this.Field2015 == 1 && (Globals.mc.player.moveForward != 0.0f || Globals.mc.player.moveStrafing != 0.0f)) {
            this.Field2015 = 2;
            this.Field2014 = 1.38 * Class52.Method104() - 0.01;
        } else if (this.Field2015 == 2) {
            this.Field2015 = 3;
            Globals.mc.player.motionY = 0.3994f;
            eventPlayerMove.Method105(0.3994f);
            this.Field2014 *= 2.149;
        } else if (this.Field2015 == 3) {
            this.Field2015 = 4;
            double d = 0.66 * (this.Field2016 - Class52.Method104());
            this.Field2014 = this.Field2016 - d;
        } else {
            if (Globals.mc.world.getCollisionBoxes((Entity)Globals.mc.player, Globals.mc.player.getEntityBoundingBox().offset(0.0, Globals.mc.player.motionY, 0.0)).size() > 0 || Globals.mc.player.collidedVertically) {
                this.Field2015 = 1;
            }
            this.Field2014 = this.Field2016 - this.Field2016 / 159.0;
        }
        this.Field2014 = Math.max(this.Field2014, Class52.Method104());
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
            if (f > 0.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = -1.0f;
            }
        }
        double d = Math.cos(Math.toRadians(f3 + 90.0f));
        double d2 = Math.sin(Math.toRadians(f3 + 90.0f));
        eventPlayerMove.Method107((double)f * this.Field2014 * d + (double)f2 * this.Field2014 * d2);
        eventPlayerMove.Method108((double)f * this.Field2014 * d2 - (double)f2 * this.Field2014 * d);
        Globals.mc.player.stepHeight = 0.6f;
        if (f == 0.0f && f2 == 0.0f) {
            eventPlayerMove.Method107(0.0);
            eventPlayerMove.Method108(0.0);
        }
    }

    private Block Method2453(AxisAlignedBB axisAlignedBB) {
        for (int i = MathHelper.floor((double)axisAlignedBB.minX); i < MathHelper.floor((double)axisAlignedBB.maxX) + 1; ++i) {
            for (int j = MathHelper.floor((double)axisAlignedBB.minZ); j < MathHelper.floor((double)axisAlignedBB.maxZ) + 1; ++j) {
                Block block = Globals.mc.world.getBlockState(new BlockPos(i, (int)axisAlignedBB.minY, j)).getBlock();
                if (block == null) continue;
                return block;
            }
        }
        return null;
    }

    private Block Method2454(double d) {
        return this.Method2453(Globals.mc.player.getEntityBoundingBox().offset(0.0, d, 0.0));
    }

    private double Method2452(double d) {
        BigDecimal bigDecimal = new BigDecimal(d);
        bigDecimal = bigDecimal.setScale(3, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}
