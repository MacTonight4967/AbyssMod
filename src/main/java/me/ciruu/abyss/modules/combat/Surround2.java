package me.ciruu.abyss.modules.combat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import me.ciruu.abyss.Class155;
import me.ciruu.abyss.Class22;
import me.ciruu.abyss.Class31;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.events.player.EventPlayerUpdate;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class Surround2
extends Module {
    private final Setting delay = new Setting("Delay", "", (Module)this, (Object)50, 0, 250);
    private final Setting blockspertick = new Setting("BlocksPerTick", "", (Module)this, (Object)10, 0, 20);
    private final Setting monkeylanguage = new Setting("EncimaDeEChest", "", this, true);
    private final Setting toggleoffground = new Setting("ToggleOffGround", "ToggleOffGround", this, true);
    private final Setting anticity = new Setting("AntiCity", "", this, false);
    private final Setting extender = new Setting("Extender", "", (Module)this, (Object)1, 0, 4);
    private final Setting echest = new Setting("E-Chest", "", this, true);
    private final Setting retryer = new Setting("Retryer", "", (Module)this, (Object)4, 1, 15);
    private final Class22 Field3112 = new Class22();
    private final Class22 Field3113 = new Class22();
    private boolean Field3114 = false;
    private int Field3115 = 0;
    private final Set Field3116 = new HashSet();
    private int Field3117 = 1;
    private int Field3118 = -1;
    public static boolean Field3119 = false;
    private final Map Field3120 = new HashMap();
    private double Field3121;
    @EventHandler
    private Listener Field3122 = new Listener<EventPlayerUpdate>(this::Method3747, new Predicate[0]);

    public Surround2() {
        super("Surround2", "Surrounn2", Class11.COMBAT);
        this.Method3748(this.toggleoffground);
        this.Method3748(this.delay);
        this.Method3748(this.blockspertick);
        this.Method3748(this.retryer);
        this.Method3748(this.echest);
        this.Method3748(this.anticity);
        this.Method3748(this.extender);
    }

    public void Method3749() {
        super.Method13();
        this.Field3121 = Globals.mc.player.posY;
        this.Field3120.clear();
        this.Field3113.Method47();
    }

    public void Method3750() {
        Field3119 = false;
    }

    public static Vec3d[] Method3751(Entity entity, int n) {
        List list = Class31.Method1297(entity, n);
        Vec3d[] vec3dArray = new Vec3d[list.size()];
        return list.toArray(vec3dArray);
    }

    private void Method3752() {
        if (this.Field3116.size() == 2 && this.Field3117 < (Integer)this.extender.getValue()) {
            Vec3d[] vec3dArray = new Vec3d[2];
            int n = 0;
            Iterator iterator = this.Field3116.iterator();
            while (iterator.hasNext()) {
                Vec3d vec3d;
                vec3dArray[n] = vec3d = (Vec3d)iterator.next();
                ++n;
            }
            int n2 = this.Field3115;
            if (this.Method3753(vec3dArray) != null) {
                this.Method3755(this.Method3753(vec3dArray), Surround2.Method3754(this.Method3753(vec3dArray), 0), (Boolean)this.monkeylanguage.getValue(), false, true);
            }
            if (n2 < this.Field3115) {
                this.Field3116.clear();
            }
        } else if (this.Field3116.size() > 2 || this.Field3117 >= (Integer)this.extender.getValue()) {
            this.Field3116.clear();
        }
    }

    public static Vec3d[] Method3754(Vec3d vec3d, int n) {
        List list = Class31.Method1295(vec3d, n);
        Vec3d[] vec3dArray = new Vec3d[list.size()];
        return list.toArray(vec3dArray);
    }

    private Vec3d Method3753(Vec3d[] vec3dArray) {
        int n = 0;
        for (Vec3d vec3d : vec3dArray) {
            for (Vec3d vec3d2 : Surround2.Method3751((Entity)Globals.mc.player, 0)) {
                if (!vec3d.equals((Object)vec3d2)) continue;
                ++n;
            }
        }
        if (n == 2) {
            return Globals.mc.player.getPositionVector().add(vec3dArray[0].add(vec3dArray[1]));
        }
        return null;
    }

    private boolean Method3755(Vec3d vec3d, Vec3d[] vec3dArray, boolean bl, boolean bl2, boolean bl3) {
        int n = 0;
        int n2 = Globals.mc.player.inventory.currentItem;
        Objects.requireNonNull(Globals.mc.getConnection()).sendPacket((Packet)new CPacketHeldItemChange(this.Field3118));
        block6: for (Vec3d vec3d2 : vec3dArray) {
            boolean bl4 = true;
            if (bl2 && ++n > 1) {
                return false;
            }
            BlockPos blockPos = new BlockPos(vec3d).add(vec3d2.x, vec3d2.y, vec3d2.z);
            switch (Class31.Method533(blockPos, true)) {
                case -1: {
                    continue block6;
                }
                case 1: {
                    if (this.Field3120.get(blockPos) == null || (Integer)this.Field3120.get(blockPos) < (Integer)this.retryer.getValue()) {
                        this.Method3756(blockPos);
                        this.Field3120.put(blockPos, this.Field3120.get(blockPos) == null ? 1 : (Integer)this.Field3120.get(blockPos) + 1);
                        this.Field3113.Method47();
                        continue block6;
                    }
                    if ((Integer)this.extender.getValue() <= 0 || bl3 || this.Field3117 >= (Integer)this.extender.getValue()) continue block6;
                    this.Method3755(Globals.mc.player.getPositionVector().add(vec3d2), Surround2.Method3754(Globals.mc.player.getPositionVector().add(vec3d2), 0), bl, false, true);
                    this.Field3116.add(vec3d2);
                    ++this.Field3117;
                    continue block6;
                }
                case 2: {
                    if (!bl) continue block6;
                    bl4 = this.Method3755(vec3d, Class31.Method1267(vec3d2), false, true, true);
                }
                case 3: {
                    if (bl4) {
                        this.Method3756(blockPos);
                    }
                    if (!bl2) continue block6;
                    return true;
                }
            }
        }
        Globals.mc.getConnection().sendPacket((Packet)new CPacketHeldItemChange(n2));
        return false;
    }

    private boolean Method3757() {
        Field3119 = false;
        this.Field3114 = false;
        this.Field3117 = 1;
        this.Field3115 = 0;
        this.Field3118 = Class155.Method3000(Blocks.OBSIDIAN);
        int n = Class155.Method3000(Blocks.ENDER_CHEST);
        if (!this.Method3758()) {
            return true;
        }
        if (((Boolean)this.toggleoffground.getValue()).booleanValue() && Globals.mc.player.posY > this.Field3121) {
            this.Method3759();
            Globals.printChatMessage("Toggling, you are off ground!");
            return true;
        }
        if (this.Field3113.Method2131(100L)) {
            this.Field3120.clear();
            this.Field3113.Method47();
        }
        if (this.Field3118 == -1) {
            this.Field3118 = n;
            if (!((Boolean)this.echest.getValue()).booleanValue() || n == -1) {
                Globals.printChatMessage("You don't have obsidian in your hotbar! Toggling.");
                this.Method3759();
                return true;
            }
        }
        return !this.Field3112.Method2131(((Integer)this.delay.getValue()).intValue());
    }

    private void Method3756(BlockPos blockPos) {
        if (this.Field3115 < (Integer)this.blockspertick.getValue()) {
            Field3119 = true;
            Class31.Method541(blockPos, false, false, false);
            this.Field3114 = true;
            ++this.Field3115;
        }
    }

    private void Method3747(EventPlayerUpdate eventPlayerUpdate) {
        boolean bl = false;
        if (Globals.mc.player.posY < (double)Math.round(Globals.mc.player.posY)) {
            bl = true;
        }
        if (this.Method3757()) {
            return;
        }
        if (Globals.mc.player.posY - (double)((int)Globals.mc.player.posY) < 0.7) {
            bl = false;
        }
        if (!Class31.Method1298((Entity)Globals.mc.player, bl ? 1 : 0)) {
            this.Method3755(Globals.mc.player.getPositionVector(), Surround2.Method3751((Entity)Globals.mc.player, bl ? 1 : 0), (Boolean)this.monkeylanguage.getValue(), false, false);
        } else if (!Class31.Method1298((Entity)Globals.mc.player, bl ? 0 : -1) && ((Boolean)this.anticity.getValue()).booleanValue()) {
            this.Method3755(Globals.mc.player.getPositionVector(), Surround2.Method3751((Entity)Globals.mc.player, bl ? 0 : -1), false, false, true);
        }
        this.Method3752();
        if (this.Field3114) {
            this.Field3112.Method47();
        }
    }
}
