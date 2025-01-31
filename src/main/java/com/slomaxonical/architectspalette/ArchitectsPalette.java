package com.slomaxonical.architectspalette;

import com.slomaxonical.architectspalette.config.APConfigs;
import com.slomaxonical.architectspalette.crafting.WarpingRecipe;
import com.slomaxonical.architectspalette.features.APConfiguredFeatures;
import com.slomaxonical.architectspalette.features.APFeatures;
import com.slomaxonical.architectspalette.features.APPlacedFeatures;
import com.slomaxonical.architectspalette.loot.LootTableModifications;
import com.slomaxonical.architectspalette.registry.*;
import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ArchitectsPalette implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("Architect's Palette");
    public static final String MOD_ID = "architects_palette";
    public static final APConfigs CONFIGS = APConfigs.createAndLoad();
    public static final OwoItemGroup AP_GROUP = OwoItemGroup.builder(new Identifier(MOD_ID,"everything"), () -> Icon.of(APBlocks.CHISELED_ABYSSALINE_BRICKS))
            .customTexture(new Identifier(MOD_ID,"textures/gui/item_group.png"))
            .build();
    public static List<Item> ITEMGROUP_LIST = new ArrayList<>();

    @Override
    public void onInitialize() {
        APParticles.register();

        FieldRegistrationHandler.register(APBlocks.class,MOD_ID,false);
        ConfigResourceCondition.init();
        FieldRegistrationHandler.register(APItems.class,MOD_ID,false);

        AP_GROUP.initialize();
        APMisc.registerFuel();
        APMisc.registerStrippables();
        APMisc.registerOxidizables();
        APMisc.registerWaxables();

        APSounds.registerSounds();
        WarpingRecipe.registerRecipe();
        APTrades.registerVillagerTrades();
        APTrades.registerWanderingTrades();

        APFeatures.register();
        APConfiguredFeatures.register();
        APPlacedFeatures.register();
        LootTableModifications.registerWitheredBones();
    }
}
