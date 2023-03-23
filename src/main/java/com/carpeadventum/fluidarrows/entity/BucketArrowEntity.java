package com.carpeadventum.fluidarrows.entity;
//
//import net.minecraft.block.BlockState;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.fluid.Fluids;
//import net.minecraft.item.Item;
//import net.minecraft.util.hit.HitResult;
//import net.minecraft.world.World;
//import com.carpeadventum.fluidarrows.entity.ModEntityTypes;
//import com.carpeadventum.fluidarrows.items.ModItems;
//
//public class BucketArrowEntity extends PersistentProjectileEntity {
//    public static final BlockState fluid = Fluids.WATER.getDefaultState().getBlockState();
//    public BucketArrowEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
//        super(entityType, world);
//    }
//
//    public BucketArrowEntity(World world, double x, double y, double z) {
//        super(ModEntityTypes.BUCKET_ARROW_ENTITY, x, y, z, world);
//    }
//
//    public BucketArrowEntity(World world, LivingEntity owner) {
//        super(ModEntityTypes.BUCKET_ARROW_ENTITY, owner, world);
//    }
//
//    // Method is called when colliding with anything
//    protected void onCollision(HitResult hitResult) {
//        super.onCollision(hitResult);
//        if (!this.world.isClient) {
//            world.setBlockState(getBlockPos(), fluid, 11);
//            this.kill();
//        }
//    }
//
//    @Override
//    protected Item getDefaultItem() {
//        return ModItems.BUCKET_ARROW_ITEM;
//    }
//
//    @Override
//    protected float getGravity() {
//        return 0.04f;
//    }
//}
//


import com.carpeadventum.fluidarrows.entity.ModEntityTypes;
import com.carpeadventum.fluidarrows.items.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class BucketArrowEntity
        extends PersistentProjectileEntity {
    public static final BlockState fluid = Fluids.WATER.getDefaultState().getBlockState();

    public BucketArrowEntity(EntityType<? extends BucketArrowEntity> entityType, World world) {
        super((EntityType<? extends PersistentProjectileEntity>)entityType, world);
    }

    public BucketArrowEntity(World world, double x, double y, double z) {
        super(ModEntityTypes.BUCKET_ARROW_ENTITY, x, y, z, world);
    }

    public BucketArrowEntity(World world, LivingEntity owner) {
        super( ModEntityTypes.BUCKET_ARROW_ENTITY, owner, world);
    }


    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.world.isClient) {
            if (this.inGround) {
                if (this.inGroundTime % 5 == 0) {
                    this.spawnParticles(5);
                }
            } else {
                this.spawnParticles(3);
            }
        } else if (this.inGround && this.inGroundTime != 0 && this.inGroundTime >= 600) {
            this.world.sendEntityStatus(this, (byte)0);
        }
    }

    private void spawnParticles(int amount) {
        double d = (double)(16 & 0xFF) / 255.0;
        double e = (double)(8 & 0xFF) / 255.0;
        double f = (double)(0) / 255.0;
        for (int j = 0; j < amount; ++j) {
            this.world.addParticle(ParticleTypes.BUBBLE_COLUMN_UP, this.getParticleX(0.5), this.getRandomBodyY(), this.getParticleZ(0.5), d, e, f);
            this.world.addParticle(ParticleTypes.BUBBLE, this.getParticleX(0.5), this.getRandomBodyY(), this.getParticleZ(0.5), d, e, f);
        }
    }


    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
        target.setAir(-20);
    }
    @Override
    protected void onCollision(HitResult hitResult) {
        HitResult.Type type = hitResult.getType();
        if (type == HitResult.Type.ENTITY) {
            this.onEntityHit((EntityHitResult)hitResult);
        } else if (type == HitResult.Type.BLOCK) {
            this.onBlockHit((BlockHitResult)hitResult);
            BlockPos blockPos = ((BlockHitResult) hitResult).getBlockPos();
            if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                this.world.setBlockState(getBlockPos(), fluid, 11);
                this.discard();
            } else this.discard();
        }
        if (type != HitResult.Type.MISS) {
            this.emitGameEvent(GameEvent.PROJECTILE_LAND, this.getOwner());
        }
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.BUCKET_ARROW_ITEM);
    }
}
