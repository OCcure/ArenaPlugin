package me.occure.arenaplugin.game.difficulty;

import org.bukkit.Location;

import static me.occure.arenaplugin.map.EasyArenaMap.getEasySpawnPoint;
import static me.occure.arenaplugin.map.HardArenaMap.getHardSpawnPoint;
import static me.occure.arenaplugin.map.NormalArenaMap.getNormalSpawnPoint;

public class SpawnLocation {
    public static Location[] spawnLoc(String difficulty){
        return switch (difficulty.toLowerCase()) {
            case "easy" -> getEasySpawnPoint();
            case "normal" -> getNormalSpawnPoint();
            case "hard" -> getHardSpawnPoint();
            default -> throw new IllegalStateException("Unexpected value: " + difficulty.toLowerCase());
        };
    }
}
