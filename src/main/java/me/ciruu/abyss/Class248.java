package me.ciruu.abyss;

import java.util.Objects;
import me.ciruu.abyss.enums.Class246;
import me.ciruu.abyss.modules.exploit.ChunkLogger;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.ChunkPos;

/*
 * Exception performing whole class analysis ignored.
 */
private class Class248 {
    final ChunkPos Field1354;
    final AxisAlignedBB Field666;
    final boolean Field1355;
    boolean Field1356;
    boolean Field1357;
    boolean Field1358;
    boolean Field1359;
    boolean Field1360;
    long Field1361;
    long Field1362;
    int Field1363;
    int Field1364;
    final ChunkLogger Field1365;

    Class248(ChunkLogger chunkLogger, SPacketChunkData sPacketChunkData) {
        this.Field1365 = chunkLogger;
        this.Field1356 = false;
        this.Field1357 = false;
        this.Field1358 = false;
        this.Field1359 = false;
        this.Field1361 = -1L;
        this.Field1363 = 0;
        this.Field1354 = new ChunkPos(sPacketChunkData.getChunkX(), sPacketChunkData.getChunkZ());
        this.Field666 = new AxisAlignedBB((double)this.Field1354.getXStart(), 0.0, (double)this.Field1354.getZStart(), (double)this.Field1354.getXEnd(), 255.0, (double)this.Field1354.getZEnd());
        this.Field1355 = sPacketChunkData.isFullChunk();
        this.Method947(sPacketChunkData);
    }

    void Method947(SPacketChunkData sPacketChunkData) {
        this.Field1360 = sPacketChunkData.isFullChunk();
        if (!this.Field1360) {
            this.Field1356 = true;
        }
        this.Field1362 = this.Field1361;
        this.Field1361 = System.currentTimeMillis();
        if (this.Method1782() != -1L && (float)this.Method1782() <= ((Float)ChunkLogger.Method952(this.Field1365).getValue()).floatValue()) {
            this.Field1357 = true;
        }
        this.Field1364 = this.Field1363;
    }

    long Method1782() {
        return this.Field1362 == -1L ? -1L : this.Field1362 - this.Field1361;
    }

    boolean Method951() {
        switch ((Class246)((Object)ChunkLogger.Method953(this.Field1365).getValue())) {
            case IS_FULL_CHUNK: {
                return this.Field1356;
            }
            case TIMING: {
                return this.Field1357;
            }
        }
        return false;
    }

    public boolean equals(Object object) {
        return object == this || object instanceof Class248 && this.Field1354.x == ((Class248)object).Field1354.x && this.Field1354.z == ((Class248)object).Field1354.z;
    }

    public int hashCode() {
        return Objects.hash(this.Field1354.x, this.Field1354.z);
    }
}
