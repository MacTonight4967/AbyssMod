package me.ciruu.abyss;

import java.util.function.Predicate;
import me.ciruu.abyss.Class22;
import me.ciruu.abyss.Class26;
import me.ciruu.abyss.Class31;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.modules.misc.XCarry;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;

public class Class674
extends Module {
    private final Setting Field3463 = new Setting("Delay", "", (Module)this, (Object)0, 0, 100);
    private final Setting Field3464 = new Setting("Sync", "", this, false);
    private final Setting Field3465 = new Setting("SyncAfterPlace", "", this, true);
    private boolean Field3466 = false;
    private boolean Field3467 = false;
    private int Field3468 = -1;
    private int Field3469 = -1;
    private final Class22 Field3470 = new Class22();
    @EventHandler
    private Listener Field3471 = new Listener<Class26>(this::Method4207, new Predicate[0]);

    public Class674() {
        super("7kIlegalPlacer", "", Class11.EXPLOIT);
        this.Method4208(this.Field3463);
        this.Method4208(this.Field3464);
        this.Method4208(this.Field3465);
    }

    public void Method4209() {
        super.Method15();
        this.Field3466 = false;
        this.Field3467 = false;
    }

    public void Method4210(boolean bl) {
        if (this.Method4211()) {
            this.Method4212(false);
            this.Method4209();
        }
    }

    private void Method4213(int n, int n2, boolean bl) {
        Globals.mc.playerController.windowClick(Globals.mc.player.inventoryContainer.windowId, n, 0, ClickType.PICKUP, (EntityPlayer)Globals.mc.player);
        Globals.mc.playerController.windowClick(Globals.mc.player.inventoryContainer.windowId, n2, 0, ClickType.PICKUP, (EntityPlayer)Globals.mc.player);
        Globals.mc.playerController.windowClick(Globals.mc.player.inventoryContainer.windowId, n, 0, ClickType.PICKUP, (EntityPlayer)Globals.mc.player);
        if (bl) {
            Globals.mc.playerController.updateController();
        }
    }

    private int Method4214(Item item) {
        for (int i = 1; i < 5; ++i) {
            Slot slot = (Slot)Globals.mc.player.inventoryContainer.inventorySlots.get(i);
            ItemStack itemStack = slot.getStack();
            if (itemStack.getItem() != item) continue;
            return i;
        }
        return -1;
    }

    private int Method4215() {
        if (Globals.mc.player == null) {
            return 0;
        }
        for (int i = Globals.mc.player.inventoryContainer.getInventory().size() - 1; i > 0; --i) {
            ItemStack itemStack;
            if (i == 0 || i == 5 || i == 6 || i == 7 || i == 8 || !(itemStack = (ItemStack)Globals.mc.player.inventoryContainer.getInventory().get(i)).isEmpty()) continue;
            return i;
        }
        return -1;
    }

    private void Method4207(Class26 class26) {
        boolean bl;
        if (Globals.mc.player == null || Globals.mc.world == null) {
            return;
        }
        if (!Manager.moduleManager.isModuleEnabled(XCarry.class)) {
            this.Method4216();
            return;
        }
        if (Globals.mc.objectMouseOver == null) {
            return;
        }
        boolean bl2 = bl = Globals.mc.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK;
        if (!bl) {
            return;
        }
        BlockPos blockPos = Globals.mc.objectMouseOver.getBlockPos();
        EnumFacing enumFacing = Globals.mc.objectMouseOver.sideHit;
        if (!(Globals.mc.currentScreen instanceof GuiInventory) && !this.Field3466) {
            Globals.mc.displayGuiScreen(null);
            Globals.mc.displayGuiScreen((GuiScreen)new GuiInventory((EntityPlayer)Globals.mc.player));
            this.Field3466 = true;
        }
        Item item = (Item)Item.REGISTRY.getObjectById(7);
        if (!this.Field3467) {
            this.Field3468 = this.Method4214(item);
        }
        if (this.Field3468 != -1) {
            if (!this.Field3467) {
                this.Field3469 = this.Method4215();
                if (this.Field3469 != -1) {
                    this.Method4213(this.Field3468, this.Field3469, (Boolean)this.Field3464.getValue());
                    Globals.mc.playerController.currentPlayerItem = this.Field3469;
                    Globals.mc.playerController.updateController();
                    this.Field3470.Method47();
                }
            }
            if (this.Field3469 == -1) {
                return;
            }
            this.Field3467 = true;
            if (this.Field3470.Method50(((Integer)this.Field3463.getValue()).intValue())) {
                Globals.mc.displayGuiScreen(null);
                Class31.Method541(blockPos.offset(enumFacing), false, false, false);
                Globals.mc.displayGuiScreen((GuiScreen)new GuiInventory((EntityPlayer)Globals.mc.player));
                this.Method4213(this.Field3469, this.Field3468, (Boolean)this.Field3465.getValue());
                Globals.mc.displayGuiScreen(null);
                this.Method4216();
            }
        }
    }
}
