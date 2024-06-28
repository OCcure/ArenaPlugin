package me.occure.arenaplugin.game.round;

import me.occure.arenaplugin.arenaMonster.ArenaMob;
import me.occure.arenaplugin.data.DataManger;
import me.occure.arenaplugin.data.PlayerData;
import me.occure.arenaplugin.game.difficulty.MobSpawner;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Random;

import static me.occure.arenaplugin.map.EasyArenaMap.getEasySpawnPoint;


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
        Location[] corners = getEasySpawnPoint();

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
        data.addRoundScore(Difficulty, round);
        DataManger.saveData(data);

        roundStarter.sendMessage("게임 종료!" );
        roundStarter.sendMessage( Difficulty +"난이도 최고 라운드: " + data.getHighestRound(Difficulty));
        roundStarter.sendMessage( Difficulty +"난이도 라운드 평균: " + data.getRoundAVG(Difficulty));
        roundStarter.sendMessage( Difficulty +"난이도 게임 종료 라운드: " + round);

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
