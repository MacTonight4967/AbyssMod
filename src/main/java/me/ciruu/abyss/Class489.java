package me.ciruu.abyss;

import com.google.common.base.Strings;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Stream;
import me.ciruu.abyss.AbyssMod;
import me.ciruu.abyss.Class163;
import me.ciruu.abyss.Class179;
import me.ciruu.abyss.Class26;
import me.ciruu.abyss.Class27;
import me.ciruu.abyss.Class277;
import me.ciruu.abyss.Class278;
import me.ciruu.abyss.Class35;
import me.ciruu.abyss.Class350;
import me.ciruu.abyss.Class66;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class53;
import me.ciruu.abyss.events.network.EventNetworkPrePacketEvent;
import me.ciruu.abyss.events.player.EventPlayerUpdate;
import me.ciruu.abyss.managers.ModuleManager;
import me.ciruu.abyss.modules.client.Client;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listenable;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Class489
implements Listenable {
    public static Class489 Field3420;
    @EventHandler
    private Listener Field3421 = new Listener<EventNetworkPrePacketEvent>(Class489::Method4093, new Predicate[0]);
    @EventHandler
    private Listener Field3422 = new Listener<EventPlayerUpdate>(Class489::Method4094, 300, new Predicate[0]);

    public Class489() {
        Field3420 = this;
        AbyssMod.EVENT_BUS.subscribe(this);
    }

    @SubscribeEvent
    public void Method4095(TickEvent.ClientTickEvent clientTickEvent) {
        if (Globals.mc.player == null) {
            return;
        }
        if (clientTickEvent.isCanceled()) {
            return;
        }
        AbyssMod.EVENT_BUS.post(new Class26());
    }

    private void Method4096() {
        block6: {
            try {
                Stream<Path> stream;
                block7: {
                    stream = Files.walk(Paths.get("Abyss/PacketLogger/", new String[0]), new FileVisitOption[0]);
                    Throwable throwable = null;
                    try {
                        stream.filter(Class489::Method4097).forEach(System.out::println);
                        if (stream == null) break block6;
                        if (throwable == null) break block7;
                    }
                    catch (Throwable throwable2) {
                        throwable = throwable2;
                        throw throwable2;
                    }
                    try {
                        stream.close();
                    }
                    catch (Throwable throwable3) {
                        throwable.addSuppressed(throwable3);
                    }
                    break block6;
                }
                stream.close();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @SubscribeEvent
    public void Method4098(LivingEvent.LivingUpdateEvent livingUpdateEvent) {
        if (Globals.mc.player != null && Globals.mc.world != null && livingUpdateEvent.getEntity().getEntityWorld().isRemote && livingUpdateEvent.getEntityLiving().equals((Object)Globals.mc.player)) {
            Manager.Field298.Method2907();
        }
    }

    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
    public void Method4099(InputEvent.KeyInputEvent keyInputEvent) {
        if (!Keyboard.getEventKeyState()) {
            return;
        }
        if (Keyboard.getEventKey() == 0 || Keyboard.getEventKey() == 0) {
            return;
        }
        ModuleManager.Method3251(Keyboard.getKeyName((int)Keyboard.getEventKey()));
        AbyssMod.EVENT_BUS.post(new Class350(Keyboard.getEventKey()));
    }

    @SubscribeEvent(priority=EventPriority.LOW)
    public void Method4100(RenderGameOverlayEvent.Text text) {
        if (text.getType().equals((Object)RenderGameOverlayEvent.ElementType.TEXT)) {
            ScaledResolution scaledResolution = new ScaledResolution(Globals.mc);
            Class35 class35 = new Class35(text.getPartialTicks(), scaledResolution);
            AbyssMod.EVENT_BUS.post(class35);
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        }
    }

    @SubscribeEvent
    public void Method4101(PlayerDestroyItemEvent playerDestroyItemEvent) {
        AbyssMod.EVENT_BUS.post(playerDestroyItemEvent);
    }

    @SubscribeEvent
    public void Method4102(InputEvent.MouseInputEvent mouseInputEvent) {
        if (Mouse.getEventButtonState()) {
            AbyssMod.EVENT_BUS.post(mouseInputEvent);
        }
        if (Mouse.getEventButton() != -1 && Mouse.isButtonDown((int)Mouse.getEventButton())) {
            ModuleManager.Method3251(Mouse.getButtonName((int)Mouse.getEventButton()));
        }
    }

    @SubscribeEvent(priority=EventPriority.HIGHEST)
    public void Method4103(LivingDeathEvent livingDeathEvent) {
        AbyssMod.EVENT_BUS.post(livingDeathEvent);
    }

    @SubscribeEvent
    public void Method4104(RenderWorldLastEvent renderWorldLastEvent) {
        if (renderWorldLastEvent.isCanceled()) {
            return;
        }
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.shadeModel((int)7425);
        GlStateManager.disableDepth();
        GlStateManager.glLineWidth((float)1.0f);
        AbyssMod.EVENT_BUS.post(new Class66(renderWorldLastEvent.getPartialTicks()));
        GlStateManager.glLineWidth((float)1.0f);
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.enableDepth();
        GlStateManager.enableCull();
    }

    @SubscribeEvent
    public void Method4105(RenderWorldLastEvent renderWorldLastEvent) {
        if (renderWorldLastEvent.isCanceled()) {
            return;
        }
        Class278.Method1780();
        AbyssMod.EVENT_BUS.post(new Class277(renderWorldLastEvent.getPartialTicks()));
        Class278.Method1781();
    }

    @SubscribeEvent(priority=EventPriority.HIGHEST)
    public void Method4106(ClientChatEvent clientChatEvent) {
        if (clientChatEvent.getMessage().startsWith(Manager.moduleManager.getModuleByClass(Client.class) != null ? ((String)((Client)Manager.moduleManager.getModuleByClass(Client.class)).cmdprefix.getValue()).trim() : Class163.Field3370)) {
            clientChatEvent.setCanceled(true);
            try {
                Globals.mc.ingameGUI.getChatGUI().addToSentMessages(clientChatEvent.getMessage());
                String string = clientChatEvent.getMessage().substring(((String)((Client)Manager.moduleManager.getModuleByClass(Client.class)).cmdprefix.getValue()).trim().length());
                String[] stringArray = string.split("");
                if (stringArray == null || stringArray.length == 0) {
                    return;
                }
                List list = Manager.Field1639.Method3634(stringArray[0]);
                Class163 class163 = (Class163)list.get(0);
                class163.Method4028(clientChatEvent.getMessage().substring(((String)((Client)Manager.moduleManager.getModuleByClass(Client.class)).cmdprefix.getValue()).trim().length()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
                if (exception.getMessage().equalsIgnoreCase("Index: 0, Size: 0")) {
                    Globals.printChatMessage(ChatFormatting.RED + "Error: Incorrect command please type *Help for a list of commands");
                }
                Globals.printChatMessage(ChatFormatting.DARK_RED + "Error:" + exception.getMessage());
            }
        }
    }

    @SubscribeEvent(priority=EventPriority.HIGHEST)
    public void Method4107(EntityJoinWorldEvent entityJoinWorldEvent) {
        AbyssMod.EVENT_BUS.post(new Class27(entityJoinWorldEvent.getEntity(), entityJoinWorldEvent.getWorld()));
    }

    @SubscribeEvent
    public void Method4108(LivingAttackEvent livingAttackEvent) {
        AbyssMod.EVENT_BUS.post(livingAttackEvent);
    }

    @SubscribeEvent
    public void Method4109(InputUpdateEvent inputUpdateEvent) {
        AbyssMod.EVENT_BUS.post(inputUpdateEvent);
    }

    @SubscribeEvent
    public void Method4110(AttackEntityEvent attackEntityEvent) {
        AbyssMod.EVENT_BUS.post(attackEntityEvent);
    }

    @SubscribeEvent
    public void Method4111(RenderPlayerEvent.Pre pre) {
        AbyssMod.EVENT_BUS.post(pre);
    }

    @SubscribeEvent
    public void Method4112(ChunkEvent.Load load) {
        AbyssMod.EVENT_BUS.post(load);
    }

    @SubscribeEvent
    public void Method4113(ChunkEvent.Unload unload) {
        AbyssMod.EVENT_BUS.post(unload);
    }

    @SubscribeEvent
    public void Method4114(InputEvent.MouseInputEvent mouseInputEvent) {
        AbyssMod.EVENT_BUS.post(mouseInputEvent);
    }

    @SubscribeEvent
    public void Method4115(ProjectileImpactEvent.Throwable throwable) {
        AbyssMod.EVENT_BUS.post(throwable);
    }

    @SubscribeEvent
    public void Method4116(GuiOpenEvent guiOpenEvent) {
        AbyssMod.EVENT_BUS.post(guiOpenEvent);
    }

    private static void Method4094(EventPlayerUpdate eventPlayerUpdate) {
        Manager.Field1643.Method465();
    }

    private static void Method4093(EventNetworkPrePacketEvent eventNetworkPrePacketEvent) {
        if (eventNetworkPrePacketEvent.Method49() instanceof SPacketTimeUpdate) {
            Manager.Field1645.Method3656();
        } else if (eventNetworkPrePacketEvent.Method49() instanceof SPacketPlayerListItem && Globals.mc.player != null && Globals.mc.world != null) {
            SPacketPlayerListItem sPacketPlayerListItem = (SPacketPlayerListItem)eventNetworkPrePacketEvent.Method49();
            if (!SPacketPlayerListItem.Action.ADD_PLAYER.equals((Object)sPacketPlayerListItem.getAction()) && !SPacketPlayerListItem.Action.REMOVE_PLAYER.equals((Object)sPacketPlayerListItem.getAction())) {
                return;
            }
            sPacketPlayerListItem.getEntries().stream().filter(Objects::nonNull).filter(Class489::Method4117).forEach(arg_0 -> Class489.Method4118(sPacketPlayerListItem, arg_0));
        }
    }

    private static void Method4118(SPacketPlayerListItem sPacketPlayerListItem, SPacketPlayerListItem.AddPlayerData addPlayerData) {
        UUID uUID = addPlayerData.getProfile().getId();
        switch (sPacketPlayerListItem.getAction()) {
            case ADD_PLAYER: {
                String string = addPlayerData.getProfile().getName();
                AbyssMod.EVENT_BUS.post(new Class179(Class53.PRE, uUID, string));
                break;
            }
            case REMOVE_PLAYER: {
                EntityPlayer entityPlayer = Globals.mc.world.getPlayerEntityByUUID(uUID);
                if (entityPlayer != null) {
                    String string = entityPlayer.getName();
                    AbyssMod.EVENT_BUS.post(new Class179(Class53.PERI, entityPlayer, uUID, string));
                    break;
                }
                AbyssMod.EVENT_BUS.post(new Class179(Class53.POST, uUID, null));
            }
        }
    }

    private static boolean Method4117(SPacketPlayerListItem.AddPlayerData addPlayerData) {
        return !Strings.isNullOrEmpty(addPlayerData.getProfile().getName()) || addPlayerData.getProfile().getId() != null;
    }

    private static boolean Method4097(Path path) {
        return Files.isRegularFile(path, new LinkOption[0]);
    }
}
