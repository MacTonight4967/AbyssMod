package me.ciruu.abyss;

import java.text.DecimalFormat;
import me.ciruu.abyss.Globals;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class Class354 {
    public static Minecraft Field2646 = Minecraft.getMinecraft();

    public static boolean Method3252(Entity entity, Boolean bl, Boolean bl2, Boolean bl3, Boolean bl4) {
        return bl != false && (bl2 != false && Class354.Method3253(entity) || bl3 != false && Class354.Method3254(entity) || bl4 != false && Class354.Method3255(entity));
    }

    public static boolean Method3253(Entity entity) {
        return entity instanceof EntityAnimal || entity instanceof EntityAgeable || entity instanceof EntityTameable || entity instanceof EntityAmbientCreature || entity instanceof EntitySquid;
    }

    public static boolean Method3254(Entity entity) {
        return Class354.Method3256(entity) && !Class354.Method3255(entity);
    }

    public static boolean Method3257(Entity entity) {
        return (!(entity instanceof EntityWolf) || !((EntityWolf)entity).isAngry()) && (entity instanceof EntityAnimal || entity instanceof EntityAgeable || entity instanceof EntityTameable || entity instanceof EntityAmbientCreature || entity instanceof EntitySquid || entity instanceof EntityIronGolem && ((EntityIronGolem)entity).getRevengeTarget() == null);
    }

    public static int Method3258(Item item) {
        if (Class354.Field2646.player == null) {
            return 0;
        }
        for (int i = Class354.Field2646.player.inventoryContainer.getInventory().size() - 1; i > 0; --i) {
            ItemStack itemStack;
            if (i == 0 || i == 5 || i == 6 || i == 7 || i == 8 || (itemStack = (ItemStack)Class354.Field2646.player.inventoryContainer.getInventory().get(i)).isEmpty() || itemStack.getItem() != item) continue;
            return i;
        }
        return -1;
    }

    public static int Method3259(Item item) {
        if (Class354.Field2646.player == null) {
            return 0;
        }
        for (int i = 9; i < 36; ++i) {
            Item item2 = Class354.Field2646.player.inventory.getStackInSlot(i).getItem();
            if (item2 != item) continue;
            return i;
        }
        return -1;
    }

    public static float Method3260() {
        return Class354.Field2646.player.getHealth() + Class354.Field2646.player.getAbsorptionAmount();
    }

    public static boolean Method1908(Entity entity) {
        return entity instanceof EntityLivingBase;
    }

    public static boolean Method3261(Entity entity) {
        return entity != null && entity.getEntityId() == -100 && Globals.mc.player != entity;
    }

    public static Vec3d Method3262(Entity entity, double d, double d2, double d3) {
        return new Vec3d((entity.posX - entity.lastTickPosX) * d, (entity.posY - entity.lastTickPosY) * d2, (entity.posZ - entity.lastTickPosZ) * d3);
    }

    public static Vec3d Method3263(Entity entity, Vec3d vec3d) {
        return Class354.Method3262(entity, vec3d.x, vec3d.y, vec3d.z);
    }

    public static Vec3d Method3264(Entity entity, double d) {
        return Class354.Method3262(entity, d, d, d);
    }

    public static boolean Method3255(Entity entity) {
        if (entity instanceof EntityPigZombie) {
            if (((EntityPigZombie)entity).isArmsRaised() || ((EntityPigZombie)entity).isAngry()) {
                return true;
            }
        } else {
            if (entity instanceof EntityWolf) {
                return ((EntityWolf)entity).isAngry() && !Globals.mc.player.equals((Object)((EntityWolf)entity).getOwner());
            }
            if (entity instanceof EntityEnderman) {
                return ((EntityEnderman)entity).isScreaming();
            }
        }
        return Class354.Method3265(entity);
    }

    public static boolean Method3256(Entity entity) {
        return entity instanceof EntityPigZombie || entity instanceof EntityWolf || entity instanceof EntityEnderman;
    }

    public static boolean Method3266(Entity entity) {
        return entity.isCreatureType(EnumCreatureType.CREATURE, false) && !Class354.Method3256(entity) || entity.isCreatureType(EnumCreatureType.AMBIENT, false) || entity instanceof EntityVillager || entity instanceof EntityIronGolem || Class354.Method3256(entity) && !Class354.Method3255(entity);
    }

    public static boolean Method3265(Entity entity) {
        return entity.isCreatureType(EnumCreatureType.MONSTER, false) && !Class354.Method3256(entity);
    }

    public static Vec3d Method2221(Entity entity, float f) {
        return new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ).add(Class354.Method3264(entity, f));
    }

    public static boolean Method3267(Entity entity) {
        if (entity == null) {
            return false;
        }
        double d = entity.posY + 0.01;
        for (int i = MathHelper.floor((double)entity.posX); i < MathHelper.ceil((double)entity.posX); ++i) {
            for (int j = MathHelper.floor((double)entity.posZ); j < MathHelper.ceil((double)entity.posZ); ++j) {
                BlockPos blockPos = new BlockPos(i, (int)d, j);
                if (!(Globals.mc.world.getBlockState(blockPos).getBlock() instanceof BlockLiquid)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean Method3268(Entity entity) {
        return Globals.mc.player != null && entity != null && entity.equals((Object)Globals.mc.player.getRidingEntity());
    }

    public static double Method3269(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d - d4;
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        return MathHelper.sqrt((double)(d7 * d7 + d8 * d8 + d9 * d9));
    }

    public static double Method3270(Entity entity, BlockPos blockPos) {
        return Class354.Method3269(entity.posX, entity.posY, entity.posZ, blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }

    public static boolean Method3271(Entity entity) {
        return Class354.Method3272(entity, false);
    }

    public static boolean Method3272(Entity entity, boolean bl) {
        if (entity == null) {
            return false;
        }
        double d = entity.posY - (bl ? 0.03 : (Class354.Method3273(entity) ? 0.2 : 0.5));
        for (int i = MathHelper.floor((double)entity.posX); i < MathHelper.ceil((double)entity.posX); ++i) {
            for (int j = MathHelper.floor((double)entity.posZ); j < MathHelper.ceil((double)entity.posZ); ++j) {
                BlockPos blockPos = new BlockPos(i, MathHelper.floor((double)d), j);
                if (!(Globals.mc.world.getBlockState(blockPos).getBlock() instanceof BlockLiquid)) continue;
                return true;
            }
        }
        return false;
    }

    public static double[] Method1505(double d, double d2, double d3, EntityPlayer entityPlayer) {
        double d4 = entityPlayer.posX - d;
        double d5 = entityPlayer.posY - d2;
        double d6 = entityPlayer.posZ - d3;
        double d7 = Math.sqrt(d4 * d4 + d5 * d5 + d6 * d6);
        double d8 = Math.asin(d5 /= d7);
        double d9 = Math.atan2(d6 /= d7, d4 /= d7);
        d8 = d8 * 180.0 / Math.PI;
        d9 = d9 * 180.0 / Math.PI;
        return new double[]{d9 += 90.0, d8};
    }

    public static int Method3274(Item item) {
        if (Class354.Field2646.player == null) {
            return 0;
        }
        for (int i = 0; i < Class354.Field2646.player.inventoryContainer.getInventory().size(); ++i) {
            ItemStack itemStack;
            if (i == 0 || i == 5 || i == 6 || i == 7 || i == 8 || (itemStack = (ItemStack)Class354.Field2646.player.inventoryContainer.getInventory().get(i)).isEmpty() || itemStack.getItem() != item) continue;
            return i;
        }
        return -1;
    }

    public static boolean Method3273(Entity entity) {
        return entity instanceof EntityPlayer;
    }

    public static double Method3275(float f) {
        return MathHelper.sin((float)(-f * ((float)Math.PI / 180)));
    }

    public static double Method3276(float f) {
        return MathHelper.cos((float)(f * ((float)Math.PI / 180)));
    }

    public static boolean Method3277() {
        return Class354.Field2646.gameSettings.keyBindForward.isKeyDown() || Class354.Field2646.gameSettings.keyBindBack.isKeyDown() || Class354.Field2646.gameSettings.keyBindLeft.isKeyDown() || Class354.Field2646.gameSettings.keyBindRight.isKeyDown();
    }

    public static boolean Method3278() {
        return Class354.Field2646.player.moveForward > 0.0f || Class354.Field2646.player.moveStrafing > 0.0f || Class354.Field2646.player.moveForward < 0.0f || Class354.Field2646.player.moveStrafing < 0.0f;
    }

    public static boolean Method3279() {
        return Class354.Field2646.gameSettings.keyBindForward.isKeyDown();
    }

    public static void Method3280() {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        double d = Class354.Field2646.player.posX - Class354.Field2646.player.prevPosX;
        double d2 = Class354.Field2646.player.posY - Class354.Field2646.player.prevPosY;
    }

    public static int Method3281() {
        if (Class354.Field2646.world == null || Class354.Field2646.player == null || Class354.Field2646.player.getUniqueID() == null) {
            return 0;
        }
        NetworkPlayerInfo networkPlayerInfo = Field2646.getConnection().getPlayerInfo(Class354.Field2646.player.getUniqueID());
        if (networkPlayerInfo == null) {
            return 0;
        }
        return networkPlayerInfo.getResponseTime();
    }

    public static double Method3282(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d - d4;
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        return MathHelper.sqrt((double)(d7 * d7 + d8 * d8 + d9 * d9));
    }
}
