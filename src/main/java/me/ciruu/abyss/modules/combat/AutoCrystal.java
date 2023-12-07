package me.ciruu.abyss.modules.combat;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import me.ciruu.abyss.Class152;
import me.ciruu.abyss.Class155;
import me.ciruu.abyss.Class202;
import me.ciruu.abyss.Class22;
import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Class29;
import me.ciruu.abyss.Class30;
import me.ciruu.abyss.Class308;
import me.ciruu.abyss.Class31;
import me.ciruu.abyss.Class352;
import me.ciruu.abyss.Class353;
import me.ciruu.abyss.Class354;
import me.ciruu.abyss.Class50;
import me.ciruu.abyss.Class66;
import me.ciruu.abyss.Class67;
import me.ciruu.abyss.Class84;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class158;
import me.ciruu.abyss.enums.Class159;
import me.ciruu.abyss.enums.Class252;
import me.ciruu.abyss.enums.Class45;
import me.ciruu.abyss.enums.Class460;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.enums.Class577;
import me.ciruu.abyss.enums.Class649;
import me.ciruu.abyss.enums.Class659;
import me.ciruu.abyss.events.network.EventNetworkPostPacketEvent;
import me.ciruu.abyss.events.network.EventNetworkPrePacketEvent;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.modules.combat.Burrow;
import me.ciruu.abyss.modules.combat.HoleFiller;
import me.ciruu.abyss.modules.combat.KillAura;
import me.ciruu.abyss.modules.combat.WebFill;
import me.ciruu.abyss.modules.hud.CrystalCounter;
import me.ciruu.abyss.modules.misc.AutoEz;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemEndCrystal;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.network.play.server.SPacketSpawnObject;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/*
 * Illegal identifiers - recommend switching to table mode
 */
public class AutoCrystal
extends Module {
    public static final Object Field3272 = new Object();
    private final Setting mainwindow = new Setting("Main", "", this, new Class25("Main Settings"));
    private final Setting sswitch = new Setting("Switch", "", this, (Object)Class649.Target);
    private final Setting rotate = new Setting("Rotate", "Rotate", this, (Object)Class159.Off);
    private final Setting strict = new Setting("Strict", "", (Module)this, (Object)false, this.mainwindow, this::Method3942);
    private final Setting target = new Setting("Target", "", this, (Object)Class659.Damage);
    private final Setting targetrange = new Setting("TargetRange", "", (Module)this, (Object)Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(16.0f));
    private final Setting pauseeating = new Setting("PauseEating", "Pause While Eating", this, false);
    private final Setting nosounddesync = new Setting("NoSoundDesync", "No Sound Desync", this, false);
    private final Setting swing = new Setting("Swing", "", this, (Object)Class158.Auto);
    private final Setting metadata = new Setting("Metadata", "", this, (Object)Class45.Target);
    private final Setting placewindow = new Setting("Place Settings", "", this, new Class25("Place Settings"));
    private final Setting place = new Setting("Place", "Place crystals", (Module)this, (Object)true, this.placewindow, AutoCrystal::Method3943);
    public final Setting placerange = new Setting("PlaceRange", "Place Range", this, Float.valueOf(6.0f), Float.valueOf(0.0f), Float.valueOf(6.0f), this.placewindow, this.place::getValue);
    private final Setting faceplace = new Setting("FacePlace", "FacePlace", this, Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(37.0f), this.placewindow, this.place::getValue);
    private final Setting armorbreaker = new Setting("ArmourBreaker", "", this, 0, 0, 100, this.placewindow, this.place::getValue);
    public final Setting 1_13mode = new Setting("1.13", "1.13 mode", (Module)this, (Object)false, this.placewindow, this.place::getValue);
    private final Setting breakwindow = new Setting("Break Settings", "", this, new Class25("Break Settings"));
    private final Setting bbreak = new Setting("Break", "Break crystals", (Module)this, (Object)true, this.breakwindow, AutoCrystal::Method3944);
    public final Setting breakrange = new Setting("BreakRange", "Break Range", this, Float.valueOf(6.0f), Float.valueOf(0.0f), Float.valueOf(6.0f), this.breakwindow, this.bbreak::getValue);
    private final Setting instabreak = new Setting("InstaBreak", "", (Module)this, (Object)false, this.breakwindow, AutoCrystal::Method3945);
    private final Setting timer = new Setting("Timer", "InstaBreak Delay (MS)", this, Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1000.0f), this.breakwindow, this::Method3946);
    private final Setting cancel = new Setting("Cancel", "", (Module)this, (Object)false, this.breakwindow, this::Method3947);
    private final Setting damagewindow = new Setting("Damage Settings", "", this, new Class25("Damage Settings"));
    private final Setting nosuicide = new Setting("NoSuicide", "", (Module)this, (Object)true, this.damagewindow, AutoCrystal::Method3948);
    private final Setting mindamage = new Setting("MinDamage", "MinDamage", this, Float.valueOf(6.0f), Float.valueOf(0.1f), Float.valueOf(20.0f), this.damagewindow, AutoCrystal::Method3949);
    private final Setting ignoreselfdamage = new Setting("IgnoreSelfDMG", "", (Module)this, (Object)false, this.damagewindow, AutoCrystal::Method3950);
    private final Setting maxselfdamage = new Setting("MaxSelfDMG", "Maximum self damage", this, Float.valueOf(9.0f), Float.valueOf(0.0f), Float.valueOf(20.0f), this.damagewindow, this::Method3951);
    private final Setting raytracewindow = new Setting("Raytrace Settings", "", this, new Class25("Raytrace Settings"));
    private final Setting Field3299 = new Setting("", "", (Module)this, (Object)Class460.Auto, this.raytracewindow, AutoCrystal::Method3952);
    private final Setting placetrace = new Setting("PlaceTrace", "", this, Float.valueOf(3.0f), Float.valueOf(0.0f), Float.valueOf(6.0f), this.raytracewindow, this::Method3953);
    private final Setting breaktrace = new Setting("BreakTrace", "", this, Float.valueOf(3.0f), Float.valueOf(0.0f), Float.valueOf(6.0f), this.raytracewindow, this::Method3954);
    private final Setting placecheck = new Setting("PlaceCheck", "Only will place crystals that the player can break", (Module)this, (Object)false, this.raytracewindow, this::Method3955);
    private final Setting packetpos = new Setting("PacketPos", "", (Module)this, (Object)false, this.raytracewindow, this::Method3956);
    private final Setting recalc = new Setting("Recalc", "", (Module)this, (Object)true, this.raytracewindow, this::Method3957);
    private final Setting RPlaceTrace = new Setting("RPlaceTrace", "", this, Float.valueOf(3.0f), Float.valueOf(0.0f), Float.valueOf(6.0f), this.raytracewindow, this::Method3958);
    private final Setting RMinDamage = new Setting("RMinDamage", "", this, Float.valueOf(6.0f), Float.valueOf(0.1f), Float.valueOf(20.0f), this.raytracewindow, this::Method3959);
    private final Setting delaywindow = new Setting("Delay Settings", "", this, new Class25("Delay Settings"));
    private final Setting delaymode = new Setting("DelayMode", "", (Module)this, (Object)Class252.Ticks, this.delaywindow, AutoCrystal::Method3960);
    private final Setting placetimer = new Setting("PlaceTimer", "Place Delay (MS)", this, Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1000.0f), this.delaywindow, this::Method3961);
    private final Setting breaktimer = new Setting("BreakTimer", "Break Delay (MS)", this, Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1000.0f), this.delaywindow, this::Method3962);
    private final Setting placeticks = new Setting("PlaceTicks", "", this, 0, 0, 10, this.delaywindow, this::Method3963);
    private final Setting breakticks = new Setting("BreakTicks", "", this, 0, 0, 10, this.delaywindow, this::Method3964);
    private final Setting renderwindow = new Setting("Render Settings", "", this, new Class25("Render Settings"));
    private final Setting render = new Setting("Render", "Render", (Module)this, (Object)true, this.renderwindow, AutoCrystal::Method3965);
    private final Setting renderbox;
    private final Setting renderfade;
    private final Setting fadeticks;
    private final Setting renderbox = new Setting("RenderBox", "RenderBox", (Module)this, (Object)Class577.FullBox, this.renderwindow, this::Method3966);
    private final Setting renderoutline;
    private final Setting rendertext;
    private final Setting rendertextcolor;
    private final Setting renderrainbow;
    private final Setting rendergradient;
    private final Setting renderdelta;
    private final Setting boxcolor;
    private final Setting boxcolor2;
    private final Setting renderlinewidth;
    private final Setting rendercustomline;
    private final Setting outlinecolor;
    private final Setting outlinecolor2;
    private final Setting renderspeed;
    private final Setting rendersaturation;
    private final Setting renderbrightness;
    private List Field3334;
    public EntityPlayer Field70 = null;
    public BlockPos Field68 = null;
    private float Field3335 = 0.0f;
    public boolean Field3336 = false;
    public BlockPos Field69;
    private double[] Field3337;
    public Vec3d Field3338;
    public boolean Field66 = false;
    private final HashMap Field3339;
    private int Field3340 = 0;
    private Class22 Field3341;
    private int Field3342 = 0;
    private int Field3343 = 0;
    private final Class22 Field3344;
    private final Class22 Field3345;
    private final Class22 Field3346;
    private Vec3d Field3347;
    private int Field3348 = -1;
    @EventHandler
    private Listener Field3349;
    @EventHandler
    private Listener Field3350;
    @EventHandler
    private Listener Field3351;
    @EventHandler
    private Listener Field3352;
    @EventHandler
    private Listener Field3353;
    @EventHandler
    private Listener Field3354;

    public AutoCrystal() {
        super("AutoCrystal", "Attacks nearby players by placing and breaking end crystals.", Class11.COMBAT);
        this.renderfade = new Setting("Fade", "", (Module)this, (Object)false, this.renderwindow, this::Method3967);
        this.fadeticks = new Setting("FadeTicks", "", this, 20, 1, 40, this.renderwindow, this.renderfade::getValue);
        this.renderbox = new Setting("Box", "Box", (Module)this, (Object)true, this.renderwindow, this::Method3968);
        this.renderoutline = new Setting("Outline", "Outline", (Module)this, (Object)true, this.renderwindow, this::Method3969);
        this.rendertext = new Setting("Text", "Text", (Module)this, (Object)true, this.renderwindow, this::Method3970);
        this.rendertextcolor = new Setting("TextColor", "", (Module)this, (Object)Color.WHITE, this.renderwindow, this::Method3971);
        this.renderrainbow = new Setting("Rainbow", "", (Module)this, (Object)true, this.renderwindow, this.render::getValue);
        this.rendergradient = new Setting("Gradient", "", (Module)this, (Object)true, this.renderwindow, this::Method3972);
        this.renderdelta = new Setting("Delta", "", this, Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), this.renderwindow, this::Method3973);
        this.boxcolor = new Setting("BoxColor", "Box color", (Module)this, (Object)new Color(0, 0, 0, 125), this.renderwindow, this::Method3974);
        this.boxcolor2 = new Setting("BoxColor2", "Box color", (Module)this, (Object)new Color(0, 0, 0, 125), this.renderwindow, this::Method3975);
        this.renderlinewidth = new Setting("LineWidth", "LineWidth", this, Float.valueOf(1.5f), Float.valueOf(0.1f), Float.valueOf(5.0f), this.renderwindow, this::Method3976);
        this.rendercustomline = new Setting("CustomLine", "CustomLine", (Module)this, (Object)true, this.renderwindow, this::Method3977);
        this.outlinecolor = new Setting("OutLinecolor", "OutLine color", (Module)this, (Object)new Color(0, 0, 0, 255), this.renderwindow, this::Method3978);
        this.outlinecolor2 = new Setting("OutLinecolor2", "OutLine color", (Module)this, (Object)new Color(0, 0, 0, 255), this.renderwindow, this::Method3979);
        this.renderspeed = new Setting("Speed", "", this, Float.valueOf(7.0f), Float.valueOf(0.1f), Float.valueOf(10.0f), this.renderwindow, this::Method3980);
        this.rendersaturation = new Setting("Saturation", "", this, Float.valueOf(0.5f), Float.valueOf(0.0f), Float.valueOf(1.0f), this.renderwindow, this::Method3981);
        this.renderbrightness = new Setting("Brightness", "", this, Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), this.renderwindow, this::Method3982);
        this.Field3334 = new ArrayList();
        this.Field3337 = new double[2];
        this.Field3338 = new Vec3d(0.0, 0.0, 0.0);
        this.Field3339 = new HashMap();
        this.Field3341 = new Class22();
        this.Field3344 = new Class22();
        this.Field3345 = new Class22();
        this.Field3346 = new Class22();
        this.Field3347 = new Vec3d(0.0, 0.0, 0.0);
        this.Field3349 = new Listener<EventPlayerUpdateWalking>(this::Method3983, new Predicate[0]);
        this.Field3350 = new Listener<Class66>(this::Method3984, 5000, new Predicate[0]);
        this.Field3351 = new Listener<EventNetworkPrePacketEvent>(this::Method3985, new Predicate[0]);
        this.Field3352 = new Listener<EventNetworkPrePacketEvent>(this::Method3986, 3000, new Predicate[0]);
        this.Field3353 = new Listener<EventPlayerUpdateWalking>(this::Method3987, new Predicate[0]);
        this.Field3354 = new Listener<EventNetworkPostPacketEvent>(this::Method3988, new Predicate[0]);
        this.Method3989(this.sswitch);
        this.Method3989(this.rotate);
        this.Method3989(this.strict);
        this.Method3989(this.target);
        this.Method3989(this.targetrange);
        this.Method3989(this.pauseeating);
        this.Method3989(this.nosounddesync);
        this.Method3989(this.swing);
        this.Method3989(this.metadata);
        this.Method3989(this.placewindow);
        this.Method3989(this.place);
        this.Method3989(this.placerange);
        this.Method3989(this.faceplace);
        this.Method3989(this.armorbreaker);
        this.Method3989(this.1_13mode);
        this.Method3989(this.breakwindow);
        this.Method3989(this.bbreak);
        this.Method3989(this.breakrange);
        this.Method3989(this.instabreak);
        this.Method3989(this.timer);
        this.Method3989(this.cancel);
        this.Method3989(this.damagewindow);
        this.Method3989(this.nosuicide);
        this.Method3989(this.mindamage);
        this.Method3989(this.ignoreselfdamage);
        this.Method3989(this.maxselfdamage);
        this.Method3989(this.raytracewindow);
        this.Method3989(this.Field3299);
        this.Method3989(this.placetrace);
        this.Method3989(this.breaktrace);
        this.Method3989(this.placecheck);
        this.Method3989(this.packetpos);
        this.Method3989(this.recalc);
        this.Method3989(this.RPlaceTrace);
        this.Method3989(this.RMinDamage);
        this.Method3989(this.delaywindow);
        this.Method3989(this.delaymode);
        this.Method3989(this.placetimer);
        this.Method3989(this.breaktimer);
        this.Method3989(this.placeticks);
        this.Method3989(this.breakticks);
        this.Method3989(this.renderwindow);
        this.Method3989(this.renderbox);
        this.Method3989(this.render);
        this.Method3989(this.renderfade);
        this.Method3989(this.fadeticks);
        this.Method3989(this.renderbox);
        this.Method3989(this.renderoutline);
        this.Method3989(this.rendertext);
        this.Method3989(this.rendertextcolor);
        this.Method3989(this.rendergradient);
        this.Method3989(this.renderdelta);
        this.Method3989(this.boxcolor);
        this.Method3989(this.boxcolor2);
        this.Method3989(this.renderlinewidth);
        this.Method3989(this.rendercustomline);
        this.Method3989(this.outlinecolor);
        this.Method3989(this.outlinecolor2);
        this.Method3989(this.renderrainbow);
        this.Method3989(this.renderspeed);
        this.Method3989(this.rendersaturation);
        this.Method3989(this.renderbrightness);
    }

    public void Method3990() {
        super.Method13();
        if (Manager.moduleManager.isModuleEnabled(KillAura.class) && ((Boolean)((KillAura)Manager.moduleManager.getModuleByClass(KillAura.class)).toggleOnAutoCrystal.getValue()).booleanValue()) {
            ((KillAura)Manager.moduleManager.getModuleByClass(KillAura.class)).Method3991();
        }
        this.Field3340 = 20;
    }

    public void Method3992() {
        super.Method15();
        Object object = Field3272;
        synchronized (object) {
            this.Field3339.clear();
        }
    }

    public void Method3993(boolean bl) {
        if (this.Method3859()) {
            this.Method3994(false);
            this.Method3992();
        }
    }

    public String Method3995() {
        return this.Method3996();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean Method3997(BlockPos blockPos) {
        Object object = Field3272;
        synchronized (object) {
            if (this.Field3339.get(blockPos) == null) return false;
            return true;
        }
    }

    private void Method3998() {
        if (!this.Method3999()) {
            return;
        }
        this.Method4000();
        this.Field70 = this.Method4001();
        this.Method4002();
        this.Method4003();
        this.Method4004();
        if (this.Field70 != null) {
            AutoEz.Method1512(this.Field70.getName());
        }
    }

    private boolean Method3999() {
        if (Globals.mc.player == null || Globals.mc.world == null) {
            return false;
        }
        if (this.sswitch.getValue() == Class649.Always) {
            if (Class30.Method2776((EntityPlayer)Globals.mc.player)) {
                return true;
            }
            Class155.Method1491(ItemEndCrystal.class, false);
        }
        if (this.sswitch.getValue() == Class649.None && !Class30.Method2776((EntityPlayer)Globals.mc.player)) {
            return false;
        }
        if (Manager.moduleManager.isModuleEnabled(HoleFiller.class) || Class152.Field1104 || Class152.Field1105 || ((Boolean)this.pauseeating.getValue()).booleanValue() && this.Method4005() || WebFill.Field2425 || Manager.moduleManager.isModuleEnabled(Burrow.class)) {
            this.Field66 = true;
            return false;
        }
        this.Field66 = false;
        return true;
    }

    private boolean Method4005() {
        return Globals.mc.player.getHeldItemMainhand().getItem() instanceof ItemAppleGold && Globals.mc.player.isHandActive();
    }

    private void Method4000() {
        this.Field3334 = Class308.Method2664(((Float)this.placerange.getValue()).floatValue(), (Boolean)this.1_13mode.getValue());
    }

    private EntityPlayer Method4001() {
        Object object = null;
        if (this.target.getValue() == Class659.Closest) {
            for (Object object2 : Globals.mc.world.playerEntities) {
                if (Class30.Method749((Entity)object2, ((Float)this.targetrange.getValue()).floatValue())) continue;
                if (object == null) {
                    object = object2;
                    continue;
                }
                if (!(Globals.mc.player.getDistanceSq((Entity)object2) < Globals.mc.player.getDistanceSq((Entity)object))) continue;
                object = object2;
            }
        }
        if (this.target.getValue() == Class659.Damage) {
            float f = 0.0f;
            for (EntityPlayer entityPlayer : Globals.mc.world.playerEntities) {
                float f2;
                if (Class30.Method749((Entity)entityPlayer, ((Float)this.targetrange.getValue()).floatValue()) || !((f2 = this.Method4006(entityPlayer)) > f)) continue;
                f = f2;
                object = entityPlayer;
            }
        }
        return object;
    }

    private float Method4006(EntityPlayer entityPlayer) {
        float f = 0.5f;
        for (BlockPos blockPos : this.Field3334) {
            float f2;
            float f3;
            if (!Class31.Method1223(blockPos, Globals.mc.player.getDistanceSq(blockPos) > Class29.Method114(this.Field3299.getValue() == Class460.Auto ? 6.0 : (double)((Float)this.placetrace.getValue()).floatValue()), 1.0f) || !((double)(f3 = Class352.Method1510(blockPos, (Entity)Globals.mc.player)) + 0.5 < (double)Class30.Method1454((Entity)Globals.mc.player)) && ((Boolean)this.nosuicide.getValue()).booleanValue() || !((Boolean)this.ignoreselfdamage.getValue()).booleanValue() && !(f3 < ((Float)this.maxselfdamage.getValue()).floatValue()) || !((f2 = Class352.Method1510(blockPos, (Entity)entityPlayer)) >= ((Float)this.mindamage.getValue()).floatValue()) && !(f2 > Class30.Method1454((Entity)this.Field70)) && (!(Class30.Method1454((Entity)entityPlayer) < ((Float)this.faceplace.getValue()).floatValue()) || !(f2 >= 2.0f)) || !(f2 > f)) continue;
            f = f2;
        }
        return f;
    }

    private void Method4007() {
        if (this.Field70 != null && !Class30.Method2776((EntityPlayer)Globals.mc.player)) {
            int n;
            if (this.sswitch.getValue() == Class649.Target) {
                Class155.Method1491(ItemEndCrystal.class, false);
            }
            if (this.sswitch.getValue() == Class649.Silent && (n = Class155.Method544(ItemEndCrystal.class)) != -1) {
                this.Field3348 = Globals.mc.player.inventory.currentItem;
                Globals.mc.player.inventory.currentItem = n;
                Globals.mc.playerController.updateController();
            }
        }
    }

    private void Method4008() {
        int n;
        if (this.sswitch.getValue() == Class649.Silent && Globals.mc.player.getHeldItemOffhand().getItem() != Items.END_CRYSTAL && (n = Class155.Method544(ItemEndCrystal.class)) != -1 && this.Field3348 != -1) {
            Globals.mc.player.inventory.currentItem = this.Field3348;
            Globals.mc.playerController.updateController();
        }
    }

    private void Method4002() {
        boolean bl;
        if (!((Boolean)this.bbreak.getValue()).booleanValue() || this.Field3336 || this.Field3343 < (Integer)this.breakticks.getValue() && this.delaymode.getValue() == Class252.Ticks || !this.Field3345.Method50(((Float)this.breaktimer.getValue()).longValue()) && this.delaymode.getValue() == Class252.Timer) {
            return;
        }
        float f = 0.0f;
        EntityEnderCrystal entityEnderCrystal = null;
        boolean bl2 = bl = (this.Field3299.getValue() == Class460.Auto || (Boolean)this.placecheck.getValue() != false) && (Boolean)this.recalc.getValue() != false;
        if (((Boolean)this.bbreak.getValue()).booleanValue() && this.Field70 != null) {
            for (Entity entity : Globals.mc.world.loadedEntityList) {
                if (!this.Method4009(entity)) continue;
                float f2 = Class352.Method1469(entity, (Entity)this.Field70);
                float f3 = Class352.Method1469(entity, (Entity)Globals.mc.player);
                if ((f2 < ((Float)this.mindamage.getValue()).floatValue() && !bl || bl && f2 < ((Float)this.RMinDamage.getValue()).floatValue()) && Class30.Method1454((Entity)this.Field70) > ((Float)this.faceplace.getValue()).floatValue() || Class30.Method1454((Entity)this.Field70) < ((Float)this.faceplace.getValue()).floatValue() && f2 < 1.0f || f3 >= ((Float)this.maxselfdamage.getValue()).floatValue() && !((Boolean)this.ignoreselfdamage.getValue()).booleanValue() || !(f2 > f)) continue;
                f = f2;
                entityEnderCrystal = (EntityEnderCrystal)entity;
            }
            if (entityEnderCrystal != null) {
                this.Method4010((Entity)entityEnderCrystal);
                this.Method4011(entityEnderCrystal);
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean Method4009(Entity entity) {
        if (!(entity instanceof EntityEnderCrystal)) return false;
        if (!(Globals.mc.player.getDistanceSq(entity) <= Class29.Method114(((Float)this.breakrange.getValue()).floatValue()))) return false;
        if (Globals.mc.player.canEntityBeSeen(entity)) return true;
        if (Globals.mc.player.canEntityBeSeen(entity)) return false;
        double d = Globals.mc.player.getDistanceSq(entity);
        double d2 = this.Field3299.getValue() == Class460.Auto ? 3.0 : (double)((Float)this.breaktrace.getValue()).floatValue();
        if (!(d <= Class29.Method114(d2))) return false;
        return true;
    }

    private void Method4010(Entity entity) {
        switch ((Class159)((Object)this.rotate.getValue())) {
            case Off: {
                break;
            }
            case Break: 
            case All: {
                this.Field3337 = Class354.Method1505(entity.posX + 0.5, entity.posY - 0.5, entity.posZ + 0.5, (EntityPlayer)Globals.mc.player);
                this.Field3341.Method47();
            }
        }
    }

    private void Method4011(EntityEnderCrystal entityEnderCrystal) {
        Globals.mc.player.connection.sendPacket((Packet)new CPacketUseEntity((Entity)entityEnderCrystal));
        Globals.mc.player.swingArm(this.Method4012());
        this.Field3343 = 0;
        this.Field3345.Method47();
    }

    private void Method4003() {
        Object object;
        if (this.Field70 == null || !((Boolean)this.place.getValue()).booleanValue() || this.Field3342 < (Integer)this.placeticks.getValue() && this.delaymode.getValue() == Class252.Ticks || !this.Field3344.Method50(((Float)this.placetimer.getValue()).longValue()) && this.delaymode.getValue() == Class252.Timer) {
            return;
        }
        float f = 0.5f;
        BlockPos blockPos = null;
        this.Field68 = null;
        for (BlockPos blockPos2 : this.Field3334) {
            float f2;
            float f3;
            if (!Class31.Method1223(blockPos2, Globals.mc.player.getDistanceSq(blockPos2) > Class29.Method114(this.Field3299.getValue() == Class460.Auto ? 6.0 : (double)((Float)this.placetrace.getValue()).floatValue()), 1.0f)) continue;
            if (this.Field3299.getValue() == Class460.Manual && ((Boolean)this.placecheck.getValue()).booleanValue() || this.Field3299.getValue() == Class460.Auto) {
                boolean bl;
                EntityEnderCrystal entityEnderCrystal = new EntityEnderCrystal((World)Globals.mc.world, (double)((float)blockPos2.getX() + 0.5f), (double)(blockPos2.getY() + 1), (double)((float)blockPos2.getZ() + 0.5f));
                double d = this.Field3299.getValue() == Class460.Auto ? 3.0 : (double)((Float)this.breaktrace.getValue()).floatValue();
                boolean bl2 = bl = ((Boolean)this.packetpos.getValue() != false ? this.Field3347.distanceTo(entityEnderCrystal.getPositionVector()) : Globals.mc.player.getDistanceSq((Entity)entityEnderCrystal)) > ((Boolean)this.packetpos.getValue() != false ? d : Class29.Method114(d));
                if (bl && !this.Method4013((Entity)entityEnderCrystal)) {
                    if (this.Method4013((Entity)entityEnderCrystal)) continue;
                    double d2 = Globals.mc.player.getDistanceSq((Entity)entityEnderCrystal);
                    double d3 = this.Field3299.getValue() == Class460.Auto ? 3.0 : (double)((Float)this.breaktrace.getValue()).floatValue();
                    if (!(d2 <= Class29.Method114(d3))) continue;
                }
            }
            if (!((double)(f3 = Class352.Method1510(blockPos2, (Entity)Globals.mc.player)) + 0.5 < (double)Class30.Method1454((Entity)Globals.mc.player)) && ((Boolean)this.nosuicide.getValue()).booleanValue() || !((Boolean)this.ignoreselfdamage.getValue()).booleanValue() && !(f3 < ((Float)this.maxselfdamage.getValue()).floatValue()) || !((f2 = Class352.Method1510(blockPos2, (Entity)this.Field70)) >= ((Float)this.mindamage.getValue()).floatValue()) && !(f2 > Class30.Method1454((Entity)this.Field70)) && (!(Class30.Method1454((Entity)this.Field70) < ((Float)this.faceplace.getValue()).floatValue()) && !this.Method4014(this.Field70) || !(f2 >= 2.0f)) || !(f2 > f)) continue;
            f = f2;
            blockPos = blockPos2;
        }
        if (blockPos == null && ((Boolean)this.recalc.getValue()).booleanValue() && (this.Field3299.getValue() == Class460.Auto || ((Boolean)this.placecheck.getValue()).booleanValue())) {
            object = this.Field3334.iterator();
            while (object.hasNext()) {
                float f4;
                float f5;
                BlockPos blockPos2;
                if (!Class31.Method1223(blockPos2, Globals.mc.player.getDistanceSq(blockPos2 = (BlockPos)object.next()) > Class29.Method114(((Float)this.RPlaceTrace.getValue()).floatValue()), 1.0f) || !((double)(f5 = Class352.Method1510(blockPos2, (Entity)Globals.mc.player)) + 0.5 < (double)Class30.Method1454((Entity)Globals.mc.player)) && ((Boolean)this.nosuicide.getValue()).booleanValue() || !((Boolean)this.ignoreselfdamage.getValue()).booleanValue() && !(f5 < ((Float)this.maxselfdamage.getValue()).floatValue()) || !((f4 = Class352.Method1510(blockPos2, (Entity)this.Field70)) >= ((Float)this.RMinDamage.getValue()).floatValue()) && !(f4 > Class30.Method1454((Entity)this.Field70)) && (!(Class30.Method1454((Entity)this.Field70) < ((Float)this.faceplace.getValue()).floatValue()) && !this.Method4014(this.Field70) || !(f4 >= 2.0f)) || !(f4 > f)) continue;
                f = f4;
                blockPos = blockPos2;
            }
        }
        if (blockPos != null) {
            this.Method4007();
            this.Field68 = blockPos;
            this.Field3335 = f;
            this.Field69 = blockPos;
            this.Method4015(blockPos);
            Class31.Method52(blockPos, Globals.mc.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, (Boolean)this.strict.getValue(), this.Field3338);
            this.Field3342 = 0;
            this.Field3344.Method47();
            object = Field3272;
            synchronized (object) {
                int n = this.Field3340;
                this.Field3339.put(blockPos, n);
            }
            this.Method4008();
        }
    }

    private boolean Method4016(BlockPos blockPos) {
        EntityEnderCrystal entityEnderCrystal = new EntityEnderCrystal((World)Globals.mc.world, (double)((float)blockPos.getX() + 0.5f), (double)(blockPos.getY() + 1), (double)((float)blockPos.getZ() + 0.5f));
        return this.Method4013((Entity)entityEnderCrystal) || !this.Method4013((Entity)entityEnderCrystal) && Globals.mc.player.getDistanceSq((Entity)entityEnderCrystal) <= Class29.Method114(this.Field3299.getValue() == Class460.Auto ? 3.0 : (double)((Float)this.breaktrace.getValue()).floatValue());
    }

    private void Method4015(BlockPos blockPos) {
        switch ((Class159)((Object)this.rotate.getValue())) {
            case Off: {
                break;
            }
            case All: 
            case Place: {
                Class353 class353 = null;
                try {
                    class353 = Class84.Method1492(blockPos);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                if (class353 != null) {
                    this.Field3338 = class353.Method1493();
                }
                this.Field3337 = Class354.Method1505((double)blockPos.getX() + 0.5, (double)blockPos.getY() - 0.5, (double)blockPos.getZ() + 0.5, (EntityPlayer)Globals.mc.player);
                this.Field3341.Method47();
            }
        }
    }

    public boolean Method4013(Entity entity) {
        return Globals.mc.world.rayTraceBlocks((Boolean)this.packetpos.getValue() != false ? this.Field3347.add(0.0, (double)Globals.mc.player.getEyeHeight(), 0.0) : new Vec3d(Globals.mc.player.posX, Globals.mc.player.posY + (double)Globals.mc.player.getEyeHeight(), Globals.mc.player.posZ), new Vec3d(entity.posX, entity.posY + (double)entity.getEyeHeight(), entity.posZ), false, true, false) == null;
    }

    private void Method4004() {
        ++this.Field3342;
        ++this.Field3343;
        this.Field3336 = false;
        ++this.Field3340;
    }

    private void Method4017() {
        if ((Class30.Method2776((EntityPlayer)Globals.mc.player) || this.sswitch.getValue() == Class649.Silent) && this.Field68 != null && ((Boolean)this.render.getValue()).booleanValue() && (((Boolean)this.renderbox.getValue()).booleanValue() || ((Boolean)this.rendertext.getValue()).booleanValue() || ((Boolean)this.renderoutline.getValue()).booleanValue())) {
            this.Method4018(this.Field68, true, 255, true);
            if (((Boolean)this.renderfade.getValue()).booleanValue()) {
                this.Field3339.forEach(this::Method4019);
            }
        }
    }

    private boolean Method4020(BlockPos blockPos, BlockPos blockPos2) {
        return blockPos.getX() == blockPos2.getX() && blockPos.getY() == blockPos2.getY() && blockPos.getZ() == blockPos2.getZ();
    }

    private void Method4018(BlockPos blockPos, boolean bl, int n, boolean bl2) {
        if (this.renderbox.getValue() == Class577.FullBox) {
            if (!((Boolean)this.rendergradient.getValue()).booleanValue()) {
                Class50.Method137(blockPos, (Boolean)this.renderrainbow.getValue() != false ? this.Method4021((int)(((Float)this.renderspeed.getValue()).floatValue() * 1000.0f), ((Float)this.rendersaturation.getValue()).floatValue(), ((Float)this.renderbrightness.getValue()).floatValue()) : (Color)this.boxcolor.getValue(), (Boolean)this.rendercustomline.getValue(), (Boolean)this.renderrainbow.getValue() != false ? this.Method4021((int)(((Float)this.renderspeed.getValue()).floatValue() * 1000.0f), ((Float)this.rendersaturation.getValue()).floatValue(), ((Float)this.renderbrightness.getValue()).floatValue()) : (Color)this.outlinecolor.getValue(), ((Float)this.renderlinewidth.getValue()).floatValue(), (Boolean)this.renderoutline.getValue(), (Boolean)this.renderbox.getValue(), bl ? ((Color)this.boxcolor.getValue()).getAlpha() : n, false);
            } else {
                Color color;
                Color color2 = (Boolean)this.renderrainbow.getValue() != false ? this.Method4021((int)(((Float)this.renderspeed.getValue()).floatValue() * 1000.0f), ((Float)this.rendersaturation.getValue()).floatValue(), ((Float)this.renderbrightness.getValue()).floatValue()) : (Color)this.boxcolor.getValue();
                Color color3 = (Boolean)this.renderrainbow.getValue() != false ? this.Method4021((int)((((Float)this.renderspeed.getValue()).floatValue() + ((Float)this.renderdelta.getValue()).floatValue()) * 1000.0f), ((Float)this.rendersaturation.getValue()).floatValue(), ((Float)this.renderbrightness.getValue()).floatValue()) : (Color)this.boxcolor2.getValue();
                Color color4 = (Boolean)this.renderrainbow.getValue() != false ? this.Method4021((int)(((Float)this.renderspeed.getValue()).floatValue() * 1000.0f), ((Float)this.rendersaturation.getValue()).floatValue(), ((Float)this.renderbrightness.getValue()).floatValue()) : (Color)this.outlinecolor.getValue();
                Color color5 = color = (Boolean)this.renderrainbow.getValue() != false ? this.Method4021((int)((((Float)this.renderspeed.getValue()).floatValue() + ((Float)this.renderdelta.getValue()).floatValue()) * 1000.0f), ((Float)this.rendersaturation.getValue()).floatValue(), ((Float)this.renderbrightness.getValue()).floatValue()) : (Color)this.outlinecolor2.getValue();
                if (((Boolean)this.renderbox.getValue()).booleanValue()) {
                    Class50.Method135(blockPos, new Color(color3.getRed(), color3.getGreen(), color3.getBlue(), bl ? ((Color)this.boxcolor.getValue()).getAlpha() : n), new Color(color2.getRed(), color2.getGreen(), color2.getBlue(), bl ? ((Color)this.boxcolor.getValue()).getAlpha() : n));
                }
                if (((Boolean)this.renderoutline.getValue()).booleanValue()) {
                    Class50.Method136(blockPos, (Boolean)this.rendercustomline.getValue() != false ? color4 : new Color(color2.getRed(), color2.getGreen(), color2.getBlue(), bl ? 255 : n), (Boolean)this.rendercustomline.getValue() != false ? color : new Color(color3.getRed(), color3.getGreen(), color3.getBlue(), bl ? 255 : n), ((Float)this.renderlinewidth.getValue()).floatValue());
                }
            }
        } else if (this.renderbox.getValue() == Class577.CustomBox) {
            Class50.Method793(blockPos, (Boolean)this.renderrainbow.getValue() != false ? this.Method4021((int)(((Float)this.renderspeed.getValue()).floatValue() * 1000.0f), ((Float)this.rendersaturation.getValue()).floatValue(), ((Float)this.renderbrightness.getValue()).floatValue()) : (Color)this.boxcolor.getValue(), (Boolean)this.rendercustomline.getValue(), (Boolean)this.renderrainbow.getValue() != false ? this.Method4021((int)(((Float)this.renderspeed.getValue()).floatValue() * 1000.0f), ((Float)this.rendersaturation.getValue()).floatValue(), ((Float)this.renderbrightness.getValue()).floatValue()) : (Color)this.outlinecolor.getValue(), ((Float)this.renderlinewidth.getValue()).floatValue(), (Boolean)this.renderoutline.getValue(), (Boolean)this.renderbox.getValue(), bl ? ((Color)this.boxcolor.getValue()).getAlpha() : n, false);
        } else if (this.renderbox.getValue() == Class577.Clock) {
            Class67.Method138(blockPos, (Boolean)this.renderrainbow.getValue() != false ? this.Method4021((int)(((Float)this.renderspeed.getValue()).floatValue() * 1000.0f), ((Float)this.rendersaturation.getValue()).floatValue(), ((Float)this.renderbrightness.getValue()).floatValue()) : ((Boolean)this.rendercustomline.getValue() != false ? (Color)this.outlinecolor.getValue() : (Color)this.boxcolor.getValue()), ((Float)this.renderlinewidth.getValue()).floatValue());
        } else if (this.renderbox.getValue() == Class577.Triangle) {
            Class67.Method139(blockPos, (Boolean)this.renderrainbow.getValue() != false ? this.Method4021((int)(((Float)this.renderspeed.getValue()).floatValue() * 1000.0f), ((Float)this.rendersaturation.getValue()).floatValue(), ((Float)this.renderbrightness.getValue()).floatValue()) : ((Boolean)this.rendercustomline.getValue() != false ? (Color)this.outlinecolor.getValue() : (Color)this.boxcolor.getValue()), ((Float)this.renderlinewidth.getValue()).floatValue());
        } else if (this.renderbox.getValue() == Class577.Butterfly) {
            Class67.Method140(blockPos, (Boolean)this.renderrainbow.getValue() != false ? this.Method4021((int)(((Float)this.renderspeed.getValue()).floatValue() * 1000.0f), ((Float)this.rendersaturation.getValue()).floatValue(), ((Float)this.renderbrightness.getValue()).floatValue()) : ((Boolean)this.rendercustomline.getValue() != false ? (Color)this.outlinecolor.getValue() : (Color)this.boxcolor.getValue()), ((Float)this.renderlinewidth.getValue()).floatValue());
        }
        if (((Boolean)this.rendertext.getValue()).booleanValue() && bl2) {
            if (this.renderbox.getValue() == Class577.FullBox) {
                Class50.Method846(blockPos, (Math.floor(this.Field3335) == (double)this.Field3335 ? Float.valueOf(this.Field3335) : String.format("%.1f", Float.valueOf(this.Field3335))) + "", ((Color)this.rendertextcolor.getValue()).getRGB());
            } else if (this.renderbox.getValue() == Class577.CustomBox) {
                Class50.Method841(blockPos, (Math.floor(this.Field3335) == (double)this.Field3335 ? Float.valueOf(this.Field3335) : String.format("%.1f", Float.valueOf(this.Field3335))) + "", ((Color)this.rendertextcolor.getValue()).getRGB());
            }
        }
    }

    private boolean Method4014(EntityPlayer entityPlayer) {
        if (entityPlayer == null) {
            return false;
        }
        for (ItemStack itemStack : entityPlayer.inventory.armorInventory) {
            if (itemStack == null) {
                return true;
            }
            if (!(Class352.Method1847(itemStack) < (float)((Integer)this.armorbreaker.getValue()).intValue())) continue;
            return true;
        }
        return false;
    }

    private Color Method4021(int n, float f, float f2) {
        float f3 = System.currentTimeMillis() % (long)n;
        return Color.getHSBColor(f3 /= (float)n, f, f2);
    }

    private String Method3996() {
        switch ((Class45)((Object)this.metadata.getValue())) {
            case Counter: {
                if (Manager.moduleManager.isModuleEnabled(CrystalCounter.class)) {
                    return ChatFormatting.WHITE + String.valueOf(CrystalCounter.Field2055) + ":" + CrystalCounter.Field2056;
                }
            }
            case Target: {
                return this.Field70 != null ? ChatFormatting.WHITE + this.Field70.getName() : ChatFormatting.GREEN + "ON";
            }
            case Facing: {
                if (((Boolean)this.strict.getValue()).booleanValue()) {
                    return ChatFormatting.WHITE + Class31.Field934.getName();
                }
                return this.Field70 != null ? ChatFormatting.WHITE + this.Field70.getName() : ChatFormatting.GREEN + "ON";
            }
        }
        return null;
    }

    private EnumHand Method4012() {
        switch ((Class158)((Object)this.swing.getValue())) {
            case Auto: {
                return Globals.mc.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND;
            }
            case MainHand: {
                return EnumHand.MAIN_HAND;
            }
            case OffHand: {
                return EnumHand.OFF_HAND;
            }
        }
        return Globals.mc.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND;
    }

    private void Method4019(BlockPos blockPos, Integer n) {
        if (!this.Method4020(blockPos, this.Field68) && this.Field3340 - n <= (Integer)this.fadeticks.getValue()) {
            int n2 = ((Color)this.boxcolor.getValue()).getAlpha();
            int n3 = (int)((float)n2 - (float)(this.Field3340 - n) / ((Integer)this.fadeticks.getValue()).floatValue() * (float)n2);
            this.Method4018(blockPos, false, n3, false);
        }
    }

    private void Method3988(EventNetworkPostPacketEvent eventNetworkPostPacketEvent) {
        if (eventNetworkPostPacketEvent.Method16() instanceof CPacketPlayer.Position || eventNetworkPostPacketEvent.Method16() instanceof CPacketPlayer.PositionRotation) {
            CPacketPlayer cPacketPlayer = (CPacketPlayer)eventNetworkPostPacketEvent.Method16();
            this.Field3347 = new Vec3d(cPacketPlayer.x, cPacketPlayer.y, cPacketPlayer.z);
        }
    }

    private void Method3987(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        if (eventPlayerUpdateWalking.Method100() != Class53.PRE) {
            return;
        }
        if (eventPlayerUpdateWalking.isCancelled()) {
            this.Field3337 = null;
            return;
        }
        if (this.Field66) {
            this.Field3337 = null;
            return;
        }
        if (this.Field3341.Method50(1000L)) {
            this.Field3337 = null;
        }
        if (this.Field3337 != null) {
            eventPlayerUpdateWalking.setYaw(this.Field3337[0]);
            eventPlayerUpdateWalking.setPitch(this.Field3337[1]);
            eventPlayerUpdateWalking.cancel();
            Class202.Method934((float)this.Field3337[1], (float)this.Field3337[0]);
        }
    }

    private void Method3986(EventNetworkPrePacketEvent eventNetworkPrePacketEvent) {
        SPacketSpawnObject sPacketSpawnObject;
        Packet packet = eventNetworkPrePacketEvent.Method49();
        if (((Boolean)this.instabreak.getValue()).booleanValue() && packet instanceof SPacketSpawnObject && (sPacketSpawnObject = (SPacketSpawnObject)packet).getType() == 51) {
            BlockPos blockPos = new BlockPos(sPacketSpawnObject.getX(), sPacketSpawnObject.getY(), sPacketSpawnObject.getZ());
            if ((this.Field69 != null && this.Field69.equals((Object)blockPos.down()) || this.Method3997(blockPos.down())) && this.Field3346.Method50(((Float)this.timer.getValue()).longValue()) && !this.Field66 && Globals.mc.player.getDistance((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ()) <= (double)(((Float)this.breakrange.getValue()).floatValue() + 1.0f)) {
                CPacketUseEntity cPacketUseEntity = new CPacketUseEntity();
                cPacketUseEntity.entityId = sPacketSpawnObject.getEntityID();
                cPacketUseEntity.action = CPacketUseEntity.Action.ATTACK;
                Globals.mc.player.connection.sendPacket((Packet)cPacketUseEntity);
                Globals.mc.player.swingArm(this.Method4012());
                this.Field3343 = 0;
                this.Field3346.Method47();
                if (((Boolean)this.cancel.getValue()).booleanValue()) {
                    this.Field3336 = true;
                }
            }
        }
    }

    private void Method3985(EventNetworkPrePacketEvent eventNetworkPrePacketEvent) {
        SPacketSoundEffect sPacketSoundEffect;
        if (eventNetworkPrePacketEvent.Method49() instanceof SPacketSoundEffect && ((Boolean)this.nosounddesync.getValue()).booleanValue() && (sPacketSoundEffect = (SPacketSoundEffect)eventNetworkPrePacketEvent.Method49()).getCategory() == SoundCategory.BLOCKS && sPacketSoundEffect.getSound() == SoundEvents.ENTITY_GENERIC_EXPLODE) {
            for (Entity entity : Minecraft.getMinecraft().world.loadedEntityList) {
                if (!(entity instanceof EntityEnderCrystal) || !(entity.getDistance(sPacketSoundEffect.getX(), sPacketSoundEffect.getY(), sPacketSoundEffect.getZ()) <= 6.0)) continue;
                entity.setDead();
            }
        }
    }

    private void Method3984(Class66 class66) {
        this.Method4017();
    }

    private void Method3983(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        if (eventPlayerUpdateWalking.Method100() == Class53.PRE) {
            this.Method3998();
        }
    }

    private boolean Method3982() {
        return (Boolean)this.render.getValue() != false && (Boolean)this.renderrainbow.getValue() != false;
    }

    private boolean Method3981() {
        return (Boolean)this.render.getValue() != false && (Boolean)this.renderrainbow.getValue() != false;
    }

    private boolean Method3980() {
        return (Boolean)this.render.getValue() != false && (Boolean)this.renderrainbow.getValue() != false;
    }

    private boolean Method3979() {
        return (Boolean)this.render.getValue() != false && (Boolean)this.renderoutline.getValue() != false && (Boolean)this.rendercustomline.getValue() != false && (Boolean)this.renderrainbow.getValue() == false;
    }

    private boolean Method3978() {
        return (Boolean)this.render.getValue() != false && (Boolean)this.renderoutline.getValue() != false && (Boolean)this.rendercustomline.getValue() != false;
    }

    private boolean Method3977() {
        return (Boolean)this.render.getValue() != false && (Boolean)this.renderoutline.getValue() != false;
    }

    private boolean Method3976() {
        return (Boolean)this.render.getValue() != false && (Boolean)this.renderoutline.getValue() != false;
    }

    private boolean Method3975() {
        return (Boolean)this.render.getValue() != false && (Boolean)this.rendergradient.getValue() != false && (Boolean)this.renderrainbow.getValue() == false;
    }

    private boolean Method3974() {
        return (Boolean)this.render.getValue();
    }

    private boolean Method3973() {
        return (Boolean)this.render.getValue() != false && (Boolean)this.rendergradient.getValue() != false;
    }

    private boolean Method3972() {
        return (Boolean)this.render.getValue() != false && this.renderbox.getValue() == Class577.FullBox;
    }

    private boolean Method3971() {
        return (Boolean)this.render.getValue() != false && (Boolean)this.rendertext.getValue() != false;
    }

    private boolean Method3970() {
        return (Boolean)this.render.getValue();
    }

    private boolean Method3969() {
        return (Boolean)this.render.getValue();
    }

    private boolean Method3968() {
        return (Boolean)this.render.getValue();
    }

    private boolean Method3967() {
        return (Boolean)this.render.getValue();
    }

    private boolean Method3966() {
        return (Boolean)this.render.getValue();
    }

    private static boolean Method3965() {
        return true;
    }

    private boolean Method3964() {
        return this.delaymode.getValue() == Class252.Ticks;
    }

    private boolean Method3963() {
        return this.delaymode.getValue() == Class252.Ticks;
    }

    private boolean Method3962() {
        return this.delaymode.getValue() == Class252.Timer;
    }

    private boolean Method3961() {
        return this.delaymode.getValue() == Class252.Timer;
    }

    private static boolean Method3960() {
        return true;
    }

    private boolean Method3959() {
        return (this.Field3299.getValue() == Class460.Auto || (Boolean)this.placecheck.getValue() != false) && (Boolean)this.recalc.getValue() != false;
    }

    private boolean Method3958() {
        return (this.Field3299.getValue() == Class460.Auto || (Boolean)this.placecheck.getValue() != false) && (Boolean)this.recalc.getValue() != false;
    }

    private boolean Method3957() {
        return this.Field3299.getValue() == Class460.Auto || (Boolean)this.placecheck.getValue() != false;
    }

    private boolean Method3956() {
        return this.Field3299.getValue() == Class460.Manual && (Boolean)this.placecheck.getValue() != false || this.Field3299.getValue() == Class460.Auto;
    }

    private boolean Method3955() {
        return this.Field3299.getValue() == Class460.Manual;
    }

    private boolean Method3954() {
        return this.Field3299.getValue() == Class460.Manual;
    }

    private boolean Method3953() {
        return this.Field3299.getValue() == Class460.Manual;
    }

    private static boolean Method3952() {
        return true;
    }

    private boolean Method3951() {
        return (Boolean)this.ignoreselfdamage.getValue() == false;
    }

    private static boolean Method3950() {
        return true;
    }

    private static boolean Method3949() {
        return true;
    }

    private static boolean Method3948() {
        return true;
    }

    private boolean Method3947() {
        return (Boolean)this.instabreak.getValue();
    }

    private boolean Method3946() {
        return (Boolean)this.instabreak.getValue();
    }

    private static boolean Method3945() {
        return true;
    }

    private static boolean Method3944() {
        return true;
    }

    private static boolean Method3943() {
        return true;
    }

    private boolean Method3942() {
        return this.rotate.getValue() == Class159.Place || this.rotate.getValue() == Class159.All;
    }
}
