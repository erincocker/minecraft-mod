package com.gmail.erin618c.ten10mod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.gmail.erin618c.ten10mod.ExampleMod.MODID;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> RPS_BLOCK = BLOCKS.register("rps_block", () -> new RPSBlock(BlockBehaviour.Properties.of()));

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
