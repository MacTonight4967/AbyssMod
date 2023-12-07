package me.ciruu.abyss.mixin.client.blocks;

import me.ciruu.abyss.AbyssMod;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.events.render.EventRenderBlockLayer;
import me.ciruu.abyss.modules.exploit.Phase;
import me.ciruu.abyss.modules.render.WallHack;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={Block.class})
public class MixinBlock {
    @Inject(method={"shouldSideBeRendered"}, at={@At(value="HEAD")}, cancellable=true)
    public void shouldSideBeRendered(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing, CallbackInfoReturnable callbackInfoReturnable) {
        if (Manager.moduleManager.getModuleByClass(WallHack.class) != null && Manager.moduleManager.isModuleEnabled(WallHack.class)) {
            ((WallHack)Manager.moduleManager.getModuleByClass(WallHack.class)).Method2463((Block)this, iBlockState, iBlockAccess, blockPos, enumFacing, callbackInfoReturnable);
        }
    }

    @Inject(method={"getRenderLayer"}, at={@At(value="HEAD")}, cancellable=true)
    public void getRenderLayer(CallbackInfoReturnable callbackInfoReturnable) {
        EventRenderBlockLayer eventRenderBlockLayer = new EventRenderBlockLayer((Block)this);
        AbyssMod.EVENT_BUS.post(eventRenderBlockLayer);
        if (eventRenderBlockLayer.isCancelled()) {
            callbackInfoReturnable.cancel();
            callbackInfoReturnable.setReturnValue(eventRenderBlockLayer.getBlockRenderLayer());
        }
    }

    @Inject(method={"getLightValue"}, at={@At(value="HEAD")}, cancellable=true)
    public void getLightValue(CallbackInfoReturnable callbackInfoReturnable) {
        if (Manager.moduleManager.getModuleByClass(WallHack.class) != null && Manager.moduleManager.isModuleEnabled(WallHack.class)) {
            ((WallHack)Manager.moduleManager.getModuleByClass(WallHack.class)).Method2464((Block)this, callbackInfoReturnable);
        }
    }

    @Inject(method={"getCollisionBoundingBox"}, at={@At(value="RETURN")}, cancellable=true)
    public void shouldSideBeRendered(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, CallbackInfoReturnable callbackInfoReturnable) {
        if (Manager.moduleManager.getModuleByClass(Phase.class) != null && Manager.moduleManager.isModuleEnabled(Phase.class) && ((Phase)Manager.moduleManager.getModuleByClass(Phase.class)).Method2465()) {
            callbackInfoReturnable.setReturnValue(new AxisAlignedBB(0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
        }
    }
}
