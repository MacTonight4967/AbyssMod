package me.ciruu.abyss.modules.combat;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;
import me.ciruu.abyss.Class155;
import me.ciruu.abyss.Class207;
import me.ciruu.abyss.Class219;
import me.ciruu.abyss.Class22;
import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Class30;
import me.ciruu.abyss.Class308;
import me.ciruu.abyss.Class31;
import me.ciruu.abyss.Class350;
import me.ciruu.abyss.Class353;
import me.ciruu.abyss.Class354;
import me.ciruu.abyss.Class602;
import me.ciruu.abyss.Class84;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class238;
import me.ciruu.abyss.enums.Class580;
import me.ciruu.abyss.events.player.EventPlayerUpdate;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.block.BlockObsidian;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemEndCrystal;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class AutoTrap
extends Module {
    private final Setting mainwindow = new Setting("Main", "", this, new Class25("Main Settings"));
    private final Setting mode = new Setting("Mode", "", this, (Object)Class580.Normal);
    private final Setting rotate = new Setting("Rotate", "Rotate", this, false);
    private final Setting smartdisable = new Setting("SmartDisable", "", this, true);
    private final Setting range = new Setting("Range", "", (Module)this, (Object)Float.valueOf(6.0f), Float.valueOf(0.0f), Float.valueOf(6.0f));
    private final Setting delay = new Setting("Delay", "Delay in ticks", (Module)this, (Object)0, 0, 10);
    private final Setting blockspertick = new Setting("BlocksPerTick", "Blocks per tick", (Module)this, (Object)4, 1, 8);
    private final Setting silentswitch = new Setting("SilentSwitch", "", this, false);
    private final Setting disableswitchback = new Setting("DisableSwitchBack", "", this, false);
    private final Setting disable = new Setting("Disable", "", this, (Object)Class238.None);
    private final Setting timer = new Setting("Timer", "Delay (MS)", this, Float.valueOf(1000.0f), Float.valueOf(0.0f), Float.valueOf(10000.0f), this.mainwindow, this::Method3319);
    private final Setting crystaltrapwindow = new Setting("", "", this, new Class25("CrystalTrap Settings"));
    private final Setting crystalbind = new Setting("CrystalBind", "", (Module)this, (Object)new Class207(0), this.crystaltrapwindow, AutoTrap::Method3320);
    private final Setting breakdelay = new Setting("BreakDelay", "Delay in ticks", this, 1, 0, 10, this.crystaltrapwindow, AutoTrap::Method3321);
    private int Field2708;
    private EntityPlayer Field2709;
    private BlockPos Field2710;
    private int Field2711 = 0;
    private int Field2712 = 0;
    private boolean Field2713 = false;
    private boolean Field2714 = false;
    private EntityEnderCrystal Field2715;
    private BlockPos Field2716;
    private double[] Field2717 = new double[2];
    public Vec3d Field2718 = new Vec3d(0.0, 0.0, 0.0);
    private int Field2719 = 0;
    private boolean Field2720 = false;
    private final Class22 Field2721 = new Class22();
    private final Vec3d[] Field2722 = new Vec3d[]{new Vec3d(0.0, 0.0, -1.0), new Vec3d(1.0, 0.0, 0.0), new Vec3d(0.0, 0.0, 1.0), new Vec3d(-1.0, 0.0, 0.0), new Vec3d(0.0, 1.0, -1.0), new Vec3d(1.0, 1.0, 0.0), new Vec3d(0.0, 1.0, 1.0), new Vec3d(-1.0, 1.0, 0.0), new Vec3d(0.0, 2.0, -1.0), new Vec3d(1.0, 2.0, 0.0), new Vec3d(0.0, 2.0, 1.0), new Vec3d(-1.0, 2.0, 0.0), new Vec3d(0.0, 3.0, -1.0), new Vec3d(0.0, 3.0, 0.0)};
    private final Vec3d[] Field2723 = new Vec3d[]{new Vec3d(0.0, 0.0, -1.0), new Vec3d(1.0, 0.0, 0.0), new Vec3d(0.0, 0.0, 1.0), new Vec3d(-1.0, 0.0, 0.0), new Vec3d(0.0, 1.0, -1.0), new Vec3d(1.0, 1.0, 0.0), new Vec3d(0.0, 1.0, 1.0), new Vec3d(-1.0, 1.0, 0.0), new Vec3d(0.0, 2.0, -1.0), new Vec3d(0.0, 3.0, -1.0), new Vec3d(0.0, 3.0, 1.0), new Vec3d(1.0, 3.0, 0.0), new Vec3d(-1.0, 3.0, 0.0), new Vec3d(0.0, 3.0, 0.0)};
    private final Vec3d[] Field2724 = new Vec3d[]{new Vec3d(0.0, 0.0, -1.0), new Vec3d(1.0, 0.0, 0.0), new Vec3d(0.0, 0.0, 1.0), new Vec3d(-1.0, 0.0, 0.0), new Vec3d(0.0, 1.0, -1.0), new Vec3d(1.0, 1.0, 0.0), new Vec3d(0.0, 1.0, 1.0), new Vec3d(-1.0, 1.0, 0.0), new Vec3d(0.0, 2.0, -1.0), new Vec3d(0.0, 3.0, -1.0), new Vec3d(0.0, 3.0, 0.0)};
    private final Vec3d[] Field2725 = new Vec3d[]{new Vec3d(0.0, 0.0, -1.0), new Vec3d(1.0, 0.0, 0.0), new Vec3d(0.0, 0.0, 1.0), new Vec3d(-1.0, 0.0, 0.0), new Vec3d(0.0, 1.0, -1.0), new Vec3d(0.0, 2.0, -1.0), new Vec3d(1.0, 2.0, 0.0), new Vec3d(0.0, 2.0, 1.0), new Vec3d(-1.0, 2.0, 0.0), new Vec3d(0.0, 3.0, -1.0), new Vec3d(0.0, 3.0, 0.0)};
    private final Vec3d[] Field2726 = new Vec3d[]{new Vec3d(0.0, 0.0, -1.0), new Vec3d(1.0, 0.0, 0.0), new Vec3d(0.0, 0.0, 1.0), new Vec3d(-1.0, 0.0, 0.0), new Vec3d(0.0, 1.0, -1.0), new Vec3d(1.0, 1.0, 0.0), new Vec3d(0.0, 1.0, 1.0), new Vec3d(-1.0, 1.0, 0.0), new Vec3d(0.0, 2.0, -1.0), new Vec3d(1.0, 2.0, 0.0), new Vec3d(0.0, 2.0, 1.0), new Vec3d(-1.0, 2.0, 0.0), new Vec3d(0.0, 3.0, -1.0), new Vec3d(0.0, 3.0, 0.0), new Vec3d(0.0, 4.0, 0.0)};
    @EventHandler
    private Listener Field2727 = new Listener<EventPlayerUpdate>(this::Method3322, new Predicate[0]);
    @EventHandler
    private Listener Field2728 = new Listener<Class350>(this::Method3323, new Predicate[0]);

    public AutoTrap() {
        super("AutoTrap", "Trap nearby players in obsidian.", Class11.COMBAT);
        this.Method3324(this.mode);
        this.Method3324(this.rotate);
        this.Method3324(this.smartdisable);
        this.Method3324(this.range);
        this.Method3324(this.delay);
        this.Method3324(this.blockspertick);
        this.Method3324(this.silentswitch);
        this.Method3324(this.disableswitchback);
        this.Method3324(this.disable);
        this.Method3324(this.timer);
        this.Method3324(this.crystaltrapwindow);
        this.Method3324(this.crystalbind);
        this.Method3324(this.breakdelay);
    }

    public void Method3325() {
        super.Method13();
        if (!this.Method3326()) {
            this.Method2373();
            return;
        }
        this.Field2708 = Globals.mc.player.inventory.currentItem;
        this.Field2709 = this.Method3327();
        if (this.Field2709 == null) {
            Globals.printChatMessage("Can't find target!");
            this.Method2373();
            return;
        }
        this.Field2710 = Class30.Method209(this.Field2709);
        this.Field2721.Method47();
    }

    public void Method3328() {
        super.Method15();
        this.Field2713 = false;
        if (((Boolean)this.disableswitchback.getValue()).booleanValue() && !((Boolean)this.silentswitch.getValue()).booleanValue()) {
            Class155.Method522(this.Field2708, false);
        }
    }

    public String Method3329() {
        return this.Field2713 ? ChatFormatting.YELLOW + "Crystal" : ChatFormatting.WHITE + ((Class580)((Object)this.mode.getValue())).name();
    }

    public void Method3330(boolean bl) {
        if (this.Method3331()) {
            this.Method3332(false);
            this.Method3328();
        }
    }

    private void Method3333() {
        if (this.Field2709.isDead || this.Field2709 == null || this.Field2709.getDistance((Entity)Globals.mc.player) >= 8.0f) {
            this.Method2373();
            return;
        }
        if (((Boolean)this.smartdisable.getValue()).booleanValue() && (Math.abs(Class30.Method209(this.Field2709).getZ() - this.Field2710.getZ()) >= 1 || Math.abs(Class30.Method209(this.Field2709).getX() - this.Field2710.getX()) >= 1)) {
            this.Method2373();
            return;
        }
        ArrayList arrayList = new ArrayList();
        switch ((Class580)((Object)this.mode.getValue())) {
            case Normal: {
                Collections.addAll(arrayList, this.Field2722);
                break;
            }
            case DoubleTop: {
                Collections.addAll(arrayList, this.Field2726);
                break;
            }
            case Feet: {
                Collections.addAll(arrayList, this.Field2725);
                break;
            }
            case Face: {
                Collections.addAll(arrayList, this.Field2723);
                break;
            }
            default: {
                Collections.addAll(arrayList, this.Field2724);
            }
        }
        if (this.Field2711 >= (Integer)this.delay.getValue()) {
            this.Field2711 = 0;
            int n = 0;
            int n2 = Class155.Method544(BlockObsidian.class);
            if (((Boolean)this.silentswitch.getValue()).booleanValue() && n2 != -1) {
                this.Field2708 = Globals.mc.player.inventory.currentItem;
                Globals.mc.player.inventory.currentItem = n2;
                Globals.mc.playerController.updateController();
            }
            while (n < (Integer)this.blockspertick.getValue()) {
                if (this.Field2712 >= arrayList.size()) {
                    this.Field2712 = 0;
                    break;
                }
                BlockPos blockPos = new BlockPos((Vec3d)arrayList.get(this.Field2712));
                BlockPos blockPos2 = new BlockPos(this.Field2709.getPositionVector()).down().add(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                boolean bl = true;
                if (!Globals.mc.world.getBlockState(blockPos2).getMaterial().isReplaceable()) {
                    bl = false;
                }
                for (Entity entity : Globals.mc.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos2))) {
                    if (entity instanceof EntityItem || entity instanceof EntityXPOrb) continue;
                    bl = false;
                    break;
                }
                if (blockPos.equals((Object)new BlockPos(0, 3, 0)) && this.mode.getValue() != Class580.DoubleTop && this.Field2713) {
                    this.Field2716 = blockPos2;
                    for (Entity entity : Globals.mc.world.loadedEntityList) {
                        if (entity instanceof EntityEnderCrystal && entity.getPosition().equals((Object)blockPos2.add(new Vec3i(0.5, 1.0, 0.5)))) {
                            bl = false;
                            this.Field2714 = true;
                            this.Field2715 = (EntityEnderCrystal)entity;
                            break;
                        }
                        this.Field2714 = false;
                        this.Field2715 = null;
                    }
                }
                if (bl) {
                    if (!((Boolean)this.silentswitch.getValue()).booleanValue()) {
                        Class155.Method522(Class155.Method544(BlockObsidian.class), false);
                    }
                    if (Class31.Method1261(blockPos2, (Boolean)this.rotate.getValue(), ((Float)this.range.getValue()).floatValue())) {
                        ++n;
                    }
                }
                ++this.Field2712;
                if (bl || this.Field2712 < arrayList.size() || this.disable.getValue() != Class238.Blocks) continue;
                this.Method2373();
            }
            if (((Boolean)this.silentswitch.getValue()).booleanValue() && this.Field2708 != -1 && n2 != -1) {
                Globals.mc.player.inventory.currentItem = this.Field2708;
                Globals.mc.playerController.updateController();
            }
        }
        ++this.Field2711;
        if (this.Field2713 && this.mode.getValue() != Class580.DoubleTop) {
            if (this.Field2716 == null || !(Globals.mc.world.getBlockState(this.Field2716).getBlock() instanceof BlockObsidian)) {
                Class602.Method3024(null);
                this.Field2720 = false;
            } else if (!this.Field2720) {
                Class602.Method3024(this.Field2716);
                Class602.Method3026(((Float)this.range.getValue()).floatValue(), false);
                this.Field2720 = true;
            }
            if (!this.Field2714 && this.Field2716 != null) {
                if (Globals.mc.player.getHeldItemMainhand().getItem() != Items.END_CRYSTAL && Globals.mc.player.getHeldItemOffhand().getItem() != Items.END_CRYSTAL) {
                    if (Class155.Method544(ItemEndCrystal.class) == -1) {
                        Globals.printChatMessage(ChatFormatting.RED + "Can't find crystals in your hotbar!");
                        this.Field2713 = false;
                        return;
                    }
                    Class155.Method1491(ItemEndCrystal.class, false);
                }
                if (Class308.Method1106(this.Field2716, true, false)) {
                    this.Method3334(this.Field2716);
                    Class31.Method52(this.Field2716, Globals.mc.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, (Boolean)this.rotate.getValue(), this.Field2718);
                }
            }
            if (this.Field2715 != null && this.Field2716 != null) {
                if (Globals.mc.world.getBlockState(this.Field2716).getMaterial().isReplaceable() && this.Field2719 > (Integer)this.breakdelay.getValue()) {
                    this.Field2719 = 0;
                    this.Method3335((Entity)this.Field2715);
                    this.Method3336(this.Field2715);
                }
                if (!Globals.mc.world.getBlockState(this.Field2716).getMaterial().isReplaceable()) {
                    if (this.Method3337()) {
                        Class602.Method3026(((Float)this.range.getValue()).floatValue(), false);
                    } else {
                        Globals.printChatMessage(ChatFormatting.RED + "Can't find pickaxe in your hotbar!");
                        this.Field2713 = false;
                        return;
                    }
                }
            }
            ++this.Field2719;
        }
    }

    private boolean Method3337() {
        boolean bl;
        boolean bl2 = bl = Globals.mc.player.getHeldItemMainhand().getItem() == Items.DIAMOND_PICKAXE;
        if (!bl) {
            for (int i = 0; i < 9; ++i) {
                ItemStack itemStack = Globals.mc.player.inventory.getStackInSlot(i);
                if (itemStack.isEmpty() || itemStack.getItem() != Items.DIAMOND_PICKAXE) continue;
                Class155.Method522(i, false);
                return true;
            }
        } else {
            return true;
        }
        return false;
    }

    private void Method3334(BlockPos blockPos) {
        if (((Boolean)this.rotate.getValue()).booleanValue()) {
            Class353 class353 = Class84.Method1492(blockPos);
            if (class353 != null) {
                this.Field2718 = class353.Method1493();
            }
            this.Field2717 = Class354.Method1505((double)blockPos.getX() + 0.5, (double)blockPos.getY() - 0.5, (double)blockPos.getZ() + 0.5, (EntityPlayer)Globals.mc.player);
            Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation((float)this.Field2717[0], (float)this.Field2717[1], Globals.mc.player.onGround));
        }
    }

    private void Method3335(Entity entity) {
        if (((Boolean)this.rotate.getValue()).booleanValue()) {
            double[] dArray = Class354.Method1505(entity.posX + 0.5, entity.posY - 0.5, entity.posZ + 0.5, (EntityPlayer)Globals.mc.player);
            Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation((float)dArray[0], (float)dArray[1], Globals.mc.player.onGround));
        }
    }

    private void Method3336(EntityEnderCrystal entityEnderCrystal) {
        Globals.mc.player.connection.sendPacket((Packet)new CPacketUseEntity((Entity)entityEnderCrystal));
        Globals.mc.player.swingArm(Globals.mc.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
    }

    private EntityPlayer Method3327() {
        if (Globals.mc.world.playerEntities.isEmpty()) {
            return null;
        }
        EntityPlayer entityPlayer = null;
        for (EntityPlayer entityPlayer2 : Globals.mc.world.playerEntities) {
            if (entityPlayer2 == Globals.mc.player || Manager.Field223.Method711((Entity)entityPlayer2) || !Class354.Method1908((Entity)entityPlayer2) || entityPlayer2.getHealth() <= 0.0f || entityPlayer != null && Minecraft.getMinecraft().player.getDistance((Entity)entityPlayer2) > Minecraft.getMinecraft().player.getDistance((Entity)entityPlayer)) continue;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    private boolean Method3326() {
        if (Class155.Method544(BlockObsidian.class) == -1) {
            Globals.printChatMessage("Can't find obsidian in hotbar!");
            return false;
        }
        return true;
    }

    private void Method3323(Class350 class350) {
        if (!(Globals.mc.currentScreen instanceof Class219) && class350.Method1535() == ((Class207)this.crystalbind.getValue()).Method592() && this.mode.getValue() != Class580.DoubleTop) {
            this.Field2713 = !this.Field2713;
        }
    }

    private void Method3322(EventPlayerUpdate eventPlayerUpdate) {
        if (this.disable.getValue() == Class238.Timer && this.Field2721.Method50(((Float)this.timer.getValue()).longValue())) {
            this.Method2373();
            return;
        }
        this.Method3333();
    }

    private static boolean Method3321() {
        return true;
    }

    private static boolean Method3320() {
        return true;
    }

    private boolean Method3319() {
        return this.disable.getValue() == Class238.Timer;
    }
}
