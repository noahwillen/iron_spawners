package net.noah.ironspawners.container;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import net.noah.ironspawners.blockentities.IronSpawnersBlockEntityBase;


public class IronSpawnersContainerBase extends AbstractContainerMenu {

    protected IronSpawnersBlockEntityBase blockEntity;
    protected final Level level;

    protected IronSpawnersContainerBase(MenuType<?> pMenuType, int pContainerId, Level pLevel, BlockPos pPos, Inventory pPlayerInv, Player pPlayer) {
        super(pMenuType, pContainerId);
        this.blockEntity=(IronSpawnersBlockEntityBase) pLevel.getBlockEntity(pPos);
        this.level = pPlayerInv.player.level();
        checkContainerSize(pPlayerInv, 1);


        addPlayerHotbar(pPlayerInv);
        addPlayerInventory(pPlayerInv);

        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
            this.addSlot(new SlotItemHandler(iItemHandler, 0, 80, 20));
        });
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (!sourceSlot.hasItem()) return ItemStack.EMPTY;
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        if (pIndex < 36) {
            if (!moveItemStackTo(sourceStack, 36, 37, false)) {
                return ItemStack.EMPTY;
            }
        } else if (pIndex < 37) {
            if (!moveItemStackTo(sourceStack, 0, 36, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            return ItemStack.EMPTY;
        }

        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return  !(pPlayer.distanceToSqr((double)blockEntity.getBlockPos().getX()+0.5D, (double)blockEntity.getBlockPos().getY()+0.5D,(double)blockEntity.getBlockPos().getZ()+0.5D) > 64.0D);
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 51 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 109));
        }
    }
}
