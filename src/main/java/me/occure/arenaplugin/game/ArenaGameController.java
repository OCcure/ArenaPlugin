package me.occure.arenaplugin.game;

import me.occure.arenaplugin.ArenaMonster.ArenaMob;
import me.occure.arenaplugin.ArenaMonster.EasyArenaMob;
import me.occure.arenaplugin.arenaPlayre.ArenaPlayer;
import me.occure.arenaplugin.map.ArenaMap;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

public class ArenaGameController implements GameController{
    private final @NotNull ArenaPlayer arenaPlayer;
    private final @NotNull ArenaMap arenaMap;
    private final @NotNull ArenaMob arenaMob;


    public ArenaGameController(@NotNull ArenaPlayer arenaPlayer, @NotNull ArenaMap arena, @NotNull ArenaMob arenaMob) {
        this.arenaPlayer = arenaPlayer;
        this.arenaMap = arena;
        this.arenaMob = arenaMob;
    }


    @Override
    public @NotNull ArenaPlayer getArenaPlayer() {
        return arenaPlayer;
    }

    @Override
    public void startGame() {
        Location playerLoc = arenaPlayer.getBukkitPlayer().getLocation();
        arenaMap.setup(playerLoc);
        arenaMob.spawnSpade(playerLoc,1);
        arenaMob.spawnHeart(playerLoc,1);
        arenaPlayer.setup();
    }

    @Override
    public void stopGame() {
        arenaMap.clear();
    }
}
