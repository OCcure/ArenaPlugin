package me.occure.arenaplugin.ArenaMonster;


import io.lumine.mythic.api.mobs.MythicMob;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.core.mobs.ActiveMob;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class EasyArenaMob implements ArenaMob{

    private final MythicMob spade = MythicBukkit.inst().getMobManager().getMythicMob("SpadeSoldier").orElse(null);
    private final MythicMob heart = MythicBukkit.inst().getMobManager().getMythicMob("HeartSoldier").orElse(null);

    public void spawnSpade (Location location, int level) {

        if(location != null && spade !=null){

            ActiveMob spadeSoldier = spade.spawn(BukkitAdapter.adapt(location),level);
            Entity entity = spadeSoldier.getEntity().getBukkitEntity();

        }
    }

    public void spawnHeart (Location location, int level){

        if(location != null){

            ActiveMob heartSoldier = heart.spawn(BukkitAdapter.adapt(location),level);
            Entity entity = heartSoldier.getEntity().getBukkitEntity();

        }
    }
}

