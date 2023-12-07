package me.ciruu.abyss;

import org.lwjgl.input.Keyboard;

public class Class207 {
    private int Field695;

    public Class207(int n) {
        this.Field695 = n;
    }

    public int Method592() {
        return this.Field695;
    }

    public void Method977(int n) {
        this.Field695 = n;
    }

    public String toString() {
        return this.Method978(Keyboard.getKeyName((int)this.Field695));
    }

    private String Method978(String string) {
        if (string.isEmpty()) {
            return "";
        }
        return Character.toUpperCase(string.charAt(0)) + (string.length() != 1 ? string.substring(1).toLowerCase() : "");
    }
}
