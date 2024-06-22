package me.occure.arenaplugin.map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EasyArenaMap implements ArenaMap{

    private static final int HALF_SIZE = 15;

    private final Map<Location, BlockData> removedBlocks = new HashMap<>();
    private final WorldBorderManager worldBorderManager = new WorldBorderManager();
    private static final Location [] corners = new Location[4];
    private Location arenaCenter;

    @Override
    public void setup(@NotNull Location playerLoc) {
        clear();
        arenaCenter = playerLoc;
        removeEntity(arenaCenter);

        for(int x = -HALF_SIZE; x <= HALF_SIZE; x++){
            for(int z = -HALF_SIZE; z <= HALF_SIZE; z++){
                Location loc = arenaCenter.clone().add(x,-1,z);
                Block block =loc.getBlock();
                removedBlocks.put(loc,block.getBlockData());
                block.setType(Material.DEEPSLATE_BRICKS);
            }
        }

        for(int y = 0; y <= HALF_SIZE*2; y++) {
            for (int z = -HALF_SIZE; z <= HALF_SIZE; z++) {
                for(int x = -HALF_SIZE; x <= HALF_SIZE; x++){
                    Location loc = arenaCenter.clone().add(x,y,z);
                    Block block = loc.getBlock();
                    removedBlocks.put(loc,block.getBlockData());
                    block.setType(Material.AIR);
                }
            }
        }
        corners[0] = arenaCenter.clone().add(-HALF_SIZE + 1, 0, -HALF_SIZE + 1);
        corners[1] = arenaCenter.clone().add(HALF_SIZE - 1, 0, -HALF_SIZE + 1);
        corners[2] = arenaCenter.clone().add(-HALF_SIZE + 1, 0, HALF_SIZE - 1);
        corners[3] = arenaCenter.clone().add(HALF_SIZE - 1, 0, HALF_SIZE - 1);

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
        if(arenaCenter != null){
            removeEntity(arenaCenter);
        }
    }

    public static Location[] getSpawnPoint() {
        Bukkit.getLogger().warning("" + Arrays.toString(corners));
        return corners;
    }

    private void removeEntity(@NotNull Location arenaLoc) {
        World world = arenaLoc.getWorld();
        if(world != null){
            for (Entity entity : world.getEntities()) {
                if(entity instanceof LivingEntity && !(entity instanceof Player)){
                    if(isInArena(entity.getLocation(), arenaLoc)){
                        entity.remove();
                    }
                }else if(entity instanceof Item) {
                    if (isInArena(entity.getLocation(), arenaLoc)){
                        entity.remove();
                    }
                }
            }
        }
    }

    private boolean isInArena (Location loc, Location arenaCenter) {
        return Math.abs(loc.getX() - arenaCenter.getX()) <= HALF_SIZE
                &&Math.abs(loc.getY() - arenaCenter.getY()) <= HALF_SIZE
                &&Math.abs(loc.getZ() - arenaCenter.getZ()) <= HALF_SIZE;
    }
}
