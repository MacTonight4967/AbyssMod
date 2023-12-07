package me.ciruu.abyss;

public class Class113 {
    private Long Field2912;
    private Long Field2913;
    private float Field2914;
    private float Field2915;

    public Class113(Long l, float f, float f2) {
        this.Field2913 = l;
        this.Field2914 = f;
        this.Field2915 = f2;
        this.Field2912 = System.currentTimeMillis();
    }

    public float Method264() {
        if (this.Field2915 - this.Field2914 == 0.0f) {
            return this.Field2915;
        }
        float f = this.Field2914 + (float)(System.currentTimeMillis() - this.Field2912) * ((float)this.Field2913.longValue() / (this.Field2915 - this.Field2914));
        return this.Field2915 > this.Field2914 ? Math.min(f, this.Field2915) : Math.max(f, this.Field2915);
    }

    public boolean Method261() {
        return this.Method264() == this.Field2915;
    }
}
