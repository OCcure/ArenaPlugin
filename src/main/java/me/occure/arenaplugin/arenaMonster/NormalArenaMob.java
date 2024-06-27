package me.occure.arenaplugin.arenaMonster;

import io.lumine.mythic.api.mobs.MythicMob;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.core.mobs.ActiveMob;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.Random;

public class NormalArenaMob implements ArenaMob{
    private final MythicMob spade = MythicBukkit.inst().getMobManager().getMythicMob("NormalSpadeSoldier").orElse(null);
    private final MythicMob heart = MythicBukkit.inst().getMobManager().getMythicMob("NormalHeartSoldier").orElse(null);
    private final Random random = new Random();


    public void spawnSpade(Location location, int level) {

        if (location != null && spade != null) {
            ActiveMob spadeSoldier = spade.spawn(BukkitAdapter.adapt(location), level);
        }
    }

    public void spawnHeart(Location location, int level) {

        if (location != null) {
            ActiveMob heartSoldier = heart.spawn(BukkitAdapter.adapt(location), level);
        }
    }

    public void spawnMonsters(int level, Location spawnLoc) {
        if(random.nextBoolean()){
            spawnHeart(spawnLoc, level);
            Bukkit.getLogger().warning(" " + spawnLoc + " "+level);
        } else {
            spawnSpade(spawnLoc, level);
            Bukkit.getLogger().warning(" " + spawnLoc + " "+level);
        }
    }
}
