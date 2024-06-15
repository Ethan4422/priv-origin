package me.goodi.gambler;

import me.goodi.gambler.listeners.DrinkWater;
import me.goodi.gambler.listeners.EntityDamage;
import me.goodi.gambler.listeners.GenerateLoot;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class Ghandler {

    public void register(Plugin plugin){
        final PluginManager manager = plugin.getServer().getPluginManager();

        manager.registerEvents(new DrinkWater(), plugin);
        manager.registerEvents(new EntityDamage(), plugin);
        manager.registerEvents(new GenerateLoot(), plugin);



    }

}
