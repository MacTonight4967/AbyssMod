package me.ciruu.abyss;

import java.util.function.Predicate;
import me.ciruu.abyss.Class26;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.modules.misc.XCarry;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Class630
extends Module {
    private boolean Field2802 = false;
    @EventHandler
    private Listener Field2803 = new Listener<Class26>(this::Method3384, new Predicate[0]);

    public Class630() {
        super("7kIlegalCarry", "", Class11.EXPLOIT);
    }

    public void Method3385() {
        super.Method15();
        this.Field2802 = false;
    }

    private void Method3386(int n, int n2) {
        Globals.mc.playerController.windowClick(Globals.mc.player.inventoryContainer.windowId, n, 0, ClickType.PICKUP, (EntityPlayer)Globals.mc.player);
        Globals.mc.playerController.windowClick(Globals.mc.player.inventoryContainer.windowId, n2, 0, ClickType.PICKUP, (EntityPlayer)Globals.mc.player);
        Globals.mc.playerController.windowClick(Globals.mc.player.inventoryContainer.windowId, n, 0, ClickType.PICKUP, (EntityPlayer)Globals.mc.player);
        Globals.mc.playerController.updateController();
    }

    private int Method3387() {
        for (int i = 1; i < 5; ++i) {
            Slot slot = (Slot)Globals.mc.player.inventoryContainer.inventorySlots.get(i);
            ItemStack itemStack = slot.getStack();
            if (!itemStack.isEmpty() && itemStack.getItem() != Items.AIR) continue;
            return i;
        }
        return -1;
    }

    private int Method3388(Item item) {
        for (int i = 1; i < 5; ++i) {
            Slot slot = (Slot)Globals.mc.player.inventoryContainer.inventorySlots.get(i);
            ItemStack itemStack = slot.getStack();
            if (itemStack.getItem() != item) continue;
            return i;
        }
        return -1;
    }

    private int Method3389(Item item) {
        if (Globals.mc.player == null) {
            return 0;
        }
        for (int i = Globals.mc.player.inventoryContainer.getInventory().size() - 1; i > 0; --i) {
            ItemStack itemStack;
            if (i == 0 || i == 5 || i == 6 || i == 7 || i == 8 || (itemStack = (ItemStack)Globals.mc.player.inventoryContainer.getInventory().get(i)).isEmpty() || itemStack.getItem() != item) continue;
            return i;
        }
        return -1;
    }

    private void Method3384(Class26 class26) {
        if (!Manager.moduleManager.isModuleEnabled(XCarry.class)) {
            this.Method3390();
            return;
        }
        Item item = (Item)Item.REGISTRY.getObjectById(7);
        int n = this.Method3389(item);
        if (n != -1) {
            int n2;
            if (!(Globals.mc.currentScreen instanceof GuiInventory) && !this.Field2802) {
                Globals.mc.displayGuiScreen(null);
                Globals.mc.displayGuiScreen((GuiScreen)new GuiInventory((EntityPlayer)Globals.mc.player));
                this.Field2802 = true;
            }
            if (Globals.mc.currentScreen instanceof GuiInventory && (n2 = this.Method3387()) != -1) {
                this.Method3386(n, n2);
            }
            this.Method3390();
        }
    }
}
