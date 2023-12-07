package me.ciruu.abyss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class300;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAir;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;

public class Class155 {
    public static void Method522(int n, boolean bl) {
        if (Globals.mc.player.inventory.currentItem == n || n < 0) {
            return;
        }
        if (bl) {
            Globals.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n));
            Globals.mc.playerController.updateController();
        } else {
            Globals.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n));
            Globals.mc.player.inventory.currentItem = n;
            Globals.mc.playerController.updateController();
        }
    }

    public static void Method1491(Class clazz, boolean bl) {
        int n = Class155.Method544(clazz);
        if (n > -1) {
            Class155.Method522(n, bl);
        }
    }

    public static boolean Method2999(ItemStack itemStack) {
        return itemStack == null || itemStack.getItem() instanceof ItemAir;
    }

    public static int Method544(Class clazz) {
        for (int i = 0; i < 9; ++i) {
            Block block;
            ItemStack itemStack = Globals.mc.player.inventory.getStackInSlot(i);
            if (itemStack == ItemStack.EMPTY) continue;
            if (clazz.isInstance(itemStack.getItem())) {
                return i;
            }
            if (!(itemStack.getItem() instanceof ItemBlock) || !clazz.isInstance(block = ((ItemBlock)itemStack.getItem()).getBlock())) continue;
            return i;
        }
        return -1;
    }

    public static int Method545(Block block) {
        for (int i = 0; i < 9; ++i) {
            Block block2;
            ItemStack itemStack = Globals.mc.player.inventory.getStackInSlot(i);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || (block2 = ((ItemBlock)itemStack.getItem()).getBlock()) != block) continue;
            return i;
        }
        return -1;
    }

    public static int Method3000(Block block) {
        int n = -1;
        for (int i = 0; i < 9; ++i) {
            if (Globals.mc.player.inventory.getStackInSlot(i).getItem() != Item.getItemFromBlock((Block)block)) continue;
            n = i;
        }
        return n;
    }

    public static int Method745(Item item) {
        for (int i = 0; i < 9; ++i) {
            Item item2 = Globals.mc.player.inventory.getStackInSlot(i).getItem();
            if (Item.getIdFromItem((Item)item2) != Item.getIdFromItem((Item)item)) continue;
            return i;
        }
        return -1;
    }

    public static int Method3001(Item item) {
        return Class155.Method3002(item, false);
    }

    public static int Method3002(Item item, boolean bl) {
        int n;
        int n2 = n = bl ? 0 : 9;
        while (n < 36) {
            Item item2 = Globals.mc.player.inventory.getStackInSlot(n).getItem();
            if (Item.getIdFromItem((Item)item) == Item.getIdFromItem((Item)item2)) {
                return n + (n < 9 ? 36 : 0);
            }
            ++n;
        }
        return -1;
    }

    public static int Method3003(Item item, boolean bl) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(-1);
        for (Map.Entry entry : Class155.Method3004().entrySet()) {
            if (((ItemStack)entry.getValue()).getItem() != item || (Integer)entry.getKey() == 45 && !bl) continue;
            atomicInteger.set((Integer)entry.getKey());
            return atomicInteger.get();
        }
        return atomicInteger.get();
    }

    public static List Method1807(boolean bl) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (Map.Entry slot : Class155.Method3004().entrySet()) {
            if (!((ItemStack)slot.getValue()).isEmpty && ((ItemStack)slot.getValue()).getItem() != Items.AIR) continue;
            arrayList.add(slot.getKey());
        }
        if (bl) {
            for (int i = 1; i < 5; ++i) {
                Slot slot = (Slot)Globals.mc.player.inventoryContainer.inventorySlots.get(i);
                ItemStack itemStack = slot.getStack();
                if (!itemStack.isEmpty() && itemStack.getItem() != Items.AIR) continue;
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    public static int Method3005(Class clazz, boolean bl) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(-1);
        for (Map.Entry entry : Class155.Method3004().entrySet()) {
            if (!Class155.Method1094(((ItemStack)entry.getValue()).getItem(), clazz) || (Integer)entry.getKey() == 45 && !bl) continue;
            atomicInteger.set((Integer)entry.getKey());
            return atomicInteger.get();
        }
        return atomicInteger.get();
    }

    public static boolean Method1094(Item item, Class clazz) {
        if (item instanceof ItemBlock) {
            Block block = ((ItemBlock)item).getBlock();
            return clazz.isInstance(block);
        }
        return false;
    }

    public static void Method3006(int n) {
        Globals.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n));
        Globals.mc.player.inventory.currentItem = n;
        Globals.mc.playerController.updateController();
    }

    public static Map Method3004() {
        return Class155.Method3007(9, 44);
    }

    private static Map Method3007(int n, int n2) {
        HashMap<Integer, Object> hashMap = new HashMap<Integer, Object>();
        for (int i = n; i <= n2; ++i) {
            hashMap.put(i, Globals.mc.player.inventoryContainer.getInventory().get(i));
        }
        return hashMap;
    }

    public static boolean[] Method1095(boolean bl, int n, boolean bl2, Class300 class300, Class clazz) {
        boolean[] blArray = new boolean[]{bl2, false};
        switch (class300) {
            case NORMAL: {
                if (!bl && !bl2) {
                    Class155.Method522(Class155.Method544(clazz), false);
                    blArray[0] = true;
                } else if (bl && bl2) {
                    Class155.Method522(n, false);
                    blArray[0] = false;
                }
                blArray[1] = true;
                break;
            }
            case SILENT: {
                if (!bl && !bl2) {
                    Class155.Method522(Class155.Method544(clazz), true);
                    blArray[0] = true;
                } else if (bl && bl2) {
                    blArray[0] = false;
                    Manager.Field1642.Method3008(n);
                }
                blArray[1] = true;
                break;
            }
            case NONE: {
                blArray[1] = bl ? true : Globals.mc.player.inventory.currentItem == Class155.Method544(clazz);
            }
        }
        return blArray;
    }

    public static boolean[] Method3009(boolean bl, int n, boolean bl2, Class300 class300, Item item) {
        boolean[] blArray = new boolean[]{bl2, false};
        switch (class300) {
            case NORMAL: {
                if (!bl && !bl2) {
                    Class155.Method522(Class155.Method745(item), false);
                    blArray[0] = true;
                } else if (bl && bl2) {
                    Class155.Method522(n, false);
                    blArray[0] = false;
                }
                blArray[1] = true;
                break;
            }
            case SILENT: {
                if (!bl && !bl2) {
                    Class155.Method522(Class155.Method745(item), true);
                    blArray[0] = true;
                } else if (bl && bl2) {
                    blArray[0] = false;
                    Manager.Field1642.Method3008(n);
                }
                blArray[1] = true;
                break;
            }
            case NONE: {
                blArray[1] = bl ? true : Globals.mc.player.inventory.currentItem == Class155.Method745(item);
            }
        }
        return blArray;
    }

    public static boolean Method1812(Class clazz) {
        boolean bl = false;
        ItemStack itemStack = Globals.mc.player.getHeldItemMainhand();
        bl = Class155.Method3010(itemStack, clazz);
        if (!bl) {
            ItemStack itemStack2 = Globals.mc.player.getHeldItemOffhand();
            bl = Class155.Method3010(itemStack, clazz);
        }
        return bl;
    }

    public static boolean Method3010(ItemStack itemStack, Class clazz) {
        if (itemStack == null) {
            return false;
        }
        Item item = itemStack.getItem();
        if (clazz.isInstance(item)) {
            return true;
        }
        if (item instanceof ItemBlock) {
            Block block = Block.getBlockFromItem((Item)item);
            return clazz.isInstance(block);
        }
        return false;
    }

    public static int Method3011() {
        for (int i = 1; i < 5; ++i) {
            Slot slot = (Slot)Globals.mc.player.inventoryContainer.inventorySlots.get(i);
            ItemStack itemStack = slot.getStack();
            if (!itemStack.isEmpty() && itemStack.getItem() != Items.AIR) continue;
            return i;
        }
        return -1;
    }

    public static boolean Method3012(int n) {
        Slot slot = (Slot)Globals.mc.player.inventoryContainer.inventorySlots.get(n);
        ItemStack itemStack = slot.getStack();
        return itemStack.isEmpty();
    }

    public static int Method3013(int n) {
        return 36 + n;
    }

    public static boolean Method3014(ItemStack itemStack, ItemStack itemStack2) {
        if (!itemStack.getItem().equals(itemStack2.getItem())) {
            return false;
        }
        if (itemStack.getItem() instanceof ItemBlock && itemStack2.getItem() instanceof ItemBlock) {
            Block block = ((ItemBlock)itemStack.getItem()).getBlock();
            Block block2 = ((ItemBlock)itemStack2.getItem()).getBlock();
            if (!block.material.equals(block2.material)) {
                return false;
            }
        }
        if (!itemStack.getDisplayName().equals(itemStack2.getDisplayName())) {
            return false;
        }
        return itemStack.getItemDamage() == itemStack2.getItemDamage();
    }

    public static EntityEquipmentSlot Method3015(int n) {
        if (n == 5) {
            return EntityEquipmentSlot.HEAD;
        }
        if (n == 6) {
            return EntityEquipmentSlot.CHEST;
        }
        if (n == 7) {
            return EntityEquipmentSlot.LEGS;
        }
        return EntityEquipmentSlot.FEET;
    }

    public static int Method3016(EntityEquipmentSlot entityEquipmentSlot, boolean bl) {
        int n = -1;
        float f = 0.0f;
        for (int i = 9; i < 45; ++i) {
            boolean bl2;
            ItemStack itemStack = Minecraft.getMinecraft().player.inventoryContainer.getSlot(i).getStack();
            if (itemStack.getItem() == Items.AIR || !(itemStack.getItem() instanceof ItemArmor)) continue;
            ItemArmor itemArmor = (ItemArmor)itemStack.getItem();
            if (itemArmor.armorType != entityEquipmentSlot) continue;
            float f2 = itemArmor.damageReduceAmount + EnchantmentHelper.getEnchantmentLevel((Enchantment)Enchantments.PROTECTION, (ItemStack)itemStack);
            boolean bl3 = bl2 = bl && EnchantmentHelper.hasBindingCurse((ItemStack)itemStack);
            if (!(f2 > f) || bl2) continue;
            f = f2;
            n = i;
        }
        return n;
    }

    public static int Method1814(EntityEquipmentSlot entityEquipmentSlot, boolean bl, boolean bl2) {
        int n = Class155.Method3016(entityEquipmentSlot, bl);
        if (n == -1 && bl2) {
            float f = 0.0f;
            for (int i = 1; i < 5; ++i) {
                boolean bl3;
                Slot slot = (Slot)Globals.mc.player.inventoryContainer.inventorySlots.get(i);
                ItemStack itemStack = slot.getStack();
                if (itemStack.getItem() == Items.AIR || !(itemStack.getItem() instanceof ItemArmor)) continue;
                ItemArmor itemArmor = (ItemArmor)itemStack.getItem();
                if (itemArmor.armorType != entityEquipmentSlot) continue;
                float f2 = itemArmor.damageReduceAmount + EnchantmentHelper.getEnchantmentLevel((Enchantment)Enchantments.PROTECTION, (ItemStack)itemStack);
                boolean bl4 = bl3 = bl && EnchantmentHelper.hasBindingCurse((ItemStack)itemStack);
                if (!(f2 > f) || bl3) continue;
                f = f2;
                n = i;
            }
        }
        return n;
    }

    public static int Method1815(Item item, boolean bl, boolean bl2) {
        int n = Class155.Method3003(item, bl);
        if (n == -1 && bl2) {
            for (int i = 1; i < 5; ++i) {
                Item item2;
                Slot slot = (Slot)Globals.mc.player.inventoryContainer.inventorySlots.get(i);
                ItemStack itemStack = slot.getStack();
                if (itemStack.getItem() == Items.AIR || (item2 = itemStack.getItem()) != item) continue;
                n = i;
            }
        }
        return n;
    }

    public static int Method3017(Class clazz, boolean bl, boolean bl2) {
        int n = Class155.Method3005(clazz, bl);
        if (n == -1 && bl2) {
            for (int i = 1; i < 5; ++i) {
                Block block;
                Slot slot = (Slot)Globals.mc.player.inventoryContainer.inventorySlots.get(i);
                ItemStack itemStack = slot.getStack();
                if (itemStack.getItem() == Items.AIR) continue;
                Item item = itemStack.getItem();
                if (clazz.isInstance(item)) {
                    n = i;
                    continue;
                }
                if (!(item instanceof ItemBlock) || !clazz.isInstance(block = ((ItemBlock)item).getBlock())) continue;
                n = i;
            }
        }
        return n;
    }
}
