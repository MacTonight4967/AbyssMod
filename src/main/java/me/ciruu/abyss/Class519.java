package me.ciruu.abyss;

import me.ciruu.abyss.Class52;
import me.ciruu.abyss.Class56;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.player.EventPlayerJump;
import me.ciruu.abyss.events.player.EventPlayerMove;
import me.ciruu.abyss.events.player.EventPlayerUpdate;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;

public class Class519
extends Class52 {
    private int Field3491;
    private float Field3492;

    public void Method4236(EventPlayerUpdate eventPlayerUpdate) {
    }

    public void Method4237(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        if (eventPlayerUpdateWalking.Method100() != Class53.PRE) {
            return;
        }
        double d = 3.1981;
        double d2 = 4.69;
        boolean bl = true;
        for (AxisAlignedBB axisAlignedBB : Globals.mc.world.getCollisionBoxes((Entity)Globals.mc.player, Globals.mc.player.getEntityBoundingBox().offset(Globals.mc.player.motionX / d2, 0.0, Globals.mc.player.motionZ / d2))) {
            if (axisAlignedBB == null) continue;
            bl = false;
            break;
        }
        if (Globals.mc.player.onGround && this.Field3492 < 1.0f) {
            this.Field3492 += 0.2f;
        }
        if (!Globals.mc.player.onGround) {
            this.Field3492 = 0.0f;
        }
        if (this.Field3492 == 1.0f && this.Method4238()) {
            if (!Globals.mc.player.isSprinting()) {
                d2 += 0.8;
            }
            if (Globals.mc.player.moveStrafing != 0.0f) {
                d -= 0.1;
                d2 += 0.5;
            }
            if (Globals.mc.player.isInWater()) {
                d -= 0.1;
            }
            ++this.Field3491;
            switch (this.Field3491) {
                case 1: {
                    Globals.mc.player.motionX *= d;
                    Globals.mc.player.motionZ *= d;
                    break;
                }
                case 2: {
                    Globals.mc.player.motionX /= 1.458;
                    Globals.mc.player.motionZ /= 1.458;
                    break;
                }
                case 4: {
                    if (bl) {
                        Globals.mc.player.setPosition(Globals.mc.player.posX + Globals.mc.player.motionX / d2, Globals.mc.player.posY, Globals.mc.player.posZ + Globals.mc.player.motionZ / d2);
                    }
                    this.Field3491 = 0;
                }
            }
        }
    }

    public void Method4239(EventPlayerJump eventPlayerJump) {
    }

    public void Method4240(EventPlayerMove eventPlayerMove) {
    }

    private boolean Method4238() {
        return !Globals.mc.player.isInWater() && !Globals.mc.player.isOnLadder() && !Globals.mc.player.isSneaking() && Class56.Method103();
    }
}
