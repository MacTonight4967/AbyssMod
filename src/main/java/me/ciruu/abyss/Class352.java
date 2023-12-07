package me.ciruu.abyss;

import me.ciruu.abyss.Class72;
import me.ciruu.abyss.Globals;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.CombatRules;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class Class352 {
    public static boolean Method1472(EntityPlayer entityPlayer, int n) {
        if (entityPlayer == null) {
            return false;
        }
        for (ItemStack itemStack : entityPlayer.inventory.armorInventory) {
            if (itemStack == null) {
                return true;
            }
            if (Class352.Method1846(itemStack) >= n) continue;
            return true;
        }
        return false;
    }

    public static int Method1846(ItemStack itemStack) {
        return itemStack.getMaxDamage() - itemStack.getItemDamage();
    }

    public static float Method1847(ItemStack itemStack) {
        float f = (float)Class352.Method1846(itemStack) / (float)itemStack.getMaxDamage();
        return f * 100.0f;
    }

    public static int Method1813(ItemStack itemStack) {
        return (int)Class352.Method1847(itemStack);
    }

    public static boolean Method1848(ItemStack itemStack) {
        Item item = itemStack.getItem();
        return item instanceof ItemArmor || item instanceof ItemSword || item instanceof ItemTool || item instanceof ItemShield;
    }

    @Class72
    public static boolean Method1462(EntityPlayer entityPlayer) {
        int n = 0;
        PotionEffect potionEffect = Globals.mc.player.getActivePotionEffect(MobEffects.STRENGTH);
        if (potionEffect != null) {
            n = potionEffect.getAmplifier();
        }
        return !Globals.mc.player.isPotionActive(MobEffects.WEAKNESS) || n >= 1 || Globals.mc.player.getHeldItemMainhand().getItem() instanceof ItemSword || Globals.mc.player.getHeldItemMainhand().getItem() instanceof ItemPickaxe || Globals.mc.player.getHeldItemMainhand().getItem() instanceof ItemAxe || Globals.mc.player.getHeldItemMainhand().getItem() instanceof ItemSpade;
    }

    @Class72
    public static float Method1854(double d, double d2, double d3, Entity entity) {
        float f = 12.0f;
        double d4 = entity.getDistance(d, d2, d3) / (double)f;
        Vec3d vec3d = new Vec3d(d, d2, d3);
        double d5 = 0.0;
        try {
            d5 = entity.world.getBlockDensity(vec3d, entity.getEntityBoundingBox());
        }
        catch (Exception exception) {
            // empty catch block
        }
        double d6 = (1.0 - d4) * d5;
        float f2 = (int)((d6 * d6 + d6) / 2.0 * 7.0 * (double)f + 1.0);
        double d7 = 1.0;
        if (entity instanceof EntityLivingBase) {
            d7 = Class352.Method1859((EntityLivingBase)entity, Class352.Method1858(f2), new Explosion((World)Globals.mc.world, null, d, d2, d3, 6.0f, false, true));
        }
        return (float)d7;
    }

    @Class72
    public static float Method1859(EntityLivingBase entityLivingBase, float f, Explosion explosion) {
        float f2 = f;
        if (entityLivingBase instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase;
            DamageSource damageSource = DamageSource.causeExplosionDamage((Explosion)explosion);
            f2 = CombatRules.getDamageAfterAbsorb((float)f2, (float)entityPlayer.getTotalArmorValue(), (float)((float)entityPlayer.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue()));
            int n = 0;
            try {
                n = EnchantmentHelper.getEnchantmentModifierDamage((Iterable)entityPlayer.getArmorInventoryList(), (DamageSource)damageSource);
            }
            catch (Exception exception) {
                // empty catch block
            }
            float f3 = MathHelper.clamp((float)n, (float)0.0f, (float)20.0f);
            f2 *= 1.0f - f3 / 25.0f;
            if (entityLivingBase.isPotionActive(MobEffects.RESISTANCE)) {
                f2 -= f2 / 4.0f;
            }
            f2 = Math.max(f2, 0.0f);
            return f2;
        }
        f2 = CombatRules.getDamageAfterAbsorb((float)f2, (float)entityLivingBase.getTotalArmorValue(), (float)((float)entityLivingBase.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue()));
        return f2;
    }

    @Class72
    public static float Method1858(float f) {
        int n = Globals.mc.world.getDifficulty().getId();
        return f * (n == 0 ? 0.0f : (n == 2 ? 1.0f : (n == 1 ? 0.5f : 1.5f)));
    }

    public static float Method1469(Entity entity, Entity entity2) {
        return Class352.Method1854(entity.posX, entity.posY, entity.posZ, entity2);
    }

    @Class72
    public static float Method1510(BlockPos blockPos, Entity entity) {
        return Class352.Method1854((double)blockPos.getX() + 0.5, blockPos.getY() + 1, (double)blockPos.getZ() + 0.5, entity);
    }

    public static boolean Method1877(boolean bl) {
        return !Globals.mc.player.capabilities.isCreativeMode && !bl;
    }

    public static int Method1878(EntityPlayer entityPlayer) {
        Item item = entityPlayer.getHeldItemMainhand().getItem();
        if (item instanceof ItemSword) {
            return 600;
        }
        if (item instanceof ItemPickaxe) {
            return 850;
        }
        if (item == Items.IRON_AXE) {
            return 1100;
        }
        if (item == Items.STONE_HOE) {
            return 500;
        }
        if (item == Items.IRON_HOE) {
            return 350;
        }
        if (item == Items.WOODEN_AXE || item == Items.STONE_AXE) {
            return 1250;
        }
        if (item instanceof ItemSpade || item == Items.GOLDEN_AXE || item == Items.DIAMOND_AXE || item == Items.WOODEN_HOE || item == Items.GOLDEN_HOE) {
            return 1000;
        }
        return 250;
    }
}
