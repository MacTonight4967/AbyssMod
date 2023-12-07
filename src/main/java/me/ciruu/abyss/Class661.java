package me.ciruu.abyss;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.GameProfile;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.function.Predicate;
import me.ciruu.abyss.Class26;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.apache.commons.io.IOUtils;

public class Class661
extends Module {
    public final Setting Field3242 = new Setting("Name", "Name of the fake player", this, "jared2013");
    private final Setting Field3243 = new Setting("Delay", "Delay in ticks", (Module)this, (Object)100, 0, 2000);
    private int Field3244;
    private EntityOtherPlayerMP Field3245;
    @EventHandler
    private Listener Field3246 = new Listener<Class26>(this::Method3915, new Predicate[0]);

    public Class661() {
        super("FakePlayer 2", "Summons a fake player", Class11.MISC);
        this.Method3916(this.Field3243);
    }

    public void Method3917() {
        super.Method13();
        this.Field3245 = null;
        if (Globals.mc.world == null) {
            this.Method3918();
            return;
        }
        try {
            this.Field3245 = new EntityOtherPlayerMP((World)Globals.mc.world, new GameProfile(UUID.fromString(Class661.Method3919((String)this.Field3242.getValue())), (String)this.Field3242.getValue()));
        }
        catch (Exception exception) {
            this.Field3245 = new EntityOtherPlayerMP((World)Globals.mc.world, new GameProfile(UUID.fromString("70ee432d-0a96-4137-a2c0-37cc9df67f03"), (String)this.Field3242.getValue()));
            Globals.printChatMessage("Failed to load uuid, setting another one.");
        }
        EnchantmentProtection enchantmentProtection = new EnchantmentProtection(Enchantment.Rarity.COMMON, EnchantmentProtection.Type.ALL, new EntityEquipmentSlot[]{EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.FEET});
        EnchantmentProtection enchantmentProtection2 = new EnchantmentProtection(Enchantment.Rarity.COMMON, EnchantmentProtection.Type.EXPLOSION, new EntityEquipmentSlot[]{EntityEquipmentSlot.LEGS});
        ItemStack itemStack = new ItemStack(Item.getItemById((int)310));
        itemStack.addEnchantment((Enchantment)enchantmentProtection, 4);
        ItemStack itemStack2 = new ItemStack(Item.getItemById((int)311));
        itemStack2.addEnchantment((Enchantment)enchantmentProtection, 4);
        ItemStack itemStack3 = new ItemStack(Item.getItemById((int)312));
        itemStack3.addEnchantment((Enchantment)enchantmentProtection2, 4);
        ItemStack itemStack4 = new ItemStack(Item.getItemById((int)313));
        itemStack4.addEnchantment((Enchantment)enchantmentProtection, 4);
        this.Field3245.inventoryContainer.putStackInSlot(5, itemStack);
        this.Field3245.inventoryContainer.putStackInSlot(6, itemStack2);
        this.Field3245.inventoryContainer.putStackInSlot(7, itemStack3);
        this.Field3245.inventoryContainer.putStackInSlot(8, itemStack4);
        this.Field3245.inventoryContainer.putStackInSlot(36, new ItemStack(Item.getItemById((int)426)));
        this.Field3245.inventoryContainer.putStackInSlot(45, new ItemStack(Item.getItemById((int)449)));
        Globals.printChatMessage(String.format("%s has been spawned.", this.Field3242.getValue()));
        this.Field3245.copyLocationAndAnglesFrom((Entity)Globals.mc.player);
        this.Field3245.rotationYawHead = Globals.mc.player.rotationYawHead;
        Globals.mc.world.addEntityToWorld(-100, (Entity)this.Field3245);
    }

    public void Method3920() {
        super.Method15();
        Globals.mc.world.removeEntity((Entity)this.Field3245);
    }

    public void Method3921(boolean bl) {
        if (this.Method3922()) {
            this.Method3923(false);
            this.Method3920();
        }
    }

    public static String Method3919(String string) {
        JsonParser jsonParser = new JsonParser();
        String string2 = "https://api.mojang.com/users/profiles/minecraft/" + string;
        try {
            String string3 = IOUtils.toString(new URL(string2), StandardCharsets.UTF_8);
            if (string3.isEmpty()) {
                return "invalid name";
            }
            JsonObject jsonObject = (JsonObject)jsonParser.parse(string3);
            return Class661.Method3924(jsonObject.get("id").toString());
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "error";
        }
    }

    private static String Method3924(String string) {
        String string2 = "";
        string2 = string2 + string.substring(1, 9) + "-";
        string2 = string2 + string.substring(9, 13) + "-";
        string2 = string2 + string.substring(13, 17) + "-";
        string2 = string2 + string.substring(17, 21) + "-";
        string2 = string2 + string.substring(21, 33);
        return string2;
    }

    private void Method3915(Class26 class26) {
        if (((Integer)this.Field3243.getValue()).doubleValue() > 0.0) {
            int n = (Integer)this.Field3243.getValue();
            if (this.Field3244 < n) {
                ++this.Field3244;
                return;
            }
            this.Field3244 = 0;
        }
        this.Field3245.setPosition(this.Field3245.posX + 5.0, this.Field3245.posY, this.Field3245.posZ + 5.0);
        if (this.Field3245.getDistance((Entity)Globals.mc.player) > 50.0f) {
            this.Field3245.setPosition((double)Globals.mc.player.getPosition().getX(), (double)Globals.mc.player.getPosition().getY(), (double)Globals.mc.player.getPosition().getZ());
        }
    }
}
