package me.occure.arenaplugin.game.round;


import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.core.mobs.ActiveMob;
import me.occure.arenaplugin.GUI.RewardGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class RoundHandler implements Listener {

    private int killCount = 0;


    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        ActiveMob activeMob = MythicBukkit.inst().getMobManager().getActiveMob(event.getEntity().getUniqueId()).orElse(null);
        if (activeMob != null) {
            killCount++;
            int clearScore = RoundManger.getClearScore();

            if (killCount >= clearScore) {
                Player player = RoundManger.getRoundStarter();
                RewardGUI.openRewardGUI(player, p ->{
                    killCount = 0;
                    RoundManger.nextRound();
                });

            }
        }
    }
}
