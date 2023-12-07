package me.ciruu.abyss.modules.combat;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Predicate;
import me.ciruu.abyss.Class154;
import me.ciruu.abyss.Class155;
import me.ciruu.abyss.Class207;
import me.ciruu.abyss.Class219;
import me.ciruu.abyss.Class22;
import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Class29;
import me.ciruu.abyss.Class30;
import me.ciruu.abyss.Class350;
import me.ciruu.abyss.Class352;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.modules.misc.XCarry;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemExpBottle;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import org.lwjgl.input.Keyboard;

public class AutoArmor
extends Module {
    private final Setting mainwindow = new Setting("Main", "", this, new Class25("Main Settings"));
    private final Setting delay = new Setting("Delay(ms)", "", (Module)this, (Object)50, 0, 500);
    private final Setting automend = new Setting("AutoMend", "", this, true);
    private final Setting enemydistance = new Setting("EnemyDistance", "", this, 1, 1, 20, this.mainwindow, this.automend::getValue);
    private final Setting mendkey = new Setting("MendKey", "", (Module)this, (Object)new Class207(0), this.mainwindow, this.automend::getValue);
    public final Setting armor = new Setting("Armor%", "", (Module)this, (Object)100, 1, 100);
    private final Setting curseOfBinding = new Setting("CurseOfBinding", "", this, false);
    private final Setting actions = new Setting("Actions", "", (Module)this, (Object)3, 1, 12);
    private final Setting elytraswap = new Setting("ElytraSwap", "", this, new Class207(0));
    private final Setting shiftclick = new Setting("ShiftClick", "", this, false);
    private final Class22 Field1406 = new Class22();
    private final Class22 Field1407 = new Class22();
    private final Queue Field1408 = new ConcurrentLinkedQueue();
    private final List Field1409 = new ArrayList();
    private boolean Field1410 = false;
    private boolean Field1411 = false;
    private int Field1412 = -1;
    @EventHandler
    private Listener Field1413 = new Listener<Class350>(this::Method1800, new Predicate[0]);
    @EventHandler
    private Listener Field1414 = new Listener<EventPlayerUpdateWalking>(this::Method1801, new Predicate[0]);

    public AutoArmor() {
        super("AutoArmor", "Automatically puts on armor.", Class11.COMBAT);
        this.Method1802(this.delay);
        this.Method1802(this.automend);
        this.Method1802(this.enemydistance);
        this.Method1802(this.mendkey);
        this.Method1802(this.armor);
        this.Method1802(this.curseOfBinding);
        this.Method1802(this.elytraswap);
    }

    public void Method1803() {
        super.Method13();
        this.Field1407.Method47();
        this.Field1406.Method47();
        this.Field1408.clear();
        this.Field1409.clear();
    }

    public void Method1804() {
        super.Method15();
        this.Field1408.clear();
        this.Field1409.clear();
        this.Field1410 = false;
    }

    public String Method1805() {
        return ChatFormatting.WHITE + (this.Field1410 ? "Elytra" : "Armor");
    }

    private void Method1806(int n) {
        if (this.Field1408.isEmpty()) {
            int n2 = -1;
            Iterator iterator = Class155.Method1807(Manager.moduleManager.isModuleEnabled(XCarry.class)).iterator();
            while (iterator.hasNext()) {
                int n3 = (Integer)iterator.next();
                if (this.Field1409.contains(n2)) continue;
                n2 = n3;
                this.Field1409.add(n3);
            }
            if (n2 != -1) {
                if (n2 < 5 && n2 > 0 || !((Boolean)this.shiftclick.getValue()).booleanValue()) {
                    this.Field1408.add(new Class154(n));
                    this.Field1408.add(new Class154(n2));
                } else {
                    this.Field1408.add(new Class154(n, true));
                }
                this.Field1408.add(new Class154());
            }
        }
    }

    private void Method1808(int n, int n2) {
        if (this.Field1408.isEmpty()) {
            this.Field1409.remove((Object)n2);
            if (n2 < 5 && n2 > 0 || !((Boolean)this.shiftclick.getValue()).booleanValue()) {
                this.Field1408.add(new Class154(n2));
                this.Field1408.add(new Class154(n));
            } else {
                this.Field1408.add(new Class154(n2, true));
            }
            this.Field1408.add(new Class154());
        }
    }

    private boolean Method1809() {
        boolean bl = false;
        try {
            EntityPlayer entityPlayer = Class30.Method1810(((Integer)this.enemydistance.getValue()).intValue());
            if (entityPlayer == null) {
                return true;
            }
            bl = Globals.mc.player.getDistanceSq((Entity)entityPlayer) >= Class29.Method114(((Integer)this.enemydistance.getValue()).intValue());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return bl;
    }

    public static int Method1811() {
        for (int i = 0; i < 9; ++i) {
            ItemStack itemStack = Globals.mc.player.inventory.getStackInSlot(i);
            if (itemStack == ItemStack.EMPTY || itemStack.getItem() != Items.EXPERIENCE_BOTTLE) continue;
            return i;
        }
        return -1;
    }

    private void Method1801(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        Object object;
        if (Globals.mc.player == null || Globals.mc.world == null || eventPlayerUpdateWalking.Method100() != Class53.PRE) {
            return;
        }
        if (Globals.mc.currentScreen instanceof GuiContainer && !(Globals.mc.currentScreen instanceof GuiInventory)) {
            return;
        }
        boolean bl = Keyboard.isKeyDown((int)((Class207)this.mendkey.getValue()).Method592());
        this.Field1412 = Globals.mc.player.inventory.currentItem;
        if (this.Field1411 && !bl && this.Field1412 != -1) {
            Globals.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.Field1412));
            this.Field1411 = false;
        }
        if (this.Field1408.isEmpty()) {
            int n;
            ItemStack itemStack;
            ItemStack itemStack2;
            int n2;
            int n3;
            ItemStack itemStack3;
            if (((Boolean)this.automend.getValue()).booleanValue() && (Class155.Method1812(ItemExpBottle.class) && Globals.mc.gameSettings.keyBindUseItem.isKeyDown() || bl) && this.Method1809()) {
                int n4;
                int n5;
                int n6;
                int n7;
                itemStack3 = Globals.mc.player.inventoryContainer.getSlot(5).getStack();
                n3 = 0;
                if (!itemStack3.isEmpty && (n7 = Class352.Method1813(itemStack3)) >= (Integer)this.armor.getValue()) {
                    n3 = 1;
                }
                ItemStack itemStack4 = Globals.mc.player.inventoryContainer.getSlot(6).getStack();
                n2 = 0;
                if (!itemStack4.isEmpty && (n6 = Class352.Method1813(itemStack4)) >= (Integer)this.armor.getValue()) {
                    n2 = 1;
                }
                ItemStack itemStack5 = Globals.mc.player.inventoryContainer.getSlot(7).getStack();
                boolean bl2 = false;
                if (!itemStack5.isEmpty && (n5 = Class352.Method1813(itemStack5)) >= (Integer)this.armor.getValue()) {
                    bl2 = true;
                }
                ItemStack itemStack6 = Globals.mc.player.inventoryContainer.getSlot(8).getStack();
                boolean bl3 = false;
                if (!itemStack6.isEmpty && (n4 = Class352.Method1813(itemStack6)) >= (Integer)this.armor.getValue()) {
                    bl3 = true;
                }
                int n8 = n4 = !(n3 == 0 && !itemStack3.isEmpty || n2 == 0 && !itemStack4.isEmpty || !bl2 && !itemStack5.isEmpty || !bl3 && !itemStack6.isEmpty) ? 1 : 0;
                if (bl && !this.Field1411 && n4 == 0) {
                    boolean bl4 = !Class155.Method1812(ItemExpBottle.class);
                    int n9 = AutoArmor.Method1811();
                    if (bl4 && n9 != -1) {
                        this.Field1411 = true;
                        Class155.Method522(n9, true);
                    }
                }
                if ((this.Field1411 || Class155.Method1812(ItemExpBottle.class)) && n4 == 0 && bl) {
                    Globals.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                    eventPlayerUpdateWalking.setPitch(90.0f);
                    eventPlayerUpdateWalking.cancel();
                }
                if (n4 == 0) {
                    if (n3 != 0) {
                        this.Method1806(5);
                    }
                    if (n2 != 0) {
                        this.Method1806(6);
                    }
                    if (bl2) {
                        this.Method1806(7);
                    }
                    if (bl3) {
                        this.Method1806(8);
                    }
                    return;
                }
            }
            if ((itemStack3 = Globals.mc.player.inventoryContainer.getSlot(5).getStack()).getItem() == Items.AIR && (n3 = Class155.Method1814(EntityEquipmentSlot.HEAD, (Boolean)this.curseOfBinding.getValue(), Manager.moduleManager.isModuleEnabled(XCarry.class))) != -1) {
                this.Method1808(5, n3);
            }
            if ((object = Globals.mc.player.inventoryContainer.getSlot(6).getStack()).getItem() == Items.AIR) {
                if (this.Field1408.isEmpty()) {
                    int n10;
                    if (this.Field1410 && this.Field1407.Method50(500L)) {
                        int n11 = Class155.Method1815(Items.ELYTRA, false, Manager.moduleManager.isModuleEnabled(XCarry.class));
                        if (n11 != -1) {
                            if (n11 < 5 && n11 > 1 || !((Boolean)this.shiftclick.getValue()).booleanValue()) {
                                this.Field1408.add(new Class154(n11));
                                this.Field1408.add(new Class154(6));
                            } else {
                                this.Field1408.add(new Class154(n11, true));
                            }
                            this.Field1408.add(new Class154());
                            this.Field1407.Method47();
                        }
                    } else if (!this.Field1410 && (n10 = Class155.Method1814(EntityEquipmentSlot.CHEST, (Boolean)this.curseOfBinding.getValue(), Manager.moduleManager.isModuleEnabled(XCarry.class))) != -1) {
                        this.Method1808(6, n10);
                    }
                }
            } else if (this.Field1410 && object.getItem() != Items.ELYTRA && this.Field1407.Method50(500L)) {
                if (this.Field1408.isEmpty()) {
                    int n12 = Class155.Method1815(Items.ELYTRA, false, Manager.moduleManager.isModuleEnabled(XCarry.class));
                    if (n12 != -1) {
                        this.Field1408.add(new Class154(n12));
                        this.Field1408.add(new Class154(6));
                        this.Field1408.add(new Class154(n12));
                        this.Field1408.add(new Class154());
                    }
                    this.Field1407.Method47();
                }
            } else if (!this.Field1410 && object.getItem() == Items.ELYTRA && this.Field1407.Method50(500L) && this.Field1408.isEmpty()) {
                int n13 = Class155.Method1815((Item)Items.DIAMOND_CHESTPLATE, false, Manager.moduleManager.isModuleEnabled(XCarry.class));
                if (n13 == -1 && (n13 = Class155.Method1815((Item)Items.IRON_CHESTPLATE, false, Manager.moduleManager.isModuleEnabled(XCarry.class))) == -1 && (n13 = Class155.Method1815((Item)Items.GOLDEN_CHESTPLATE, false, Manager.moduleManager.isModuleEnabled(XCarry.class))) == -1 && (n13 = Class155.Method1815((Item)Items.CHAINMAIL_CHESTPLATE, false, Manager.moduleManager.isModuleEnabled(XCarry.class))) == -1) {
                    n13 = Class155.Method1815((Item)Items.LEATHER_CHESTPLATE, false, Manager.moduleManager.isModuleEnabled(XCarry.class));
                }
                if (n13 != -1) {
                    this.Field1408.add(new Class154(n13));
                    this.Field1408.add(new Class154(6));
                    this.Field1408.add(new Class154(n13));
                    this.Field1408.add(new Class154());
                }
                this.Field1407.Method47();
            }
            if ((itemStack2 = Globals.mc.player.inventoryContainer.getSlot(7).getStack()).getItem() == Items.AIR && (n2 = Class155.Method1814(EntityEquipmentSlot.LEGS, (Boolean)this.curseOfBinding.getValue(), Manager.moduleManager.isModuleEnabled(XCarry.class))) != -1) {
                this.Method1808(7, n2);
            }
            if ((itemStack = Globals.mc.player.inventoryContainer.getSlot(8).getStack()).getItem() == Items.AIR && (n = Class155.Method1814(EntityEquipmentSlot.FEET, (Boolean)this.curseOfBinding.getValue(), Manager.moduleManager.isModuleEnabled(XCarry.class))) != -1) {
                this.Method1808(8, n);
            }
        }
        if (this.Field1406.Method50(((Integer)this.delay.getValue()).intValue())) {
            if (!this.Field1408.isEmpty()) {
                for (int i = 0; i < (Integer)this.actions.getValue(); ++i) {
                    object = (Class154)this.Field1408.poll();
                    if (object == null) continue;
                    ((Class154)object).Method438();
                }
            }
            this.Field1406.Method47();
        }
    }

    private void Method1800(Class350 class350) {
        if (!(Globals.mc.currentScreen instanceof Class219) && ((Class207)this.elytraswap.getValue()).Method592() == class350.Method1535()) {
            this.Field1410 = !this.Field1410;
        }
    }
}
