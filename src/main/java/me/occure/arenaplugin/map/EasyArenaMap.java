package me.occure.arenaplugin.map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class EasyArenaMap implements ArenaMap{

    private static final int HALF_SIZE = 15;

    private final Map<Location, BlockData> removedBlocks = new HashMap<>();
    private final WorldBorderManager worldBorderManager = new WorldBorderManager();

    @Override
    public void setup(@NotNull Location playerLoc) {
        clear();

        Location arenaLoc = playerLoc;

        for(int x = -HALF_SIZE; x <= HALF_SIZE; x++){
            for(int z = -HALF_SIZE; z <= HALF_SIZE; z++){
                Location loc = arenaLoc.clone().add(x,-1,z);
                Block block =loc.getBlock();
                removedBlocks.put(loc,block.getBlockData());
                block.setType(Material.DEEPSLATE_BRICKS);
            }
        }

        for(int y = 0; y <= HALF_SIZE*2; y++) {
            for (int z = -HALF_SIZE; z <= HALF_SIZE; z++) {
                for(int x = -HALF_SIZE; x <= HALF_SIZE; x++){
                    Location loc = arenaLoc.clone().add(x,y,z);
                    Block block = loc.getBlock();
                    removedBlocks.put(loc,block.getBlockData());
                    block.setType(Material.AIR);
                }
            }
        }
        worldBorderManager.setWorldBorder(playerLoc , HALF_SIZE * 2);
    }

    @Override
    public void clear() {
        for(Map.Entry<Location, BlockData> entry: removedBlocks.entrySet()){
            Location loc = entry.getKey();
            BlockData blockData = entry.getValue();
            Block block = loc.getBlock();
            block.setBlockData(blockData);
        }
        removedBlocks.clear();
        worldBorderManager.resetWorldBorder();
    }
}
