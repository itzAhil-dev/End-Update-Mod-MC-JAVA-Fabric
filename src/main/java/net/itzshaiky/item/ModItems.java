package net.itzshaiky.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.itzshaiky.EndUpdate;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item ENDERITE_INGOT = register("enderite_ingot", Item::new, new Item.Settings());

    public static final Item RAW_ENDERITE = register("raw_enderite", Item::new, new Item.Settings());



    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
            // Create the item key.
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(EndUpdate.MOD_ID, name));

            // Create the item instance.
            Item item = itemFactory.apply(settings.registryKey(itemKey));

            // Register the item.
            Registry.register(Registries.ITEM, itemKey, item);

            return item;
        }
    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our suspicious item to the ingredients group.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> {
                    itemGroup.add(ModItems.ENDERITE_INGOT);
                    itemGroup.add(ModItems.RAW_ENDERITE);
                });

    }
}

