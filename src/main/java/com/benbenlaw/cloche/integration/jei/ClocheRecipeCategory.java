package com.benbenlaw.cloche.integration.jei;

import com.benbenlaw.cloche.Cloche;
import com.benbenlaw.cloche.block.ClocheBlocks;
import com.benbenlaw.cloche.recipe.ClocheRecipe;
import com.benbenlaw.cloche.recipe.ClocheRecipeCache;
import com.benbenlaw.core.recipe.ChanceResult;
import com.benbenlaw.core.util.MouseUtil;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClocheRecipeCategory implements IRecipeCategory<ClocheRecipe> {

    public final static Identifier TEXTURE = Cloche.identifier("textures/gui/jei_cloche.png");
    private final IDrawable background;

    public static final IRecipeType<ClocheRecipe> RECIPE_TYPE = IRecipeType.create(Cloche.MOD_ID, "cloche", ClocheRecipe.class);

    private final IDrawable icon;


    @Override
    public @Nullable Identifier getIdentifier(ClocheRecipe recipe) {
        return ClocheRecipeCache.getRecipes().stream()
                .filter(r -> r.equals(recipe))
                .findFirst()
                .map(r -> {
                    // Find the corresponding ID in the cache map
                    for (Map.Entry<Identifier, ClocheRecipe> entry : ClocheRecipeCache.cachedRecipes.entrySet()) {
                        if (entry.getValue().equals(recipe)) {
                            return entry.getKey();
                        }
                    }
                    return null;
                })
                .orElse(null);
    }

    public ClocheRecipeCategory(IGuiHelper helper) {
        background = helper.createDrawable(TEXTURE, 0, 0, getWidth(), getHeight());
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ClocheBlocks.CLOCHE.get()));
    }

    @Override
    public IRecipeType<ClocheRecipe> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("block.cloche.cloche");
    }

    @Override
    public int getWidth() {
        return 140;
    }

    @Override
    public int getHeight() {
        return 37;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ClocheRecipe recipe, IFocusGroup focusGroup) {


        builder.addSlot(RecipeIngredientRole.INPUT, 2, 2).add(recipe.seed()).setBackground(JEIClochePlugin.slotDrawable, -1, -1);

        builder.addSlot(RecipeIngredientRole.INPUT, 2, 20).add(recipe.soil()).setBackground(JEIClochePlugin.slotDrawable, -1, -1);

        if (!recipe.catalyst().isEmpty()) {
            builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 36, 11).add(recipe.catalyst().get())
                    .setBackground(JEIClochePlugin.slotDrawable, -1, -1);
        } else {
            builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 36, 11).add(Items.AIR.getDefaultInstance())
                    .setBackground(JEIClochePlugin.slotDrawable, -1, -1);
        }

        List<ChanceResult> modifiedOutputs = new ArrayList<>(recipe.getRollResults());
        if (!recipe.shearsResult().isEmpty()) {
            modifiedOutputs.addLast(new ChanceResult(recipe.shearsResult(), 1.0f));
        }

        int size = modifiedOutputs.size();
        int centerX = size > 0 ? 1 : 10;
        int centerY = size > 4 ? 1 : 10;
        int xOffset = 0;
        int yOffset = 0;
        int index = 0;

        for (int i = 0; i < size; i++) {
            xOffset = centerX + (i % 4) * 18;
            yOffset = centerY + ((i / 4) * 18);
            index = i;

            int finalIndex = index;
            builder.addSlot(RecipeIngredientRole.OUTPUT, 67 + xOffset, yOffset)
                    .add(modifiedOutputs.get(i).stack()).addRichTooltipCallback((slotView, tooltip) -> {
                        ChanceResult output = modifiedOutputs.get(finalIndex);
                        float chance = output.chance();
                        int displayChance = (int) (chance * 100);
                        tooltip.add(Component.translatable("jei.cloche.chance", displayChance).withStyle(ChatFormatting.GOLD));
                        if (finalIndex == 0) {
                            tooltip.add(Component.translatable("jei.cloche.main_output")
                                    .withStyle(ChatFormatting.GREEN));
                        }
                        if (output.stack().is(recipe.shearsResult().getItem())) {
                            tooltip.add(Component.translatable("jei.cloche.shears_result")
                                    .withStyle(ChatFormatting.GREEN));
                        }
                        if (recipe.seed().test(output.stack()) && finalIndex > 0) {
                            tooltip.add(Component.translatable("jei.cloche.seeds_results")
                                    .withStyle(ChatFormatting.GREEN));
                        }
                    }).setBackground(JEIClochePlugin.slotDrawable, -1, -1);
        }
    }

    @Override
    public void draw(ClocheRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {

        background.draw(guiGraphics);

        if (MouseUtil.isMouseAboveArea((int) mouseX, (int) mouseY, 0, 0, 19, 10, 16, 16)) {
            Font font = Minecraft.getInstance().font;
            int duration = recipe.duration();
            //guiGraphics.renderTooltip(font, Component.translatable("block.cloche.jei.duration", duration), 2 + (int) mouseX, 6 + (int) mouseY);
        }

        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
    }
}
