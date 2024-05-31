package me.occure.arenaplugin;

import me.occure.arenaplugin.GUI.RewardGUI_Handler;
import me.occure.arenaplugin.command.ArenaCommand;
import me.occure.arenaplugin.game.ArenaGameController;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArenaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().warning("아레나 플러그인 시작");
        Bukkit.getCommandMap().register("arena", new ArenaCommand("game"));
        Bukkit.getPluginManager().registerEvents(new RewardGUI_Handler(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
