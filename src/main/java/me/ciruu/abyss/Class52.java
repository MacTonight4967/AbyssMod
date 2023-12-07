package me.ciruu.abyss;

import me.ciruu.abyss.Globals;
import me.ciruu.abyss.events.player.EntityPlayerAttackEntityFrom;
import me.ciruu.abyss.events.player.EventPlayerJump;
import me.ciruu.abyss.events.player.EventPlayerMove;
import me.ciruu.abyss.events.player.EventPlayerUpdate;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import net.minecraft.init.MobEffects;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;

public class Class52 {
    public void Method116(EventPlayerUpdate eventPlayerUpdate) {
    }

    public void Method117(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
    }

    public void Method118(EventPlayerJump eventPlayerJump) {
    }

    public void Method119(EventPlayerMove eventPlayerMove) {
    }

    public void Method120() {
    }

    public void Method121(EntityPlayerAttackEntityFrom entityPlayerAttackEntityFrom) {
    }

    public void Method122(SPacketEntityVelocity sPacketEntityVelocity) {
    }

    public void Method123(SPacketExplosion sPacketExplosion) {
    }

    public void Method124() {
    }

    public void Method125() {
    }

    public static double Method104() {
        double d = 0.2873;
        try {
            int n;
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
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return d;
    }
}
