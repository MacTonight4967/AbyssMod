package me.ciruu.abyss.modules.misc;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import me.ciruu.abyss.Class142;
import me.ciruu.abyss.Class26;
import me.ciruu.abyss.Class385;
import me.ciruu.abyss.Class386;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;

public class HotbarRefill
extends Module {
    public final Setting durability = new Setting("Durability", "DurabilityThreshold", (Module)this, (Object)50, 0, 100);
    public final Setting stackThreshold = new Setting("StackThreshold", "StackThreshold", (Module)this, (Object)1, 1, 63);
    public final Setting delay = new Setting("Delay", "TickDelay", (Module)this, (Object)1, 1, 100);
    public final Setting nogui = new Setting("NoGui", "", this, true);
    private Class142 Field2986 = Class142.empty();
    private long Field2987 = 0L;
    @EventHandler
    private Listener Field2988 = new Listener<Class26>(this::Method3664, new Predicate[0]);

    public HotbarRefill() {
        super("HotbarRefill", "Refill items from your inventory to your hotbar.", Class11.MISC);
        this.Method3665(this.durability);
        this.Method3665(this.stackThreshold);
        this.Method3665(this.delay);
        this.Method3665(this.nogui);
    }

    private boolean Method3666(int n) {
        if ((Integer)this.delay.getValue() == 0) {
            return true;
        }
        if ((Integer)this.delay.getValue() < 0) {
            return n < Math.abs((Integer)this.delay.getValue());
        }
        return n == 0 && this.Field2987 % (long)((Integer)this.delay.getValue()).intValue() == 0L;
    }

    private boolean Method3667(Class385 class385) {
        return class385.isItemDamageable() || class385.isStackable();
    }

    private boolean Method3668(Class385 class385) {
        return class385.isItemDamageable() ? class385.getDurability() > (Integer)this.durability.getValue() : class385.getStackCount() > (Integer)this.stackThreshold.getValue();
    }

    private int Method3669(Class385 class385) {
        return class385.isNull() ? 0 : (class385.isItemDamageable() ? class385.getDurability() : class385.getStackCount());
    }

    private void Method3670() {
        Class385 class385 = Class386.Method3671();
        if (class385.isEmpty()) {
            return;
        }
        Class385 class3852 = class385.isDamageable() ? Class386.Method3672().stream().filter(Class385::isNull).findAny().orElse(Class385.Field1513) : Class386.Method3672().stream().filter(arg_0 -> HotbarRefill.Method3673(class385, arg_0)).filter(HotbarRefill::Method3674).max(Comparator.comparing(Class385::getStackCount)).orElse(Class385.Field1513);
        if (class3852 == Class385.Field1513) {
            HotbarRefill.Method3675(class385, 0, ClickType.PICKUP);
        } else {
            HotbarRefill.Method3675(class3852, 0, ClickType.PICKUP);
            if (Class386.Method3671().nonEmpty()) {
                throw new RuntimeException();
            }
        }
    }

    public void Method3676() {
        super.Method15();
        Globals.mc.addScheduledTask(this::Method3677);
    }

    private static void Method3678(Class385 class385) {
        Class385 class3852 = (Class385)Class386.Method3679().get(class385.getIndex());
        if (!class385.isItemsEqual(class3852)) {
            throw new IllegalArgumentException();
        }
    }

    private static void Method3680(Class385 class385) {
    }

    private static void Method3681(int n, int n2, ClickType clickType, ItemStack itemStack) {
        Globals.mc.player.connection.sendPacket((Packet)new CPacketClickWindow(0, n, n2, clickType, itemStack, Class386.Method3682().getNextTransactionID(Class386.Method3683())));
    }

    private static ItemStack Method3675(Class385 class385, int n, ClickType clickType) {
        if (class385.getIndex() == -1) {
            throw new IllegalArgumentException();
        }
        ItemStack itemStack = Class386.Method3682().slotClick(class385.getSlotNumber(), n, clickType, (EntityPlayer)Globals.mc.player);
        HotbarRefill.Method3681(class385.getSlotNumber(), n, clickType, itemStack);
        return itemStack;
    }

    private void Method3664(Class26 class26) {
        if (Globals.mc.player == null) {
            return;
        }
        if (Globals.mc.currentScreen != null && ((Boolean)this.nogui.getValue()).booleanValue()) {
            return;
        }
        if (this.Field2986.isEmpty()) {
            List list = Class386.Method3672();
            this.Field2986 = Class386.Method3679().stream().filter(Class385::nonNull).filter(this::Method3667).filter(this::Method3684).filter(arg_0 -> this.Method3685(list, arg_0)).max(Comparator.comparingInt(Class386::Method3686)).map(arg_0 -> this.Method3687(list, arg_0)).orElse(Class142.empty());
        }
        int n = 0;
        while (this.Method3666(n++) && this.Field2986.hasNext()) {
            try {
                ((Runnable)this.Field2986.next()).run();
            }
            catch (Throwable throwable) {
                this.Field2986 = Class142.singleton(this::Method3670);
            }
        }
        ++this.Field2987;
    }

    private Class142 Method3687(List list, Class385 class385) {
        return Class142.builder().Method714(() -> this.Method3688(class385, list)).Method714(() -> HotbarRefill.Method3689(class385)).Method714(this::Method3670).Method717();
    }

    private static void Method3689(Class385 class385) {
        HotbarRefill.Method3678(class385);
        HotbarRefill.Method3675(class385, 0, ClickType.PICKUP);
    }

    private void Method3688(Class385 class385, List list) {
        HotbarRefill.Method3678(class385);
        HotbarRefill.Method3675(list.stream().filter(Class385::nonNull).filter(this::Method3667).filter(class385::isItemsEqual).filter(this::Method3690).max(Comparator.comparingInt(this::Method3669)).orElseThrow(RuntimeException::new), 0, ClickType.PICKUP);
    }

    private boolean Method3690(Class385 class385) {
        return !class385.isDamageable() || this.Method3668(class385);
    }

    private boolean Method3685(List list, Class385 class385) {
        return list.stream().filter(this::Method3667).filter(this::Method3691).anyMatch(class385::isItemsEqual);
    }

    private boolean Method3691(Class385 class385) {
        return !class385.isItemDamageable() || this.Method3668(class385);
    }

    private boolean Method3684(Class385 class385) {
        return !this.Method3668(class385);
    }

    private void Method3677() {
        this.Field2986 = Class142.empty();
        this.Field2987 = 0L;
    }

    private static boolean Method3674(Class385 class385) {
        return class385.isNull() || !class385.isStackMaxed();
    }

    private static boolean Method3673(Class385 class385, Class385 class3852) {
        return class3852.isNull() || class385.isItemsEqual(class3852);
    }
}
