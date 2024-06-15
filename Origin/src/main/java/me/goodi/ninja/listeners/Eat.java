package me.goodi.ninja.listeners;

import me.goodi.origin.User;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import java.util.Arrays;
import java.util.List;

public class Eat implements Listener {

    final User user = new User();
    final List<Material> meat = Arrays.asList(Material.BEEF, Material.COOKED_BEEF, Material.CHICKEN, Material.COOKED_CHICKEN, Material.COD, Material.COOKED_COD, Material.MUTTON, Material.COOKED_MUTTON, Material.PORKCHOP, Material.COOKED_PORKCHOP, Material.RABBIT, Material.COOKED_RABBIT, Material.TROPICAL_FISH, Material.SALMON, Material.COOKED_SALMON);


    @EventHandler
    public void eat(PlayerItemConsumeEvent e){
        Player player = e.getPlayer();
        if(!user.isNinja(player.getUniqueId().toString())) return;
        if(meat.contains(player.getInventory().getItemInMainHand().getType())){
            e.setCancelled(true);
            player.sendMessage("§cYou cannot consume that you are vegetarian!");
        }
    }
}
