package me.occure.arenaplugin.map;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

public interface ArenaMap {

    void setup(@NotNull Location playerLoc);

    void clear();
}
