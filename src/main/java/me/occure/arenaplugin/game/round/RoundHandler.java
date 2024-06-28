package me.occure.arenaplugin.game.round;

import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.core.mobs.ActiveMob;
import me.occure.arenaplugin.ArenaPlugin;
import me.occure.arenaplugin.GUI.RewardGUI;
import me.occure.arenaplugin.map.WorldBorderManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class RoundHandler implements Listener {

    public static int killCount = 0;

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        ActiveMob activeMob = MythicBukkit.inst().getMobManager().getActiveMob(event.getEntity().getUniqueId()).orElse(null);

        if(!RoundManger.isRunning()){
            return;
        }
        if (activeMob != null) {
            killCount++;

            int clearScore = RoundManger.getClearScore();

            if (killCount >= clearScore) {
                Player player = RoundManger.getRoundStarter();
                RewardGUI.openRewardGUI(player, p ->{
                    killCount = 0;
                    nextRoundCountdown(player);
                });
            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        Player player = event.getEntity();
        Bukkit.getLogger().warning("22" + player);
        if(!RoundManger.isRunning()){
            return;
        }
        if(player.equals(RoundManger.getRoundStarter())){
            killCount = 0;
            RoundManger.endRound();
            WorldBorderManager.resetWorldBorder();
        }
    }
    private void nextRoundCountdown(Player player) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(ArenaPlugin.getInstance(), () -> {
                if(RoundManger.isRunning()) {
                    player.sendTitle("", "3초 후 다음 라운드가 시작됩니다.", 10, 70, 20);
                }
            },140); // 7초후

            Bukkit.getScheduler().scheduleSyncDelayedTask(ArenaPlugin.getInstance(), () -> {
                if(RoundManger.isRunning()) {
                    player.sendTitle("", "2초 후 다음 라운드가 시작됩니다.", 10, 70, 20);
                }
            },160); // 8초후

            Bukkit.getScheduler().scheduleSyncDelayedTask(ArenaPlugin.getInstance(), () -> {
                if(RoundManger.isRunning()) {
                        player.sendTitle("", "1초 후 다음 라운드가 시작됩니다.", 10, 70, 20);
                    }
            },180); // 9초후

            Bukkit.getScheduler().scheduleSyncDelayedTask(ArenaPlugin.getInstance(), () -> {
                if(RoundManger.isRunning()) {
                    player.sendTitle("", "다음 라운드가 시작됩니다.", 10, 70, 20);
                    RoundManger.nextRound();
                }
            },200);
    }
}
