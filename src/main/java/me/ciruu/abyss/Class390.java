package me.ciruu.abyss;

import java.awt.Color;
import java.util.Random;
import me.ciruu.abyss.Class29;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;

public class Class390 {
    private static final Random Field1283 = new Random();
    private Vector2f Field1284;
    private Vector2f Field1285;
    private float Field1286;
    private float Field1287;
    private int Field1288 = Display.getWidth();
    private int Field1289 = Display.getHeight();
    private Color Field1290;

    public Class390(Vector2f vector2f, float f, float f2, float f3) {
        this.Field1284 = vector2f;
        this.Field1285 = new Vector2f(f, f2);
        this.Field1286 = f3;
    }

    public static Class390 Method1627() {
        Vector2f vector2f = new Vector2f((float)(Math.random() * 2.0 - 1.0), (float)(Math.random() * 2.0 - 1.0));
        float f = Field1283.nextInt(Display.getWidth());
        float f2 = Field1283.nextInt(Display.getHeight());
        float f3 = (float)(Math.random() * 4.0) + 1.0f;
        return new Class390(vector2f, f, f2, f3);
    }

    public float Method1630() {
        return this.Field1287;
    }

    public Vector2f Method1631() {
        return this.Field1284;
    }

    public void Method1632(Vector2f vector2f) {
        this.Field1284 = vector2f;
    }

    public float Method1633() {
        return this.Field1285.getX();
    }

    public void Method1635(float f) {
        this.Field1285.setX(f);
    }

    public float Method1637() {
        return this.Field1285.getY();
    }

    public void Method1639(float f) {
        this.Field1285.setY(f);
    }

    public float Method1641() {
        return this.Field1286;
    }

    public void Method1642(float f) {
        this.Field1286 = f;
    }

    public Color Method1643() {
        return this.Field1290;
    }

    public void Method1644(Color color) {
        this.Field1290 = color;
    }

    public void Method1645(int n, float f) {
        this.Field1285.x += this.Field1284.getX() * (float)n * f;
        this.Field1285.y += this.Field1284.getY() * (float)n * f;
        if (this.Field1287 < 255.0f) {
            this.Field1287 += 0.05f * (float)n;
        }
        if (this.Field1285.getX() > (float)this.Field1288) {
            this.Field1285.setX(0.0f);
        }
        if (this.Field1285.getX() < 0.0f) {
            this.Field1285.setX((float)this.Field1288);
        }
        if (this.Field1285.getY() > (float)this.Field1289) {
            this.Field1285.setY(0.0f);
        }
        if (this.Field1285.getY() < 0.0f) {
            this.Field1285.setY((float)this.Field1289);
        }
    }

    public float Method1646(Class390 class390) {
        return this.Method1647(class390.Method1633(), class390.Method1637());
    }

    public float Method1647(float f, float f2) {
        return (float)Class29.Method1648(this.Method1633(), this.Method1637(), f, f2);
    }

    public void Method1649(int n, int n2) {
        this.Field1288 = n;
        this.Field1289 = n2;
    }
}
