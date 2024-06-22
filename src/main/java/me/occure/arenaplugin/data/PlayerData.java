package me.occure.arenaplugin.data;


import java.util.ArrayList;
import java.util.List;

public class PlayerData {
    private String playerName;
    private final List<Integer> roundHistory = new ArrayList<>();

    public PlayerData(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getHighestRound() {
        return roundHistory.stream().max(Integer::compareTo).orElse(0);
    }

    public double getRoundAVG() {
        return roundHistory.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public void addRoundScore(int round) {
        roundHistory.add(round);
    }

    public List<Integer> getRoundHistory() {
        return roundHistory;
    }
}
