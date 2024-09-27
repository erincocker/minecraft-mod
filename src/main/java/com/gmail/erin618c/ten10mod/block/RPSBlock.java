package com.gmail.erin618c.ten10mod.block;

import com.gmail.erin618c.ten10mod.item.ModItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class RPSBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final MapCodec<RPSBlock> CODEC = simpleCodec(RPSBlock::new);

    @Override
    protected @NotNull MapCodec<? extends RPSBlock> codec() {
        return CODEC;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    protected RPSBlock(BlockBehaviour.Properties p_52591_) {
        super(p_52591_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(ItemStack itemStack, @NotNull BlockState blockState,
                                                       @NotNull Level level, @NotNull BlockPos blockPos,
                                                       @NotNull Player player, @NotNull InteractionHand interactionHand,
                                                       @NotNull BlockHitResult blockHitResult) {

        int playerMove;
        if (itemStack.is(Items.COAL)) {
            playerMove = 0;
        } else if (itemStack.is(Items.PAPER)) {
            playerMove = 1;
        } else if (itemStack.is(Items.SHEARS)) {
            playerMove = 2;
        } else {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        int machineMove = new Random().nextInt(3);
        switch (machineMove) {
            case 0:
                popResourceFromFace(level, blockPos, blockState.getValue(FACING), new ItemStack(Items.COAL));
                break;
            case 1:
                popResourceFromFace(level, blockPos, blockState.getValue(FACING), new ItemStack(Items.PAPER));
                break;
            case 2:
                popResourceFromFace(level, blockPos, blockState.getValue(FACING), new ItemStack(Items.SHEARS));
                break;
        }

        char playerWon = RPSGame.playGame(playerMove, machineMove);

        itemStack.shrink(1);
        if (playerWon == 'y') {
            popResourceFromFace(level, blockPos, blockState.getValue(FACING), new ItemStack(ModItems.PETER_MUG_ITEM.get()));
        } else if (playerWon == 'n') {
            popResourceFromFace(level, blockPos, blockState.getValue(FACING), new ItemStack(ModItems.PETER_MUG_EVIL_ITEM.get()));
        }
        return ItemInteractionResult.CONSUME;
    }
}
