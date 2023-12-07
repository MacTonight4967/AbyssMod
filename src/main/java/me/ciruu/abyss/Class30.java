package me.ciruu.abyss;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import me.ciruu.abyss.Class29;
import me.ciruu.abyss.Class31;
import me.ciruu.abyss.Class354;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumHand;
import net.minecraft.util.MovementInput;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class Class30 {
    public static final Vec3d[] Field2210 = new Vec3d[]{new Vec3d(0.0, -2.0, 0.0)};
    public static final Vec3d[] Field2211 = new Vec3d[]{new Vec3d(0.0, -1.0, 0.0), new Vec3d(0.0, -1.0, -1.0), new Vec3d(0.0, -1.0, 1.0), new Vec3d(-1.0, -1.0, 0.0), new Vec3d(1.0, -1.0, 0.0)};
    public static final Vec3d[] Field2212 = new Vec3d[]{new Vec3d(-1.0, 0.0, 0.0), new Vec3d(1.0, 0.0, 0.0), new Vec3d(0.0, 0.0, -1.0), new Vec3d(0.0, 0.0, 1.0)};
    public static final Vec3d[] Field2213 = new Vec3d[]{new Vec3d(1.0, 1.0, 0.0), new Vec3d(-1.0, 1.0, 0.0), new Vec3d(0.0, 1.0, 1.0), new Vec3d(0.0, 1.0, -1.0), new Vec3d(0.0, 2.0, 0.0)};
    public static final Vec3d[] Field2214 = new Vec3d[]{new Vec3d(-1.0, 2.0, 0.0), new Vec3d(1.0, 2.0, 0.0), new Vec3d(0.0, 2.0, 1.0), new Vec3d(0.0, 2.0, -1.0)};
    public static final Vec3d[] Field2215 = new Vec3d[]{new Vec3d(0.0, 3.0, 0.0)};

    public static void Method2714(Entity entity, boolean bl) {
        if (bl) {
            Globals.mc.player.connection.sendPacket((Packet)new CPacketUseEntity(entity));
        } else {
            Globals.mc.playerController.attackEntity((EntityPlayer)Globals.mc.player, entity);
        }
    }

    public static void Method1524(Entity entity, boolean bl, boolean bl2) {
        Class30.Method2714(entity, bl);
        if (bl2) {
            Globals.mc.player.swingArm(EnumHand.MAIN_HAND);
        }
    }

    public static Vec3d Method778(Entity entity, float f) {
        return new Vec3d(entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f, entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f, entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f);
    }

    public static Vec3d Method968(Entity entity, float f) {
        return new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ).add(Class30.Method2715(entity, f));
    }

    public static Vec3d Method2079(Entity entity, float f) {
        return Class30.Method968(entity, f).subtract(Globals.mc.getRenderManager().renderPosX, Globals.mc.getRenderManager().renderPosY, Globals.mc.getRenderManager().renderPosZ);
    }

    public static Vec3d Method2716(Vec3d vec3d) {
        return new Vec3d(vec3d.x, vec3d.y, vec3d.z).subtract(Globals.mc.getRenderManager().renderPosX, Globals.mc.getRenderManager().renderPosY, Globals.mc.getRenderManager().renderPosZ);
    }

    public static Vec3d Method2717(Entity entity, double d, double d2, double d3) {
        return new Vec3d((entity.posX - entity.lastTickPosX) * d, (entity.posY - entity.lastTickPosY) * d2, (entity.posZ - entity.lastTickPosZ) * d3);
    }

    public static Vec3d Method2718(Entity entity, Vec3d vec3d) {
        return Class30.Method2717(entity, vec3d.x, vec3d.y, vec3d.z);
    }

    public static Vec3d Method2715(Entity entity, float f) {
        return Class30.Method2717(entity, f, f, f);
    }

    public static boolean Method231(Entity entity) {
        if (entity instanceof EntityWolf && ((EntityWolf)entity).isAngry()) {
            return false;
        }
        if (!(entity instanceof EntityAgeable || entity instanceof EntityAmbientCreature || entity instanceof EntitySquid)) {
            return entity instanceof EntityIronGolem && ((EntityIronGolem)entity).getRevengeTarget() == null;
        }
        return true;
    }

    public static boolean Method2719(Entity entity, int n, boolean bl) {
        return Class30.Method2720(entity, n, bl).size() == 0;
    }

    public static boolean Method1093(boolean bl) {
        if (bl && Globals.mc.player != null) {
            Globals.mc.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Globals.mc.player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
        return false;
    }

    public static boolean Method1513(Entity entity) {
        return Class30.Method2719(entity, 0, false);
    }

    public static BlockPos Method209(EntityPlayer entityPlayer) {
        return new BlockPos(Math.floor(entityPlayer.posX), Math.floor(entityPlayer.posY), Math.floor(entityPlayer.posZ));
    }

    public static List Method2720(Entity entity, int n, boolean bl) {
        return Class30.Method2721(entity.getPositionVector(), n, bl);
    }

    public static boolean Method2722(Entity entity) {
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
        return Class30.Method2723(entity);
    }

    public static boolean Method2724(Entity entity) {
        return entity instanceof EntityPigZombie || entity instanceof EntityWolf || entity instanceof EntityEnderman;
    }

    public static boolean Method2725(Entity entity) {
        return entity instanceof EntityShulkerBullet || entity instanceof EntityFireball;
    }

    public static boolean Method2726(Entity entity) {
        return entity instanceof EntityBoat || entity instanceof EntityMinecart;
    }

    public static boolean Method2727(Entity entity) {
        return entity.isCreatureType(EnumCreatureType.CREATURE, false) && !Class30.Method2724(entity) || entity.isCreatureType(EnumCreatureType.AMBIENT, false) || entity instanceof EntityVillager || entity instanceof EntityIronGolem || Class30.Method2724(entity) && !Class30.Method2722(entity);
    }

    public static boolean Method2723(Entity entity) {
        return entity.isCreatureType(EnumCreatureType.MONSTER, false) && !Class30.Method2724(entity);
    }

    public static List Method2721(Vec3d vec3d, int n, boolean bl) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        for (Vec3d vec3d2 : Class30.Method2728(n, bl)) {
            BlockPos blockPos = new BlockPos(vec3d).add(vec3d2.x, vec3d2.y, vec3d2.z);
            Block block = Globals.mc.world.getBlockState(blockPos).getBlock();
            if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid) && !(block instanceof BlockTallGrass) && !(block instanceof BlockFire) && !(block instanceof BlockDeadBush) && !(block instanceof BlockSnow)) continue;
            arrayList.add(vec3d2);
        }
        return arrayList;
    }

    public static boolean Method543(Entity entity) {
        return Class30.Method2729(new BlockPos(entity.posX, entity.posY, entity.posZ));
    }

    public static boolean Method2729(BlockPos blockPos) {
        return Class30.Method2730(blockPos) || Class30.Method2731(blockPos) || Class30.Method2732(blockPos);
    }

    public static boolean Method2731(BlockPos blockPos) {
        BlockPos[] blockPosArray;
        BlockPos[] blockPosArray2 = blockPosArray = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()};
        int n = blockPosArray.length;
        for (int i = 0; i < n; ++i) {
            BlockPos blockPos2 = blockPosArray2[i];
            IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && iBlockState.getBlock() == Blocks.OBSIDIAN) continue;
            return false;
        }
        return true;
    }

    public static boolean Method2730(BlockPos blockPos) {
        BlockPos[] blockPosArray;
        BlockPos[] blockPosArray2 = blockPosArray = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()};
        int n = blockPosArray.length;
        for (int i = 0; i < n; ++i) {
            BlockPos blockPos2 = blockPosArray2[i];
            IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && iBlockState.getBlock() == Blocks.BEDROCK) continue;
            return false;
        }
        return true;
    }

    public static boolean Method2732(BlockPos blockPos) {
        BlockPos[] blockPosArray;
        BlockPos[] blockPosArray2 = blockPosArray = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()};
        int n = blockPosArray.length;
        for (int i = 0; i < n; ++i) {
            BlockPos blockPos2 = blockPosArray2[i];
            IBlockState iBlockState = Globals.mc.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() != Blocks.AIR && (iBlockState.getBlock() == Blocks.BEDROCK || iBlockState.getBlock() == Blocks.OBSIDIAN)) continue;
            return false;
        }
        return true;
    }

    public static Vec3d[] Method2733(Entity entity, int n, boolean bl) {
        List list = Class30.Method2720(entity, n, bl);
        Vec3d[] vec3dArray = new Vec3d[list.size()];
        return list.toArray(vec3dArray);
    }

    public static Vec3d[] Method2734(Vec3d vec3d, int n, boolean bl) {
        List list = Class30.Method2721(vec3d, n, bl);
        Vec3d[] vec3dArray = new Vec3d[list.size()];
        return list.toArray(vec3dArray);
    }

    public static double Method2735(Vec3d vec3d) {
        return Globals.mc.player.getPositionVector().distanceTo(vec3d);
    }

    public static boolean Method2736(EntityPlayer entityPlayer, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        return Class30.Method2737(entityPlayer, bl, bl2, bl3, bl4, bl5).size() == 0;
    }

    public static boolean Method2738(int n, EntityPlayer entityPlayer, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        return Class30.Method2739(n, entityPlayer, bl, bl2, bl3, bl4, bl5, bl6).size() == 0;
    }

    public static List Method2737(EntityPlayer entityPlayer, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        if (!bl2 && Class30.Method2720((Entity)entityPlayer, 2, false).size() == 4) {
            arrayList.addAll(Class30.Method2720((Entity)entityPlayer, 2, false));
        }
        for (int i = 0; i < Class30.Method2740(bl, bl2, bl3, bl4, bl5).length; ++i) {
            Vec3d vec3d = Class30.Method2740(bl, bl2, bl3, bl4, bl5)[i];
            BlockPos blockPos = new BlockPos(entityPlayer.getPositionVector()).add(vec3d.x, vec3d.y, vec3d.z);
            Block block = Globals.mc.world.getBlockState(blockPos).getBlock();
            if (!(block instanceof BlockAir) && !(block instanceof BlockLiquid) && !(block instanceof BlockTallGrass) && !(block instanceof BlockFire) && !(block instanceof BlockDeadBush) && !(block instanceof BlockSnow)) continue;
            arrayList.add(vec3d);
        }
        return arrayList;
    }

    public static boolean Method2741(Entity entity) {
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

    public static boolean Method2742(Entity entity) {
        return Globals.mc.player != null && entity != null && entity.equals((Object)Globals.mc.player.getRidingEntity());
    }

    public static boolean Method2743(Entity entity) {
        return entity instanceof EntityPlayer;
    }

    public static boolean Method2744(Entity entity) {
        return Class30.Method2745(entity, false);
    }

    public static boolean Method2745(Entity entity, boolean bl) {
        if (entity == null) {
            return false;
        }
        double d = entity.posY - (bl ? 0.03 : (Class30.Method2743(entity) ? 0.2 : 0.5));
        for (int i = MathHelper.floor((double)entity.posX); i < MathHelper.ceil((double)entity.posX); ++i) {
            for (int j = MathHelper.floor((double)entity.posZ); j < MathHelper.ceil((double)entity.posZ); ++j) {
                BlockPos blockPos = new BlockPos(i, MathHelper.floor((double)d), j);
                if (!(Globals.mc.world.getBlockState(blockPos).getBlock() instanceof BlockLiquid)) continue;
                return true;
            }
        }
        return false;
    }

    public static List Method2739(int n, EntityPlayer entityPlayer, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        ArrayList arrayList = new ArrayList();
        if (n == 1) {
            arrayList.addAll(Class30.Method2746(entityPlayer.getPositionVector(), bl, bl2, bl3, bl4, bl5, bl6));
        } else {
            int n2 = 1;
            for (Vec3d vec3d : Class29.Method2747((Entity)entityPlayer)) {
                if (n2 > n) break;
                arrayList.addAll(Class30.Method2746(vec3d, bl, bl2, bl3, bl4, bl5, bl6));
                ++n2;
            }
        }
        ArrayList<Vec3d> arrayList2 = new ArrayList<Vec3d>();
        for (Vec3d vec3d : arrayList) {
            BlockPos blockPos = new BlockPos(vec3d);
            if (Class31.Method533(blockPos, bl6) != -1) continue;
            arrayList2.add(vec3d);
        }
        for (Vec3d vec3d : arrayList2) {
            arrayList.remove(vec3d);
        }
        return arrayList;
    }

    public static List Method2746(Vec3d vec3d, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        if (bl5) {
            Collections.addAll(arrayList, Class31.Method1291(vec3d, Field2210));
        }
        if (bl4) {
            Collections.addAll(arrayList, Class31.Method1291(vec3d, Field2211));
        }
        if (bl3) {
            Collections.addAll(arrayList, Class31.Method1291(vec3d, Field2212));
        }
        Collections.addAll(arrayList, Class31.Method1291(vec3d, Field2213));
        if (bl2) {
            Collections.addAll(arrayList, Class31.Method1291(vec3d, Field2214));
        } else {
            List list = Class30.Method2721(vec3d, 2, false);
            if (list.size() == 4) {
                block4: for (Vec3d vec3d2 : list) {
                    BlockPos blockPos = new BlockPos(vec3d).add(vec3d2.x, vec3d2.y, vec3d2.z);
                    switch (Class31.Method533(blockPos, bl6)) {
                        case -1: 
                        case 1: 
                        case 2: {
                            continue block4;
                        }
                        default: {
                            break;
                        }
                        case 3: {
                            arrayList.add(vec3d.add(vec3d2));
                            break;
                        }
                    }
                    break;
                }
            }
        }
        if (bl) {
            Collections.addAll(arrayList, Class31.Method1291(vec3d, Field2215));
        }
        return arrayList;
    }

    public static List Method2748(int n, boolean bl) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        arrayList.add(new Vec3d(-1.0, (double)n, 0.0));
        arrayList.add(new Vec3d(1.0, (double)n, 0.0));
        arrayList.add(new Vec3d(0.0, (double)n, -1.0));
        arrayList.add(new Vec3d(0.0, (double)n, 1.0));
        if (bl) {
            arrayList.add(new Vec3d(0.0, (double)(n - 1), 0.0));
        }
        return arrayList;
    }

    public static Vec3d[] Method2728(int n, boolean bl) {
        List list = Class30.Method2748(n, bl);
        Vec3d[] vec3dArray = new Vec3d[list.size()];
        return list.toArray(vec3dArray);
    }

    public static Vec3d[] Method2740(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        List list = Class30.Method2749(bl, bl2, bl3, bl4, bl5);
        Vec3d[] vec3dArray = new Vec3d[list.size()];
        return list.toArray(vec3dArray);
    }

    public static List Method2749(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>(Class30.Method2748(1, false));
        arrayList.add(new Vec3d(0.0, 2.0, 0.0));
        if (bl) {
            arrayList.add(new Vec3d(0.0, 3.0, 0.0));
        }
        if (bl2) {
            arrayList.addAll(Class30.Method2748(2, false));
        }
        if (bl3) {
            arrayList.addAll(Class30.Method2748(0, false));
        }
        if (bl4) {
            arrayList.addAll(Class30.Method2748(-1, false));
            arrayList.add(new Vec3d(0.0, -1.0, 0.0));
        }
        if (bl5) {
            arrayList.add(new Vec3d(0.0, -2.0, 0.0));
        }
        return arrayList;
    }

    public static Vec3d[] Method2750(int n, int n2) {
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        for (int i = n; i <= n2; ++i) {
            arrayList.add(new Vec3d(0.0, (double)i, 0.0));
        }
        Vec3d[] vec3dArray = new Vec3d[arrayList.size()];
        return arrayList.toArray(vec3dArray);
    }

    public static BlockPos Method2751(Entity entity) {
        return new BlockPos(Class29.Method2752(entity.getPositionVector(), 0));
    }

    public static boolean Method2753(Entity entity) {
        return entity instanceof EntityLivingBase;
    }

    public static boolean Method2754(Entity entity) {
        return Class30.Method2753(entity) && !entity.isDead && ((EntityLivingBase)entity).getHealth() > 0.0f;
    }

    public static boolean Method2755(Entity entity) {
        return !Class30.Method2754(entity);
    }

    public static float Method1454(Entity entity) {
        if (Class30.Method2753(entity)) {
            EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
            return entityLivingBase.getHealth() + entityLivingBase.getAbsorptionAmount();
        }
        return 0.0f;
    }

    public static float Method2756(Entity entity, boolean bl) {
        if (Class30.Method2753(entity)) {
            EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
            return entityLivingBase.getHealth() + (bl ? entityLivingBase.getAbsorptionAmount() : 0.0f);
        }
        return 0.0f;
    }

    public static boolean Method2757(Entity entity) {
        return Globals.mc.world.rayTraceBlocks(new Vec3d(Globals.mc.player.posX, Globals.mc.player.posX + (double)Globals.mc.player.getEyeHeight(), Globals.mc.player.posZ), new Vec3d(entity.posX, entity.posY, entity.posZ), false, true, false) == null;
    }

    public static boolean Method749(Entity entity, double d) {
        return entity == null || Class30.Method2755(entity) || entity.equals((Object)Globals.mc.player) || entity instanceof EntityPlayer && Manager.Field223.Method233(entity.getName()) || Globals.mc.player.getDistanceSq(entity) > Class29.Method114(d);
    }

    public static boolean Method1471(Entity entity, double d) {
        return !Class30.Method749(entity, d);
    }

    public static boolean Method2758(EntityPlayer entityPlayer) {
        if (entityPlayer == null) {
            return false;
        }
        return entityPlayer.getHeldItemMainhand().getItem() instanceof ItemSword || entityPlayer.getHeldItemMainhand().getItem() instanceof ItemAxe;
    }

    public static double Method2759() {
        double d = 0.2873;
        if (Globals.mc.player.isPotionActive(Objects.requireNonNull(Potion.getPotionById((int)1)))) {
            d *= 1.0 + 0.2 * (double)(Objects.requireNonNull(Globals.mc.player.getActivePotionEffect(Objects.requireNonNull(Potion.getPotionById((int)1)))).getAmplifier() + 1);
        }
        return d;
    }

    public static void Method2760(Entity entity, double d) {
        if (entity != null) {
            entity.motionX *= d;
            entity.motionZ *= d;
        }
    }

    public static boolean Method2761(Entity entity) {
        if (entity == null) {
            return false;
        }
        if (entity instanceof EntityPlayer) {
            return Globals.mc.gameSettings.keyBindForward.isKeyDown() || Globals.mc.gameSettings.keyBindBack.isKeyDown() || Globals.mc.gameSettings.keyBindLeft.isKeyDown() || Globals.mc.gameSettings.keyBindRight.isKeyDown();
        }
        return entity.motionX != 0.0 || entity.motionY != 0.0 || entity.motionZ != 0.0;
    }

    public static double Method2762(Entity entity) {
        if (entity != null) {
            double d = entity.posX - entity.prevPosX;
            double d2 = entity.posZ - entity.prevPosZ;
            double d3 = MathHelper.sqrt((double)(d * d + d2 * d2));
            return d3 * 20.0;
        }
        return 0.0;
    }

    public static boolean Method2763(EntityPlayer entityPlayer) {
        return Class30.Method2764(entityPlayer.getHeldItemMainhand());
    }

    public static boolean Method2764(ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if (itemStack.getTagCompound() == null) {
            return false;
        }
        NBTTagList nBTTagList = (NBTTagList)itemStack.getTagCompound().getTag("ench");
        if (nBTTagList == null) {
            return false;
        }
        for (int i = 0; i < nBTTagList.tagCount(); ++i) {
            NBTTagCompound nBTTagCompound = nBTTagList.getCompoundTagAt(i);
            if (nBTTagCompound.getInteger("id") != 16) continue;
            int n = nBTTagCompound.getInteger("lvl");
            if (n < 42) break;
            return true;
        }
        return false;
    }

    public static boolean Method2765(ItemStack itemStack) {
        return EnchantmentHelper.getEnchantmentLevel((Enchantment)Enchantments.SHARPNESS, (ItemStack)itemStack) >= 1000;
    }

    public static void Method2766(double d, Entity entity) {
        if (entity != null) {
            MovementInput movementInput = Globals.mc.player.movementInput;
            double d2 = movementInput.moveForward;
            double d3 = movementInput.moveStrafe;
            float f = Globals.mc.player.rotationYaw;
            if (d2 == 0.0 && d3 == 0.0) {
                entity.motionX = 0.0;
                entity.motionZ = 0.0;
            } else {
                if (d2 != 0.0) {
                    if (d3 > 0.0) {
                        f += (float)(d2 > 0.0 ? -45 : 45);
                    } else if (d3 < 0.0) {
                        f += (float)(d2 > 0.0 ? 45 : -45);
                    }
                    d3 = 0.0;
                    if (d2 > 0.0) {
                        d2 = 1.0;
                    } else if (d2 < 0.0) {
                        d2 = -1.0;
                    }
                }
                entity.motionX = d2 * d * Math.cos(Math.toRadians(f + 90.0f)) + d3 * d * Math.sin(Math.toRadians(f + 90.0f));
                entity.motionZ = d2 * d * Math.sin(Math.toRadians(f + 90.0f)) - d3 * d * Math.cos(Math.toRadians(f + 90.0f));
            }
        }
    }

    public static boolean Method2767(Entity entity, boolean bl) {
        return !bl || Globals.mc.player.canEntityBeSeen(entity);
    }

    public static Color Method2768(Entity entity, int n, int n2, int n3, int n4, boolean bl) {
        Color color = new Color((float)n / 255.0f, (float)n2 / 255.0f, (float)n3 / 255.0f, (float)n4 / 255.0f);
        if (entity instanceof EntityPlayer && bl && Manager.Field223.Method711((Entity)((EntityPlayer)entity))) {
            color = new Color(0.33333334f, 1.0f, 1.0f, (float)n4 / 255.0f);
        }
        return color;
    }

    public static boolean Method1832() {
        return (double)Globals.mc.player.moveForward != 0.0 || (double)Globals.mc.player.moveStrafing != 0.0;
    }

    public static EntityPlayer Method1810(double d) {
        EntityPlayer entityPlayer = null;
        for (EntityPlayer entityPlayer2 : Globals.mc.world.playerEntities) {
            if (Class30.Method749((Entity)entityPlayer2, d)) continue;
            if (entityPlayer == null) {
                entityPlayer = entityPlayer2;
                continue;
            }
            if (!(Globals.mc.player.getDistanceSq((Entity)entityPlayer2) < Globals.mc.player.getDistanceSq((Entity)entityPlayer))) continue;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    public static boolean Method2769() {
        if (Globals.mc.player.isSneaking()) {
            return false;
        }
        if (Globals.mc.player.getRidingEntity() != null && Globals.mc.player.getRidingEntity().fallDistance >= 3.0f) {
            return false;
        }
        return Globals.mc.player.fallDistance < 3.0f;
    }

    public static boolean Method1834() {
        if (Globals.mc.player.fallDistance >= 3.0f) {
            return false;
        }
        boolean bl = false;
        AxisAlignedBB axisAlignedBB = Globals.mc.player.getRidingEntity() != null ? Globals.mc.player.getRidingEntity().getEntityBoundingBox() : Globals.mc.player.getEntityBoundingBox();
        int n = (int)axisAlignedBB.minY;
        for (int i = MathHelper.floor((double)axisAlignedBB.minX); i < MathHelper.floor((double)axisAlignedBB.maxX) + 1; ++i) {
            for (int j = MathHelper.floor((double)axisAlignedBB.minZ); j < MathHelper.floor((double)axisAlignedBB.maxZ) + 1; ++j) {
                Block block = Globals.mc.world.getBlockState(new BlockPos(i, n, j)).getBlock();
                if (block instanceof BlockAir) continue;
                if (!(block instanceof BlockLiquid)) {
                    return false;
                }
                bl = true;
            }
        }
        return bl;
    }

    public static boolean Method2770(double d) {
        if (Globals.mc.player.fallDistance >= 3.0f) {
            return false;
        }
        AxisAlignedBB axisAlignedBB = Globals.mc.player.getRidingEntity() != null ? Globals.mc.player.getRidingEntity().getEntityBoundingBox().contract(0.0, 0.0, 0.0).offset(0.0, -d, 0.0) : Globals.mc.player.getEntityBoundingBox().contract(0.0, 0.0, 0.0).offset(0.0, -d, 0.0);
        boolean bl = false;
        int n = (int)axisAlignedBB.minY;
        for (int i = MathHelper.floor((double)axisAlignedBB.minX); i < MathHelper.floor((double)(axisAlignedBB.maxX + 1.0)); ++i) {
            for (int j = MathHelper.floor((double)axisAlignedBB.minZ); j < MathHelper.floor((double)(axisAlignedBB.maxZ + 1.0)); ++j) {
                Block block = Globals.mc.world.getBlockState(new BlockPos(i, n, j)).getBlock();
                if (block == Blocks.AIR) continue;
                if (!(block instanceof BlockLiquid)) {
                    return false;
                }
                bl = true;
            }
        }
        return bl;
    }

    public static boolean Method2771(Entity entity) {
        if (entity == null) {
            return false;
        }
        double d = entity.posY + 0.01;
        for (int i = MathHelper.floor((double)entity.posX); i < MathHelper.ceil((double)entity.posX); ++i) {
            for (int j = MathHelper.floor((double)entity.posZ); j < MathHelper.ceil((double)entity.posZ); ++j) {
                if (!(Globals.mc.world.getBlockState(new BlockPos(i, (int)d, j)).getBlock() instanceof BlockLiquid)) continue;
                return true;
            }
        }
        return false;
    }

    public static BlockPos Method2772() {
        return new BlockPos(Globals.mc.player.getRidingEntity() != null ? Globals.mc.player.getRidingEntity().posX : Globals.mc.player.posX, Globals.mc.player.getRidingEntity() != null ? Globals.mc.player.getRidingEntity().posY : Globals.mc.player.posY, Globals.mc.player.getRidingEntity() != null ? Globals.mc.player.getRidingEntity().posZ : Globals.mc.player.posZ);
    }

    public static boolean Method2773(Entity entity, boolean bl) {
        if (entity == null) {
            return false;
        }
        double d = entity.posY;
        double d2 = bl ? 0.03 : (entity instanceof EntityPlayer ? 0.2 : 0.5);
        double d3 = d - d2;
        for (int i = MathHelper.floor((double)entity.posX); i < MathHelper.ceil((double)entity.posX); ++i) {
            for (int j = MathHelper.floor((double)entity.posZ); j < MathHelper.ceil((double)entity.posZ); ++j) {
                if (!(Globals.mc.world.getBlockState(new BlockPos(i, MathHelper.floor((double)d3), j)).getBlock() instanceof BlockLiquid)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean Method1835() {
        double d = Globals.mc.player.posY - 0.03;
        for (int i = MathHelper.floor((double)Globals.mc.player.posX); i < MathHelper.ceil((double)Globals.mc.player.posX); ++i) {
            for (int j = MathHelper.floor((double)Globals.mc.player.posZ); j < MathHelper.ceil((double)Globals.mc.player.posZ); ++j) {
                BlockPos blockPos = new BlockPos(i, MathHelper.floor((double)d), j);
                if (!(Globals.mc.world.getBlockState(blockPos).getBlock() instanceof BlockLiquid)) continue;
                return true;
            }
        }
        return false;
    }

    public static double[] Method2774(double d) {
        float f = Globals.mc.player.movementInput.moveForward;
        float f2 = Globals.mc.player.movementInput.moveStrafe;
        float f3 = Globals.mc.player.prevRotationYaw + (Globals.mc.player.rotationYaw - Globals.mc.player.prevRotationYaw) * Globals.mc.getRenderPartialTicks();
        if (f != 0.0f) {
            if (f2 > 0.0f) {
                f3 += (float)(f > 0.0f ? -45 : 45);
            } else if (f2 < 0.0f) {
                f3 += (float)(f > 0.0f ? 45 : -45);
            }
            f2 = 0.0f;
            if (f > 0.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = -1.0f;
            }
        }
        double d2 = Math.sin(Math.toRadians(f3 + 90.0f));
        double d3 = Math.cos(Math.toRadians(f3 + 90.0f));
        double d4 = (double)f * d * d3 + (double)f2 * d * d2;
        double d5 = (double)f * d * d2 - (double)f2 * d * d3;
        return new double[]{d4, d5};
    }

    public static boolean Method2775(Entity entity, BlockPos blockPos) {
        return entity.posY >= (double)blockPos.getY();
    }

    public static boolean Method51() {
        for (Entity entity : Globals.mc.world.loadedEntityList) {
            if (!(entity instanceof EntityItem) && !(entity instanceof EntityXPOrb) && !(entity instanceof EntityArrow) || !(Globals.mc.player.getDistance(entity) <= 6.0f)) continue;
            return true;
        }
        return false;
    }

    public static boolean Method2776(EntityPlayer entityPlayer) {
        return entityPlayer.getHeldItemMainhand().getItem() == Items.END_CRYSTAL || entityPlayer.getHeldItemOffhand().getItem() == Items.END_CRYSTAL;
    }

    public static EntityPlayer Method518() {
        if (Globals.mc.world.playerEntities.isEmpty()) {
            return null;
        }
        EntityPlayer entityPlayer = null;
        for (EntityPlayer entityPlayer2 : Globals.mc.world.playerEntities) {
            if (entityPlayer2 == Globals.mc.player || Manager.Field223.Method711((Entity)entityPlayer2) || !Class354.Method1908((Entity)entityPlayer2) || entityPlayer2.getHealth() <= 0.0f || entityPlayer != null && Minecraft.getMinecraft().player.getDistance((Entity)entityPlayer2) > Minecraft.getMinecraft().player.getDistance((Entity)entityPlayer)) continue;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }
}
