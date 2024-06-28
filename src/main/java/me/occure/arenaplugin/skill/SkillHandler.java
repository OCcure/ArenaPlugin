package me.occure.arenaplugin.skill;

import me.occure.arenaplugin.skill.skillItem.InvincibilityItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SkillHandler implements Listener {

    @EventHandler
    public void onPlayerUseItem(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if(item != null && item.isSimilar(InvincibilityItem.createInvincibilityItem())){
            event.setCancelled(true);

            if (CooldownManager.isOnCooldown(player)){
                long cooldownRemaining = CooldownManager.getCooldownRemaining(player);
                player.sendMessage("스킬 쿨타임이 " + (cooldownRemaining / 1000) + "초 남았습니다.");
                return;
            }

            Invincibility.activate(player, 100);
            CooldownManager.setCooldowns(player);
            player.getInventory().removeItem(item);

        }
    }

}
