package me.goodi.ninja.runnable;

import me.goodi.origin.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Sneak extends BukkitRunnable {

    User user = new User();

    @Override
    public void run() {

        for(Player player : Bukkit.getServer().getOnlinePlayers()){
            if(user.isGambler(player.getUniqueId().toString())){
                player.setInvisible(player.isSneaking());
            }
        }

    }
}
