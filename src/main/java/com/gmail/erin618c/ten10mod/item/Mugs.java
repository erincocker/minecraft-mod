package com.gmail.erin618c.ten10mod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class Mugs {
    public static final FoodProperties PETER_MUG = mugBuilder()
            .effect(new MobEffectInstance(MobEffects.LUCK, 500, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 500, 0), 1.0F)
            .build();

    public static final FoodProperties PETER_MUG_EVIL = mugBuilder()
            .build();

    public static final FoodProperties MONSTER = mugBuilder()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 500, 0), 1.0F)
            .build();

    private static FoodProperties.Builder mugBuilder() {
        return new FoodProperties
                .Builder()
                .alwaysEdible()
                .nutrition(4)
                .saturationModifier(0.4f);
    }
}