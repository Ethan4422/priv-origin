package me.goodi.ninja;

import me.goodi.ninja.listeners.Eat;
import me.goodi.ninja.listeners.EntityDamage;
import me.goodi.ninja.runnable.Sneak;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitTask;

public class Nhandler {

    public void register(Plugin plugin){
        final PluginManager manager = plugin.getServer().getPluginManager();

        manager.registerEvents(new EntityDamage(), plugin);
        manager.registerEvents(new Eat(), plugin);

        BukkitTask invisibleSneak = new Sneak().runTaskTimer(plugin, 0, 10);

    }

}
