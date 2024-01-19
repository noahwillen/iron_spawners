package net.noah.ironspawners.init;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.noah.ironspawners.IronSpawners;
import net.noah.ironspawners.gui.IronSpawnerScreen;
import net.noah.ironspawners.gui.GoldSpawnerScreen;
import net.noah.ironspawners.gui.EmeraldSpawnerScreen;
import net.noah.ironspawners.gui.DiamondSpawnerScreen;
import net.noah.ironspawners.gui.NetheriteSpawnerScreen;
import net.noah.ironspawners.render.IronSpawnerEntityRenderer;
import net.noah.ironspawners.render.GoldSpawnerEntityRenderer;
import net.noah.ironspawners.render.EmeraldSpawnerEntityRenderer;
import net.noah.ironspawners.render.DiamondSpawnerEntityRenderer;
import net.noah.ironspawners.render.NetheriteSpawnerEntityRenderer;

@Mod.EventBusSubscriber(modid = IronSpawners.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    public static void initContainers(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(Registration.IRON_SPAWNER_CONTAINER.get(), IronSpawnerScreen::new);
            MenuScreens.register(Registration.GOLD_SPAWNER_CONTAINER.get(), GoldSpawnerScreen::new);
            MenuScreens.register(Registration.EMERALD_SPAWNER_CONTAINER.get(), EmeraldSpawnerScreen::new);
            MenuScreens.register(Registration.DIAMOND_SPAWNER_CONTAINER.get(), DiamondSpawnerScreen::new);
            MenuScreens.register(Registration.NETHERITE_SPAWNER_CONTAINER.get(), NetheriteSpawnerScreen::new);
        });
    }

    public static void initRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(Registration.IRON_SPAWNER_BLOCK_ENTITY.get(), IronSpawnerEntityRenderer::new);
        event.registerBlockEntityRenderer(Registration.GOLD_SPAWNER_BLOCK_ENTITY.get(), GoldSpawnerEntityRenderer::new);
        event.registerBlockEntityRenderer(Registration.EMERALD_SPAWNER_BLOCK_ENTITY.get(), EmeraldSpawnerEntityRenderer::new);
        event.registerBlockEntityRenderer(Registration.DIAMOND_SPAWNER_BLOCK_ENTITY.get(), DiamondSpawnerEntityRenderer::new);
        event.registerBlockEntityRenderer(Registration.NETHERITE_SPAWNER_BLOCK_ENTITY.get(), NetheriteSpawnerEntityRenderer::new);
    }
}
