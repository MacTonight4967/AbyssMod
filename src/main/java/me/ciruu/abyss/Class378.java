package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.MinecraftEvent;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class Class378
extends MinecraftEvent {
    public BlockPos Field1243;
    public EnumFacing Field1244;

    public Class378(Class53 class53, BlockPos blockPos, EnumFacing enumFacing) {
        this.Method1589(class53);
        this.Field1243 = blockPos;
        this.Field1244 = enumFacing;
    }
}
