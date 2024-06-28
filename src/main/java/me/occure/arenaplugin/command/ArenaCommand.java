package me.occure.arenaplugin.command;

import me.occure.arenaplugin.game.ArenaGameController;
import me.occure.arenaplugin.game.GameManager;
import org.bukkit.Bukkit;
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
                if (args.length < 2) {
                    player.sendMessage("올바른 명령어를 입력해주세요 : /game <start> <easy, normal, hard>");
                    return false;
                }
                switch (args[1].toLowerCase()){
                    case "easy" -> {
                        ArenaGameController controller = GameManager.getOrCreateGameController(player, "easy");
                        controller.startGame("easy");
                    }
                    case "normal" -> {
                        ArenaGameController controller = GameManager.getOrCreateGameController(player, "normal");
                        controller.startGame("normal");
                    }
                    case "hard" -> {
                        ArenaGameController controller = GameManager.getOrCreateGameController(player, "Hard");
                        controller.startGame("Hard");
                    }default -> player.sendMessage("올바른 명령어를 입력해주세요 : /game <start> <easy, normal, hard>");
                }
            }
            case "stop" -> {
                if(!GameManager.hasGameController(player)){
                    player.sendMessage("게임이 실행 되어있지 않습니다");
                    return false;
                }
                ArenaGameController controller = GameManager.getOrCreateGameController(player, "easy");
                controller.stopGame();
            }default -> player.sendMessage("올바른 명령어를 입력해주세요 : /game <start> <easy, normal, hard>, /game stop");
        }
        return false;
    }
}
