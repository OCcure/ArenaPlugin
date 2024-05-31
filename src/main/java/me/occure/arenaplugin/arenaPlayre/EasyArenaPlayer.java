package me.occure.arenaplugin.arenaPlayre;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
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
        //기본 아이템 지급
        Inventory inv = player.getInventory();

        ItemStack arenaSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta swordMeta = arenaSword.getItemMeta();
        swordMeta.setDisplayName("아레나 검");
        arenaSword.setItemMeta(swordMeta);

        inv.addItem(arenaSword);

        ItemStack[] armor = {
                new ItemStack(Material.DIAMOND_BOOTS),
                new ItemStack(Material.DIAMOND_LEGGINGS),
                new ItemStack(Material.DIAMOND_CHESTPLATE),
                new ItemStack(Material.DIAMOND_HELMET),
        };

        player.getInventory().setArmorContents(armor);
    }

    @Override
    public void clear() {

    }
}
