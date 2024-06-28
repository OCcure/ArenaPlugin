package me.occure.arenaplugin.skill.skillItem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InvincibilityItem {

    public static ItemStack createInvincibilityItem() {

        ItemStack item = new ItemStack(Material.NETHER_STAR) ;
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("무적 스킬");
        item.setItemMeta(meta);
        return item;
    }
}
