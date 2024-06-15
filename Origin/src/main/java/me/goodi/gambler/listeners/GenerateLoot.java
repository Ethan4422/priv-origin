package me.goodi.gambler.listeners;

import me.goodi.origin.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class GenerateLoot implements Listener {

    final User user = new User();

    @EventHandler
    public void lootGen(LootGenerateEvent e){
        if(e.getEntity() instanceof Player player){
            if(user.isGambler(player.getUniqueId().toString())){
                Random random = new Random();

                if(random.nextInt(2) == 1){
                    e.getLoot().clear();
                    player.sendMessage("Cleared! );");
                }else{
                    player.sendMessage("Doubled! (:");
                    for(ItemStack item : e.getLoot()){
                        item.setAmount(item.getAmount()*2);
                    }
                }

            }
        }
    }
}
