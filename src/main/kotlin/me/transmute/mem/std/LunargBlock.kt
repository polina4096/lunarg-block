package me.transmute.mem.std

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import org.slf4j.LoggerFactory

object LunargBlock : ModInitializer {
    private val logger = LoggerFactory.getLogger("lunarg-block")

    private val LUNARG_BLOCK_ID = Identifier.fromNamespaceAndPath("lunarg-block", "lunarg_block")

    val LUNARG_BLOCK: Block = Registry.register(
        BuiltInRegistries.BLOCK,
        LUNARG_BLOCK_ID,
        Block(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, LUNARG_BLOCK_ID))
            .sound(SoundType.CALCITE)
            .strength(0.3f, 0.3f))
    )

    val LUNARG_BLOCK_ITEM: Item = Registry.register(
        BuiltInRegistries.ITEM,
        LUNARG_BLOCK_ID,
        BlockItem(LUNARG_BLOCK, Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, LUNARG_BLOCK_ID)))
    )

    private val VULKAN_TRIANGLE_ID = Identifier.fromNamespaceAndPath("lunarg-block", "vulkan_triangle")

    val VULKAN_TRIANGLE_ITEM: Item = Registry.register(
        BuiltInRegistries.ITEM,
        VULKAN_TRIANGLE_ID,
        Item(Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, VULKAN_TRIANGLE_ID)))
    )

    override fun onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register { entries ->
            entries.accept(LUNARG_BLOCK_ITEM)
        }

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register { entries ->
            entries.accept(VULKAN_TRIANGLE_ITEM)
        }
    }
}