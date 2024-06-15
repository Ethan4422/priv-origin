package me.goodi.gambler.listeners;

import me.goodi.origin.User;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Random;

public class DrinkWater implements Listener {

    final User user = new User();
    final HashMap<String, Long> cooldown = new HashMap<>();

    @EventHandler
    public void drink(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (shouldAddEffect(player, e.getAction())) {
            cooldown.put(player.getUniqueId().toString(), System.currentTimeMillis());

            Random random = new Random();
            PotionEffectType[] effects = PotionEffectType.values();
            PotionEffect effect = new PotionEffect(effects[random.nextInt(effects.length)], 250 + random.nextInt(750), random.nextInt(3), false, false);
            player.addPotionEffect(effect);

            player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
        }
    }

    public boolean shouldAddEffect(Player player, Action action) {
        if (user.isGambler(player.getUniqueId().toString())) {
            if (player.getInventory().getItemInMainHand().getType() == Material.POTION && player.getInventory().getItemInMainHand().getDurability() == 0) {

                if (cooldown.get(player.getUniqueId().toString()) == null) {
                    cooldown.put(player.getUniqueId().toString(), System.currentTimeMillis());
                    return true;
                }
                if ((double) (cooldown.get(player.getUniqueId().toString()) - System.currentTimeMillis()) < -100) {
                    if (action.equals(Action.RIGHT_CLICK_AIR)) {
                        return true;

                    } else return action.equals(Action.RIGHT_CLICK_BLOCK);
                }
            }
        }
        return false;
    }
}
