package me.ciruu.abyss;

import me.ciruu.abyss.Class385;
import net.minecraft.item.ItemStack;

/*
 * Exception performing whole class analysis ignored.
 */
protected static class Class446
extends Class385 {
    private final ItemStack Field2297;
    private final int Field2298;

    protected Class446(ItemStack itemStack, int n) {
        this.Field2297 = itemStack;
        this.Field2298 = n;
    }

    @Override
    public ItemStack getItemStack() {
        return this.Field2297;
    }

    @Override
    public int getIndex() {
        return this.Field2298;
    }

    @Override
    public int compareTo(Object object) {
        return super.compareTo((Class385)object);
    }
}
