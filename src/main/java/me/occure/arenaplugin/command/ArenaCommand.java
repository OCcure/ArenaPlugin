package me.occure.arenaplugin.command;

import me.occure.arenaplugin.game.ArenaGameController;
import me.occure.arenaplugin.game.GameController;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ArenaCommand extends BukkitCommand {


   public ArenaCommand(@NotNull String name, GameController controller) {
        super(name);

   }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }
        if (args.length == 0) {
            return false;
        }
        switch (args[0].toLowerCase()) {
            case "start" -> {
                ArenaGameController.startGame();
            }
        }
        return false;
    }
}
