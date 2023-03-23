package com.carpeadventum.fluidarrows.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BucketArrowEntityRenderer extends ProjectileEntityRenderer<BucketArrowEntity> {
    public static final Identifier TEXTURE = new Identifier("fluidarrows:textures/entity/bucket_arrow.png");

    public BucketArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(BucketArrowEntity entity) {
        return TEXTURE;
    }
}
