package me.ciruu.abyss.mixin.client;

import io.netty.channel.ChannelHandlerContext;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import me.ciruu.abyss.AbyssMod;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.events.network.EventNetworkExceptionCaught;
import me.ciruu.abyss.events.network.EventNetworkPostPacketEvent;
import me.ciruu.abyss.events.network.EventNetworkPrePacketEvent;
import me.zero.alpine.event.type.Cancellable;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={NetworkManager.class}, priority=0)
public class MixinNetworkManager {
    @Inject(method={"sendPacket(Lnet/minecraft/network/Packet;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void onSendPacket(Packet packet, CallbackInfo callbackInfo) {
        EventNetworkPostPacketEvent eventNetworkPostPacketEvent = new EventNetworkPostPacketEvent(packet);
        AbyssMod.EVENT_BUS.post(eventNetworkPostPacketEvent);
        if (eventNetworkPostPacketEvent.isCancelled()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"channelRead0"}, at={@At(value="HEAD")}, cancellable=true)
    private void onChannelRead(ChannelHandlerContext channelHandlerContext, Packet packet, CallbackInfo callbackInfo) {
        EventNetworkPrePacketEvent eventNetworkPrePacketEvent = new EventNetworkPrePacketEvent(packet);
        AbyssMod.EVENT_BUS.post(eventNetworkPrePacketEvent);
        if (eventNetworkPrePacketEvent.isCancelled()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"exceptionCaught"}, at={@At(value="HEAD")}, cancellable=true)
    public void exception(ChannelHandlerContext channelHandlerContext, Throwable throwable, CallbackInfo callbackInfo) {
        Object object;
        String string = throwable.getMessage();
        if (string == null) {
            object = new ByteArrayOutputStream();
            throwable.printStackTrace(new PrintStream((OutputStream)object));
            string = ((ByteArrayOutputStream)object).toString().split("", 2)[0];
            Manager.logger.error(string);
        }
        object = new EventNetworkExceptionCaught();
        AbyssMod.EVENT_BUS.post(object);
        if (((Cancellable)object).isCancelled()) {
            callbackInfo.cancel();
        }
    }
}
