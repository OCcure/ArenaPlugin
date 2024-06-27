package me.occure.arenaplugin.game;

import com.google.common.collect.Maps;
import me.occure.arenaplugin.arenaPlayre.ArenaPlayer;
import me.occure.arenaplugin.arenaPlayre.EasyArenaPlayer;
import me.occure.arenaplugin.game.round.RoundManger;
import me.occure.arenaplugin.map.ArenaMap;
import me.occure.arenaplugin.map.EasyArenaMap;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameManager {

    private static final Map<UUID,ArenaGameController> controllers = Maps.newHashMap();

    public static @NotNull ArenaGameController getOrCreateGameController(@NotNull Player player) {
        return controllers.computeIfAbsent(player.getUniqueId(), k -> createGameController(player));
    }

    public static @NotNull ArenaGameController createGameController(@NotNull Player player){
        ArenaPlayer arenaPlayer = new EasyArenaPlayer(player);
        ArenaMap arenaMap = new EasyArenaMap();
        RoundManger roundManger = new RoundManger();

        return new ArenaGameController(arenaPlayer, arenaMap,roundManger);
    }

    public static boolean hasGameController(@NotNull Player player) {
        return controllers.containsKey(player.getUniqueId());
    }

    public static @NotNull Map<UUID, ArenaGameController> getGameControllers() {
        return new HashMap<>(controllers);
    }

}
