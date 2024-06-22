package me.occure.arenaplugin.arenaReward;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ApplyReward_ENC {

    public static void  apply_ENC(Player player, Enchantment enchantment, String itemType, int level){
        ItemStack itemStack = switch (itemType) {
            case "머리" -> player.getInventory().getHelmet();
            case "갑옷" -> player.getInventory().getChestplate();
            case "바지" -> player.getInventory().getLeggings();
            case "신발" -> player.getInventory().getBoots();
            case "검"  ->  getArenaSword(player);
            default -> null;
        };

        if(itemStack != null){
            ItemMeta itemMeta =itemStack.getItemMeta();
            if(itemMeta != null) {
                int encLevel = itemMeta.getEnchantLevel(enchantment);
                int nextLevel = encLevel + level;
                itemMeta.addEnchant(enchantment, nextLevel,true);
                itemStack.setItemMeta(itemMeta);
            }
        }
    }

    private static ItemStack getArenaSword(Player player) {
        for (ItemStack itemStack : player.getInventory().getContents()) {
            if(itemStack != null && itemStack.getType() == Material.DIAMOND_SWORD){
                ItemMeta meta = itemStack.getItemMeta();
                if(itemStack != null && "아레나 검".equals(meta.getDisplayName())){
                    return itemStack;
                }
            }
        }
        return null;
    }
}
