package com.gmail.erin618c.ten10mod.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class PeterMugEvilItem extends Item {
    public PeterMugEvilItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        level.explode( null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 4.0F, Level.ExplosionInteraction.MOB);
        livingEntity.igniteForTicks(200);
        return itemStack.has(DataComponents.FOOD) ? livingEntity.eat(level, itemStack) : itemStack;
    }
}
