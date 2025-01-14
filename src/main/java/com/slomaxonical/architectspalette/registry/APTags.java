package com.slomaxonical.architectspalette.registry;

import com.slomaxonical.architectspalette.ArchitectsPalette;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class APTags {
    //Blocks
    public static final TagKey<Block> TWISTED_LOGS = TagKey.of(RegistryKeys.BLOCK,new Identifier(ArchitectsPalette.MOD_ID, "twisted_logs"));
    public static final TagKey<Block> CAGE_LANTERNS = TagKey.of(RegistryKeys.BLOCK,new Identifier(ArchitectsPalette.MOD_ID, "cage_lanterns"));
    public static final TagKey<Block> CRYSTAL_REPLACEABLE = TagKey.of(RegistryKeys.BLOCK,new Identifier(ArchitectsPalette.MOD_ID, "crystal_formation_replaceable"));
    public static final TagKey<Block> GREEN_FIRE_SUPPORTING = TagKey.of(RegistryKeys.BLOCK,new Identifier(ArchitectsPalette.MOD_ID, "green_fire_supporting"));
    public static final TagKey<Block> WIZARD_BLOCKS = TagKey.of(RegistryKeys.BLOCK, new Identifier(ArchitectsPalette.MOD_ID,"wizard_blocks"));
    public static final TagKey<Block> NUBS = TagKey.of(RegistryKeys.BLOCK, new Identifier(ArchitectsPalette.MOD_ID,"nubs"));

    //Items
//    public static TagKey<Item> SET_TAB = TagKey.of(RegistryKeys.ITEM,new Identifier(ArchitectsPalette.MOD_ID,"sets"));
//    public static final TagKey<Item> NUB_TAB = TagKey.of(RegistryKeys.ITEM,new Identifier(ArchitectsPalette.MOD_ID,"nubs"));
//    public static final TagKey<Item> WOOD_TAB = TagKey.of(RegistryKeys.ITEM,new Identifier(ArchitectsPalette.MOD_ID,"woods"));
//    public static final TagKey<Item> MISC_TAB = TagKey.of(RegistryKeys.ITEM,new Identifier(ArchitectsPalette.MOD_ID,"misc"));
    public static final TagKey<Item> ITEM_TWISTED_LOGS = TagKey.of(RegistryKeys.ITEM,new Identifier(ArchitectsPalette.MOD_ID, "twisted_logs"));
    public static final TagKey<Item> OLIVESTONE = TagKey.of(RegistryKeys.ITEM,new Identifier(ArchitectsPalette.MOD_ID, "olivestone"));
    public static final TagKey<Item> OLIVESTONE_SLABS = TagKey.of(RegistryKeys.ITEM,new Identifier(ArchitectsPalette.MOD_ID, "olivestone_slabs"));
    public static final TagKey<Item> WITHERED_BONES = TagKey.of(RegistryKeys.ITEM,new Identifier("c", "withered_bones"));
    public static final TagKey<Item> MUSHROOMS = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "mushrooms"));
}