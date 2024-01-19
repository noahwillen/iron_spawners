package net.noah.ironspawners;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.noah.ironspawners.init.ClientSetup;
import net.noah.ironspawners.init.Registration;

@Mod(IronSpawners.MOD_ID)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class IronSpawners {

    public static final String MOD_ID = "ironspawners";

    public static IEventBus MOD_EVENT_BUS;

    public static CreativeModeTab tabIronSpawners;

    public IronSpawners() {

        MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::initContainers);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::initRenderers);

        MOD_EVENT_BUS.register(Registration.class);

        Registration.init();
    }
}
