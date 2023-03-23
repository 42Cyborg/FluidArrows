package com.carpeadventum.fluidarrows.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;



import static com.carpeadventum.fluidarrows.main.FluidArrows.MOD_ID;
public class ModEntityTypes {

    public static EntityType<BucketArrowEntity> BUCKET_ARROW_ENTITY;

    private static <T extends Entity> EntityType<T> register(String s, EntityType<T> entityType) {
        return Registry.register(Registry.ENTITY_TYPE, MOD_ID + ":" + s, entityType);
    }

    private static <T extends Entity> EntityType<T> createArrowEntityType(EntityType.EntityFactory<T> factory) {
        return FabricEntityTypeBuilder.create(SpawnGroup.MISC, factory).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).trackRangeBlocks(4).trackedUpdateRate(20).build();
    }

    public static void init() {
        BUCKET_ARROW_ENTITY = register("bucket_arrow", createArrowEntityType(BucketArrowEntity::new));
    }

    public static void registerEntityRender() {
        EntityRendererRegistry.register(ModEntityTypes.BUCKET_ARROW_ENTITY, BucketArrowEntityRenderer::new);
    }
}