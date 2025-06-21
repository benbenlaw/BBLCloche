package com.benbenlaw.cloche.block.entity.client;

import com.benbenlaw.cloche.block.entity.ClocheBlockEntity;
import com.benbenlaw.core.util.RenderUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;

public class ClocheBlockEntityRenderer implements BlockEntityRenderer<ClocheBlockEntity> {
    public ClocheBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(ClocheBlockEntity blockEntity, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight, int packedOverlay, Vec3 cameraOffset) {

        BlockRenderDispatcher blockRenderer = Minecraft.getInstance().getBlockRenderer();
        ItemStack soilStack = blockEntity.getSoil();
        ItemStack seedStack = blockEntity.getSeed();

        // SOIL RENDERING
        if (soilStack.getItem() instanceof BlockItem blockItem) {
            BlockState soilBlockState = blockItem.getBlock().defaultBlockState();

            poseStack.pushPose();
            poseStack.scale(0.9f, 0.9f, 0.9f);
            poseStack.translate(0.05f, -0.92f, 0.05f);

            blockRenderer.renderSingleBlock(
                    soilBlockState,
                    poseStack,
                    bufferSource,
                    packedLight,
                    packedOverlay
            );

            poseStack.popPose();
        }

        // LIQUID SOIL (like from buckets)
        if (soilStack.getItem() instanceof BucketItem bucketItem) {
            Fluid fluid = bucketItem.content.defaultFluidState().getType();
            VertexConsumer buffer = bufferSource.getBuffer(Sheets.translucentItemSheet());
            renderFluid(poseStack.last(), buffer, blockEntity, fluid, 0.05F, packedLight);
        }

        // SEED RENDERING
        if (seedStack.getItem() instanceof BlockItem blockItem) {
            BlockState seedState = blockItem.getBlock().defaultBlockState();
            int progress = blockEntity.progress;
            int maxProgress = blockEntity.maxProgress;

            // CropBlock rendering (with age)
            if (seedState.getBlock() instanceof CropBlock cropBlock) {
                int maxAge = cropBlock.getMaxAge();
                int age = Math.round((float) progress / maxProgress * maxAge);

                for (Property<?> prop : cropBlock.getStateDefinition().getProperties()) {
                    if (prop instanceof IntegerProperty intProp && intProp.getPossibleValues().contains(age)) {
                        seedState = seedState.setValue(intProp, age);
                        break;
                    }
                }
            }
            // StemBlock (AGE_7)
            else if (seedState.getBlock() instanceof StemBlock) {
                int age = Math.min(7, Math.round((float) progress / maxProgress * 7));
                seedState = seedState.setValue(BlockStateProperties.AGE_7, age);
            }

            // Render seed
            poseStack.pushPose();

            float growthProgress = progress / (float) maxProgress;
            float minScale = 0.3f;
            float maxScale = 0.6f;
            float scale = minScale + growthProgress * (maxScale - minScale);

            poseStack.translate(0.5f, 0.1f, 0.5f);
            poseStack.scale(scale, scale, scale);
            poseStack.translate(-0.5f, 0.0f, -0.5f);

            blockRenderer.renderSingleBlock(
                    seedState,
                    poseStack,
                    bufferSource,
                    packedLight,
                    packedOverlay
            );

            poseStack.popPose();
        }
    }

    private static void renderFluid(PoseStack.Pose pose, VertexConsumer consumer, BlockEntity entity, Fluid fluid, float fillAmount, int packedLight) {
        int color = IClientFluidTypeExtensions.of(fluid).getTintColor(fluid.defaultFluidState(), entity.getLevel(), entity.getBlockPos());
        //if (color == -1) color = 0xffffff;
        renderFluid(pose, consumer, fluid, fillAmount, color, packedLight);
    }


    public static void renderFluid(PoseStack.Pose pose, VertexConsumer consumer, Fluid fluid, float fillAmount, int color, int packedLight) {
        // Get fluid texture
        IClientFluidTypeExtensions props = IClientFluidTypeExtensions.of(fluid);
        TextureAtlasSprite texture = Minecraft.getInstance().getTextureAtlas(Sheets.BLOCKS_MAPPER.sheet()).apply(props.getStillTexture());

        // Get sizes
        float fluidHeight = (14 * fillAmount) / 16.0f;
        float inset = 0.0625F;
        float faceSize = 14 / 16.0f;


        // Sides
        RenderUtil.renderFace(Direction.SOUTH, pose, consumer, texture, inset, inset, inset, faceSize, fluidHeight, color, packedLight);
        RenderUtil.renderFace(Direction.NORTH, pose, consumer, texture, inset, inset, inset, faceSize, fluidHeight, color, packedLight);
        RenderUtil.renderFace(Direction.EAST, pose, consumer, texture, inset, inset, inset, faceSize, fluidHeight, color, packedLight);
        RenderUtil.renderFace(Direction.WEST, pose, consumer, texture, inset, inset, inset, faceSize, fluidHeight, color, packedLight);
        RenderUtil.renderFace(Direction.UP, pose, consumer, texture, inset, inset, inset + fluidHeight, faceSize, faceSize, color, packedLight);


        RenderUtil.renderFace(Direction.DOWN, pose, consumer, texture, inset, inset, 1 - inset , faceSize, faceSize, color, packedLight);
    }
}