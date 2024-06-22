package me.occure.arenaplugin.arenaReward;


import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Reward_ENC {

    private static final List<Enchantment> ARMOR_ENCHANTMENTS = Arrays.asList(
            Enchantment.PROTECTION_ENVIRONMENTAL,
            Enchantment.PROTECTION_FIRE,
            Enchantment.PROTECTION_EXPLOSIONS,
            Enchantment.PROTECTION_PROJECTILE,
            Enchantment.THORNS
    );
    private static final List<Enchantment> WEAPON_ENCHANTMENTS = Arrays.asList(
            Enchantment.DAMAGE_ALL,
            Enchantment.FIRE_ASPECT,
            Enchantment.KNOCKBACK,
            Enchantment.LOOT_BONUS_MOBS,
            Enchantment.SWEEPING_EDGE
    );
    private static final List<String> ARMOR_TYPES = List.of("머리", "갑옷", "바지", "신발");
    private static final List<String> WEAPON_TYPES = List.of("검");

    public static ItemStack createEnchantedBook(String itemType, Enchantment enchantment, int level) {
        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();

        if (meta != null){
            meta.addStoredEnchant(enchantment, level, true);
            meta.setDisplayName(itemType);
            enchantedBook.setItemMeta(meta);
        }

        return enchantedBook;
    }

    public static ItemStack getRandom_ENC() {
        Random random = new Random();

        List<String> allTypes = Arrays.asList(
                "머리", "갑옷", "바지", "신발", "검"
        );

        String randomType = allTypes.get(random.nextInt(allTypes.size()));
        Enchantment randomENC;

        if(ARMOR_TYPES.contains(randomType)){
            randomENC = ARMOR_ENCHANTMENTS.get(random.nextInt(ARMOR_ENCHANTMENTS.size()));
        }else {
            randomENC = WEAPON_ENCHANTMENTS.get(random.nextInt(WEAPON_TYPES.size()));
        }

        return createEnchantedBook(randomType,randomENC,1);
    }
}
