package me.occure.arenaplugin.game;

import me.occure.arenaplugin.arenaPlayre.ArenaPlayer;
import me.occure.arenaplugin.map.ArenaMap;
import org.jetbrains.annotations.NotNull;

public class ArenaGameController implements GameController{
    private final @NotNull ArenaPlayer arenaPlayer;
    private final @NotNull ArenaMap arenaMap;

    public ArenaGameController(@NotNull ArenaPlayer arenaPlayer, @NotNull ArenaMap arena, @NotNull ArenaMap arena1) {
        this.arenaPlayer = arenaPlayer;
        this.arenaMap = arena;
    }


    @Override
    public @NotNull ArenaPlayer getArenaPlayer() {
        return arenaPlayer;
    }

    @Override
    public void startGame() {
        arenaMap.setup(arenaPlayer.getBukkitPlayer().getLocation());

    }

    @Override
    public void stopGame() {

    }
}
