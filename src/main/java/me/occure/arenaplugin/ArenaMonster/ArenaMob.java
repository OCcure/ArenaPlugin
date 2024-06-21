package me.occure.arenaplugin.ArenaMonster;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.List;

public interface ArenaMob {

    void spawnSpade (Location location, int level);

    void spawnHeart (Location location, int level);

    void spawnMonsters(int level, Location spawnLoc);

}
