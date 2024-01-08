package net.dragm.goofymod.item;

import net.dragm.goofymod.GoofyMod;
import net.dragm.goofymod.block.ModBlocks;
import net.dragm.goofymod.entity.ModEntities;
import net.dragm.goofymod.item.custom.FuelItems;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GoofyMod.MOD_ID);


    public static final RegistryObject<Item> PLATINUM = ITEMS.register("platinum",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MUD = ITEMS.register("mud",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_CLUMP = ITEMS.register("platinum_clump",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFood.STRAWBERRY)));
    public static final RegistryObject<Item> CURSED_EYE = ITEMS.register("cursed_eye",
            () -> new Item(new Item.Properties().food(ModFood.CURSED_EYE)));
    public static final RegistryObject<Item> PLATINUM_TANK = ITEMS.register("platinum_tank",
            () -> new Item(new Item.Properties()));
     public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            () -> new FuelItems(new Item.Properties(), 35));

    public static final RegistryObject<Item> STRAWBERRY_SEED = ITEMS.register("strawberry_seed",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_CROP.get(),new Item.Properties()));
    public static final RegistryObject<Item> CURSED_EYE_SEED = ITEMS.register("cursed_eye_seed",
            () -> new ItemNameBlockItem(ModBlocks.CURSED_EYE_CROP.get(),new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_SWORD = ITEMS.register("platinum_sword",
            () -> new SwordItem(ModToolTiers.PLATINUM, 6, 2, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PLATINUM, 5, 7, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PLATINUM_AXE = ITEMS.register("platinum_axe",
            () -> new AxeItem(ModToolTiers.PLATINUM, 8, 2, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel",
            () -> new ShovelItem(ModToolTiers.PLATINUM, 4, 4, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PLATINUM_HOE = ITEMS.register("platinum_hoe",
            () -> new HoeItem(ModToolTiers.PLATINUM, 4, 4, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> PLATINUM_HELMET = ITEMS.register("platinum_helmet",
            () -> new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PLATINUM_CHESTPLATE = ITEMS.register("platinum_chestplate",
            () -> new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PLATINUM_LEGGINGS = ITEMS.register("platinum_leggings",
            () -> new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PLATINUM_BOOTS = ITEMS.register("platinum_boots",
            () -> new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> MAMMOTH_SPAWN_EGG = ITEMS.register("mammoth_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MAMMOTH, 0x7e9680, 0xc5d1c5, new Item.Properties()));
    public  static  void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
