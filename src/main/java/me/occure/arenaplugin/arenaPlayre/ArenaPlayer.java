package me.occure.arenaplugin.arenaPlayre;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface ArenaPlayer {

    @NotNull Player getBukkitPlayer();

    void setup();

    void clear();

}
