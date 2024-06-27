package me.occure.arenaplugin.command;

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
                if(args.length < 2){
                    sender.sendMessage("난이도를 입력해주세요 :/game start (easy, normal, hard)");
                    return false;
                }
                String difficulty = args[1].toLowerCase();
                ArenaGameController controller = GameManager.getOrCreateGameController(player);
                controller.startGame(difficulty);
            }
            case "stop" -> {
                ArenaGameController controller = GameManager.getOrCreateGameController(player);
                controller.stopGame();
            }
        }
        return false;
    }
}
