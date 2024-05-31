package me.occure.arenaplugin.GUI;

import me.occure.arenaplugin.ArenaReward.RewardBuff;
import me.occure.arenaplugin.ArenaReward.Reward_ENC;
import org.bukkit.Bukkit;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class RewardGUI {

    public static @NotNull Inventory openRewardGUI(Player player) {
        Inventory inv = Bukkit.createInventory(null, 45, "보상 선택");

        inv.setItem(11, Reward_ENC.getRandom_ENC());
        inv.setItem(13, Reward_ENC.getRandom_ENC());
        inv.setItem(15, Reward_ENC.getRandom_ENC());

        inv.setItem(29, RewardBuff.getRandomBuff());
        inv.setItem(31, RewardBuff.getRandomBuff());
        inv.setItem(33, RewardBuff.getRandomBuff());

        player.openInventory(inv);
        return inv;
    }

}
