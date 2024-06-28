package me.occure.arenaplugin.skill;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CooldownManager {

    private static final Map<UUID, Long> cooldowns = new HashMap<>();
    private static final long COOLDOWN_TIME = 5000;

    public static boolean isOnCooldown(Player player){
        UUID playerID = player.getUniqueId();
        Long current = System.currentTimeMillis();

        if(cooldowns.containsKey(playerID)){
            Long lastUsed = cooldowns.get(playerID);
            if ((current - lastUsed) < COOLDOWN_TIME){
                return true;
            }
        }
        return false;
    }

    public static void setCooldowns(Player player){
        cooldowns.put(player.getUniqueId(), System.currentTimeMillis());
    }

    public static Long getCooldownRemaining(Player player){

        UUID playerId = player.getUniqueId();
        long current = System.currentTimeMillis();

        if (cooldowns.containsKey(playerId)) {
            long lastUsed = cooldowns.get(playerId);
            return COOLDOWN_TIME - (current - lastUsed);
        }
        return 0L;
    }
}
