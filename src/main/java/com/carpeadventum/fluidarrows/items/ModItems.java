package com.carpeadventum.fluidarrows.items;

import com.carpeadventum.fluidarrows.entity.BucketArrowEntity;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Position;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Objects;

import static com.carpeadventum.fluidarrows.main.FluidArrows.MOD_ID;

public class ModItems {

    public static final BucketArrowItem BUCKET_ARROW_ITEM = new BucketArrowItem(new Item.Settings().group(ItemGroup.COMBAT));

    public static void registerDispenserBlockBehavior(Item item) {
        DispenserBlock.registerBehavior(item, new ProjectileDispenserBehavior() {
            @Override
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {

                if (item instanceof BucketArrowItem) {
                    BucketArrowEntity arrowEntity = new BucketArrowEntity(world, position.getX(), position.getY(), position.getZ());
                    arrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
                    return arrowEntity;
//                }  else if (item instanceof EnderArrowItem) {
//                    EnderArrowEntity arrowEntity = new EnderArrowEntity(world, position.getX(), position.getY(), position.getZ());
//                    arrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
//                    return arrowEntity;
                } else return null;
            }
        });
    }


    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bucket_arrow"), BUCKET_ARROW_ITEM);

        registerDispenserBlockBehavior(BUCKET_ARROW_ITEM);
    }
}
