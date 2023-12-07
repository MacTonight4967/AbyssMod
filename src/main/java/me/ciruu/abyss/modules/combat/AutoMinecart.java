package me.ciruu.abyss.modules.combat;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.function.Predicate;
import me.ciruu.abyss.Class155;
import me.ciruu.abyss.Class22;
import me.ciruu.abyss.Class30;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.player.EventPlayerUpdate;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFlintAndSteel;
import net.minecraft.item.ItemMinecart;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class AutoMinecart
extends Module {
    private final Setting placerange = new Setting("Place Range", "", (Module)this, (Object)Float.valueOf(5.0f), Float.valueOf(0.0f), Float.valueOf(6.0f));
    private final Setting targetrange = new Setting("Target Range", "", (Module)this, (Object)Float.valueOf(12.0f), Float.valueOf(0.1f), Float.valueOf(20.0f));
    private final Setting packetplace = new Setting("PacketPlace", "", this, true);
    private final Setting maxminecarts = new Setting("MaxMinecarts", "Max minecarts to place", (Module)this, (Object)64, 1, 256);
    private final Setting minecartspertick = new Setting("MinecartsPerTick", "", (Module)this, (Object)2, 1, 20);
    private final Setting placedelay = new Setting("PlaceDelay", "", (Module)this, (Object)0, 0, 100);
    private final Setting webplace = new Setting("WebPlace", "", this, false);
    private final Setting bbreak = new Setting("Break", "", this, true);
    private final Setting flintandsteel = new Setting("Use Flint&Steel", "", this, true);
    private final Setting flinttimer = new Setting("UseFlintTimer", "", (Module)this, (Object)100, 1, 1000);
    private final Setting fastplace = new Setting("FastPlace", "", this, true);
    private final Setting debug = new Setting("Debug", "", this, false);
    private EntityPlayer Field613 = null;
    private BlockPos Field614 = null;
    private IBlockState Field615 = null;
    private int Field616 = 0;
    private boolean Field617 = false;
    private boolean Field618 = false;
    private boolean Field619 = false;
    private boolean Field620 = false;
    private boolean Field621 = false;
    private boolean Field622 = false;
    private Class22 Field623 = new Class22();
    private Class22 Field624 = new Class22();
    @EventHandler
    private Listener Field625 = new Listener<EventPlayerUpdate>(this::Method731, new Predicate[0]);
    @EventHandler
    private Listener Field626 = new Listener<EventPlayerUpdate>(this::Method732, new Predicate[0]);

    public AutoMinecart() {
        super("AutoMinecart", "Place and light TNT minecarts to nearby players.", Class11.COMBAT);
        this.Method733(this.placerange);
        this.Method733(this.targetrange);
        this.Method733(this.packetplace);
        this.Method733(this.maxminecarts);
        this.Method733(this.minecartspertick);
        this.Method733(this.placedelay);
        this.Method733(this.webplace);
        this.Method733(this.bbreak);
        this.Method733(this.fastplace);
        this.Method733(this.flintandsteel);
        this.Method733(this.flinttimer);
        this.Method733(this.debug);
    }

    private void Method734() {
        this.Method735();
        if (this.Field613 == null) {
            return;
        }
        if (!this.Method736()) {
            if (((Boolean)this.debug.getValue()).booleanValue()) {
                this.Method737("Can't place minecarts on target position, toggling!");
            }
            this.Method738();
            return;
        }
        this.Method739();
        if (!this.Method740(this.Field615.getBlock()) && !this.Field618) {
            return;
        }
        if (((Boolean)this.webplace.getValue()).booleanValue()) {
            this.Method741();
        }
        this.Method742();
        if (((Boolean)this.flintandsteel.getValue()).booleanValue() && this.Field618) {
            this.Method743();
        }
    }

    private void Method735() {
        if (this.Field613 == null || this.Field613.isDead || this.Field613.getDistance((Entity)Globals.mc.player) > ((Float)this.targetrange.getValue()).floatValue()) {
            this.Field613 = this.Method744();
            if (this.Field613 == null) {
                this.Method737("Can't find a new target, toggling!");
                this.Method738();
                return;
            }
            if (((Boolean)this.debug.getValue()).booleanValue()) {
                this.Method737("Found new target:" + this.Field613.getName());
            }
        }
    }

    private boolean Method736() {
        this.Field614 = Class30.Method209(this.Field613);
        this.Field615 = Globals.mc.world.getBlockState(this.Field614);
        return this.Method740(this.Field615.getBlock()) || this.Field615.getBlock() == Blocks.AIR;
    }

    private void Method739() {
        if (this.Method740(this.Field615.getBlock()) || this.Field617 || this.Field618) {
            return;
        }
        if (this.Field615.getBlock() == Blocks.AIR) {
            if (Class155.Method544(BlockRailBase.class) == -1) {
                if (((Boolean)this.debug.getValue()).booleanValue()) {
                    this.Method737("Can't find rails in hotbar!");
                }
                this.Method738();
            } else {
                Globals.mc.player.inventory.currentItem = Class155.Method544(BlockRailBase.class);
                Globals.mc.playerController.processRightClickBlock(Globals.mc.player, Globals.mc.world, this.Field614.down(), EnumFacing.UP, new Vec3d((Vec3i)this.Field614), EnumHand.MAIN_HAND);
                Globals.mc.player.swingArm(EnumHand.MAIN_HAND);
            }
        }
    }

    private boolean Method740(Block block) {
        return block == Blocks.ACTIVATOR_RAIL || block == Blocks.RAIL || block == Blocks.DETECTOR_RAIL || block == Blocks.GOLDEN_RAIL;
    }

    private void Method741() {
        if (Globals.mc.world.getBlockState(this.Field614.up()).getBlock() == Blocks.WEB) {
            return;
        }
        if (Globals.mc.world.getBlockState(this.Field614.up()).getBlock() != Blocks.AIR) {
            if (((Boolean)this.debug.getValue()).booleanValue() && !this.Field621) {
                this.Method737("Can't place a web!");
                this.Field621 = true;
            }
            return;
        }
        if (Class155.Method545(Blocks.WEB) == -1) {
            if (((Boolean)this.debug.getValue()).booleanValue() && !this.Field622) {
                this.Method737("Can't find webs in hotbar!");
                this.Field622 = true;
            }
        } else {
            Globals.mc.player.inventory.currentItem = Class155.Method545(Blocks.WEB);
            Globals.mc.playerController.processRightClickBlock(Globals.mc.player, Globals.mc.world, this.Field614, EnumFacing.UP, new Vec3d((Vec3i)this.Field614), EnumHand.MAIN_HAND);
            Globals.mc.player.swingArm(EnumHand.MAIN_HAND);
        }
    }

    private void Method742() {
        if (this.Field618) {
            return;
        }
        if (!this.Field624.Method50(((Integer)this.placedelay.getValue()).longValue())) {
            return;
        }
        if (this.Field616 >= (Integer)this.maxminecarts.getValue()) {
            this.Field617 = true;
            return;
        }
        if (Class155.Method544(ItemMinecart.class) == -1 && !this.Field620) {
            if (((Boolean)this.debug.getValue()).booleanValue()) {
                this.Method737("Can't find minecarts in hotbar!");
            }
            this.Method738();
            return;
        }
        if (Class155.Method745(Item.getItemById((int)407)) == -1) {
            this.Field616 = (Integer)this.maxminecarts.getValue();
            return;
        }
        Globals.mc.player.inventory.currentItem = Class155.Method745(Item.getItemById((int)407));
        if (Globals.mc.player.inventory.currentItem == Class155.Method745(Item.getItemById((int)407))) {
            for (int i = 0; i < (Integer)this.minecartspertick.getValue(); ++i) {
                if (((Boolean)this.packetplace.getValue()).booleanValue()) {
                    Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(this.Field614, EnumFacing.UP, EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
                } else {
                    Globals.mc.playerController.processRightClickBlock(Globals.mc.player, Globals.mc.world, this.Field614, EnumFacing.UP, new Vec3d((Vec3i)this.Field614), EnumHand.MAIN_HAND);
                }
                Globals.mc.player.swingArm(EnumHand.MAIN_HAND);
                this.Field620 = true;
                ++this.Field616;
            }
        }
        this.Field624.Method47();
    }

    private void Method743() {
        if (Class155.Method544(ItemFlintAndSteel.class) == -1) {
            if (((Boolean)this.debug.getValue()).booleanValue()) {
                this.Method737("Can't find Flint & Steel in hotbar!");
            }
            this.Method738();
        } else {
            if (!this.Field623.Method50(((Integer)this.flinttimer.getValue()).longValue())) {
                return;
            }
            Globals.mc.player.inventory.currentItem = Class155.Method745(Item.getItemById((int)259));
            Globals.mc.playerController.updateController();
            Globals.mc.playerController.processRightClickBlock(Globals.mc.player, Globals.mc.world, this.Field614.down(), EnumFacing.UP, new Vec3d((Vec3i)this.Field614.down()), EnumHand.MAIN_HAND);
            Globals.mc.player.swingArm(EnumHand.MAIN_HAND);
            this.Field623.Method47();
        }
        this.Method738();
    }

    private void Method746() {
        boolean bl;
        boolean bl2 = bl = Globals.mc.player.getHeldItemMainhand().getItem() == Items.DIAMOND_PICKAXE;
        if (!bl) {
            for (int i = 0; i < 9; ++i) {
                ItemStack itemStack = Globals.mc.player.inventory.getStackInSlot(i);
                if (itemStack.isEmpty() || itemStack.getItem() != Items.DIAMOND_PICKAXE) continue;
                bl = true;
                Globals.mc.player.inventory.currentItem = i;
                Globals.mc.playerController.updateController();
                break;
            }
        }
        if (!bl) {
            Globals.printChatMessage(ChatFormatting.RED + "No pickaxe!");
        }
    }

    private boolean Method747() {
        if (this.Field614 == null) {
            return false;
        }
        IBlockState iBlockState = Globals.mc.world.getBlockState(this.Field614);
        if (AutoMinecart.Method748(iBlockState) || Globals.mc.player.getDistanceSq(this.Field614) > Math.pow(((Float)this.placerange.getValue()).floatValue(), ((Float)this.placerange.getValue()).floatValue())) {
            this.Field614 = null;
            return false;
        }
        Globals.mc.player.swingArm(EnumHand.MAIN_HAND);
        EnumFacing enumFacing = EnumFacing.UP;
        if (!this.Field619) {
            this.Field619 = true;
            Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, this.Field614, enumFacing));
        } else {
            Globals.mc.playerController.onPlayerDamageBlock(this.Field614, enumFacing);
        }
        return true;
    }

    private static boolean Method748(IBlockState iBlockState) {
        return iBlockState.getBlock() == Blocks.BEDROCK || iBlockState.getBlock() == Blocks.AIR || iBlockState.getBlock() instanceof BlockLiquid;
    }

    private EntityPlayer Method744() {
        EntityPlayer entityPlayer = null;
        for (EntityPlayer entityPlayer2 : Globals.mc.world.playerEntities) {
            if (Manager.Field223.Method233(entityPlayer2.getName()) || Class30.Method749((Entity)entityPlayer2, ((Float)this.placerange.getValue()).floatValue() + ((Float)this.targetrange.getValue()).floatValue())) continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                continue;
            }
            if (!(Globals.mc.player.getDistanceSq((Entity)entityPlayer2) < Globals.mc.player.getDistanceSq((Entity)entityPlayer))) continue;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    private void Method737(String string) {
        if (Globals.mc.ingameGUI != null || Globals.mc.player != null) {
            Globals.mc.ingameGUI.getChatGUI().printChatMessage((ITextComponent)new TextComponentString(ChatFormatting.GOLD + this.Method750() + ":" + ChatFormatting.WHITE + string));
        }
    }

    public void Method751() {
        super.Method13();
        this.Field618 = false;
        this.Field620 = false;
        this.Field621 = false;
        this.Field622 = false;
    }

    public void Method752() {
        super.Method15();
        this.Field618 = false;
        this.Field616 = 0;
        this.Field620 = false;
        this.Field621 = false;
        this.Field622 = false;
    }

    private void Method732(EventPlayerUpdate eventPlayerUpdate) {
        if (!((Boolean)this.bbreak.getValue()).booleanValue()) {
            return;
        }
        if (eventPlayerUpdate.Method753() != Class53.PRE) {
            return;
        }
        if (this.Field617 && !this.Field618) {
            this.Method746();
            if (!this.Method747()) {
                if (((Boolean)this.debug.getValue()).booleanValue()) {
                    this.Method737("Finished");
                }
                this.Field617 = false;
                this.Field618 = true;
                this.Field623.Method47();
                if (!((Boolean)this.flintandsteel.getValue()).booleanValue()) {
                    this.Method738();
                }
            }
        }
    }

    private void Method731(EventPlayerUpdate eventPlayerUpdate) {
        if (((Boolean)this.fastplace.getValue()).booleanValue()) {
            Globals.mc.rightClickDelayTimer = 0;
        }
        this.Method734();
    }
}
