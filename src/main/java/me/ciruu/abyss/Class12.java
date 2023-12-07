package me.ciruu.abyss;

import java.util.ArrayList;
import java.util.List;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.settings.Setting;

public abstract class Class12 {
    private String Field2870;
    private final Class11 Field2871;
    private final List Field2872 = new ArrayList();

    public Class12(String string, Class11 class11) {
        this.Field2870 = string;
        this.Field2871 = class11;
    }

    public Enum Method3544() {
        return this.Field2871;
    }

    public String Method3545() {
        return this.Field2870;
    }

    public void Method3546(String string) {
        this.Field2870 = string;
    }

    public void Method3547(Setting setting) {
        this.Field2872.add(setting);
    }

    public List Method3548() {
        return this.Field2872;
    }
}
