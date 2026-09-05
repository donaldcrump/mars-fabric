package de.su.martian.item;

import de.su.martian.MartianMindsetMod;
import de.su.martian.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final Item MARTIAN_REGOLITH_ITEM = registerItem(
            "martian_regolith",
            itemKey -> new BlockItem(ModBlocks.MARTIAN_REGOLITH, new Item.Properties().setId(itemKey))
    );

    private static Item registerItem(String name, java.util.function.Function<ResourceKey<Item>, Item> itemFactory) {
        ResourceKey<Item> key = ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(MartianMindsetMod.MOD_ID, name)
        );
        return Registry.register(BuiltInRegistries.ITEM, key, itemFactory.apply(key));
    }

    public static void registerModItems() {
        MartianMindsetMod.LOGGER.info("Registering items for " + MartianMindsetMod.MOD_ID);
    }
}