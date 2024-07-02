package me.occure.arenaplugin.skill;

import me.occure.arenaplugin.ArenaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Invincibility {

    public static void activate(Player player, int duration){

        player.setInvulnerable(true);
        player.sendMessage("무적 활성화!");

        Bukkit.getScheduler().scheduleSyncDelayedTask(ArenaPlugin.getInstance(), () -> {
            player.setInvulnerable(false);
            player.sendMessage("무적 비활성화!");
        },duration);
    }
}
