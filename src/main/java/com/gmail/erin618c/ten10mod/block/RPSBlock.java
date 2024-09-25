package com.gmail.erin618c.ten10mod.block;

import com.gmail.erin618c.ten10mod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class RPSBlock extends Block {
    public RPSBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(
            ItemStack itemStack, @NotNull BlockState blockState, @NotNull Level level,
            @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand,
            @NotNull BlockHitResult blockHitResult) {

        if (itemStack.is(Items.COAL) || itemStack.is(Items.PAPER) || itemStack.is(Items.SHEARS)) {
            popResource(level, blockPos, new ItemStack(ModItems.PETER_MUG_ITEM.get()));
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        //good practiced to instead go to the super method?
    }
}
