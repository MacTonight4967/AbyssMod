package me.ciruu.abyss.modules.combat;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import me.ciruu.abyss.Class155;
import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Class26;
import me.ciruu.abyss.Class29;
import me.ciruu.abyss.Class30;
import me.ciruu.abyss.Class31;
import me.ciruu.abyss.Class50;
import me.ciruu.abyss.Class66;
import me.ciruu.abyss.Class84;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class194;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.modules.combat.AutoTrap;
import me.ciruu.abyss.modules.render.Freecam;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPiston;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class AntiHoleCamp
extends Module {
    private final Setting mainwindow = new Setting("Main", "", this, new Class25("Main Settings"));
    private final Setting checkhole = new Setting("CheckHole", "", this, true);
    private final Setting redstone = new Setting("RedStone", "", this, (Object)Class194.Torch);
    private final Setting placeobsidian = new Setting("PlaceObby", "", (Module)this, (Object)true, this.mainwindow, this::Method513);
    private final Setting range = new Setting("Range", "", (Module)this, (Object)Float.valueOf(6.0f), Float.valueOf(0.0f), Float.valueOf(6.0f));
    private final Setting raytrace = new Setting("RayTrace", "", this, false);
    private final Setting rotate = new Setting("Rotate", "", this, false);
    private EntityPlayer currentTarget;
    private BlockPos Field444;
    private int Field445 = -1;
    private int Field446 = -1;
    private int Field447 = -1;
    private int Field448 = -1;
    private BlockPos Field449;
    private float[] Field450 = new float[2];
    private boolean Field451 = false;
    private BlockPos Field452 = null;
    @EventHandler
    private Listener Field453 = new Listener<Class26>(this::Method514, new Predicate[0]);
    @EventHandler
    private Listener Field454 = new Listener<Class66>(this::Method515, new Predicate[0]);

    public AntiHoleCamp() {
        super("AntiHoleCamp", "Pulls players out of their holes.", Class11.COMBAT);
        this.Method516(this.checkhole);
        this.Method516(this.redstone);
        this.Method516(this.placeobsidian);
        this.Method516(this.range);
        this.Method516(this.raytrace);
        this.Method516(this.rotate);
    }

    public void Method517() {
        super.Method13();
        this.currentTarget = Class30.Method518();
        if (this.currentTarget == null) {
            Globals.printChatMessage("Can't find any target!");
            this.Method519();
            return;
        }
        this.Field444 = Class30.Method209(this.currentTarget);
        if (!this.Method520()) {
            this.Method519();
            return;
        }
    }

    public void Method521() {
        super.Method15();
        if (this.Field445 != -1) {
            Class155.Method522(this.Field445, false);
        }
        if (this.Field451) {
            this.Field451 = false;
            Manager.Field456.Method523(this.Field450[0], this.Field450[1]);
        }
    }

    public void Method524(boolean bl) {
        if (this.Method525()) {
            this.Method526(false);
            this.Method521();
        }
    }

    private void Method527() {
        this.Method528();
    }

    private void Method528() {
        this.Field449 = this.Method529();
        if (this.Field449 == null) {
            Globals.printChatMessage("Can't place piston!");
            this.Method519();
            return;
        }
        switch ((Class194)((Object)this.redstone.getValue())) {
            case Block: {
                this.Method530();
                break;
            }
            case Torch: {
                this.Method531();
            }
        }
    }

    private void Method530() {
        List list = AntiHoleCamp.Method532(this.Field449);
        if (list.isEmpty()) {
            return;
        }
        for (EnumFacing enumFacing : list) {
            BlockPos blockPos = this.Field449.offset(enumFacing);
            if (!(Globals.mc.player.getDistanceSq(blockPos) < Class29.Method114(((Float)this.range.getValue()).floatValue())) || Class31.Method533(blockPos, (Boolean)this.raytrace.getValue()) != 3) continue;
            this.Field452 = blockPos;
            this.Method534(this.Field449, blockPos, false, enumFacing);
            break;
        }
    }

    private void Method531() {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        BlockPos blockPos = this.Field449.north();
        BlockPos blockPos2 = this.Field449.west();
        BlockPos blockPos3 = this.Field449.south();
        BlockPos blockPos4 = this.Field449.east();
        arrayList.add(blockPos);
        arrayList.add(blockPos2);
        arrayList.add(blockPos3);
        arrayList.add(blockPos4);
        boolean bl = false;
        for (BlockPos blockPos5 : arrayList) {
            if (!this.Method535(blockPos5) || Globals.mc.world.getBlockState(blockPos5.down()).getMaterial().isReplaceable()) continue;
            this.Method534(this.Field449, blockPos5, true, EnumFacing.UP);
            bl = true;
            break;
        }
        if (!bl && ((Boolean)this.placeobsidian.getValue()).booleanValue()) {
            for (BlockPos blockPos5 : arrayList) {
                if (!this.Method535(blockPos5.down()) || !this.Method535(blockPos5)) continue;
                Class155.Method522(this.Field448, false);
                Class31.Method536(blockPos5.down(), EnumHand.MAIN_HAND, (Boolean)this.rotate.getValue(), true, Globals.mc.player.isSneaking());
                this.Method534(this.Field449, blockPos5, true, EnumFacing.UP);
                break;
            }
        }
    }

    private boolean Method535(BlockPos blockPos) {
        return !this.Method537(blockPos) && Globals.mc.world.getBlockState(blockPos).getMaterial().isReplaceable();
    }

    private boolean Method537(BlockPos blockPos) {
        for (Entity entity : Globals.mc.world.loadedEntityList) {
            if (entity.equals((Object)Globals.mc.player) || entity instanceof EntityItem || entity instanceof EntityXPOrb || !new AxisAlignedBB(blockPos).intersects(entity.getEntityBoundingBox())) continue;
            return true;
        }
        return false;
    }

    private void Method534(BlockPos blockPos, BlockPos blockPos2, boolean bl, EnumFacing enumFacing) {
        Class155.Method522(this.Field446, false);
        this.Field450[0] = Globals.mc.player.rotationYaw;
        this.Field450[1] = Globals.mc.player.rotationPitch;
        this.Field451 = true;
        double d = Class84.Method538((float)blockPos.getX() + 0.5f, (float)blockPos.getY() + 0.5f, (float)blockPos.getZ() + 0.5f, this.currentTarget)[0];
        Manager.Field456.Method523(Class84.Method540(Class84.Method539((float)d)), 0.0f);
        Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation((float)Class84.Method540(Class84.Method539((float)d)), 0.0f, true));
        Class31.Method536(blockPos, EnumHand.MAIN_HAND, (Boolean)this.rotate.getValue(), true, Globals.mc.player.isSneaking());
        Class155.Method522(this.Field447, false);
        Class31.Method541(blockPos2, (Boolean)this.rotate.getValue(), (Boolean)this.rotate.getValue(), false);
        Globals.printChatMessage(ChatFormatting.GREEN + "Done!");
        this.Method519();
    }

    private BlockPos Method529() {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        BlockPos blockPos = this.Field444.north().up();
        BlockPos blockPos2 = this.Field444.west().up();
        BlockPos blockPos3 = this.Field444.south().up();
        BlockPos blockPos4 = this.Field444.east().up();
        arrayList.add(blockPos);
        arrayList.add(blockPos2);
        arrayList.add(blockPos3);
        arrayList.add(blockPos4);
        BlockPos blockPos5 = null;
        ArrayList<BlockPos> arrayList2 = new ArrayList<BlockPos>();
        for (BlockPos blockPos6 : arrayList) {
            if (Class31.Method533(blockPos6, (Boolean)this.raytrace.getValue()) != 3 || Globals.mc.player.getDistanceSq(blockPos6) > Class29.Method114(((Float)this.range.getValue()).floatValue())) continue;
            arrayList2.add(blockPos6);
        }
        double d = 5.0;
        if (!arrayList2.isEmpty()) {
            for (BlockPos blockPos7 : arrayList2) {
                Vec3d vec3d = new Vec3d((Vec3i)blockPos7);
                if (!(this.currentTarget.getPositionVector().distanceTo(vec3d.add(0.5, 0.0, 0.5)) < d)) continue;
                blockPos5 = blockPos7;
            }
        }
        return blockPos5;
    }

    public static List Method532(BlockPos blockPos) {
        ArrayList<EnumFacing> arrayList = new ArrayList<EnumFacing>();
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos2);
            if (!iBlockState.getMaterial().isReplaceable()) continue;
            arrayList.add(enumFacing);
        }
        return arrayList;
    }

    private boolean Method542() {
        if (Globals.mc.player == null || Globals.mc.world == null || Manager.moduleManager.isModuleEnabled(AutoTrap.class) || Manager.moduleManager.isModuleEnabled(Freecam.class)) {
            return false;
        }
        if (this.currentTarget != null && !Class30.Method543((Entity)this.currentTarget) && ((Boolean)this.checkhole.getValue()).booleanValue()) {
            Globals.printChatMessage("Target it's not in a hole!");
            return false;
        }
        return true;
    }

    private boolean Method520() {
        this.Field446 = Class155.Method544(ItemPiston.class);
        if (this.Field446 == -1) {
            Globals.printChatMessage("Could not find pistons in hotbar!");
            return false;
        }
        switch ((Class194)((Object)this.redstone.getValue())) {
            case Torch: {
                this.Field447 = Class155.Method545(Blocks.REDSTONE_TORCH);
                break;
            }
            case Block: {
                this.Field447 = Class155.Method545(Blocks.REDSTONE_BLOCK);
            }
        }
        if (this.Field447 == -1) {
            Globals.printChatMessage("Could not find redstone in hotbar!");
            return false;
        }
        if (((Boolean)this.placeobsidian.getValue()).booleanValue() && this.redstone.getValue() == Class194.Torch) {
            this.Field448 = Class155.Method544(BlockObsidian.class);
            if (this.Field448 == -1) {
                Globals.printChatMessage("Could not find obsidian in hotbar!");
                return false;
            }
        }
        this.Field445 = Globals.mc.player.inventory.currentItem;
        return true;
    }

    private void Method515(Class66 class66) {
        if (this.Field452 != null) {
            Class50.Method137(this.Field452, Color.RED, false, Color.RED, 1.0f, true, true, 125, true);
        }
    }

    private void Method514(Class26 class26) {
        if (!this.Method542()) {
            this.Method519();
            return;
        }
        this.Method527();
    }

    private boolean Method513() {
        return this.redstone.getValue() == Class194.Torch;
    }
}
