package umpaz.nethersdelight.common;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.advancements.critereon.EntityEquipmentPredicate;
import net.minecraft.advancements.critereon.EntityFlagsPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import umpaz.nethersdelight.common.registry.NDCreativeTab;
import umpaz.nethersdelight.common.registry.NDItems;
import umpaz.nethersdelight.common.tag.NDTags;


public class NDCommonSetup {

    public static void init() {
        NDCreativeTab.buildContents();
        registerCompostables();
        registerLootTables();
    }

    private static void registerCompostables() {
        ComposterBlock.COMPOSTABLES.put(NDItems.WARPED_FUNGUS_COLONY.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(NDItems.CRIMSON_FUNGUS_COLONY.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(NDItems.PROPELPLANT_CANE.get(), 0.4F);
    }

    private static final ResourceLocation PIGLIN_BARTERING = new ResourceLocation("gameplay/piglin_bartering");

    private static void registerLootTables() {
        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if (EntityType.HOGLIN.getDefaultLootTable().equals(id)) {
                return LootTable.lootTable()
                    .pool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(NDItems.HOGLIN_LOIN.get())
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                            .apply(SmeltItemFunction.smelted()
                                .when(LootItemEntityPropertyCondition
                                    .hasProperties(LootContext.EntityTarget.THIS,
                                        EntityPredicate.Builder.entity()
                                            .flags(EntityFlagsPredicate.Builder.flags()
                                                .setOnFire(true)
                                                .build()))))
                            .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))
                        .build())
                    .pool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(Items.LEATHER)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                            .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))
                        .when(LootItemEntityPropertyCondition
                            .hasProperties(LootContext.EntityTarget.KILLER,
                                EntityPredicate.Builder.entity()
                                    .equipment(EntityEquipmentPredicate.Builder.equipment()
                                        .mainhand(ItemPredicate.Builder.item()
                                            .of(NDTags.HUNTING_TOOLS)
                                            .build())
                                        .build()))
                            .invert())
                        .build())
                    .build();
            }
            return null;
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (EntityType.STRIDER.getDefaultLootTable().equals(id)) {
                tableBuilder.pool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(NDItems.STRIDER_SLICE.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                        .apply(SmeltItemFunction.smelted()
                            .when(LootItemEntityPropertyCondition
                                .hasProperties(LootContext.EntityTarget.THIS,
                                    EntityPredicate.Builder.entity()
                                        .flags(EntityFlagsPredicate.Builder.flags()
                                            .setOnFire(true)
                                            .build()))))
                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))
                    .when(LootItemEntityPropertyCondition
                        .hasProperties(LootContext.EntityTarget.KILLER,
                            EntityPredicate.Builder.entity()
                                .equipment(EntityEquipmentPredicate.Builder.equipment()
                                    .mainhand(ItemPredicate.Builder.item()
                                        .of(NDTags.HUNTING_TOOLS)
                                        .build())
                                    .build())))
                    .build());
            } else if (PIGLIN_BARTERING.equals(id)) {
                tableBuilder.modifyPools(pool -> pool
                    .add(LootItem.lootTableItem(NDItems.PROPELPEARL.get())
                    .setWeight(20)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                ));
            }
        });
    }

}