package me.ciruu.abyss;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import me.ciruu.abyss.Class22;
import me.ciruu.abyss.Class30;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class303;
import me.ciruu.abyss.enums.Class393;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.network.EventNetworkPrePacketEvent;
import me.ciruu.abyss.events.player.EventPlayerMove;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.modules.movement.Step;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.MovementInput;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Class304
extends Module {
    private final Setting Field3472 = new Setting("Boost", "", (Module)this, (Object)Float.valueOf(4.48f), Float.valueOf(1.0f), Float.valueOf(20.0f));
    private final Setting Field3473 = new Setting("Mode", "", this, (Object)Class303.DIRECT);
    private final Setting Field3474 = new Setting("LagOff", "", this, false);
    private final Setting Field3475 = new Setting("AutoDisable", "", this, false);
    private final Setting Field3476 = new Setting("UseStep", "", this, false);
    private int Field3477;
    private int Field3478;
    private int Field3479;
    private int Field3480;
    private int Field3481;
    private double Field3482;
    private double Field3483;
    private boolean Field3484;
    private final Class22 Field3485 = new Class22();
    private boolean Field3486 = false;
    @EventHandler
    private Listener Field3487 = new Listener<EventNetworkPrePacketEvent>(this::Method4217, new Predicate[0]);
    @EventHandler
    private Listener Field3488 = new Listener<EventPlayerMove>(this::Method4218, new Predicate[0]);
    @EventHandler
    private Listener Field3489 = new Listener<EventPlayerUpdateWalking>(this::Method4219, new Predicate[0]);

    public Class304() {
        super("LongJump", "", Class11.MOVEMENT);
        this.Method4220(this.Field3472);
        this.Method4220(this.Field3473);
        this.Method4220(this.Field3474);
        this.Method4220(this.Field3475);
        this.Method4220(this.Field3476);
    }

    public void Method4221() {
        super.Method13();
        MinecraftForge.EVENT_BUS.register((Object)this);
        this.Field3485.Method47();
        this.Field3480 = 4;
        this.Field3481 = 0;
        this.Field3477 = 0;
        this.Field3486 = false;
        if (((Boolean)this.Field3476.getValue()).booleanValue() && !Manager.moduleManager.isModuleEnabled(Step.class) && ((Step)Manager.moduleManager.getModuleByClass(Step.class)).mode.getValue() == Class393.Vanilla) {
            ((Step)Manager.moduleManager.getModuleByClass(Step.class)).Method580();
        }
    }

    public void Method4222() {
        super.Method15();
        MinecraftForge.EVENT_BUS.unregister((Object)this);
        Manager.Field298.Method337(1.0f);
        if (((Boolean)this.Field3476.getValue()).booleanValue() && Manager.moduleManager.isModuleEnabled(Step.class) && ((Step)Manager.moduleManager.getModuleByClass(Step.class)).mode.getValue() == Class393.Vanilla) {
            ((Step)Manager.moduleManager.getModuleByClass(Step.class)).Method580();
        }
    }

    @SubscribeEvent
    public void Method4223(TickEvent.ClientTickEvent clientTickEvent) {
        if (clientTickEvent.phase != TickEvent.Phase.START) {
            return;
        }
        switch ((Class303)((Object)this.Field3473.getValue())) {
            case TICK: {
                this.Method4224(null);
            }
        }
    }

    private void Method4224(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        if (((Boolean)this.Field3475.getValue()).booleanValue() && this.Field3486 && Globals.mc.player.onGround) {
            this.Method4225();
            return;
        }
        switch ((Class303)((Object)this.Field3473.getValue())) {
            case VIRTUE: {
                if (Globals.mc.player.moveForward != 0.0f || Globals.mc.player.moveStrafing != 0.0f) {
                    double d = Globals.mc.player.posX - Globals.mc.player.prevPosX;
                    double d2 = Globals.mc.player.posZ - Globals.mc.player.prevPosZ;
                    this.Field3483 = Math.sqrt(d * d + d2 * d2);
                    break;
                }
                eventPlayerUpdateWalking.cancel();
                break;
            }
            case TICK: {
                if (eventPlayerUpdateWalking != null) {
                    return;
                }
            }
            case DIRECT: {
                if (Class30.Method1834() || Class30.Method1835() || Globals.mc.player.movementInput.moveForward == 0.0f) break;
                if (Globals.mc.player.onGround) {
                    this.Field3478 = 0;
                }
                float f = Globals.mc.player.rotationYaw + (float)(Globals.mc.player.moveForward < 0.0f ? 180 : 0) + (Globals.mc.player.moveStrafing > 0.0f ? -90.0f * (Globals.mc.player.moveForward < 0.0f ? -0.5f : (Globals.mc.player.moveForward > 0.0f ? 0.5f : 1.0f)) : 0.0f) - (Globals.mc.player.moveStrafing < 0.0f ? -90.0f * (Globals.mc.player.moveForward < 0.0f ? -0.5f : (Globals.mc.player.moveForward > 0.0f ? 0.5f : 1.0f)) : 0.0f);
                float f2 = (float)Math.cos((double)(f + 90.0f) * Math.PI / 180.0);
                float f3 = (float)Math.sin((double)(f + 90.0f) * Math.PI / 180.0);
                if (!Globals.mc.player.collidedVertically) {
                    ++this.Field3479;
                    this.Field3484 = true;
                    if (Globals.mc.gameSettings.keyBindSneak.isKeyDown()) {
                        Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(0.0, 2.147483647E9, 0.0, false));
                    }
                    this.Field3481 = 0;
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
                    Manager.Field298.Method337(0.85f);
                    double[] dArray = new double[]{0.420606, 0.417924, 0.415258, 0.412609, 0.409977, 0.407361, 0.404761, 0.402178, 0.399611, 0.39706, 0.394525, 0.392, 0.3894, 0.38644, 0.383655, 0.381105, 0.37867, 0.37625, 0.37384, 0.37145, 0.369, 0.3666, 0.3642, 0.3618, 0.35945, 0.357, 0.354, 0.351, 0.348, 0.345, 0.342, 0.339, 0.336, 0.333, 0.33, 0.327, 0.324, 0.321, 0.318, 0.315, 0.312, 0.309, 0.307, 0.305, 0.303, 0.3, 0.297, 0.295, 0.293, 0.291, 0.289, 0.287, 0.285, 0.283, 0.281, 0.279, 0.277, 0.275, 0.273, 0.271, 0.269, 0.267, 0.265, 0.263, 0.261, 0.259, 0.257, 0.255, 0.253, 0.251, 0.249, 0.247, 0.245, 0.243, 0.241, 0.239, 0.237};
                    if (Globals.mc.gameSettings.keyBindForward.pressed) {
                        try {
                            Globals.mc.player.motionX = (double)f2 * dArray[this.Field3479 - 1] * 3.0;
                            Globals.mc.player.motionZ = (double)f3 * dArray[this.Field3479 - 1] * 3.0;
                            break;
                        }
                        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                            return;
                        }
                    }
                    Globals.mc.player.motionX = 0.0;
                    Globals.mc.player.motionZ = 0.0;
                    break;
                }
                Manager.Field298.Method337(1.0f);
                this.Field3479 = 0;
                ++this.Field3481;
                --this.Field3480;
                Globals.mc.player.motionX /= 13.0;
                Globals.mc.player.motionZ /= 13.0;
                if (this.Field3481 == 1) {
                    this.Method4226(Globals.mc.player.posX, Globals.mc.player.posY, Globals.mc.player.posZ);
                    this.Method4226(Globals.mc.player.posX + 0.0624, Globals.mc.player.posY, Globals.mc.player.posZ);
                    this.Method4226(Globals.mc.player.posX, Globals.mc.player.posY + 0.419, Globals.mc.player.posZ);
                    this.Method4226(Globals.mc.player.posX + 0.0624, Globals.mc.player.posY, Globals.mc.player.posZ);
                    this.Method4226(Globals.mc.player.posX, Globals.mc.player.posY + 0.419, Globals.mc.player.posZ);
                    break;
                }
                if (this.Field3481 <= 2) break;
                this.Field3481 = 0;
                Globals.mc.player.motionX = (double)f2 * 0.3;
                Globals.mc.player.motionZ = (double)f3 * 0.3;
                Globals.mc.player.motionY = 0.424f;
                this.Field3486 = true;
            }
        }
    }

    private void Method4227(EventPlayerMove eventPlayerMove) {
        if (this.Field3473.getValue() == Class303.VIRTUE && (Globals.mc.player.moveForward != 0.0f || Globals.mc.player.moveStrafing != 0.0f && !Class30.Method1835() && !Class30.Method1834())) {
            if (this.Field3477 == 0) {
                this.Field3482 = (double)((Float)this.Field3472.getValue()).floatValue() * this.Method4228();
            } else if (this.Field3477 == 1) {
                Globals.mc.player.motionY = 0.42;
                eventPlayerMove.cancel();
                eventPlayerMove.Method105(0.42);
                this.Field3482 *= 2.149;
            } else if (this.Field3477 == 2) {
                double d = 0.66 * (this.Field3483 - this.Method4228());
                this.Field3482 = this.Field3483 - d;
            } else {
                this.Field3482 = this.Field3483 - this.Field3483 / 159.0;
            }
            this.Field3482 = Math.max(this.Method4228(), this.Field3482);
            this.Method4229(eventPlayerMove, this.Field3482);
            List list = Globals.mc.world.getCollisionBoxes((Entity)Globals.mc.player, Globals.mc.player.getEntityBoundingBox().offset(0.0, Globals.mc.player.motionY, 0.0));
            List list2 = Globals.mc.world.getCollisionBoxes((Entity)Globals.mc.player, Globals.mc.player.getEntityBoundingBox().offset(0.0, -0.4, 0.0));
            if (!(Globals.mc.player.collidedVertically || list.size() <= 0 && list2.size() <= 0)) {
                Globals.mc.player.motionY = -0.001;
                eventPlayerMove.cancel();
                eventPlayerMove.Method105(-0.001);
            }
            ++this.Field3477;
        } else if (this.Field3477 > 0 && ((Boolean)this.Field3475.getValue()).booleanValue()) {
            this.Method4225();
        }
    }

    private void Method4230() {
        this.Method4226(0.0, 2.147483647E9, 0.0);
    }

    private void Method4226(double d, double d2, double d3) {
        Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(d, d2, d3, Globals.mc.player.onGround));
    }

    private Block Method4231(BlockPos blockPos) {
        return Globals.mc.world.getBlockState(blockPos).getBlock();
    }

    private double Method4232(EntityPlayer entityPlayer, double d) {
        List list = entityPlayer.world.getCollisionBoxes((Entity)entityPlayer, entityPlayer.getEntityBoundingBox().offset(0.0, -d, 0.0));
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

    private void Method4229(EventPlayerMove eventPlayerMove, double d) {
        MovementInput movementInput = Globals.mc.player.movementInput;
        double d2 = movementInput.moveForward;
        double d3 = movementInput.moveStrafe;
        float f = Globals.mc.player.rotationYaw;
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
            eventPlayerMove.Method107(d2 * d * Math.cos(Math.toRadians(f + 90.0f)) + d3 * d * Math.sin(Math.toRadians(f + 90.0f)));
            eventPlayerMove.Method108(d2 * d * Math.sin(Math.toRadians(f + 90.0f)) - d3 * d * Math.cos(Math.toRadians(f + 90.0f)));
        }
    }

    private double Method4228() {
        double d = 0.2873;
        if (Globals.mc.player != null && Globals.mc.player.isPotionActive(MobEffects.SPEED)) {
            int n = Objects.requireNonNull(Globals.mc.player.getActivePotionEffect(MobEffects.SPEED)).getAmplifier();
            d *= 1.0 + 0.2 * (double)(n + 1);
        }
        return d;
    }

    private void Method4219(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        if (eventPlayerUpdateWalking.Method100() != Class53.PRE) {
            return;
        }
        this.Method4224(eventPlayerUpdateWalking);
    }

    private void Method4218(EventPlayerMove eventPlayerMove) {
        if (eventPlayerMove.Method2162() != Class53.PRE) {
            return;
        }
        this.Method4227(eventPlayerMove);
    }

    private void Method4217(EventNetworkPrePacketEvent eventNetworkPrePacketEvent) {
        if (((Boolean)this.Field3474.getValue()).booleanValue() && eventNetworkPrePacketEvent.Method49() instanceof SPacketPlayerPosLook && this.Method4233()) {
            this.Method4225();
        }
    }
}
