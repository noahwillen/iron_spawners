package net.noah.ironspawners.init;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SmithingTableBlock;
import net.minecraft.world.level.block.SpawnerBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.noah.ironspawners.IronSpawners;
import net.noah.ironspawners.blockentities.*;
import net.noah.ironspawners.blocks.*;
import net.noah.ironspawners.container.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Registration {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, IronSpawners.MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IronSpawners.MOD_ID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, IronSpawners.MOD_ID);
    private static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, IronSpawners.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IronSpawners.MOD_ID);

    public static void init() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
        CONTAINERS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }

    //IRON
    public static final RegistryObject<IronSpawnerBlock> IRON_SPAWNER_BLOCK = BLOCKS.register(IronSpawnerBlock.IRON_SPAWNER, () -> new IronSpawnerBlock(BlockBehaviour.Properties.copy(Blocks.SPAWNER)));
    public static final RegistryObject<Item> IRON_SPAWNER_ITEM = ITEMS.register(IronSpawnerBlock.IRON_SPAWNER, () -> new BlockItem(IRON_SPAWNER_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<BlockEntityType<IronSpawnerBlockEntity>> IRON_SPAWNER_BLOCK_ENTITY = BLOCK_ENTITIES.register(IronSpawnerBlock.IRON_SPAWNER, () -> BlockEntityType.Builder.of(IronSpawnerBlockEntity::new, IRON_SPAWNER_BLOCK.get()).build(null));

    public static final RegistryObject<MenuType<IronSpawnerContainer>> IRON_SPAWNER_CONTAINER = CONTAINERS.register(IronSpawnerBlock.IRON_SPAWNER, () -> IForgeMenuType.create((pContainerId, pPlayerInv, data) -> {
        BlockPos pos = data.readBlockPos();
        Level level = pPlayerInv.player.getCommandSenderWorld();
        return new IronSpawnerContainer(pContainerId, level, pos, pPlayerInv, pPlayerInv.player);
    }));


    //GOLD
    public static final RegistryObject<GoldSpawnerBlock> GOLD_SPAWNER_BLOCK = BLOCKS.register(GoldSpawnerBlock.GOLD_SPAWNER, () -> new GoldSpawnerBlock(BlockBehaviour.Properties.copy(Blocks.SPAWNER)));
    public static final RegistryObject<Item> GOLD_SPAWNER_ITEM = ITEMS.register(GoldSpawnerBlock.GOLD_SPAWNER, () -> new BlockItem(GOLD_SPAWNER_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<BlockEntityType<GoldSpawnerBlockEntity>> GOLD_SPAWNER_BLOCK_ENTITY = BLOCK_ENTITIES.register(GoldSpawnerBlock.GOLD_SPAWNER, () -> BlockEntityType.Builder.of(GoldSpawnerBlockEntity::new, GOLD_SPAWNER_BLOCK.get()).build(null));

    public static final RegistryObject<MenuType<GoldSpawnerContainer>> GOLD_SPAWNER_CONTAINER = CONTAINERS.register(GoldSpawnerBlock.GOLD_SPAWNER, () -> IForgeMenuType.create((pContainerId, pPlayerInv, data) -> {
        BlockPos pos = data.readBlockPos();
        Level level = pPlayerInv.player.getCommandSenderWorld();
        return new GoldSpawnerContainer(pContainerId, level, pos, pPlayerInv, pPlayerInv.player);
    }));


    //EMERALD
    public static final RegistryObject<EmeraldSpawnerBlock> EMERALD_SPAWNER_BLOCK = BLOCKS.register(EmeraldSpawnerBlock.EMERALD_SPAWNER, () -> new EmeraldSpawnerBlock(BlockBehaviour.Properties.copy(Blocks.SPAWNER)));
    public static final RegistryObject<Item> EMERALD_SPAWNER_ITEM = ITEMS.register(EmeraldSpawnerBlock.EMERALD_SPAWNER, () -> new BlockItem(EMERALD_SPAWNER_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<BlockEntityType<EmeraldSpawnerBlockEntity>> EMERALD_SPAWNER_BLOCK_ENTITY = BLOCK_ENTITIES.register(EmeraldSpawnerBlock.EMERALD_SPAWNER, () -> BlockEntityType.Builder.of(EmeraldSpawnerBlockEntity::new, EMERALD_SPAWNER_BLOCK.get()).build(null));

    public static final RegistryObject<MenuType<EmeraldSpawnerContainer>> EMERALD_SPAWNER_CONTAINER = CONTAINERS.register(EmeraldSpawnerBlock.EMERALD_SPAWNER, () -> IForgeMenuType.create((pContainerId, pPlayerInv, data) -> {
        BlockPos pos = data.readBlockPos();
        Level level = pPlayerInv.player.getCommandSenderWorld();
        return new EmeraldSpawnerContainer(pContainerId, level, pos, pPlayerInv, pPlayerInv.player);
    }));


    //DIAMOND
    public static final RegistryObject<DiamondSpawnerBlock> DIAMOND_SPAWNER_BLOCK = BLOCKS.register(DiamondSpawnerBlock.DIAMOND_SPAWNER, () -> new DiamondSpawnerBlock(BlockBehaviour.Properties.copy(Blocks.SPAWNER)));
    public static final RegistryObject<Item> DIAMOND_SPAWNER_ITEM = ITEMS.register(DiamondSpawnerBlock.DIAMOND_SPAWNER, () -> new BlockItem(DIAMOND_SPAWNER_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<BlockEntityType<DiamondSpawnerBlockEntity>> DIAMOND_SPAWNER_BLOCK_ENTITY = BLOCK_ENTITIES.register(DiamondSpawnerBlock.DIAMOND_SPAWNER, () -> BlockEntityType.Builder.of(DiamondSpawnerBlockEntity::new, DIAMOND_SPAWNER_BLOCK.get()).build(null));

    public static final RegistryObject<MenuType<DiamondSpawnerContainer>> DIAMOND_SPAWNER_CONTAINER = CONTAINERS.register(DiamondSpawnerBlock.DIAMOND_SPAWNER, () -> IForgeMenuType.create((pContainerId, pPlayerInv, data) -> {
        BlockPos pos = data.readBlockPos();
        Level level = pPlayerInv.player.getCommandSenderWorld();
        return new DiamondSpawnerContainer(pContainerId, level, pos, pPlayerInv, pPlayerInv.player);
    }));


    //NETHERITE
    public static final RegistryObject<NetheriteSpawnerBlock> NETHERITE_SPAWNER_BLOCK = BLOCKS.register(NetheriteSpawnerBlock.NETHERITE_SPAWNER, () -> new NetheriteSpawnerBlock(BlockBehaviour.Properties.copy(Blocks.SPAWNER)));
    public static final RegistryObject<Item> NETHERITE_SPAWNER_ITEM = ITEMS.register(NetheriteSpawnerBlock.NETHERITE_SPAWNER, () -> new BlockItem(NETHERITE_SPAWNER_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<BlockEntityType<NetheriteSpawnerBlockEntity>> NETHERITE_SPAWNER_BLOCK_ENTITY = BLOCK_ENTITIES.register(NetheriteSpawnerBlock.NETHERITE_SPAWNER, () -> BlockEntityType.Builder.of(NetheriteSpawnerBlockEntity::new, NETHERITE_SPAWNER_BLOCK.get()).build(null));

    public static final RegistryObject<MenuType<NetheriteSpawnerContainer>> NETHERITE_SPAWNER_CONTAINER = CONTAINERS.register(NetheriteSpawnerBlock.NETHERITE_SPAWNER, () -> IForgeMenuType.create((pContainerId, pPlayerInv, data) -> {
        BlockPos pos = data.readBlockPos();
        Level level = pPlayerInv.player.getCommandSenderWorld();
        return new NetheriteSpawnerContainer(pContainerId, level, pos, pPlayerInv, pPlayerInv.player);
    }));



    public static final RegistryObject<CreativeModeTab> tabIronSpawners = CREATIVE_MODE_TABS.register("ironspawners_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> IRON_SPAWNER_BLOCK.get().asItem().getDefaultInstance())
            .title(Component.translatable("creativetab.ironspawners"))
            .displayItems((parameters, output) -> {
                output.accept(Registration.IRON_SPAWNER_ITEM.get());
                output.accept(Registration.GOLD_SPAWNER_ITEM.get());
                output.accept(Registration.EMERALD_SPAWNER_ITEM.get());
                output.accept(Registration.DIAMOND_SPAWNER_ITEM.get());
                output.accept(Registration.NETHERITE_SPAWNER_ITEM.get());
            }).build());

}
