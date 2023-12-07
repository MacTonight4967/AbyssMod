package me.ciruu.abyss;

import me.ciruu.abyss.enums.Class272;
import me.ciruu.abyss.enums.Class274;
import net.minecraft.util.math.AxisAlignedBB;

/*
 * Exception performing whole class analysis ignored.
 */
public static class Class273 {
    private Class274 Field2927;
    private Class272 Field2928;
    private AxisAlignedBB Field2929;

    public Class273() {
        this(Class272.UNBREAKABLE, Class274.NONE);
    }

    public Class273(Class272 class272, Class274 class274) {
        this.Field2927 = class274;
        this.Field2928 = class272;
    }

    public void Method3604(Class274 class274) {
        this.Field2927 = class274;
    }

    public void Method3605(Class272 class272) {
        this.Field2928 = class272;
    }

    public void Method3606(AxisAlignedBB axisAlignedBB) {
        this.Field2929 = axisAlignedBB;
    }

    public Class274 Method1013() {
        return this.Field2927;
    }

    public Class272 Method1014() {
        return this.Field2928;
    }

    public AxisAlignedBB Method1015() {
        return this.Field2929;
    }
}
