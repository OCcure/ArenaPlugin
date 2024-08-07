package me.occure.arenaplugin.arenaPlayre;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;

public class EasyArenaPlayer implements ArenaPlayer{
    private final Player player;
    private ItemStack[] saveInv;
    private ItemStack[] saveArmor;

    public EasyArenaPlayer(Player player) {
        this.player = player;
    }

    @Override
    public @NotNull Player getBukkitPlayer() {
        return player;
    }

    @Override
    public void setup() {
        saveInv();
        clear();

        //기본 아이템 지급
        Inventory inv = player.getInventory();


        ItemStack arenaSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack meet = new ItemStack(Material.COOKED_BEEF,10);

        ItemMeta swordMeta = arenaSword.getItemMeta();
        swordMeta.setDisplayName("아레나 검");
        arenaSword.setItemMeta(swordMeta);

        inv.addItem(arenaSword);
        inv.addItem(meet);
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
        clearArenaItem();
        restoreInv();
        clearPotionEffects();
    }

    private void saveInv(){
        saveInv = player.getInventory().getContents();
        saveArmor = player.getInventory().getArmorContents();
    }
    private void restoreInv(){
        player.getInventory().setContents(saveInv);
        player.getInventory().setArmorContents(saveArmor);
    }
    private void clearPotionEffects() {
        for (PotionEffect effect : player.getActivePotionEffects()){
            player.removePotionEffect(effect.getType());
        }
    }
    private void clearArenaItem(){
        Inventory inv = player.getInventory();
        inv.clear();
    }
}
