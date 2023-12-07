package me.ciruu.abyss;

import java.text.DecimalFormat;
import me.ciruu.abyss.enums.Class243;
import me.ciruu.abyss.events.player.EventPlayerUpdateWalking;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class Class202 {
    private static Minecraft Field646 = Minecraft.getMinecraft();
    static final DecimalFormat Field647 = new DecimalFormat("#.#");

    public static int Method923(Item item) {
        if (Class202.Field646.player == null) {
            return 0;
        }
        for (int i = 0; i < Class202.Field646.player.inventoryContainer.getInventory().size(); ++i) {
            ItemStack itemStack;
            if (i == 0 || i == 5 || i == 6 || i == 7 || i == 8 || (itemStack = (ItemStack)Class202.Field646.player.inventoryContainer.getInventory().get(i)).isEmpty() || itemStack.getItem() != item) continue;
            return i;
        }
        return -1;
    }

    public static int Method924(Item item) {
        if (Class202.Field646.player == null) {
            return 0;
        }
        for (int i = Class202.Field646.player.inventoryContainer.getInventory().size() - 1; i > 0; --i) {
            ItemStack itemStack;
            if (i == 0 || i == 5 || i == 6 || i == 7 || i == 8 || (itemStack = (ItemStack)Class202.Field646.player.inventoryContainer.getInventory().get(i)).isEmpty() || itemStack.getItem() != item) continue;
            return i;
        }
        return -1;
    }

    public static int Method925(Item item) {
        if (Class202.Field646.player == null) {
            return 0;
        }
        for (int i = 9; i < 36; ++i) {
            Item item2 = Class202.Field646.player.inventory.getStackInSlot(i).getItem();
            if (item2 != item) continue;
            return i;
        }
        return -1;
    }

    public static int Method926(Item item) {
        if (Class202.Field646.player == null) {
            return 0;
        }
        int n = 0;
        for (int i = 0; i < 45; ++i) {
            ItemStack itemStack = Class202.Field646.player.inventory.getStackInSlot(i);
            if (itemStack.getItem() != item) continue;
            n += itemStack.getCount();
        }
        return n;
    }

    public static boolean Method927(BlockPos blockPos) {
        if (Class202.Field646.player == null) {
            return false;
        }
        return Class202.Field646.world.rayTraceBlocks(new Vec3d(Class202.Field646.player.posX, Class202.Field646.player.posY + (double)Class202.Field646.player.getEyeHeight(), Class202.Field646.player.posZ), new Vec3d((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ()), false, true, false) == null;
    }

    public static boolean Method928() {
        return Field646.getRenderViewEntity() == Class202.Field646.player;
    }

    public static boolean Method929() {
        return Class202.Field646.player != null && Class202.Field646.player.getHeldItemMainhand().getItem() instanceof ItemFood && Class202.Field646.player.isHandActive();
    }

    public static int Method930(Item item) {
        for (int i = 0; i < 9; ++i) {
            ItemStack itemStack = Class202.Field646.player.inventory.getStackInSlot(i);
            if (itemStack == ItemStack.EMPTY || itemStack.getItem() != item) continue;
            return i;
        }
        return -1;
    }

    public static BlockPos Method931() {
        return new BlockPos(Math.floor(Class202.Field646.player.posX), Math.floor(Class202.Field646.player.posY), Math.floor(Class202.Field646.player.posZ));
    }

    public static BlockPos Method932(Entity entity) {
        return new BlockPos(Math.floor(entity.posX), Math.floor(entity.posY), Math.floor(entity.posZ));
    }

    public static float Method933() {
        return Class202.Field646.player.getHealth() + Class202.Field646.player.getAbsorptionAmount();
    }

    public static boolean Method577() {
        BlockPos blockPos = Class202.Method931();
        IBlockState iBlockState = Class202.Field646.world.getBlockState(blockPos);
        if (iBlockState.getBlock() != Blocks.AIR) {
            return false;
        }
        if (Class202.Field646.world.getBlockState(blockPos.up()).getBlock() != Blocks.AIR) {
            return false;
        }
        if (Class202.Field646.world.getBlockState(blockPos.down()).getBlock() == Blocks.AIR) {
            return false;
        }
        BlockPos[] blockPosArray = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west()};
        int n = 0;
        for (BlockPos blockPos2 : blockPosArray) {
            IBlockState iBlockState2 = Class202.Field646.world.getBlockState(blockPos2);
            if (iBlockState2.getBlock() == Blocks.AIR || !iBlockState2.isFullBlock()) continue;
            ++n;
        }
        return n >= 4;
    }

    public static void Method934(float f, float f2) {
        boolean bl;
        boolean bl2 = Class202.Field646.player.isSprinting();
        if (bl2 != Class202.Field646.player.serverSprintState) {
            if (bl2) {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Class202.Field646.player, CPacketEntityAction.Action.START_SPRINTING));
            } else {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Class202.Field646.player, CPacketEntityAction.Action.STOP_SPRINTING));
            }
            Class202.Field646.player.serverSprintState = bl2;
        }
        if ((bl = Class202.Field646.player.isSneaking()) != Class202.Field646.player.serverSneakState) {
            if (bl) {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Class202.Field646.player, CPacketEntityAction.Action.START_SNEAKING));
            } else {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Class202.Field646.player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            Class202.Field646.player.serverSneakState = bl;
        }
        if (Class202.Method928()) {
            boolean bl3;
            float f3 = f;
            float f4 = f2;
            AxisAlignedBB axisAlignedBB = Class202.Field646.player.getEntityBoundingBox();
            double d = Class202.Field646.player.posX - Class202.Field646.player.lastReportedPosX;
            double d2 = axisAlignedBB.minY - Class202.Field646.player.lastReportedPosY;
            double d3 = Class202.Field646.player.posZ - Class202.Field646.player.lastReportedPosZ;
            double d4 = f4 - Class202.Field646.player.lastReportedYaw;
            double d5 = f3 - Class202.Field646.player.lastReportedPitch;
            ++Class202.Field646.player.positionUpdateTicks;
            boolean bl4 = d * d + d2 * d2 + d3 * d3 > 9.0E-4 || Class202.Field646.player.positionUpdateTicks >= 20;
            boolean bl5 = bl3 = d4 != 0.0 || d5 != 0.0;
            if (Class202.Field646.player.isRiding()) {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketPlayer.PositionRotation(Class202.Field646.player.motionX, -999.0, Class202.Field646.player.motionZ, f4, f3, Class202.Field646.player.onGround));
                bl4 = false;
            } else if (bl4 && bl3) {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketPlayer.PositionRotation(Class202.Field646.player.posX, axisAlignedBB.minY, Class202.Field646.player.posZ, f4, f3, Class202.Field646.player.onGround));
            } else if (bl4) {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketPlayer.Position(Class202.Field646.player.posX, axisAlignedBB.minY, Class202.Field646.player.posZ, Class202.Field646.player.onGround));
            } else if (bl3) {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(f4, f3, Class202.Field646.player.onGround));
            } else if (Class202.Field646.player.prevOnGround != Class202.Field646.player.onGround) {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketPlayer(Class202.Field646.player.onGround));
            }
            if (bl4) {
                Class202.Field646.player.lastReportedPosX = Class202.Field646.player.posX;
                Class202.Field646.player.lastReportedPosY = axisAlignedBB.minY;
                Class202.Field646.player.lastReportedPosZ = Class202.Field646.player.posZ;
                Class202.Field646.player.positionUpdateTicks = 0;
            }
            if (bl3) {
                Class202.Field646.player.lastReportedYaw = f4;
                Class202.Field646.player.lastReportedPitch = f3;
            }
            Class202.Field646.player.prevOnGround = Class202.Field646.player.onGround;
            Class202.Field646.player.autoJumpEnabled = Class202.Field646.player.mc.gameSettings.autoJump;
        }
    }

    public static boolean Method935() {
        BlockPos[] blockPosArray;
        BlockPos blockPos = Class202.Method931();
        for (BlockPos blockPos2 : blockPosArray = new BlockPos[]{blockPos.down(), blockPos.up().up(), blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.north().up(), blockPos.south().up(), blockPos.east().up(), blockPos.west().up()}) {
            IBlockState iBlockState = Class202.Field646.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() == Blocks.OBSIDIAN || Class202.Field646.world.getBlockState(blockPos2).getBlock() == Blocks.BEDROCK) continue;
            return false;
        }
        return true;
    }

    public static boolean Method936(Entity entity) {
        BlockPos[] blockPosArray;
        BlockPos blockPos = Class202.Method932(entity);
        for (BlockPos blockPos2 : blockPosArray = new BlockPos[]{blockPos.up().up(), blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.north().up(), blockPos.south().up(), blockPos.east().up(), blockPos.west().up()}) {
            IBlockState iBlockState = Class202.Field646.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() == Blocks.OBSIDIAN || Class202.Field646.world.getBlockState(blockPos2).getBlock() == Blocks.BEDROCK) continue;
            return false;
        }
        return true;
    }

    public static Class243 Method937() {
        switch (MathHelper.floor((double)((double)(Class202.Field646.player.rotationYaw * 8.0f / 360.0f) + 0.5)) & 7) {
            case 0: 
            case 1: {
                return Class243.South;
            }
            case 2: 
            case 3: {
                return Class243.West;
            }
            case 4: 
            case 5: {
                return Class243.North;
            }
            case 6: 
            case 7: {
                return Class243.East;
            }
        }
        return Class243.North;
    }

    public static float Method938() {
        double d = Class202.Field646.player.posX - Class202.Field646.player.prevPosX;
        double d2 = Class202.Field646.player.posZ - Class202.Field646.player.prevPosZ;
        float f = MathHelper.sqrt((double)(d * d + d2 * d2));
        double d3 = Math.floor(f / 1000.0f / 1.3888889E-5f);
        String string = Field647.format(d3);
        if (!string.contains(".")) {
            string = string + ".0";
        }
        return Float.valueOf(string).floatValue();
    }

    public static void Method939(EventPlayerUpdateWalking eventPlayerUpdateWalking) {
        boolean bl;
        boolean bl2 = Class202.Field646.player.isSprinting();
        if (bl2 != Class202.Field646.player.serverSprintState) {
            if (bl2) {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Class202.Field646.player, CPacketEntityAction.Action.START_SPRINTING));
            } else {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Class202.Field646.player, CPacketEntityAction.Action.STOP_SPRINTING));
            }
            Class202.Field646.player.serverSprintState = bl2;
        }
        if ((bl = Class202.Field646.player.isSneaking()) != Class202.Field646.player.serverSneakState) {
            if (bl) {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Class202.Field646.player, CPacketEntityAction.Action.START_SNEAKING));
            } else {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)Class202.Field646.player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            Class202.Field646.player.serverSneakState = bl;
        }
        if (Field646.getRenderViewEntity() == Class202.Field646.player) {
            boolean bl3;
            double d = Class202.Field646.player.posX - Class202.Field646.player.lastReportedPosX;
            double d2 = eventPlayerUpdateWalking.getY() - Class202.Field646.player.lastReportedPosY;
            double d3 = Class202.Field646.player.posZ - Class202.Field646.player.lastReportedPosZ;
            double d4 = eventPlayerUpdateWalking.getYaw() - Class202.Field646.player.lastReportedYaw;
            double d5 = eventPlayerUpdateWalking.getPitch() - Class202.Field646.player.lastReportedPitch;
            ++Class202.Field646.player.positionUpdateTicks;
            boolean bl4 = d * d + d2 * d2 + d3 * d3 > 9.0E-4 || Class202.Field646.player.positionUpdateTicks >= 20;
            boolean bl5 = bl3 = d4 != 0.0 || d5 != 0.0;
            if (Class202.Field646.player.isRiding()) {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketPlayer.PositionRotation(Class202.Field646.player.motionX, -999.0, Class202.Field646.player.motionZ, eventPlayerUpdateWalking.getYaw(), eventPlayerUpdateWalking.getPitch(), Class202.Field646.player.onGround));
                bl4 = false;
            } else if (bl4 && bl3) {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketPlayer.PositionRotation(Class202.Field646.player.posX, eventPlayerUpdateWalking.getY(), Class202.Field646.player.posZ, eventPlayerUpdateWalking.getYaw(), eventPlayerUpdateWalking.getPitch(), Class202.Field646.player.onGround));
            } else if (bl4) {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketPlayer.Position(Class202.Field646.player.posX, eventPlayerUpdateWalking.getY(), Class202.Field646.player.posZ, Class202.Field646.player.onGround));
            } else if (bl3) {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(eventPlayerUpdateWalking.getYaw(), eventPlayerUpdateWalking.getPitch(), Class202.Field646.player.onGround));
            } else if (Class202.Field646.player.prevOnGround != Class202.Field646.player.onGround) {
                Class202.Field646.player.connection.sendPacket((Packet)new CPacketPlayer(Class202.Field646.player.onGround));
            }
            if (bl4) {
                Class202.Field646.player.lastReportedPosX = Class202.Field646.player.posX;
                Class202.Field646.player.lastReportedPosY = eventPlayerUpdateWalking.getY();
                Class202.Field646.player.lastReportedPosZ = Class202.Field646.player.posZ;
                Class202.Field646.player.positionUpdateTicks = 0;
            }
            if (bl3) {
                Class202.Field646.player.lastReportedYaw = eventPlayerUpdateWalking.getYaw();
                Class202.Field646.player.lastReportedPitch = eventPlayerUpdateWalking.getPitch();
            }
            Class202.Field646.player.prevOnGround = Class202.Field646.player.onGround;
            Class202.Field646.player.autoJumpEnabled = Class202.Field646.player.mc.gameSettings.autoJump;
        }
    }

    public static boolean Method940() {
        if (Class202.Field646.player == null) {
            return false;
        }
        boolean bl = false;
        int n = (int)(Class202.Field646.player.getEntityBoundingBox().minY + 0.02);
        for (int i = MathHelper.floor((double)Class202.Field646.player.getEntityBoundingBox().minX); i < MathHelper.floor((double)Class202.Field646.player.getEntityBoundingBox().maxX) + 1; ++i) {
            for (int j = MathHelper.floor((double)Class202.Field646.player.getEntityBoundingBox().minZ); j < MathHelper.floor((double)Class202.Field646.player.getEntityBoundingBox().maxZ) + 1; ++j) {
                Block block = Class202.Field646.world.getBlockState(new BlockPos(i, n, j)).getBlock();
                if (block == null || block instanceof BlockAir) continue;
                if (!(block instanceof BlockLiquid)) {
                    return false;
                }
                bl = true;
            }
        }
        return bl;
    }

    public static boolean Method941() {
        float f = 0.05f;
        Minecraft minecraft = Minecraft.getMinecraft();
        if (minecraft.player == null) {
            return false;
        }
        if (minecraft.player.fallDistance >= 3.0f) {
            return false;
        }
        if (minecraft.player != null) {
            AxisAlignedBB axisAlignedBB = minecraft.player.getRidingEntity() != null ? minecraft.player.getRidingEntity().getEntityBoundingBox().contract(0.0, 0.0, 0.0).offset(0.0, (double)-0.05f, 0.0) : minecraft.player.getEntityBoundingBox().contract(0.0, 0.0, 0.0).offset(0.0, (double)-0.05f, 0.0);
            boolean bl = false;
            int n = (int)axisAlignedBB.minY;
            for (int i = MathHelper.floor((double)axisAlignedBB.minX); i < MathHelper.floor((double)(axisAlignedBB.maxX + 1.0)); ++i) {
                for (int j = MathHelper.floor((double)axisAlignedBB.minZ); j < MathHelper.floor((double)(axisAlignedBB.maxZ + 1.0)); ++j) {
                    Block block = minecraft.world.getBlockState(new BlockPos(i, n, j)).getBlock();
                    if (block == Blocks.AIR) continue;
                    if (!(block instanceof BlockLiquid)) {
                        return false;
                    }
                    bl = true;
                }
            }
            return bl;
        }
        return false;
    }
}
