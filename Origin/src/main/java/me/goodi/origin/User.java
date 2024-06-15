package me.goodi.origin;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.*;

public class User implements Listener {

    private final List<String> GAMBLER = Arrays.asList("27c6f0fd-cf40-4fc3-a28f-caf75f678766");
    private final List<String> NINJA = Arrays.asList("037149bc-341e-4972-a764-bd735bf385bb");

    public boolean isGambler(String uuid){
        return GAMBLER.contains(uuid);
    }

    public boolean isNinja(String uuid){
        return NINJA.contains(uuid);
    }

}
