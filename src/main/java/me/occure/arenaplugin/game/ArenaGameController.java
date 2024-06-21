package me.occure.arenaplugin.game;

import me.occure.arenaplugin.arenaPlayre.ArenaPlayer;
import me.occure.arenaplugin.game.round.RoundManger;
import me.occure.arenaplugin.map.ArenaMap;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ArenaGameController implements GameController {
    private final @NotNull ArenaPlayer arenaPlayer;
    private final @NotNull ArenaMap arenaMap;
    private final @NotNull RoundManger roundManger;
   ;

    public ArenaGameController(@NotNull ArenaPlayer arenaPlayer, @NotNull ArenaMap arena, @NotNull RoundManger roundManger) {
        this.arenaPlayer = arenaPlayer;
        this.arenaMap = arena;
        this.roundManger = roundManger;
    }

    @Override
    public @NotNull ArenaPlayer getArenaPlayer() {
        return arenaPlayer;
    }

    @Override
    public void startGame() {
        Location playerLoc = arenaPlayer.getBukkitPlayer().getLocation();
        Player player =arenaPlayer.getBukkitPlayer();
        arenaMap.setup(playerLoc);

        arenaPlayer.setup();

        roundManger.startRound(player);

    }

    @Override
    public void stopGame() {
        arenaMap.clear();
    }
}
