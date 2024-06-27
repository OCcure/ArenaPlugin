package me.occure.arenaplugin.game.round;


import me.occure.arenaplugin.arenaMonster.ArenaMob;
import me.occure.arenaplugin.data.DataManger;
import me.occure.arenaplugin.data.PlayerData;
import me.occure.arenaplugin.game.difficulty.MobSpawner;
import me.occure.arenaplugin.game.difficulty.SpawnLocation;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Random;


public class RoundManger{

    private static boolean isRunning = false;
    private static String Difficulty;
    private static int round = 0;
    private static int clearScore = 0;
    private static final Random random = new Random();
    private static Player roundStarter;

    public void startRound(Player player, String difficulty){
        if(isRunning) {
            player.sendMessage("게임이 진행중입니다.");
            return;
        }

        isRunning =true;
        roundStarter = player;
        Difficulty = difficulty;

        nextRound();

    }

    public static void nextRound(){

        round++;
        clearScore = round * 2;

        ArenaMob arenaMob = MobSpawner.spawnArenaMob(Difficulty);
        Location[] corners = SpawnLocation.spawnLoc(Difficulty);

        roundStarter.sendMessage(round+"라운드 시작!" );

        for(int i = 1; i <= round*2; i++){
            Location spawnLoc = corners[random.nextInt(corners.length)];
            arenaMob.spawnMonsters(round ,spawnLoc);
        }
    }

    public static void endRound(){
        isRunning = false;
        RoundHandler.killCount = 0;

        PlayerData data = DataManger.getPlayerData(roundStarter.getName());
        data.addRoundScore(round);
        DataManger.saveData(data);

        roundStarter.sendMessage("게임 종료!" );
        roundStarter.sendMessage("최고 라운드: " + data.getHighestRound());
        roundStarter.sendMessage("라운드 평균: " + data.getRoundAVG());
        roundStarter.sendMessage("이번 게임 종료 라운드: " + round);

        round = 0;
    }

    public static int getClearScore() {
        return clearScore;
    }
    public static Player getRoundStarter(){
        return roundStarter;
    }
    public static boolean isRunning() {
        return isRunning;
    }
}
