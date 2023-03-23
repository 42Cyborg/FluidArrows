package com.carpeadventum.fluidarrows.items;

import com.carpeadventum.fluidarrows.entity.BucketArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BucketArrowItem extends ArrowItem {

    public BucketArrowItem(Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new BucketArrowEntity(world, shooter);
    }
}