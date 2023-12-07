package me.ciruu.abyss;

import java.awt.Color;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import me.ciruu.abyss.Class140;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Class137 {
    private int Field2677;
    private int Field2678;
    private int Field2679;
    private int Field2680;

    public final int Method3301() {
        return this.Field2677 + this.Field2679;
    }

    public final int Method1685() {
        return this.Field2678 + this.Field2680;
    }

    public final void Method1686(@NotNull Color color) {
        Class140.Method608(this.Field2677, this.Field2678, this.Field2679, this.Field2680, color.getRGB());
    }

    @Nullable
    public final Pair Method421(int n, int n2, boolean bl) {
        return Class140.Method639(this.Field2677, this.Field2678, this.Field2679, this.Field2680, n, n2, bl);
    }

    public static Pair Method1734(Class137 class137, int n, int n2, boolean bl, int n3, Object object) {
        if ((n3 & 4) != 0) {
            bl = true;
        }
        return class137.Method421(n, n2, bl);
    }

    public final boolean Method1730(int n, int n2) {
        return Class137.Method1734(this, n, n2, false, 4, null) != null;
    }

    public final int Method1677() {
        return this.Field2677;
    }

    public final void Method403(int n) {
        this.Field2677 = n;
    }

    public final int Method1678() {
        return this.Field2678;
    }

    public final void Method405(int n) {
        this.Field2678 = n;
    }

    public final int Method1679() {
        return this.Field2679;
    }

    public final void Method406(int n) {
        this.Field2679 = n;
    }

    public final int Method1676() {
        return this.Field2680;
    }

    public final void Method407(int n) {
        this.Field2680 = n;
    }

    public Class137(int n, int n2, int n3, int n4) {
        this.Field2677 = n;
        this.Field2678 = n2;
        this.Field2679 = n3;
        this.Field2680 = n4;
    }

    public Class137(int n, int n2, int n3, int n4, int n5, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n5 & 1) != 0) {
            n = 0;
        }
        if ((n5 & 2) != 0) {
            n2 = 0;
        }
        if ((n5 & 4) != 0) {
            n3 = 0;
        }
        if ((n5 & 8) != 0) {
            n4 = 0;
        }
        this(n, n2, n3, n4);
    }

    public Class137() {
        this(0, 0, 0, 0, 15, null);
    }

    public final int Method3303() {
        return this.Field2677;
    }

    public final int Method3304() {
        return this.Field2678;
    }

    public final int Method3305() {
        return this.Field2679;
    }

    public final int Method3306() {
        return this.Field2680;
    }

    @NotNull
    public final Class137 Method3307(int n, int n2, int n3, int n4) {
        return new Class137(n, n2, n3, n4);
    }

    public static Class137 Method3308(Class137 class137, int n, int n2, int n3, int n4, int n5, Object object) {
        if ((n5 & 1) != 0) {
            n = class137.Field2677;
        }
        if ((n5 & 2) != 0) {
            n2 = class137.Field2678;
        }
        if ((n5 & 4) != 0) {
            n3 = class137.Field2679;
        }
        if ((n5 & 8) != 0) {
            n4 = class137.Field2680;
        }
        return class137.Method3307(n, n2, n3, n4);
    }

    @NotNull
    public String toString() {
        return "Box(x=" + this.Field2677 + ", y=" + this.Field2678 + ", width=" + this.Field2679 + ", height=" + this.Field2680 + ")";
    }

    public int hashCode() {
        return ((this.Field2677 * 31 + this.Field2678) * 31 + this.Field2679) * 31 + this.Field2680;
    }

    public boolean equals(@Nullable Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof Class137)) break block3;
                Class137 class137 = (Class137)object;
                if (!(this.Field2677 == class137.Field2677) || !(this.Field2678 == class137.Field2678) || !(this.Field2679 == class137.Field2679) || !(this.Field2680 == class137.Field2680)) break block3;
            }
            return true;
        }
        return false;
    }
}
