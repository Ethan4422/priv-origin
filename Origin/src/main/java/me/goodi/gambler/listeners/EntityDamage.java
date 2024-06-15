package me.goodi.gambler.listeners;

import me.goodi.origin.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Random;

public class EntityDamage implements Listener {

    final User user = new User();


    @EventHandler
    public void damage(EntityDamageEvent e){
        if(e.getEntity() instanceof Player player){
            if(user.isGambler(player.getUniqueId().toString())){
                Random random = new Random();

                if(random.nextInt(2) == 1){
                    e.setDamage(e.getFinalDamage() * 0.5);
                }
                else{
                    e.setDamage(e.getFinalDamage() * 1.5);
                    player.sendMessage("Unlucky");
                }


            }
        }
    }
}
