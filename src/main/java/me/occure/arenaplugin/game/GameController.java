package me.occure.arenaplugin.game;

import me.occure.arenaplugin.arenaPlayre.ArenaPlayer;
import org.jetbrains.annotations.NotNull;

public interface GameController {

    @NotNull ArenaPlayer getArenaPlayer();

    void startGame();

    void stopGame();
}
