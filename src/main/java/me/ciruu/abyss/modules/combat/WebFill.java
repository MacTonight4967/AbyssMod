package me.ciruu.abyss.modules.combat;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import me.ciruu.abyss.Class110;
import me.ciruu.abyss.Class155;
import me.ciruu.abyss.Class202;
import me.ciruu.abyss.Class22;
import me.ciruu.abyss.Class25;
import me.ciruu.abyss.Class31;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

public class WebFill
extends Module {
    private final Setting mainwindow = new Setting("Main", "", this, new Class25("Main Settings"));
    private final Setting placerange = new Setting("PlaceRange", "Place Range", (Module)this, (Object)Float.valueOf(5.0f), Float.valueOf(0.0f), Float.valueOf(6.0f));
    private final Setting placeticks = new Setting("PlaceTicks", "Place Delay", (Module)this, (Object)0, 0, 10);
    private final Setting rotate = new Setting("Rotate", "Rotate", this, false);
    private final Setting blockspertick = new Setting("BlocksPerTick", "Blocks per tick", (Module)this, (Object)1, 1, 20);
    private final Setting disableafter = new Setting("DisableAfter", "Disable", this, false);
    private final Setting disabletime = new Setting("DisableTime", "Disable time", this, 5000, 1, 10000, this.mainwindow, this.disableafter::getValue);
    private final Setting stopAC = new Setting("StopAC", "Stop AutoCrystal while webfilling", this, true);
    private final Setting silent = new Setting("Silent", "", this, true);
    private final Class22 Field2421 = new Class22();
    private int Field2422 = -1;
    private List Field2423 = new ArrayList();
    private int Field2424 = 0;
    public static boolean Field2425 = false;
    private boolean Field2426 = true;
    private int Field2427 = -1;
    @EventHandler
    private Listener Field2428 = new Listener<EventPlayerUpdateWalking>(this::Method2949, new Predicate[0]);

    public WebFill() {
        super("WebFill", "Fill nearby holes with cobwebs.", Class11.COMBAT);
        this.Method2950(this.placerange);
        this.Method2950(this.placeticks);
        this.Method2950(this.rotate);
        this.Method2950(this.blockspertick);
        this.Method2950(this.disableafter);
        this.Method2950(this.disabletime);
        this.Method2950(this.stopAC);
        this.Method2950(this.silent);
    }

    public void Method2951() {
        super.Method13();
        if (this.Method2952()) {
            this.Method2953();
            Globals.printChatMessage(ChatFormatting.RED + "Can't find cobwebs in your hotbar!");
        }
        if (((Boolean)this.stopAC.getValue()).booleanValue()) {
            Field2425 = true;
        }
        this.Field2421.Method47();
    }

    public void Method2954() {
        super.Method15();
        Field2425 = false;
        this.Field2423.clear();
        if (this.Field2422 != -1 && this.Field2426) {
            Globals.mc.player.inventory.currentItem = this.Field2422;
        }
        this.Field2422 = -1;
        this.Field2426 = false;
    }

    private void Method2955() {
        if (!this.Method2956()) {
            this.Method2953();
            Globals.printChatMessage(ChatFormatting.YELLOW + "There's no hole to fill!");
        }
        if (Class155.Method545(Blocks.WEB) != Globals.mc.player.inventory.currentItem && !((Boolean)this.silent.getValue()).booleanValue()) {
            return;
        }
        if (this.Field2421.Method50(((Integer)this.disabletime.getValue()).intValue()) && ((Boolean)this.disableafter.getValue()).booleanValue()) {
            this.Method2953();
            return;
        }
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        if (this.Field2424 >= (Integer)this.placeticks.getValue()) {
            this.Field2424 = 0;
            int n = 0;
            int n2 = Class155.Method545(Blocks.WEB);
            if (((Boolean)this.silent.getValue()).booleanValue() && n2 != -1) {
                this.Field2422 = Globals.mc.player.inventory.currentItem;
                Globals.mc.player.inventory.currentItem = n2;
                Globals.mc.playerController.updateController();
            }
            for (BlockPos blockPos : this.Field2423) {
                Class31.Method536(blockPos, EnumHand.MAIN_HAND, (Boolean)this.rotate.getValue(), true, Globals.mc.player.isSneaking());
                arrayList.add(blockPos);
                if (++n < (Integer)this.blockspertick.getValue()) continue;
                break;
            }
            if (((Boolean)this.silent.getValue()).booleanValue() && this.Field2422 != -1 && n2 != -1) {
                Globals.mc.player.inventory.currentItem = this.Field2422;
                Globals.mc.playerController.updateController();
            }
        }
        arrayList.forEach(this::Method2957);
        if (this.Field2423.isEmpty()) {
            Globals.printChatMessage(ChatFormatting.GREEN + "Done!");
            this.Method2953();
        }
        ++this.Field2424;
    }

    private boolean Method2952() {
        this.Field2422 = Globals.mc.player.inventory.currentItem;
        this.Field2427 = Class155.Method545(Blocks.WEB);
        if (this.Field2427 != -1 && !((Boolean)this.silent.getValue()).booleanValue()) {
            Globals.mc.player.inventory.currentItem = this.Field2427;
            Globals.mc.playerController.updateController();
        }
        return Globals.mc.player == null || Globals.mc.world == null || this.Field2427 == -1;
    }

    public boolean Method2956() {
        this.Field2423.clear();
        for (BlockPos blockPos : Class110.Method1096(Class202.Method931(), ((Float)this.placerange.getValue()).floatValue(), ((Float)this.placerange.getValue()).intValue(), false, true, 0)) {
            boolean bl = Globals.mc.world.getBlockState(blockPos.add(1, 0, 0)).getBlock() == Blocks.BEDROCK | Globals.mc.world.getBlockState(blockPos.add(1, 0, 0)).getBlock() == Blocks.OBSIDIAN && Globals.mc.world.getBlockState(blockPos.add(0, 0, 1)).getBlock() == Blocks.BEDROCK | Globals.mc.world.getBlockState(blockPos.add(0, 0, 1)).getBlock() == Blocks.OBSIDIAN && Globals.mc.world.getBlockState(blockPos.add(-1, 0, 0)).getBlock() == Blocks.BEDROCK | Globals.mc.world.getBlockState(blockPos.add(-1, 0, 0)).getBlock() == Blocks.OBSIDIAN && Globals.mc.world.getBlockState(blockPos.add(0, 0, -1)).getBlock() == Blocks.BEDROCK | Globals.mc.world.getBlockState(blockPos.add(0, 0, -1)).getBlock() == Blocks.OBSIDIAN && Globals.mc.world.getBlockState(blockPos.add(0, 0, 0)).getMaterial() == Material.AIR && Globals.mc.world.getBlockState(blockPos.add(0, 1, 0)).getMaterial() == Material.AIR && Globals.mc.world.getBlockState(blockPos.add(0, 2, 0)).getMaterial() == Material.AIR;
            if (!bl) continue;
            this.Field2423.add(blockPos);
        }
        return !this.Field2423.isEmpty();
    }

    private void Method2957(BlockPos blockPos) {
        this.Field2423.remove(blockPos);
    }

    private void Method2949(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        if (this.Method2958() && eventPlayerUpdateWalking.Method100() == Class53.PRE) {
            this.Method2955();
        }
    }
}
