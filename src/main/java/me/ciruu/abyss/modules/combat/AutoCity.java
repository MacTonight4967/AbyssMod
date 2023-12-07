package me.ciruu.abyss.modules.combat;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.ArrayList;
import java.util.function.Predicate;
import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Class29;
import me.ciruu.abyss.Class30;
import me.ciruu.abyss.Class307;
import me.ciruu.abyss.Class354;
import me.ciruu.abyss.Class602;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.modules.misc.SpeedMine;
import me.ciruu.abyss.modules.render.CityESP;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

/*
 * Illegal identifiers - recommend switching to table mode
 */
public class AutoCity
extends Module {
    private final Setting mainwindow = new Setting("Main", "", this, new Class25("Main Settings"));
    private final Setting rotate = new Setting("Rotate", "", this, false);
    private final Setting range = new Setting("Range", "", (Module)this, (Object)Float.valueOf(6.0f), Float.valueOf(0.0f), Float.valueOf(6.0f));
    private final Setting raytrace = new Setting("Raytrace", "", this, false);
    private final Setting burrow = new Setting("Burrow", "", this, false);
    private final Setting autospeedmine = new Setting("AutoSpeedMine", "", (Module)this, (Object)false, this.mainwindow, AutoCity::Method3881);
    private final Setting 1_13mode = new Setting("1.13Mode", "", this, false);
    private boolean Field3215 = false;
    @EventHandler
    private Listener Field3216 = new Listener<EventPlayerUpdateWalking>(this::Method3882, new Predicate[0]);

    public AutoCity() {
        super("AutoCity", "City near players.", Class11.COMBAT);
        this.Method3883(this.rotate);
        this.Method3883(this.range);
        this.Method3883(this.raytrace);
        this.Method3883(this.burrow);
        this.Method3883(this.autospeedmine);
        this.Method3883(this.1_13mode);
    }

    public void Method3884() {
        BlockPos blockPos;
        super.Method13();
        this.Field3215 = false;
        ArrayList arrayList = ((CityESP)Manager.moduleManager.getModuleByClass(CityESP.class)).Method1102();
        if (arrayList.isEmpty() && !((Boolean)this.burrow.getValue()).booleanValue() && !((Boolean)this.1_13mode.getValue()).booleanValue()) {
            Globals.printChatMessage(ChatFormatting.RED + "There is no one to city!");
            this.Method3885();
            return;
        }
        EntityPlayer entityPlayer = null;
        BlockPos blockPos2 = null;
        double d = 100.0;
        if (!arrayList.isEmpty()) {
            blockPos = arrayList.iterator();
            while (blockPos.hasNext()) {
                Class307 class307 = (Class307)blockPos.next();
                for (BlockPos blockPos3 : (ArrayList)class307.Method1109()) {
                    if (blockPos2 == null) {
                        entityPlayer = (EntityPlayer)class307.Method2970();
                        blockPos2 = blockPos3;
                        continue;
                    }
                    double d2 = blockPos3.getDistance(blockPos2.getX(), blockPos2.getY(), blockPos2.getZ());
                    if (!(d2 < d)) continue;
                    d = d2;
                    blockPos2 = blockPos3;
                    entityPlayer = (EntityPlayer)class307.Method2970();
                }
            }
        }
        if (((Boolean)this.1_13mode.getValue()).booleanValue()) {
            for (EntityPlayer entityPlayer2 : Globals.mc.world.playerEntities) {
                BlockPos blockPos3;
                if (Globals.mc.player.getDistance((Entity)entityPlayer2) > ((Float)this.range.getValue()).floatValue() || entityPlayer2 == Globals.mc.player || Manager.Field223.Method711((Entity)entityPlayer2) || (blockPos3 = this.Method3886((EntityPlayer)(blockPos = entityPlayer2))) == null) continue;
                blockPos2 = blockPos3;
                break;
            }
        }
        blockPos = this.Method3887();
        if (((Boolean)this.burrow.getValue()).booleanValue() && blockPos != null) {
            blockPos2 = blockPos;
        }
        if (blockPos2 == null) {
            Globals.printChatMessage(ChatFormatting.RED + "Couldn't find any blocks to mine!");
            this.Method3885();
            return;
        }
        Class602.Method3024(blockPos2);
        if (entityPlayer != null) {
            Globals.printChatMessage(ChatFormatting.WHITE + "Attempting to mine a block by your target:" + ChatFormatting.RED + entityPlayer.getName());
        }
    }

    private BlockPos Method3887() {
        for (EntityPlayer entityPlayer : Globals.mc.world.playerEntities) {
            if (Globals.mc.player.getDistance((Entity)entityPlayer) > ((Float)this.range.getValue()).floatValue() || entityPlayer == Globals.mc.player || Manager.Field223.Method711((Entity)entityPlayer) || Globals.mc.world.getBlockState(Class30.Method209(entityPlayer)).getBlock() != Blocks.OBSIDIAN && Globals.mc.world.getBlockState(Class30.Method209(entityPlayer)).getBlock() != Blocks.ENDER_CHEST) continue;
            return Class30.Method209(entityPlayer);
        }
        return null;
    }

    public BlockPos Method3886(EntityPlayer entityPlayer) {
        BlockPos[] blockPosArray;
        Vec3d vec3d = Class29.Method1042((Entity)entityPlayer, Globals.mc.getRenderPartialTicks());
        BlockPos blockPos = new BlockPos(vec3d.x, vec3d.y, vec3d.z);
        BlockPos blockPos2 = blockPos.north();
        BlockPos blockPos3 = blockPos.south();
        BlockPos blockPos4 = blockPos.east();
        BlockPos blockPos5 = blockPos.west();
        for (BlockPos blockPos6 : blockPosArray = new BlockPos[]{blockPos2, blockPos3, blockPos4, blockPos5}) {
            Block block = Globals.mc.world.getBlockState(blockPos6).getBlock();
            if (block != Blocks.OBSIDIAN && block != Blocks.ENDER_CHEST || Globals.mc.player.getDistance((double)blockPos6.getX(), (double)blockPos6.getY(), (double)blockPos6.getZ()) > (double)((Float)this.range.getValue()).floatValue()) continue;
            return blockPos6;
        }
        return null;
    }

    private void Method3882(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        Object object;
        boolean bl;
        if (eventPlayerUpdateWalking.Method100() != Class53.PRE) {
            return;
        }
        if (((Boolean)this.autospeedmine.getValue()).booleanValue() && Manager.moduleManager.isModuleEnabled(SpeedMine.class) && !this.Field3215) {
            Class602.Method3026(((Float)this.range.getValue()).floatValue(), (Boolean)this.raytrace.getValue());
            Class602.Method3026(((Float)this.range.getValue()).floatValue(), (Boolean)this.raytrace.getValue());
            this.Method3885();
            return;
        }
        boolean bl2 = bl = Globals.mc.player.getHeldItemMainhand().getItem() == Items.DIAMOND_PICKAXE;
        if (!bl) {
            for (int i = 0; i < 9; ++i) {
                object = Globals.mc.player.inventory.getStackInSlot(i);
                if (object.isEmpty() || object.getItem() != Items.DIAMOND_PICKAXE) continue;
                bl = true;
                Globals.mc.player.inventory.currentItem = i;
                Globals.mc.playerController.updateController();
                break;
            }
        }
        if (!bl) {
            Globals.printChatMessage(ChatFormatting.RED + "No pickaxe!");
            this.Method3885();
            return;
        }
        BlockPos blockPos = Class602.Method3025();
        if (blockPos == null) {
            Globals.printChatMessage(ChatFormatting.GREEN + "Done!");
            this.Method3885();
            return;
        }
        if (((Boolean)this.rotate.getValue()).booleanValue()) {
            eventPlayerUpdateWalking.cancel();
            object = Class354.Method1505((double)blockPos.getX() + 0.5, (double)blockPos.getY() - 0.5, (double)blockPos.getZ() + 0.5, (EntityPlayer)Globals.mc.player);
            eventPlayerUpdateWalking.setPitch((double)object[1]);
            eventPlayerUpdateWalking.setYaw((double)object[0]);
        }
        Class602.Method3026(((Float)this.range.getValue()).floatValue(), (Boolean)this.raytrace.getValue());
    }

    private static boolean Method3881() {
        return Manager.moduleManager.getModuleByClass(SpeedMine.class) == null || Manager.moduleManager.isModuleEnabled(SpeedMine.class);
    }
}
