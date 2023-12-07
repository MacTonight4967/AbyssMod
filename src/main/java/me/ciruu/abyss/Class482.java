package me.ciruu.abyss;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

/*
 * Exception performing whole class analysis ignored.
 */
private static class Class482
extends ArrayList {
    private final ArrayList Field1715;

    public Class482(ArrayList arrayList) {
        this.Field1715 = arrayList;
    }

    public void addBlock(Block block) {
        this.Field1715.add(this.getStringFromBlock(block));
    }

    public void removeBlock(Block block) {
        this.Field1715.remove(this.getStringFromBlock(block));
    }

    public boolean containsBlock(Block block) {
        return this.Field1715.contains(this.getStringFromBlock(block));
    }

    private String getStringFromBlock(Block block) {
        return ((ResourceLocation)Block.REGISTRY.getNameForObject((Object)block)).toString();
    }
}
