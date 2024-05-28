package me.occure.arenaplugin.map;

import org.bukkit.Location;
import org.bukkit.World;

public class WorldBorderManager {

    private Location borderCenter = null;

    public void setWorldBorder(Location center, int size){
        World world = center.getWorld();
        if (world != null) {
            world.getWorldBorder().setCenter(center);
            world.getWorldBorder().setSize(size);
            borderCenter = center;
        }
    }
    public void resetWorldBorder(){
        if(borderCenter != null) {
            World world = borderCenter.getWorld();
            if (world != null) {
                world.getWorldBorder().reset();
            }
        }
        borderCenter = null;
    }
}
