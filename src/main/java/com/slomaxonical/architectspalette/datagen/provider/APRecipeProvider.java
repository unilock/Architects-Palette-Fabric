package com.slomaxonical.architectspalette.datagen.provider;

import com.slomaxonical.architectspalette.crafting.WarpingRecipeJsonBuilder;
import com.slomaxonical.architectspalette.registry.APBlocks;
import com.slomaxonical.architectspalette.registry.APItems;
import com.slomaxonical.architectspalette.registry.APTags;
import com.slomaxonical.architectspalette.registry.ConfigResourceCondition;
import com.slomaxonical.architectspalette.registry.util.RegistryUtil;
import com.slomaxonical.architectspalette.registry.util.StoneBlockSet;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

import static com.slomaxonical.architectspalette.registry.APBlocks.*;
import static com.slomaxonical.architectspalette.registry.APItems.*;
import static com.slomaxonical.architectspalette.registry.util.StoneBlockSet.SetComponent.*;

public class APRecipeProvider extends FabricRecipeProvider {
//todo: Pillars and Fences can now be automated with the new Blockset, do that

    private final Identifier NETHER = new Identifier("the_nether");

    public APRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        Consumer<RecipeJsonProvider> verticaExport =  withConditions(exporter, ConfigResourceCondition.configEnabeled("enableVerticalSlabs"));
        //Warping
        offerWarpingRecipe(exporter, Items.CLAY, WARPSTONE.asItem(), NETHER);
        offerWarpingRecipe(exporter, ItemTags.SAPLINGS, TWISTED_SAPLING.asItem(), NETHER);
        offerWarpingRecipe(exporter, ItemTags.LOGS, TWISTED_LOG.asItem(), NETHER);
        offerWarpingRecipe(exporter, ItemTags.PLANKS, TWISTED_PLANKS.asItem(), NETHER);
        offerWarpingRecipe(exporter, ItemTags.LEAVES, TWISTED_LEAVES.asItem(), NETHER);
        offerWarpingRecipe(exporter, SUNSTONE, MOONSTONE.asItem(), NETHER);
        offerWarpingRecipe(exporter, ROTTEN_FLESH_BLOCK.asItem(), ENTRAILS.asItem(), NETHER);
        offerWarpingRecipe(exporter, Items.NETHERITE_INGOT, UNOBTANIUM, NETHER);
        offerWarpingRecipe(exporter, ABYSSALINE, HADALINE.asItem(), NETHER);
        offerWarpingRecipe(exporter, ABYSSALINE_BRICKS, HADALINE_BRICKS.asItem(), NETHER);
        offerWarpingRecipe(exporter, ABYSSALINE_LAMP, HADALINE_LAMP.asItem(), NETHER);
        offerWarpingRecipe(exporter, ABYSSALINE_PILLAR, HADALINE_PILLAR.asItem(), NETHER);
        offerWarpingRecipe(exporter, ABYSSALINE_PLATING, HADALINE_PLATING.asItem(), NETHER);
        offerWarpingRecipe(exporter, ABYSSALINE_TILES, HADALINE_TILES.asItem(), NETHER);
    //Setts
        offerSetRecipes(exporter,verticaExport, ABYSSALINE_BRICKS,List.of(ABYSSALINE_BRICKS,ABYSSALINE));
        offerSetRecipes(exporter,verticaExport, ABYSSALINE_TILES, List.of(ABYSSALINE_TILES,ABYSSALINE));
        offerSetRecipes(exporter,verticaExport,HADALINE_BRICKS,List.of(HADALINE,HADALINE_BRICKS));
        offerSetRecipes(exporter,verticaExport,HADALINE_TILES,List.of(HADALINE,HADALINE_TILES));
        offerSetRecipes(exporter,verticaExport, MYONITE, List.of(MYONITE));
        offerSetRecipes(exporter,verticaExport, MYONITE_BRICKS, List.of(MYONITE,MYONITE_BRICKS));
        offerSetRecipes(exporter,verticaExport, MUSHY_MYONITE_BRICKS, List.of(MUSHY_MYONITE_BRICKS));
        offerSetRecipes(exporter,verticaExport, OLIVESTONE_BRICKS, List.of(OLIVESTONE_BRICKS));
        offerSetRecipes(exporter,verticaExport, OLIVESTONE_TILES, List.of(OLIVESTONE_TILES));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, CHISELED_OLIVESTONE).input('#', APTags.OLIVESTONE).pattern("#").pattern("#").criterion("has_olivstone",conditionsFromTag(APTags.OLIVESTONE)).offerTo(exporter);

        offerSetRecipes(exporter,verticaExport,ONYX,ONYX_PILLAR,null,List.of(ONYX));
        offerSetRecipes(exporter,verticaExport,ONYX_BRICKS,List.of(ONYX_BRICKS,ONYX));
        offerSetRecipes(exporter,verticaExport,ESOTERRACK,ESOTERRACK_PILLAR,null,List.of(ESOTERRACK));
        offerSetRecipes(exporter,verticaExport,ESOTERRACK_BRICKS,List.of(ESOTERRACK_BRICKS,ESOTERRACK));

        offerSetRecipes(exporter, verticaExport, NETHER_BRASS_BLOCK,NETHER_BRASS_PILLAR,null,List.of(NETHER_BRASS_BLOCK));
        offerSetRecipes(exporter, verticaExport, CUT_NETHER_BRASS,List.of(CUT_NETHER_BRASS, NETHER_BRASS_BLOCK));
        offerSetRecipes(exporter, verticaExport, SMOOTH_NETHER_BRASS,List.of(SMOOTH_NETHER_BRASS));

        offerSetRecipes(exporter,verticaExport, ENTRAILS,List.of(ENTRAILS));
        offerSetRecipes(exporter,verticaExport, ALGAL_BRICKS, null, CHISELED_ALGAL_BRICKS, List.of(ALGAL_BRICKS));
        offerSetRecipes(exporter,verticaExport, OVERGROWN_ALGAL_BRICKS,List.of(OVERGROWN_ALGAL_BRICKS));
        offerSetRecipes(exporter,verticaExport, SUNMETAL_BLOCK, SUNMETAL_PILLAR, CHISELED_SUNMETAL_BLOCK, List.of(SUNMETAL_BLOCK));
        offerSetRecipes(exporter,verticaExport, PLATING_BLOCK,List.of(PLATING_BLOCK));
        offerSetRecipes(exporter,verticaExport,ANCIENT_PLATING,List.of(ANCIENT_PLATING));
        offerSetRecipes(exporter,verticaExport, POLISHED_PACKED_ICE, PACKED_ICE_PILLAR, CHISELED_PACKED_ICE,List.of(POLISHED_PACKED_ICE,Items.PACKED_ICE));
        offerSetRecipes(exporter,verticaExport, GILDED_SANDSTONE, GILDED_SANDSTONE_PILLAR, CHISELED_GILDED_SANDSTONE,List.of(GILDED_SANDSTONE));
        offerSetRecipes(exporter, verticaExport, POLISHED_GLOWSTONE,RUNIC_GLOWSTONE,null,List.of(POLISHED_GLOWSTONE));

        offerSetRecipes(exporter,verticaExport, OSSEOUS_BRICKS, OSSEOUS_PILLAR, OSSEOUS_SKULL, List.of(OSSEOUS_BRICKS,Items.BONE_BLOCK));
        offerSetRecipes(exporter,verticaExport, WITHERED_OSSEOUS_BRICKS, WITHERED_OSSEOUS_PILLAR, WITHERED_OSSEOUS_SKULL,List.of(WITHERED_BONE, WITHERED_OSSEOUS_BRICKS));
        offerSetRecipes(exporter,verticaExport, FLINT_TILES,List.of(FLINT_TILES));
        offerPillarRecipe(exporter, FLINT_PILLAR, FLINT_BLOCK);

        offerSetRecipes(exporter,verticaExport, BASALT_TILES,null, CHISELED_BASALT_TILES,List.of(BASALT_TILES,Items.POLISHED_BASALT,Items.BASALT));
        offerSetRecipes(exporter,verticaExport, DRIPSTONE_BRICKS, DRIPSTONE_PILLAR, CHISELED_DRIPSTONE,List.of(DRIPSTONE_BRICKS,Items.DRIPSTONE_BLOCK));
        offerPolishedStoneRecipe(exporter, RecipeCategory.MISC, DRIPSTONE_BRICKS, Items.DRIPSTONE_BLOCK);

        offerSetRecipes(exporter,verticaExport, CALCITE_BRICKS, CALCITE_PILLAR, CHISELED_CALCITE,List.of(CALCITE_BRICKS,Items.CALCITE));
        offerSetRecipes(exporter,verticaExport, TUFF_BRICKS, TUFF_PILLAR, CHISELED_TUFF,List.of(TUFF_BRICKS,Items.TUFF));

        offerSetRecipes(exporter,verticaExport,WARDSTONE,WARDSTONE_PILLAR,CHISELED_WARDSTONE,List.of(WARDSTONE));
        offerSetRecipes(exporter,verticaExport,WARDSTONE_BRICKS,List.of(WARDSTONE_BRICKS,WARDSTONE));

        offerSetRecipes(exporter,verticaExport, ENTWINE_BLOCK, ENTWINE_PILLAR, CHISELED_ENTWINE,List.of(ENTWINE_BLOCK));
        offerSetRecipes(exporter,verticaExport, WARPSTONE,List.of(WARPSTONE));

        offerStairsRecipe(exporter,RegistryUtil.BlockSets.get(TWISTED_PLANKS).getPart(STAIRS), TWISTED_PLANKS);
        offerSlabsRecipes(exporter,verticaExport, RegistryUtil.BlockSets.get(TWISTED_PLANKS).getPart(SLAB), RegistryUtil.BlockSets.get(TWISTED_PLANKS).getPart(VERTICAL_SLAB), TWISTED_PLANKS);
        createFenceRecipe(TWISTED_FENCE,Ingredient.ofItems(TWISTED_PLANKS)).criterion(hasItem(TWISTED_PLANKS), conditionsFromItem(TWISTED_PLANKS)).offerTo(exporter);
        createFenceGateRecipe(TWISTED_FENCE_GATE,Ingredient.ofItems(TWISTED_PLANKS)).criterion(hasItem(TWISTED_PLANKS), conditionsFromItem(TWISTED_PLANKS)).offerTo(exporter);

        //Abyssaline
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ABYSSALINE,16).input('#', Items.PRISMARINE_SHARD).input('$', Items.OBSIDIAN).pattern("$#$").pattern("# #").pattern("$#$").criterion("has_obsidian",conditionsFromItem(Items.OBSIDIAN)).offerTo(exporter);
        offerPolishedStoneRecipe(exporter, RecipeCategory.MISC, ABYSSALINE_BRICKS, ABYSSALINE);
        offerPolishedStoneRecipe(exporter, RecipeCategory.MISC, ABYSSALINE_TILES, ABYSSALINE_BRICKS);
//        createCondensingRecipe(ABYSSALINE_BRICKS, Ingredient.ofItems(ABYSSALINE_TILES)).criterion("has_abyssaline_tiles", conditionsFromItem(ABYSSALINE_TILES)).offerTo(exporter,"abyssaline_bricks_from_tiles");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ABYSSALINE_LAMP, 8).input('#', Items.PRISMARINE_SHARD).input('$', Items.OBSIDIAN).input('C',Items.PRISMARINE_CRYSTALS).pattern("$C$").pattern("#C#").pattern("$C$").criterion("has_obsidian",conditionsFromItem(Items.OBSIDIAN)).offerTo(exporter);
        offerEmptyFrameRecipe(exporter,ABYSSALINE_PLATING,ABYSSALINE,8);
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ABYSSALINE_BRICKS,ABYSSALINE);
        offerStonecuttingRecipe(exporter, 1,ABYSSALINE_PILLAR,List.of(ABYSSALINE,ABYSSALINE_BRICKS));
        offerStonecuttingRecipe(exporter, 1,ABYSSALINE_TILES,List.of(ABYSSALINE,ABYSSALINE_BRICKS));
        offerStonecuttingRecipe(exporter, 1,CHISELED_ABYSSALINE_BRICKS,List.of(ABYSSALINE,ABYSSALINE_BRICKS));
        offerStonecuttingRecipe(exporter,RecipeCategory.MISC,ABYSSALINE_PLATING,ABYSSALINE);
        //Hadaline
        offerPolishedStoneRecipe(exporter, RecipeCategory.MISC, HADALINE_BRICKS, HADALINE);
        offerPolishedStoneRecipe(exporter, RecipeCategory.MISC, HADALINE_TILES, HADALINE_BRICKS);
        offerEmptyFrameRecipe(exporter,HADALINE_PLATING,HADALINE,8);
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, HADALINE_BRICKS,HADALINE_BRICKS);
        offerStonecuttingRecipe(exporter, 1,HADALINE_PILLAR,List.of(HADALINE,HADALINE_BRICKS));
        offerStonecuttingRecipe(exporter, 1,HADALINE_TILES,List.of(HADALINE,HADALINE_BRICKS));
        offerStonecuttingRecipe(exporter, 1,CHISELED_HADALINE_BRICKS,List.of(HADALINE,HADALINE_BRICKS));
        offerStonecuttingRecipe(exporter,RecipeCategory.MISC,HADALINE_PLATING,HADALINE);

        //Railings
        offerRailingsRecipe(exporter, ACACIA_RAILING, Items.ACACIA_PLANKS);
        offerRailingsRecipe(exporter, BIRCH_RAILING, Items.BIRCH_PLANKS);
        offerRailingsRecipe(exporter, OAK_RAILING, Items.OAK_PLANKS);
        offerRailingsRecipe(exporter, SPRUCE_RAILING, Items.SPRUCE_PLANKS);
        offerRailingsRecipe(exporter, DARK_OAK_RAILING, Items.DARK_OAK_PLANKS);
        offerRailingsRecipe(exporter, JUNGLE_RAILING, Items.JUNGLE_PLANKS);
        offerRailingsRecipe(exporter, CRIMSON_RAILING, Items.CRIMSON_PLANKS);
        offerRailingsRecipe(exporter, WARPED_RAILING, Items.WARPED_PLANKS);
        offerRailingsRecipe(exporter, TWISTED_RAILING, TWISTED_PLANKS);
        offerRailingsRecipe(exporter, MANGROVE_RAILING, Items.MANGROVE_PLANKS);
        //Algal
        offerShapelessRecipe(exporter,2,ALGAL_BLEND,Items.CLAY_BALL,Items.KELP);
        offerSmelting(exporter, List.of(ALGAL_BLEND),RecipeCategory.MISC,ALGAL_BRICK,0.3f, 200, null);
        offerCondensingRecipe(exporter,ALGAL_BRICKS, ALGAL_BRICK,1);
        offerShapelessRecipe(exporter, 1, OVERGROWN_ALGAL_BRICKS,ALGAL_BRICKS,Items.KELP);
        //sunmetal
        offerShapelessRecipe(exporter,2,SUNMETAL_BLEND,Items.SOUL_SAND,Items.GOLD_NUGGET);
        offerSmelting(exporter, List.of(SUNMETAL_BLEND),RecipeCategory.MISC,SUNMETAL_BRICK,0.3f, 200, null);
        offerCondensingRecipe(exporter, SUNMETAL_BLOCK, SUNMETAL_BRICK,1);
        offerBarsRecipe(exporter,SUNMETAL_BARS,SUNMETAL_BRICK);
        //Gilded Sandstone
        offerMiniXRecipe(exporter,GILDED_SANDSTONE, Items.SANDSTONE,Items.GOLD_NUGGET,2);
        //basalt
        offerPolishedStoneRecipe(exporter, RecipeCategory.MISC, BASALT_TILES, Items.POLISHED_BASALT);
        offerShapelessRecipe(exporter, Items.BONE_MEAL, WITHERED_BONE,null,3);
        //calcite
        offerPolishedStoneRecipe(exporter, RecipeCategory.MISC, CALCITE_BRICKS, Items.CALCITE);
        //lamps and cage lanterns
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ALGAL_LAMP).input('#', Items.GLOWSTONE_DUST).input('A',ALGAL_BRICK).pattern("A#A").pattern("###").pattern("A#A").criterion("has_algal_brick", RecipeProvider.conditionsFromItem(ALGAL_BRICK)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, WITHER_LAMP).input('#', Items.GLOWSTONE_DUST).input('B',WITHERED_BONE).pattern("B#B").pattern("#B#").pattern("B#B").criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST)).offerTo(exporter);
        offerLampRecipe(exporter,DRIPSTONE_LAMP, Items.DRIPSTONE_BLOCK, Items.AMETHYST_SHARD);
        offerLampRecipe(exporter,CALCITE_LAMP, Items.CALCITE, Items.GLOW_INK_SAC);
        offerLampRecipe(exporter,TUFF_LAMP, Items.TUFF, Items.GLOW_LICHEN);
        offerEmptyFrameRecipe(exporter,WARDSTONE_LAMP,WARDSTONE_BRICK,1);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ALGAL_CAGE_LANTERN).input('#', ALGAL_BRICK).input('p', Items.GLASS_PANE).input('d', Items.GLOWSTONE_DUST).pattern(" p ").pattern("#d#").criterion(hasItem(ALGAL_BRICK), conditionsFromItem(ALGAL_BRICK)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, REDSTONE_CAGE_LANTERN).input('#', Items.IRON_NUGGET).input('p', Items.GLASS_PANE).input('d', Items.GLOWSTONE_DUST).pattern(" p ").pattern("#d#").criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, GLOWSTONE_CAGE_LANTERN).input('#', WITHERED_BONE).input('p', Items.GLASS_PANE).input('d', Items.GLOWSTONE_DUST).pattern(" p ").pattern("#d#").criterion(hasItem(WITHERED_BONE), conditionsFromItem(WITHERED_BONE)).offerTo(exporter);

        //endStone
        offerChiseledBlockRecipe(exporter,RecipeCategory.MISC, CHISELED_END_STONE_BRICKS, Items.END_STONE_BRICK_SLAB);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, CHORAL_END_STONE_BRICKS).input(Ingredient.ofItems(Items.END_STONE_BRICKS,Items.CHORUS_FRUIT)).criterion(hasItem(Items.END_STONE_BRICKS),conditionsFromItem(Items.END_STONE_BRICKS)).offerTo(exporter);
        //Myonite
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, MYONITE, 8).input('#',Items.STONE).input('$', APTags.MUSHROOMS).pattern("###").pattern("#$#").pattern("###").criterion("has_mushroom",conditionsFromTag(APTags.MUSHROOMS)).offerTo(exporter);
        offerPolishedStoneRecipe(exporter, RecipeCategory.MISC, MYONITE_BRICKS, MYONITE);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, MUSHY_MYONITE_BRICKS, 2).input('#',MYONITE_BRICKS).input('$', APTags.MUSHROOMS).pattern("#$").pattern("$#").criterion("has_mushroom",conditionsFromTag(APTags.MUSHROOMS)).offerTo(exporter);
        //heavy
        offerHeavyRecipe(exporter,HEAVY_CALCITE_BRICKS,Items.CALCITE);
        offerHeavyRecipe(exporter,HEAVY_DRIPSTONE_BRICKS,Items.DRIPSTONE_BLOCK);
        offerHeavyRecipe(exporter,HEAVY_TUFF_BRICKS,Items.TUFF);
        offerHeavyRecipe(exporter,HEAVY_END_STONE_BRICKS,Items.END_STONE);
        offerHeavyRecipe(exporter,HEAVY_STONE_BRICKS,Items.STONE);
        offerShapelessRecipe(exporter,1,HEAVY_MOSSY_STONE_BRICKS,HEAVY_STONE_BRICKS,Items.VINE);
        //Wardstone
        offerMiniXRecipe(exporter,WARDSTONE_BLEND,Items.LAPIS_LAZULI,Items.NETHER_WART,4);
        offerSmelting(exporter, List.of(WARDSTONE_BLEND),RecipeCategory.MISC, WARDSTONE_BRICK,0.1f, 200, null);
        offerPolishedStoneRecipe(exporter,RecipeCategory.MISC, WARDSTONE,WARDSTONE_BRICK);
        offerPolishedStoneRecipe(exporter,RecipeCategory.MISC, WARDSTONE_BRICKS,WARDSTONE);
        //Entwine
        offerPolishedStoneRecipe(exporter, RecipeCategory.MISC, ENTWINE_BLOCK,ENTWINE_ROD);
        offerBarsRecipe(exporter,ENTWINE_BARS,ENTWINE_ROD);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ENTWINE_ROD, 4).input('#',Items.ENDER_PEARL).input('$', Items.IRON_NUGGET).pattern("#$#").criterion(hasItem(Items.ENDER_PEARL),conditionsFromItem(Items.ENDER_PEARL)).offerTo(exporter);
        offerCondensingRecipe(exporter, ENDER_PEARL_BLOCK, Items.ENDER_PEARL,1);
        offerShapelessRecipe(exporter,Items.ENDER_PEARL,ENDER_PEARL_BLOCK,null,4);
        //meow
        offerShapelessRecipe(exporter,2,ACACIA_TOTEM_WING,Items.STICK,Items.ACACIA_LEAVES);
        offerPolishedStoneRecipe(exporter, RecipeCategory.MISC, CHARCOAL_BLOCK, Items.CHARCOAL);
        offerSingleOutputShapelessRecipe(exporter, Items.CHARCOAL, CHARCOAL_BLOCK,null);
        offerMiniXRecipe(exporter,COARSE_SNOW, Items.SNOW_BLOCK,Items.GRAVEL,4);
        offerPolishedStoneRecipe(exporter,RecipeCategory.MISC, FLINT_BLOCK,Items.FLINT);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, GRINNING_ACACIA_TOTEM, 2).input('#',Items.ACACIA_LOG).input('$', Items.STICK).pattern("$#$").pattern(" # ").criterion(hasItem(Items.ACACIA_LOG),conditionsFromItem(Items.ACACIA_LOG)).offerTo(exporter);
        offerMiniXRecipe(exporter,MOLTEN_NETHER_BRICKS,Items.MAGMA_BLOCK,Items.NETHER_BRICKS,4);
        offerPolishedStoneRecipe(exporter,RecipeCategory.MISC, PIPE,PLATING_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, PLATING_BLOCK).input('#', Items.IRON_NUGGET).input('I',Items.IRON_INGOT).pattern(" # ").pattern("#I#").pattern(" # ").criterion("has_iron_ingot", RecipeProvider.conditionsFromItem(Items.IRON_INGOT)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ANCIENT_PLATING).input('I', NETHER_BRASS_INGOT).input('N',NETHER_BRASS_NUGGET).input('S',Items.NETHERITE_SCRAP).pattern("INI").pattern("NSN").pattern("INI").criterion(hasItem(Items.NETHERITE_SCRAP), RecipeProvider.conditionsFromItem(Items.NETHERITE_SCRAP)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RegistryUtil.BlockSets.get(ANCIENT_PLATING).getPart(FENCE),6).input('I', NETHER_BRASS_INGOT).input('#',ANCIENT_PLATING).pattern("#I#").pattern("#I#").criterion(hasItem(ANCIENT_PLATING), RecipeProvider.conditionsFromItem(ANCIENT_PLATING)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, HAZARD_SIGN,4).input('I', Items.IRON_INGOT).input('#',Items.IRON_NUGGET).pattern(" I ").pattern("#I#").criterion(hasItem(Items.IRON_INGOT), RecipeProvider.conditionsFromItem(Items.IRON_INGOT)).offerTo(exporter);
        offerPolishedStoneRecipe(exporter,RecipeCategory.MISC, POLISHED_GLOWSTONE,Items.GLOWSTONE);
        offerPolishedStoneRecipe(exporter,RecipeCategory.MISC, POLISHED_PACKED_ICE,Items.PACKED_ICE);
        offerReversibleCompactingRecipes(exporter,RecipeCategory.MISC,Items.ROTTEN_FLESH,RecipeCategory.MISC,ROTTEN_FLESH_BLOCK);
        offerCondensingRecipe(exporter, SCUTE_BLOCK,Items.SCUTE,12);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, SPOOL, 2).input('#',Items.WHITE_WOOL).input('$', ItemTags.WOODEN_FENCES).pattern("#$#").criterion("has_wooden_fence",conditionsFromTag(ItemTags.WOODEN_FENCES)).offerTo(exporter);
        offerMiniXRecipe(exporter,SUNSTONE,SUNMETAL_BLEND,Items.BASALT,4);
        offerPolishedStoneRecipe(exporter,RecipeCategory.MISC, TUFF_BRICKS,Items.TUFF);
        //blackstone
        offerShapelessRecipe(exporter,1,TWISTING_BLACKSTONE, Items.BLACKSTONE, Items.TWISTING_VINES);
        offerShapelessRecipe(exporter,1,TWISTING_BLACKSTONE_BRICKS, Items.POLISHED_BLACKSTONE_BRICKS, Items.TWISTING_VINES);
        offerShapelessRecipe(exporter,1,WEEPING_BLACKSTONE, Items.BLACKSTONE, Items.WEEPING_VINES);
        offerShapelessRecipe(exporter,1,WEEPING_BLACKSTONE_BRICKS, Items.POLISHED_BLACKSTONE_BRICKS, Items.WEEPING_VINES);
        //withered
        offerShapelessRecipe(exporter,WITHERED_BONE,WITHERED_BONE_BLOCK,null,3);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, WITHERED_BONE_BLOCK, 3).input('#', WITHERED_BONE).pattern("###").pattern("###").pattern("###").group("boards").criterion(hasItem(WITHERED_BONE), conditionsFromItem(WITHERED_BONE)).offerTo(exporter);
        offerPolishedStoneRecipe(exporter, RecipeCategory.MISC, WITHERED_OSSEOUS_BRICKS,WITHERED_BONE_BLOCK);
        offerSmelting(exporter,List.of(WITHERED_BONE), RecipeCategory.MISC, Items.BLACK_DYE,0.3f,200,null);
        //Onyx
        offerPolishedStoneRecipe(exporter,RecipeCategory.MISC, ONYX_BRICKS,ONYX);
        //Esoterrack
        offerPolishedStoneRecipe(exporter,RecipeCategory.MISC, ESOTERRACK_BRICKS,ESOTERRACK);
        //NetherBrass
        offerShapelessRecipe(exporter,4, NETHER_BRASS_BLEND,Items.SOUL_SAND,Items.COPPER_INGOT,Items.SOUL_SAND,Items.IRON_NUGGET);
        offerCutCopperRecipe(exporter,RecipeCategory.MISC, CUT_NETHER_BRASS, NETHER_BRASS_BLOCK);
        offerCutCopperRecipe(exporter, RecipeCategory.MISC, NETHER_BRASS_BLOCK, NETHER_BRASS_INGOT);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, NETHER_BRASS_LANTERN).input('#', APItems.NETHER_BRASS_TORCH).input('X', NETHER_BRASS_NUGGET).pattern("XXX").pattern("X#X").pattern("XXX").criterion("has_brass_torch", RecipeProvider.conditionsFromItem(APBlocks.NETHER_BRASS_TORCH)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, NETHER_BRASS_CHAIN).input('i', NETHER_BRASS_INGOT).input('n', NETHER_BRASS_NUGGET).pattern("n").pattern("i").pattern("n").criterion("has_brass_ingot", RecipeProvider.conditionsFromItem(NETHER_BRASS_INGOT)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, APBlocks.NETHER_BRASS_TORCH).input('n', NETHER_BRASS_NUGGET).input('s', Items.STICK).pattern("n").pattern("s").criterion("has_brass_nugget", RecipeProvider.conditionsFromItem(NETHER_BRASS_NUGGET)).offerTo(exporter);
        offerReversibleCompactingRecipes(exporter,RecipeCategory.MISC, NETHER_BRASS_NUGGET, RecipeCategory.MISC, NETHER_BRASS_INGOT,"brass_nuggets_to_ingot",null,"brass_ingot_to_nuggets",null);
        offerSmelting(exporter, List.of(NETHER_BRASS_BLEND), RecipeCategory.MISC, NETHER_BRASS_INGOT,0.1f, 200, null);
        offerBlasting(exporter,List.of(NETHER_BRASS_BLEND), RecipeCategory.MISC, NETHER_BRASS_INGOT,0.1f,100,null);
        offerSmelting(exporter, List.of(NETHER_BRASS_BLOCK),RecipeCategory.MISC, SMOOTH_NETHER_BRASS,0.1f, 200, null);
        offerBlasting(exporter, List.of(NETHER_BRASS_BLOCK),RecipeCategory.MISC, SMOOTH_NETHER_BRASS,0.1f, 100, null);
        //olive
        offerFramedRecipe(exporter,OLIVESTONE_BRICKS, Items.GREEN_DYE,Items.STONE,8);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ILLUMINATED_OLIVESTONE, 2).input('#', APTags.OLIVESTONE).input('$',Items.GLOWSTONE_DUST).pattern("#$").pattern("$#").criterion("has_olivestone", conditionsFromTag(APTags.OLIVESTONE)).offerTo(exporter);
        RecipeProvider.createCondensingRecipe(RecipeCategory.MISC, OLIVESTONE_BRICKS, Ingredient.ofItems(OLIVESTONE_TILES)).criterion(RecipeProvider.hasItem(OLIVESTONE_TILES), RecipeProvider.conditionsFromItem(OLIVESTONE_TILES)).offerTo(exporter,"olivstone_bricks_from_tiles");
        offerPolishedStoneRecipe(exporter, RecipeCategory.MISC, OLIVESTONE_TILES,OLIVESTONE_BRICKS);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, OLIVESTONE_PILLAR, 2).input('#', APTags.OLIVESTONE).pattern("#").pattern("#").criterion("has_olivestone", conditionsFromTag(APTags.OLIVESTONE)).offerTo(exporter);
        //fish
        offerCondensingRecipe(exporter,SALMON_LOG,Items.SALMON,6);
        offerCondensingRecipe(exporter,SALMON_SCALES,SALMON_LOG,3);
        offerCondensingRecipe(exporter, COD_LOG, Items.COD,6);
        offerCondensingRecipe(exporter, COD_SCALES, COD_LOG,3);
        //osseous
        offerPolishedStoneRecipe(exporter, RecipeCategory.MISC, OSSEOUS_BRICKS,Items.BONE_BLOCK);
        offerShapelessRecipe(exporter,1,LIT_OSSEOUS_SKULL,OSSEOUS_SKULL,Items.TORCH);
        offerShapelessRecipe(exporter,1,LIT_WITHERED_OSSEOUS_SKULL,WITHERED_OSSEOUS_SKULL,Items.SOUL_TORCH);
        //twisted
        offerCondensingRecipe(exporter,TWISTED_WOOD,TWISTED_LOG,3);
        offerCondensingRecipe(exporter,STRIPPED_TWISTED_WOOD,STRIPPED_TWISTED_LOG,3);
        offerShapelessRecipe(exporter,TWISTED_BUTTON,TWISTED_PLANKS,null,1);
        offerShapelessRecipe(exporter,TWISTED_PLANKS,TWISTED_LOG,null,4);
        offerPressurePlateRecipe(exporter,TWISTED_PRESSURE_PLATE,TWISTED_PLANKS);
        createDoorRecipe(TWISTED_DOOR, Ingredient.ofItems(TWISTED_PLANKS)).criterion(hasItem(TWISTED_PLANKS),conditionsFromItem(TWISTED_PLANKS)).offerTo(exporter);
        createTrapdoorRecipe(TWISTED_TRAPDOOR,Ingredient.ofItems(TWISTED_PLANKS)).criterion(hasItem(TWISTED_PLANKS),conditionsFromItem(TWISTED_PLANKS)).offerTo(exporter);
        //Unobtainium
        offerCondensingRecipe(exporter,UNOBTANIUM_BLOCK,UNOBTANIUM,1);
        offerShapelessRecipe(exporter,UNOBTANIUM,UNOBTANIUM_BLOCK,null,5);
        //cracked
        CookingRecipeJsonBuilder.createSmoking(Ingredient.fromTag(ItemTags.LOGS_THAT_BURN), RecipeCategory.MISC, CHARCOAL_BLOCK, 0.175f, 100).criterion("has_log", RecipeProvider.conditionsFromTag(ItemTags.LOGS_THAT_BURN)).offerTo(exporter,"charcoal_block_from_smoking");
        offerCrackingRecipe(exporter,CRACKED_ALGAL_BRICKS,ALGAL_BRICKS);
        offerCrackingRecipe(exporter,CRACKED_BASALT_TILES,BASALT_TILES);
        offerCrackingRecipe(exporter,CRACKED_END_STONE_BRICKS,Items.END_STONE_BRICKS);
        offerCrackingRecipe(exporter,CRACKED_OLIVESTONE_BRICKS,OLIVESTONE_BRICKS);
        offerCrackingRecipe(exporter,CRACKED_OLIVESTONE_TILES, OLIVESTONE_TILES);
        offerCrackingRecipe(exporter,HEAVY_CRACKED_END_STONE_BRICKS,HEAVY_END_STONE_BRICKS);
        offerCrackingRecipe(exporter,HEAVY_CRACKED_STONE_BRICKS,HEAVY_STONE_BRICKS);
        //stoncutting
        offerStonecuttingRecipe(exporter, 2,BASALT_TILES,List.of(Items.BASALT,Items.POLISHED_BASALT));

        offerStonecuttingRecipe(exporter,RecipeCategory.MISC, CALCITE_BRICKS,Items.CALCITE);
        offerStonecuttingRecipe(exporter,RecipeCategory.MISC, DRIPSTONE_BRICKS,Items.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter,RecipeCategory.MISC, TUFF_BRICKS,Items.TUFF);

        offerStonecuttingRecipe(exporter,1,CHISELED_END_STONE_BRICKS,List.of(Items.END_STONE,Items.END_STONE_BRICKS));
        offerStonecuttingRecipe(exporter,1,CHISELED_OLIVESTONE,List.of(OLIVESTONE_BRICKS, OLIVESTONE_TILES));
        offerStonecuttingRecipe(exporter,RecipeCategory.MISC, FLINT_PILLAR,FLINT_BLOCK);
        offerStonecuttingRecipe(exporter,RecipeCategory.MISC, FLINT_TILES,FLINT_BLOCK);
        offerStonecuttingRecipe(exporter,RecipeCategory.MISC, MYONITE_BRICKS,MYONITE);
        offerStonecuttingRecipe(exporter,RecipeCategory.MISC, OLIVESTONE_BRICKS, OLIVESTONE_TILES);
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, OLIVESTONE_TILES,OLIVESTONE_BRICKS);
        offerStonecuttingRecipe(exporter,1,OLIVESTONE_PILLAR,List.of(OLIVESTONE_BRICKS, OLIVESTONE_TILES));
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, OSSEOUS_BRICKS,Items.BONE_BLOCK);
        offerStonecuttingRecipe(exporter,RecipeCategory.MISC, POLISHED_GLOWSTONE,Items.GLOWSTONE);
//        offerStonecuttingRecipe(exporter,2,POLISHED_GLOWSTONE_SET.SLAB,List.of(POLISHED_GLOWSTONE,Items.GLOWSTONE));
//        offerStonecuttingRecipe(exporter,1,RUNIC_GLOWSTONE,List.of(POLISHED_GLOWSTONE,Items.GLOWSTONE));
        offerStonecuttingRecipe(exporter,RecipeCategory.MISC, POLISHED_PACKED_ICE,Items.PACKED_ICE);
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, WITHERED_OSSEOUS_BRICKS,WITHERED_BONE_BLOCK);

        offerStonecuttingRecipe(exporter,1,HEAVY_CALCITE_BRICKS,List.of(CALCITE_BRICKS,Items.CALCITE));
        offerStonecuttingRecipe(exporter,1,HEAVY_DRIPSTONE_BRICKS,List.of(DRIPSTONE_BRICKS,Items.DRIPSTONE_BLOCK));
        offerStonecuttingRecipe(exporter,1,HEAVY_TUFF_BRICKS,List.of(TUFF_BRICKS,Items.TUFF));
        offerStonecuttingRecipe(exporter,RecipeCategory.MISC, HEAVY_END_STONE_BRICKS,Items.END_STONE);
        offerStonecuttingRecipe(exporter,RecipeCategory.MISC, HEAVY_STONE_BRICKS,Items.STONE);
        //Nubs
        RegistryUtil.nubs.forEach((nub , mat)-> offerStonecuttingRecipe(exporter,2,nub,mat));
//        offerStonecuttingRecipe(exporter,NUB_OF_ENDER,Items.ENDER_EYE,2);
        offerShapelessRecipe(exporter,1,WAXED_COPPER_NUB,COPPER_NUB,Items.HONEYCOMB);
        offerShapelessRecipe(exporter,1,WAXED_EXPOSED_COPPER_NUB,EXPOSED_COPPER_NUB,Items.HONEYCOMB);
        offerShapelessRecipe(exporter,1,WAXED_WEATHERED_COPPER_NUB,WEATHERED_COPPER_NUB,Items.HONEYCOMB);
        offerShapelessRecipe(exporter,1,WAXED_OXIDIZED_COPPER_NUB,OXIDIZED_COPPER_NUB,Items.HONEYCOMB);
        //Ore Bricks
        offerOreBricksRecipes(exporter, verticaExport, RegistryUtil.oreBrickSets.get(0), Items.COAL);
        offerOreBricksRecipes(exporter, verticaExport, RegistryUtil.oreBrickSets.get(1), Items.LAPIS_LAZULI);
        offerOreBricksRecipes(exporter, verticaExport, RegistryUtil.oreBrickSets.get(2), Items.REDSTONE);
        offerOreBricksRecipes(exporter, verticaExport, RegistryUtil.oreBrickSets.get(3), Items.IRON_INGOT);
        offerOreBricksRecipes(exporter, verticaExport, RegistryUtil.oreBrickSets.get(4), Items.GOLD_INGOT);
        offerOreBricksRecipes(exporter, verticaExport, RegistryUtil.oreBrickSets.get(5), Items.EMERALD);
        offerOreBricksRecipes(exporter, verticaExport, RegistryUtil.oreBrickSets.get(6), Items.DIAMOND);

    }
    public static void offerWarpingRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible input, Item output, Identifier dimension) {
        WarpingRecipeJsonBuilder.create(Ingredient.ofItems(input), output, dimension).offerTo(exporter, "warping/"+RecipeProvider.convertBetween(output,input)+"_warping");
    }
    public static void offerWarpingRecipe(Consumer<RecipeJsonProvider> exporter, TagKey<Item> input, Item output, Identifier dimension) {
        WarpingRecipeJsonBuilder.create(Ingredient.fromTag(input), output, dimension).offerTo(exporter, "warping/"+ RecipeProvider.getItemPath(output) + "_from_" + input.id().getPath() +"_warping");
    }
    public static void offerStonecuttingRecipe(Consumer<RecipeJsonProvider> exporter, int count, ItemConvertible output, List<ItemConvertible> inputs){
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(inputs.toArray(new ItemConvertible[0])), RecipeCategory.MISC, output, count).criterion(RecipeProvider.hasItem(inputs.get(0)), RecipeProvider.conditionsFromItem(inputs.get(0))).offerTo(exporter, "stonecutting/"+output.asItem().toString() + "_stonecutting");
    }
    public static void offerStonecuttingRecipe(Consumer<RecipeJsonProvider> exporter, int count, ItemConvertible output, List<ItemConvertible> inputs,String path){
        SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(inputs.toArray(new ItemConvertible[0])), RecipeCategory.MISC, output, count).criterion(RecipeProvider.hasItem(inputs.get(0)), RecipeProvider.conditionsFromItem(inputs.get(0))).offerTo(exporter, path+"stonecutting/"+output.asItem().toString() + "_stonecutting");
    }
    public static void offerShapelessRecipe(Consumer<RecipeJsonProvider> exporter, int count,ItemConvertible output, ItemConvertible... inputs) {
        ShapelessRecipeJsonBuilder builder = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output, count);
        for (ItemConvertible input : inputs) {
            builder.input(input);
        }
        builder.criterion(RecipeProvider.hasItem(inputs[0]), RecipeProvider.conditionsFromItem(inputs[0])).offerTo(exporter, output.asItem().toString() + "_shapeless");
    }
    public static void offerRailingsRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output, 9).input('#', input).input('|', Items.STICK).pattern("#|#").group("boards").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerLampRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible base, ItemConvertible core) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output,2).input('#',base).input('$', core).pattern(" # ").pattern("#$#").pattern(" # ").criterion(hasItem(base), RecipeProvider.conditionsFromItem(base)).offerTo(exporter);
    }
    public static void offerHeavyRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output,9).input('#', input).pattern("###").pattern("###").pattern("###").criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerEmptyFrameRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible surround , int count){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output, count).input('#', surround).pattern("###").pattern("# #").pattern("###").criterion(hasItem(surround), conditionsFromItem(surround)).offerTo(exporter);
    }
    public static void  offerFramedRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible center,ItemConvertible around , int count){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output, count).input('#', around).input('$',center).pattern("###").pattern("#$#").pattern("###").criterion(hasItem(around), conditionsFromItem(around)).offerTo(exporter);
    }
    public static void offerMiniXRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input,ItemConvertible input2 , int count){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output, count).input('#', input).input('$',input2).pattern("#$").pattern("$#").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerCondensingRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input, int count){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output, count).input('#', input).pattern("##").pattern("##").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerPillarRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output, 2).input('#', input).pattern("#").pattern("#").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerStairsRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input){
        createStairsRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input),conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerBarsRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output, 16).input('#', input).pattern("###").pattern("###").criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerOreBricksRecipes(Consumer<RecipeJsonProvider> exporter,Consumer<RecipeJsonProvider> vertExporter,StoneBlockSet set, ItemConvertible baseItem){
        offerFramedRecipe(exporter,set.getBase(),baseItem,Items.STONE_BRICKS,8);
        offerSetRecipes(exporter,vertExporter,set.getBase(), null, RegistryUtil.chiseledNcrackedOres.get(set.getBase()).get(0),List.of(set.getBase()));
        offerCrackingRecipe(exporter, RegistryUtil.chiseledNcrackedOres.get(set.getBase()).get(1),set.getBase());

    }
    public static void offerSetRecipes(Consumer<RecipeJsonProvider> exporter, Consumer<RecipeJsonProvider> vertExporter, Block baseBlock, List<ItemConvertible> forCutting){
        offerSetRecipes(exporter, vertExporter, baseBlock, null, null, forCutting);
    }
    public static void offerSetRecipes(Consumer<RecipeJsonProvider> exporter, Consumer<RecipeJsonProvider> vertExporter, Block baseBlock, @Nullable Block pillar, @Nullable Block chiseled, List<ItemConvertible>  cuttingInputs){
        StoneBlockSet blockSet = null;//For the record this looping is outrageous, surely there is a better way
        if (RegistryUtil.BlockSets.containsKey(baseBlock)) blockSet = RegistryUtil.BlockSets.get(baseBlock);

       if(blockSet==null){
           for (StoneBlockSet set: RegistryUtil.oreBrickSets) {
             if (set.getBase().equals(baseBlock)){
                blockSet=set;
                break;
             }
           }
       }

        offerSlabsRecipes(exporter,vertExporter,blockSet.getPart(SLAB), blockSet.getPart(VERTICAL_SLAB), blockSet.getBase());
        offerStonecuttingRecipe(exporter,2,blockSet.getPart(SLAB),cuttingInputs);
        offerStonecuttingRecipe(vertExporter,2,blockSet.getPart(VERTICAL_SLAB),cuttingInputs,"vertical/");
        if(blockSet.getPart(STAIRS)!=null){
            offerStairsRecipe(exporter,blockSet.getPart(STAIRS), blockSet.getBase());
            offerStonecuttingRecipe(exporter,1,blockSet.getPart(STAIRS),cuttingInputs);
        }
        if (blockSet.getPart(WALL)!=null){
            offerWallRecipe(exporter, RecipeCategory.MISC, blockSet.getPart(WALL), blockSet.getBase());
            offerStonecuttingRecipe(exporter,1,blockSet.getPart(WALL),cuttingInputs);
        }
        if (pillar != null){//todo:this is now in blockset
            offerPillarRecipe(exporter, pillar, blockSet.getBase());
            offerStonecuttingRecipe(exporter,1,pillar,cuttingInputs);
        }
        if (chiseled != null){
            offerChiseledBlockRecipe(exporter, RecipeCategory.MISC, chiseled, blockSet.getPart(SLAB));
            offerStonecuttingRecipe(exporter,1,chiseled,cuttingInputs);
        }
    }
    public static void offerSlabsRecipes(Consumer<RecipeJsonProvider> exporter, Consumer<RecipeJsonProvider> vertExporter, ItemConvertible slab, ItemConvertible vertical, ItemConvertible input){
        offerSlabRecipe( exporter, RecipeCategory.MISC, slab, input);
        offerVerticalSlabRecipes(vertExporter, vertical, slab);
    }
    public static void offerVerticalSlabRecipes(Consumer<RecipeJsonProvider> vertExporter, ItemConvertible output, ItemConvertible input){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output,3).input('#', input).pattern("#").pattern("#").pattern("#").criterion("has_slab",conditionsFromItem(input)).offerTo(vertExporter,"vertical/"+output.asItem().toString());
        createTransmutationRecipe(input, Ingredient.ofItems(output)).criterion(hasItem(input),conditionsFromItem(input)). offerTo(vertExporter,"vertical/vertical_to_"+input.asItem().toString());
    }
}
