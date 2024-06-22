package me.occure.arenaplugin.arenaMonster;

import org.bukkit.Location;

public interface ArenaMob {

    void spawnSpade (Location location, int level);

    void spawnHeart (Location location, int level);

    void spawnMonsters(int level, Location spawnLoc);

}
