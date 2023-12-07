package me.ciruu.abyss;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import me.ciruu.abyss.Class354;
import me.ciruu.abyss.Class384;
import me.ciruu.abyss.Class385;
import me.ciruu.abyss.Class446;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;

public class Class386 {
    public static InventoryPlayer Method3683() {
        return Class354.Field2646.player.inventory;
    }

    public static Container Method4259() {
        return Class354.Field2646.player.inventoryContainer;
    }

    public static Container Method3682() {
        return Class354.Field2646.player.openContainer;
    }

    public static int Method4260() {
        return InventoryPlayer.getHotbarSize();
    }

    public static List Method4261() {
        ArrayList<Class446> arrayList = new ArrayList<Class446>();
        int n = 0;
        for (ItemStack itemStack : Class386.Method3683().mainInventory) {
            arrayList.add(new Class446(itemStack, n));
            ++n;
        }
        return arrayList;
    }

    public static List Method4262() {
        return Class386.Method4259().inventorySlots.stream().map(Class384::new).collect(Collectors.toList());
    }

    public static List Method4263(int n, int n2) {
        return Class386.Method4261().subList(n, n2);
    }

    public static List Method4264(int n, int n2) {
        return Class386.Method4262().subList(n, n2);
    }

    public static List Method4265() {
        return Class386.Method4263(9, 27);
    }

    public static List Method3672() {
        return Class386.Method4264(9, 36);
    }

    public static List Method3679() {
        return Class386.Method4263(0, Class386.Method4260());
    }

    public static Class385 Method3671() {
        return Class386.Method4266(Class386.Method3683().getItemStack(), -999);
    }

    public static Class385 Method4267() {
        return (Class385)Class386.Method4261().get(Class386.Method3683().currentItem);
    }

    public static Class385 Method4268() {
        return Class386.Method4266(Class354.Field2646.player.getHeldItemOffhand(), 36);
    }

    public static int Method3686(Class385 class385) {
        int n = Class386.Method4260() - 1;
        return class385.getIndex() > n ? 0 : n - Math.abs(Class386.Method4267().getIndex() - class385.getIndex());
    }

    public static void Method4269(int n, int n2, ClickType clickType, ItemStack itemStack) {
        Class354.Field2646.player.connection.sendPacket((Packet)new CPacketClickWindow(0, n, n2, clickType, itemStack, Class386.Method3682().getNextTransactionID(Class386.Method3683())));
    }

    public static ItemStack Method4270(Class385 class385, int n, ClickType clickType) {
        if (class385.getIndex() == -1) {
            throw new IllegalArgumentException();
        }
        ItemStack itemStack = Class386.Method3682().slotClick(class385.getSlotNumber(), n, clickType, (EntityPlayer)Class354.Field2646.player);
        Class386.Method4269(class385.getSlotNumber(), n, clickType, itemStack);
        return itemStack;
    }

    public static Class385 Method4266(ItemStack itemStack, int n) {
        return new Class446(itemStack, n);
    }
}
