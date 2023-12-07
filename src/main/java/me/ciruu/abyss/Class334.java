package me.ciruu.abyss;

import me.ciruu.abyss.Class52;
import me.ciruu.abyss.Class56;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.events.player.EventPlayerJump;
import me.ciruu.abyss.events.player.EventPlayerMove;
import me.ciruu.abyss.events.player.EventPlayerUpdate;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;

public class Class334
extends Class52 {
    private boolean Field973 = false;

    public void Method1334(EventPlayerUpdate eventPlayerUpdate) {
    }

    public void Method1335() {
        super.Method125();
        Manager.Field298.Method337(1.0f);
    }

    public void Method1336(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        if (!Class56.Method103()) {
            return;
        }
        if ((double)Globals.mc.player.fallDistance > 3.994) {
            return;
        }
        if (Globals.mc.player.isInWater() || Globals.mc.player.isOnLadder() || Globals.mc.player.collidedHorizontally) {
            return;
        }
        if (Globals.mc.player.onGround) {
            Globals.mc.player.motionX *= (double)1.59f;
            Globals.mc.player.motionZ *= (double)1.59f;
            Manager.Field298.Method337(1.199f);
            eventPlayerUpdateWalking.cancel();
            eventPlayerUpdateWalking.setPitch(Globals.mc.player.rotationPitch);
            eventPlayerUpdateWalking.setYaw(Globals.mc.player.rotationYaw);
            if (this.Field973) {
                eventPlayerUpdateWalking.setY(eventPlayerUpdateWalking.getY() + 0.4);
            }
            this.Field973 = !this.Field973;
            eventPlayerUpdateWalking.setOnGround(true);
        }
    }

    public void Method1337(EventPlayerJump eventPlayerJump) {
    }

    public void Method1338(EventPlayerMove eventPlayerMove) {
    }
}
