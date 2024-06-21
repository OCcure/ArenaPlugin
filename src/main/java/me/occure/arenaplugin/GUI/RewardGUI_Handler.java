package me.occure.arenaplugin.GUI;

import me.occure.arenaplugin.ArenaReward.ApplyRewardBuff;
import me.occure.arenaplugin.ArenaReward.ApplyReward_ENC;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;


public class RewardGUI_Handler implements Listener {

    @EventHandler
    public static void onInvClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("보상 선택")) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            ItemStack click = event.getCurrentItem();
            if (click != null && click.hasItemMeta()) {
                String displayName = click.getItemMeta().getDisplayName();

                if (click.getType() == Material.ENCHANTED_BOOK) {
                        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) click.getItemMeta();
                        for (Enchantment enchantment : meta.getStoredEnchants().keySet()) {
                            int level = meta.getStoredEnchantLevel(enchantment);

                            ApplyReward_ENC.apply_ENC(player, enchantment,displayName,level);
                        }
                    }else {
                        ApplyRewardBuff.applyBuff(player,displayName);
                    }
                player.closeInventory();
                RewardGUI.rewardSelection(player);
            }
        }
    }
}
