package net.allulose.pigStorage;

import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class PigStorage extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents((Listener) new pigEvent(), this);
        getCommand("pigchest").setExecutor(new summonPig());
    }


}
