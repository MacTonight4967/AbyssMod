package me.ciruu.abyss.modules.combat;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import me.ciruu.abyss.Class30;
import me.ciruu.abyss.Class354;
import me.ciruu.abyss.Class602;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraft.util.math.BlockPos;

public class AntiRegear
extends Module {
    private final Setting range = new Setting("Range", "", (Module)this, (Object)Float.valueOf(6.0f), Float.valueOf(0.0f), Float.valueOf(6.0f));
    private final Setting raytrace = new Setting("Raytrace", "", this, false);
    public final List Field2518 = new ArrayList();
    private EntityPlayer currentTarget = null;
    private BlockPos Field2520 = null;
    private BlockPos Field2521 = null;
    @EventHandler
    private Listener Field2522 = new Listener<EventPlayerUpdateWalking>(this::Method3018, new Predicate[0]);

    public AntiRegear() {
        super("AntiRegear", "Prevent other players to place shulkers and regear near you", Class11.COMBAT);
        this.Method3019(this.range);
        this.Method3019(this.raytrace);
    }

    public void Method3020() {
        super.Method13();
        this.currentTarget = this.findTarget();
        if (this.currentTarget == null) {
            Globals.printChatMessage("Can't find target!");
            this.Method3022();
            return;
        }
        this.Field2520 = Class30.Method209(this.currentTarget);
        this.Field2518.clear();
        this.Field2521 = Class30.Method209((EntityPlayer)Globals.mc.player);
        Globals.mc.world.loadedTileEntityList.forEach(this::Method3023);
        if (!this.Field2518.isEmpty()) {
            Class602.Method3024((BlockPos)this.Field2518.get(0));
        }
    }

    private EntityPlayer findTarget() {
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

    private void Method3018(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        boolean bl;
        if (this.Field2518.isEmpty()) {
            Globals.printChatMessage(ChatFormatting.RED + "Can't find a shulker!");
            this.Method3022();
            return;
        }
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
            this.Method3022();
            return;
        }
        this.Field2521 = Class30.Method209((EntityPlayer)Globals.mc.player);
        if (Class602.Method3025().getDistance(this.Field2521.getX(), this.Field2521.getY(), this.Field2521.getZ()) > (double)((Float)this.range.getValue()).floatValue()) {
            Globals.printChatMessage(ChatFormatting.RED + "Shulker out range!");
            this.Field2518.clear();
            this.Method3022();
        }
        Class602.Method3026(((Float)this.range.getValue()).floatValue(), (Boolean)this.raytrace.getValue());
        if (Class602.Method3027()) {
            Globals.printChatMessage(ChatFormatting.GREEN + "Done!");
            this.Method3022();
        }
    }

    private void Method3023(TileEntity tileEntity) {
        if (tileEntity instanceof TileEntityShulkerBox && this.Field2521.getDistance(tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ()) < (double)((Float)this.range.getValue()).floatValue()) {
            this.Field2518.add(new BlockPos(tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ()));
        }
    }
}
