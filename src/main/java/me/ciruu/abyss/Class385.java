package me.ciruu.abyss;

import java.util.Objects;
import me.ciruu.abyss.Class409;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/*
 * Exception performing whole class analysis ignored.
 */
public static abstract class Class385
implements Comparable {
    public static final Class385 Field1513 = new Class409();

    public abstract ItemStack getItemStack();

    public Item getItem() {
        return this.getItemStack().getItem();
    }

    public abstract int getIndex();

    public int getSlotNumber() {
        switch (this.getIndex()) {
            case 36: {
                return 45;
            }
        }
        int n = this.getIndex() / 9;
        int n2 = this.getIndex() % 9;
        return 45 - (n * 9 + (9 - n2));
    }

    public boolean isNull() {
        return this.getItemStack().isEmpty();
    }

    public boolean nonNull() {
        return !this.isNull();
    }

    public boolean isEmpty() {
        return this.getItemStack().isEmpty();
    }

    public boolean nonEmpty() {
        return !this.isEmpty();
    }

    public boolean isDamageable() {
        return this.getItemStack().isItemStackDamageable();
    }

    public boolean isItemDamageable() {
        return this.getItem().isDamageable();
    }

    public boolean isStackable() {
        return this.getItemStack().isStackable();
    }

    public int getDamage() {
        return this.isDamageable() ? this.getItemStack().getItemDamage() : 0;
    }

    public int getDurability() {
        return this.isDamageable() ? this.getItemStack().getMaxDamage() - this.getItemStack().getItemDamage() : 0;
    }

    public int getStackCount() {
        return this.getItemStack().getCount();
    }

    public int getMaxStackCount() {
        return this.getItemStack().getMaxStackSize();
    }

    public boolean isStackMaxed() {
        return this.getStackCount() >= this.getMaxStackCount();
    }

    public boolean isItemsEqual(Class385 class385) {
        return this.getItemStack().isItemEqualIgnoreDurability(class385.getItemStack());
    }

    public boolean equals(Object object) {
        return this == object || object instanceof Class385 && this.getIndex() == ((Class385)object).getIndex() && this.getItemStack().equals(((Class385)object).getItemStack());
    }

    public int hashCode() {
        return Objects.hash(this.getItemStack(), this.getIndex());
    }

    public int compareTo(Class385 class385) {
        return Integer.compare(this.getIndex(), class385.getIndex());
    }

    public int compareTo(Object object) {
        return this.compareTo((Class385)object);
    }
}
