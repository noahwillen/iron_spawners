package net.noah.ironspawners.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SpawnerBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public abstract class IronSpawnersBlockEntityBase extends BlockEntity implements MenuProvider {

    private int spawnDelay=0;
    private double oSpin;
    private double spin;

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    private final ItemStackHandler itemHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);  //able to remove?
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            Item i = stack.getItem();
            return !(i.equals(Items.WARDEN_SPAWN_EGG) || i.equals(Items.ELDER_GUARDIAN_SPAWN_EGG) || i.equals(Items.IRON_GOLEM_SPAWN_EGG)) &&
                    i instanceof SpawnEggItem;
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();


    public IronSpawnersBlockEntityBase(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    //ENTITY LOGIC
    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, IronSpawnersBlockEntityBase pBaseEntity) {
        if (pLevel.isClientSide()) {
            if (pState.getValue(POWERED)) {
                RandomSource randomsource = pLevel.getRandom();
                double d0 = (double)pPos.getX() + randomsource.nextDouble();
                double d1 = (double)pPos.getY() + randomsource.nextDouble();
                double d2 = (double)pPos.getZ() + randomsource.nextDouble();
                pLevel.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
                pLevel.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
                pBaseEntity.setOSpin(pBaseEntity.getSpin());
                pBaseEntity.setSpin((pBaseEntity.getSpin() + (double)(1000.0F / ((float)pBaseEntity.serializeNBT().getInt("spawnDelay") + 200.0F))) % 360.0D);
            } else {
                pBaseEntity.setOSpin(pBaseEntity.getSpin());
            }
        } else {
            if (pBaseEntity.getItem() instanceof SpawnEggItem spawnEggItem && pBaseEntity.getBlockState().getValue(POWERED)) {
                pBaseEntity.setSpawnDelay(pBaseEntity.getSpawnDelay() + 1);
                if (pBaseEntity.getSpawnDelay()>=pBaseEntity.getMaxDelay()) {
                    for (int i=0; i<pBaseEntity.getSpawnCount();i++) {
                        Random r = new Random();
                        int xOffset = r.ints(-4, 5).findFirst().getAsInt();
                        int yOffset = r.ints(-4, 3).findFirst().getAsInt();
                        int zOffset = r.ints(-4, 5).findFirst().getAsInt();
                        BlockPos newPos = new BlockPos(pPos.getX()+xOffset, pPos.getY()+yOffset, pPos.getZ()+zOffset);
                        EntityType<?> entityType = pBaseEntity.getEntityType(spawnEggItem);
                        entityType.spawn((ServerLevel)pLevel, newPos, MobSpawnType.SPAWNER);
                    }
                    pBaseEntity.setSpawnDelay(0);
                }
            }
        }
    }

    public int getSpawnDelay() {
        return spawnDelay;
    }

    public void setSpawnDelay(int spawnDelay) {
        this.spawnDelay = spawnDelay;
    }

    public Item getItem() {
        return itemHandler.getStackInSlot(0).getItem();
    }

    public int getMaxDelay() {
        return 999999;
    }

    public int getSpawnCount() {
        return 0;
    }

    public EntityType<?> getEntityType (SpawnEggItem i) {
        return i.getType(itemHandler.getStackInSlot(0).getTag());
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        inventory.setItem(0, itemHandler.getStackInSlot(0));
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public boolean bannedEgg(SpawnEggItem i){
        return (i.equals(Items.WARDEN_SPAWN_EGG) || i.equals(Items.ELDER_GUARDIAN_SPAWN_EGG) || i.equals(Items.IRON_GOLEM_SPAWN_EGG));
    }




    //ITEM HANDLER CAPABILITY
    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }




    //SYNC DATA CLIENT<->SERVER
    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("spawnDelay", spawnDelay);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        spawnDelay = pTag.getInt("spawnDelay");
    }




    //RENDERING EGG IN BLOCK
    public ItemStack getDisplayStack() {
        return itemHandler.getStackInSlot(0);
    }

    public double getSpin() {
        return this.spin;
    }

    public double getOSpin() {
        return this.oSpin;
    }

    public void setSpin(double _spin) {
        this.spin=_spin;
    }

    public void setOSpin(double _oSpin) {
        this.oSpin=_oSpin;
    }
}
