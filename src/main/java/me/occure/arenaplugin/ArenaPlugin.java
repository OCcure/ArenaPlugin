package me.occure.arenaplugin;

import me.occure.arenaplugin.GUI.RewardGUI_Handler;
import me.occure.arenaplugin.command.ArenaCommand;
import me.occure.arenaplugin.data.DataManger;
import me.occure.arenaplugin.game.round.RoundHandler;
import me.occure.arenaplugin.skill.SkillHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class ArenaPlugin extends JavaPlugin {

    private static ArenaPlugin instance;


    @Override
    public void onEnable() {
        instance = this;
        try {
            DataManger.loadData();
        } catch (IOException e) {
            getLogger().severe("데이터를 로드하는 중 오류가 발생했습니다: " + e.getMessage());
        }
        Bukkit.getLogger().warning("아레나 플러그인 시작");
        Bukkit.getCommandMap().register("arena", new ArenaCommand("game"));
        Bukkit.getPluginManager().registerEvents(new RewardGUI_Handler(), this);
        Bukkit.getPluginManager().registerEvents(new RoundHandler(),this);
        Bukkit.getPluginManager().registerEvents(new SkillHandler(), this);
    }
    @Override
    public void onDisable() {

    }
    public static ArenaPlugin getInstance() {
        return instance;
    }

}
