package me.ciruu.abyss;

import me.ciruu.abyss.Class488;
import me.ciruu.abyss.Class489;
import me.ciruu.abyss.Manager;
import me.zero.alpine.bus.EventBus;
import me.zero.alpine.bus.EventManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="abyss", name="Abyss", version="1.6.0")
@Class488
public class AbyssMod {
    public static final String MOD_ID = "abyss";
    public static final String MOD_NAME = "Abyss";
    public static final String VERSION = "1.6.0";
    public static final String suffix = "\u1d00\u0299\u028f\ua731\ua731";
    @Mod.Instance(value="abyss")
    public static AbyssMod INSTANCE;
    public static Manager manager;
    public static final EventBus EVENT_BUS;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        manager.preinit(fMLPreInitializationEvent);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register((Object)new Class489());
        manager.init(fMLInitializationEvent);
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent fMLPostInitializationEvent) {
        manager.postinit(fMLPostInitializationEvent);
    }

    static {
        manager = new Manager();
        EVENT_BUS = new EventManager();
    }
}
