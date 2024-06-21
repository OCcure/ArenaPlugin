package me.occure.arenaplugin.game.round;


import me.occure.arenaplugin.ArenaMonster.ArenaMob;
import me.occure.arenaplugin.ArenaMonster.EasyArenaMob;

import org.bukkit.Location;
import org.bukkit.entity.Player;


import java.util.Random;

import static me.occure.arenaplugin.map.EasyArenaMap.getSpawnPoint;


public class RoundManger{

    private boolean isRunning = false;
    public static int round = 0;
    public static int clearScore = 0;
    private static final Random random = new Random();
    private static Player roundStarter;

    public void startRound(Player player){
        if(isRunning) {
            player.sendMessage("게임이 진행중입니다.");
            return;
        }
        isRunning =true;
        roundStarter = player;
        nextRound();

    }

    public static void nextRound(){

        round++;
        clearScore = round * 2;

        ArenaMob arenaMob = new EasyArenaMob();
        Location[] corners = getSpawnPoint();

        roundStarter.sendMessage(round+"라운드 시작!" );

        for(int i = 1; i <= round*2; i++){
            Location spawnLoc = corners[random.nextInt(corners.length)];
            arenaMob.spawnMonsters(round ,spawnLoc);

        }
    }
    public static int getClearScore() {
        return clearScore;
    }
    public static Player getRoundStarter(){
        return roundStarter;
    }
}
