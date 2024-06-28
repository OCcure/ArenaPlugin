package me.occure.arenaplugin.map;

import org.bukkit.Location;
import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public interface ArenaMap {

    static final Map<Location, BlockData> removedBlocks = new HashMap<>();

    void setup(@NotNull Location playerLoc);

    void clear();

    static Map<Location, BlockData> getRemovedBlocks() {
        return removedBlocks;
    }


}
