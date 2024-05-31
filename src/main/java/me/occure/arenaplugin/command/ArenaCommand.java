package me.occure.arenaplugin.command;

import me.occure.arenaplugin.GUI.RewardGUI;
import me.occure.arenaplugin.game.ArenaGameController;
import me.occure.arenaplugin.game.GameManager;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ArenaCommand extends BukkitCommand {

    public ArenaCommand(@NotNull String name) {
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
                ArenaGameController controller = GameManager.getOrCreateGameController(player);
                controller.startGame();
            }
            case "stop" -> {
                ArenaGameController controller = GameManager.getOrCreateGameController(player);
                controller.stopGame();
            }
            case "open" ->{
                player.openInventory(RewardGUI.openRewardGUI(player));
            }
        }
        return false;
    }
}
