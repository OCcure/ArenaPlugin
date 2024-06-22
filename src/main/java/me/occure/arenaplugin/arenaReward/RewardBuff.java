package me.occure.arenaplugin.arenaReward;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class RewardBuff {

    private static final Map<PotionEffectType, String> REWARD_BUFF = new HashMap<>(){{
        put(PotionEffectType.SPEED, "속도 +1");
        put(PotionEffectType.REGENERATION, "재생력 +1");
        put(PotionEffectType.DAMAGE_RESISTANCE, "저항 +1");
        put(PotionEffectType.HEALTH_BOOST, "최대 체력 증가");
    }};

    public static ItemStack createPotion(PotionEffectType effectType) {
        ItemStack potion = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) potion.getItemMeta();

        if (meta != null) {
            meta.addCustomEffect(new PotionEffect(effectType, Integer.MAX_VALUE, 0), true);
            meta.setDisplayName(REWARD_BUFF.get(effectType));
            potion.setItemMeta(meta);
        }
        return potion;
    }

    public static ItemStack getRandomBuff() {
        Random random = new Random();
        Object [] keys = REWARD_BUFF.keySet().toArray();
        PotionEffectType randomBuff = (PotionEffectType) keys[random.nextInt(keys.length)];
        return createPotion(randomBuff);
    }
}