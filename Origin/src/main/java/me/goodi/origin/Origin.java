package me.goodi.origin;

import me.goodi.gambler.Ghandler;
import me.goodi.ninja.Nhandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class Origin extends JavaPlugin {



    @Override
    public void onEnable() {
        new Ghandler().register(this);
        new Nhandler().register(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
