package me.ciruu.abyss;

import me.ciruu.abyss.Class385;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/*
 * Exception performing whole class analysis ignored.
 */
protected static class Class384
extends Class385 {
    private final Slot Field1271;

    protected Class384(Slot slot) {
        this.Field1271 = slot;
    }

    @Override
    public ItemStack getItemStack() {
        return this.Field1271.getStack();
    }

    @Override
    public int getIndex() {
        int n = this.getSlotNumber() / 9 - 1;
        int n2 = this.getSlotNumber() % 9;
        return 36 - (n * 9 + (9 - n2));
    }

    @Override
    public int getSlotNumber() {
        return this.Field1271.slotNumber;
    }

    @Override
    public int compareTo(Object object) {
        return super.compareTo((Class385)object);
    }
}
