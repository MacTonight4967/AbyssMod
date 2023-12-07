package me.ciruu.abyss;

import java.util.List;
import java.util.function.Predicate;
import me.ciruu.abyss.Class30;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class433;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.player.EventPlayerMove;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.MovementInput;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class Class431
extends Module {
    private final Setting Field1421 = new Setting("Boost", "", (Module)this, (Object)Float.valueOf(4.48f), Float.valueOf(1.0f), Float.valueOf(20.0f));
    private final Setting Field1422 = new Setting("AutoDisable", "", this, false);
    private final Setting Field1423 = new Setting("Mode", "Mode", this, (Object)Class433.Yes);
    private int Field1424;
    private int Field1425;
    private int Field1426;
    private int Field1427;
    private int Field1428;
    private double Field1429;
    private double Field1430;
    private boolean Field1431;
    private int Field1432;
    private boolean Field1433 = false;
    @EventHandler
    private Listener Field1434 = new Listener<EventPlayerMove>(Class431::Method1823, new Predicate[0]);
    @EventHandler
    private Listener Field1435 = new Listener<EventPlayerUpdateWalking>(this::Method1824, new Predicate[0]);

    public Class431() {
        super("LongJumpOld", "", Class11.MOVEMENT);
        this.Method1825(this.Field1421);
        this.Method1825(this.Field1422);
        this.Method1825(this.Field1423);
    }

    public void Method1826() {
        super.Method13();
        this.Field1427 = 4;
        this.Field1428 = 0;
        this.Field1424 = 0;
        this.Field1432 = -10;
        Manager.Field298.Method337(1.0f);
        this.Field1433 = false;
    }

    public void Method1827(double d, double d2, double d3) {
        Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(d, d2, d3, Globals.mc.player.onGround));
    }

    public Block Method1828(BlockPos blockPos) {
        return Globals.mc.world.getBlockState(blockPos).getBlock();
    }

    private double Method1829(EntityPlayer entityPlayer, double d) {
        List list = Globals.mc.world.getCollisionBoxes((Entity)entityPlayer, entityPlayer.getEntityBoundingBox().expand(0.0, -d, 0.0));
        if (list.isEmpty()) {
            return 0.0;
        }
        double d2 = 0.0;
        for (AxisAlignedBB axisAlignedBB : list) {
            if (!(axisAlignedBB.maxY > d2)) continue;
            d2 = axisAlignedBB.maxY;
        }
        return entityPlayer.posY - d2;
    }

    private void Method1830(EventPlayerMove eventPlayerMove, double d) {
        MovementInput movementInput = Globals.mc.player.movementInput;
        double d2 = movementInput.moveForward;
        double d3 = movementInput.moveStrafe;
        float f = Globals.mc.player.rotationYaw;
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

    private double Method1831() {
        double d = 0.2873;
        if (Globals.mc.player != null && Globals.mc.player.isPotionActive(MobEffects.SPEED)) {
            int n = Globals.mc.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
            d *= 1.0 + 0.2 * (double)(n + 1);
        }
        return d;
    }

    private void Method1824(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        switch ((Class433)((Object)this.Field1423.getValue())) {
            case Yes: {
                if (!Class30.Method1832()) {
                    Manager.Field298.Method337(1.0f);
                    return;
                }
                if (((Boolean)this.Field1422.getValue()).booleanValue() && this.Field1433 && Globals.mc.player.onGround) {
                    this.Method1833();
                    return;
                }
                if (Class30.Method1834() || Class30.Method1835() || eventPlayerUpdateWalking.Method100() != Class53.PRE) break;
                if (Globals.mc.player.onGround) {
                    this.Field1425 = 0;
                }
                float f = Globals.mc.player.rotationYaw + (float)(Globals.mc.player.moveForward < 0.0f ? 180 : 0) + (Globals.mc.player.moveStrafing > 0.0f ? -90.0f * (Globals.mc.player.moveForward < 0.0f ? -0.5f : (Globals.mc.player.moveForward > 0.0f ? 0.5f : 1.0f)) : 0.0f) - (Globals.mc.player.moveStrafing < 0.0f ? -90.0f * (Globals.mc.player.moveForward < 0.0f ? -0.5f : (Globals.mc.player.moveForward > 0.0f ? 0.5f : 1.0f)) : 0.0f);
                float f2 = (float)Math.cos((double)(f + 90.0f) * Math.PI / 180.0);
                float f3 = (float)Math.sin((double)(f + 90.0f) * Math.PI / 180.0);
                if (!Globals.mc.player.collidedVertically) {
                    ++this.Field1426;
                    this.Field1431 = true;
                    if (Globals.mc.player.movementInput.sneak) {
                        Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(0.0, 2.147483647E9, 0.0, false));
                    }
                    this.Field1428 = 0;
                    if (!Globals.mc.player.collidedVertically) {
                        if (Globals.mc.player.motionY == -0.07190068807140403) {
                            Globals.mc.player.motionY *= (double)0.35f;
                        } else if (Globals.mc.player.motionY == -0.10306193759436909) {
                            Globals.mc.player.motionY *= (double)0.55f;
                        } else if (Globals.mc.player.motionY == -0.13395038817442878) {
                            Globals.mc.player.motionY *= (double)0.67f;
                        } else if (Globals.mc.player.motionY == -0.16635183030382) {
                            Globals.mc.player.motionY *= (double)0.69f;
                        } else if (Globals.mc.player.motionY == -0.19088711097794803) {
                            Globals.mc.player.motionY *= (double)0.71f;
                        } else if (Globals.mc.player.motionY == -0.21121925191528862) {
                            Globals.mc.player.motionY *= (double)0.2f;
                        } else if (Globals.mc.player.motionY == -0.11979897632390576) {
                            Globals.mc.player.motionY *= (double)0.93f;
                        } else if (Globals.mc.player.motionY == -0.18758479151225355) {
                            Globals.mc.player.motionY *= (double)0.72f;
                        } else if (Globals.mc.player.motionY == -0.21075983825251726) {
                            Globals.mc.player.motionY *= (double)0.76f;
                        }
                        if (Globals.mc.player.motionY < -0.2 && Globals.mc.player.motionY > -0.24) {
                            Globals.mc.player.motionY *= 0.7;
                        }
                        if (Globals.mc.player.motionY < -0.25 && Globals.mc.player.motionY > -0.32) {
                            Globals.mc.player.motionY *= 0.8;
                        }
                        if (Globals.mc.player.motionY < -0.35 && Globals.mc.player.motionY > -0.8) {
                            Globals.mc.player.motionY *= 0.98;
                        }
                        if (Globals.mc.player.motionY < -0.8 && Globals.mc.player.motionY > -1.6) {
                            Globals.mc.player.motionY *= 0.99;
                        }
                    }
                    Manager.Field298.Method337(0.8f);
                    double[] dArray = new double[]{0.420606, 0.417924, 0.415258, 0.412609, 0.409977, 0.407361, 0.404761, 0.402178, 0.399611, 0.39706, 0.394525, 0.392, 0.3894, 0.38644, 0.383655, 0.381105, 0.37867, 0.37625, 0.37384, 0.37145, 0.369, 0.3666, 0.3642, 0.3618, 0.35945, 0.357, 0.354, 0.351, 0.348, 0.345, 0.342, 0.339, 0.336, 0.333, 0.33, 0.327, 0.324, 0.321, 0.318, 0.315, 0.312, 0.309, 0.307, 0.305, 0.303, 0.3, 0.297, 0.295, 0.293, 0.291, 0.289, 0.287, 0.285, 0.283, 0.281, 0.279, 0.277, 0.275, 0.273, 0.271, 0.269, 0.267, 0.265, 0.263, 0.261, 0.259, 0.257, 0.255, 0.253, 0.251, 0.249, 0.247, 0.245, 0.243, 0.241, 0.239, 0.237};
                    if (Globals.mc.player.movementInput.moveForward != 0.0f) {
                        try {
                            Globals.mc.player.motionX = (double)f2 * dArray[this.Field1426 - 1] * (double)((Float)this.Field1421.getValue()).floatValue();
                            Globals.mc.player.motionZ = (double)f3 * dArray[this.Field1426 - 1] * (double)((Float)this.Field1421.getValue()).floatValue();
                        }
                        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {}
                        break;
                    }
                    Globals.mc.player.motionX = 0.0;
                    Globals.mc.player.motionZ = 0.0;
                    break;
                }
                Manager.Field298.Method337(1.0f);
                this.Field1426 = 0;
                ++this.Field1428;
                --this.Field1427;
                Globals.mc.player.motionX /= 13.0;
                Globals.mc.player.motionZ /= 13.0;
                if (this.Field1428 == 1) {
                    this.Method1827(Globals.mc.player.posX, Globals.mc.player.posY, Globals.mc.player.posZ);
                    this.Method1827(Globals.mc.player.posX + 0.0624, Globals.mc.player.posY, Globals.mc.player.posZ);
                    this.Method1827(Globals.mc.player.posX, Globals.mc.player.posY + 0.419, Globals.mc.player.posZ);
                    this.Method1827(Globals.mc.player.posX + 0.0624, Globals.mc.player.posY, Globals.mc.player.posZ);
                    this.Method1827(Globals.mc.player.posX, Globals.mc.player.posY + 0.419, Globals.mc.player.posZ);
                    break;
                }
                if (this.Field1428 <= 2) break;
                this.Field1428 = 0;
                Globals.mc.player.motionX = (double)f2 * 0.3;
                Globals.mc.player.motionZ = (double)f3 * 0.3;
                Globals.mc.player.motionY = 0.424f;
                this.Field1433 = true;
                break;
            }
        }
    }

    private static void Method1823(EventPlayerMove eventPlayerMove) {
    }
}
