package me.ciruu.abyss;

import me.ciruu.abyss.Class385;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/*
 * Exception performing whole class analysis ignored.
 */
static final class Class409
extends Class385 {
    Class409() {
    }

    @Override
    public ItemStack getItemStack() {
        return ItemStack.EMPTY;
    }

    @Override
    public Item getItem() {
        return Items.AIR;
    }

    @Override
    public int getIndex() {
        return -1;
    }

    @Override
    public int compareTo(Object object) {
        return super.compareTo((Class385)object);
    }
}
