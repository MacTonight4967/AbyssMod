package me.ciruu.abyss;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Class470 {
    public static final SoundEvent Field1825 = (SoundEvent)new SoundEvent(new ResourceLocation("abyss", "cara_al_sol")).setRegistryName("cara_al_sol");
    public static final SoundEvent Field1651 = (SoundEvent)new SoundEvent(new ResourceLocation("abyss", "bakaa")).setRegistryName("bakaa");
    public static final SoundEvent Field2410 = (SoundEvent)new SoundEvent(new ResourceLocation("abyss", "csgo_hitmarker")).setRegistryName("csgo_hitmarker");
    public static final SoundEvent Field2409 = (SoundEvent)new SoundEvent(new ResourceLocation("abyss", "cod_hitmarker")).setRegistryName("cod_hitmarker");
    public static final SoundEvent Field3256 = (SoundEvent)new SoundEvent(new ResourceLocation("abyss", "message")).setRegistryName("message");

    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
    public void Method4274(RegistryEvent.Register register) {
        register.getRegistry().registerAll((IForgeRegistryEntry[])new SoundEvent[]{Field1825, Field1651, Field2410, Field2409, Field3256});
    }
}
