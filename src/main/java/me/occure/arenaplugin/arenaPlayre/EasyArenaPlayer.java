package me.occure.arenaplugin.arenaPlayre;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EasyArenaPlayer implements ArenaPlayer{
    private final Player player;

    public EasyArenaPlayer(Player player) {
        this.player = player;
    }

    @Override
    public @NotNull Player getBukkitPlayer() {
        return player;
    }

    @Override
    public void setup() {

    }

    @Override
    public void clear() {

    }
}
