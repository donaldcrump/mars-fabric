package de.su.martian.block;

import de.su.martian.MartianMindsetMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {

    public static final Block MARTIAN_REGOLITH = registerBlock(
            "martian_regolith",
            blockKey -> new Block(BlockBehaviour.Properties.of()
                    .setId(blockKey)
                    .mapColor(MapColor.COLOR_ORANGE)
                    .strength(0.6f)
                    .sound(SoundType.SAND)
            )
    );

    private static Block registerBlock(String name, java.util.function.Function<ResourceKey<Block>, Block> blockFactory) {
        ResourceKey<Block> key = ResourceKey.create(
                Registries.BLOCK,
                Identifier.fromNamespaceAndPath(MartianMindsetMod.MOD_ID, name)
        );
        return Registry.register(BuiltInRegistries.BLOCK, key, blockFactory.apply(key));
    }

    public static void registerModBlocks() {
        MartianMindsetMod.LOGGER.info("Registering blocks for " + MartianMindsetMod.MOD_ID);
    }
}