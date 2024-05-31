package me.occure.arenaplugin.ArenaReward;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ApplyRewardBuff {

    public static void applyBuff(Player player, String displayName) {

        PotionEffectType effectType = switch (displayName)
        {
            case "속도 +1" -> effectType = PotionEffectType.SPEED;
            case "재생력 +1" -> effectType = PotionEffectType.REGENERATION;
            case "저항 +1" -> effectType = PotionEffectType.DAMAGE_RESISTANCE;
            case "최대 체력 증가" -> effectType = PotionEffectType.HEALTH_BOOST;
            default -> null;
        };
        int current = 0 ;

        if (player.hasPotionEffect(effectType)) {
            for(PotionEffect effect : player.getActivePotionEffects()) {
                if(effect.getType().equals(effectType));
                current = effect.getAmplifier();
                break;
            }
        }
        player.addPotionEffect(new PotionEffect(effectType, Integer.MAX_VALUE, current));

    }
}
