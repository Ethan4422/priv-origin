package me.goodi.ninja.listeners;

import me.goodi.origin.User;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.HashMap;
import java.util.Random;

public class EntityDamage implements Listener {

    final User user = new User();
    final HashMap<String, Long> lastAttacked = new HashMap<>();
    final Random random = new Random();

    @EventHandler
    public void damage(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player player){
            if(user.isNinja(player.getUniqueId().toString())){

                if(shouldDodge(player)){
                    player.getWorld().generateTree(player.getLocation(), TreeType.TREE);

                    teleportSafe(player);
                    e.setCancelled(true);
                    lastAttacked.put(player.getUniqueId().toString(), System.currentTimeMillis());
                }
            }
        }
    }

    public void teleportSafe(Player player){
        int x = player.getLocation().getBlockX() + 5 + random.nextInt(7);
        int y = player.getLocation().getBlockY();
        int z = player.getLocation().getBlockZ() + 5 + random.nextInt(7);


        Location location = new Location(player.getWorld(), x, y, z);

        do{
            location=location.add(0, 1,0);
        }while (location.getBlock().getType() != Material.AIR);

        player.teleport(location.add(0,1,0));

    }

    public boolean shouldDodge(Player player) {

        if (lastAttacked.get(player.getUniqueId().toString()) == null) {
            return true;
        }

        if ((lastAttacked.get(player.getUniqueId().toString()) / 1000 - System.currentTimeMillis() / 1000) / -1 >= 60) {
            return true;
        }
        return false;
    }
}