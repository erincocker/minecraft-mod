package com.gmail.erin618c.ten10mod.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PeterEntity extends LivingEntity {
    public PeterEntity(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }


    public static AttributeSupplier.Builder createAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.SAFE_FALL_DISTANCE, 10) //?
                .add(Attributes.SCALE, 1) //?
                .add(Attributes.KNOCKBACK_RESISTANCE, 1) //?
                .add(Attributes.FALL_DAMAGE_MULTIPLIER, 1) //?
                .add(Attributes.ARMOR, 1) //?
                .add(Attributes.MAX_HEALTH, 50.0)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1) //?
                .add(Attributes.MOVEMENT_SPEED, 0.4)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.MAX_ABSORPTION, 1) //?
                .add(Attributes.STEP_HEIGHT, 1) //?
                .add(Attributes.GRAVITY, 1) //?
                .add(Attributes.JUMP_STRENGTH, 1); //?
    }

    @Override
    public Iterable<ItemStack> getArmorSlots() {
        return null;
    }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot p_21127_) {
        return null;
    }

    @Override
    public void setItemSlot(EquipmentSlot p_21036_, ItemStack p_21037_) {

    }

    @Override
    public HumanoidArm getMainArm() {
        return null;
    }
}
