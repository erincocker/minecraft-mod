package com.gmail.erin618c.ten10mod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.gmail.erin618c.ten10mod.ExampleMod.MODID;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> PETER_MUG_ITEM = ITEMS.register("peter_mug",
            () -> new Item(new Item.Properties().food(Mugs.PETER_MUG)));
    public static final RegistryObject<Item> MONSTER_ITEM = ITEMS.register("monster",
            () -> new Item(new Item.Properties().food(Mugs.MONSTER)));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

}
