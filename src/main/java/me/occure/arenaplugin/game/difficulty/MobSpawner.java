package me.occure.arenaplugin.game.difficulty;

import me.occure.arenaplugin.arenaMonster.ArenaMob;
import me.occure.arenaplugin.arenaMonster.EasyArenaMob;
import me.occure.arenaplugin.arenaMonster.HardArenaMob;
import me.occure.arenaplugin.arenaMonster.NormalArenaMob;

public class MobSpawner {
    public static ArenaMob spawnArenaMob(String difficulty) {
        return switch (difficulty.toLowerCase()) {
            case "easy" -> new EasyArenaMob();
            case "normal" -> new NormalArenaMob();
            case "hard" -> new HardArenaMob();
            default -> throw new IllegalStateException("Unexpected value: " + difficulty.toLowerCase());
        };
    }
}
