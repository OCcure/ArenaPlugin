package me.occure.arenaplugin.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerData {
    private String playerName;
    private final Map<String, List<Integer>> arenaHistory = new HashMap<>();

    public PlayerData(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getHighestRound(String difficulty) {
        return arenaHistory.getOrDefault(difficulty, new ArrayList<>())
                            .stream().max(Integer::compareTo).orElse(0);
    }

    public double getRoundAVG(String difficulty) {
        return arenaHistory.getOrDefault(difficulty, new ArrayList<>())
                            .stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public void addRoundScore(String difficulty, int round) {
        arenaHistory.computeIfAbsent(difficulty, k -> new ArrayList<>()).add(round);
    }

    public Map<String, List<Integer>> getArenaHistory() {
        return arenaHistory;
    }
}
