package me.occure.arenaplugin;

import me.occure.arenaplugin.GUI.RewardGUI_Handler;
import me.occure.arenaplugin.command.ArenaCommand;
import me.occure.arenaplugin.game.round.RoundHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArenaPlugin extends JavaPlugin {

    private static ArenaPlugin instance;


    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getLogger().warning("아레나 플러그인 시작");
        Bukkit.getCommandMap().register("arena", new ArenaCommand("game"));
        Bukkit.getPluginManager().registerEvents(new RewardGUI_Handler(), this);
        Bukkit.getPluginManager().registerEvents(new RoundHandler(),this);
    }
    @Override
    public void onDisable() {

    }
    public static ArenaPlugin getInstance() {
        return instance;
    }

}
