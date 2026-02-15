package net.allulose.pigStorage;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class pigEvent implements Listener {

    public final Map<UUID, Inventory> pigStorageData = new HashMap<UUID, Inventory>();

    @EventHandler
    public void pigEvent(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getType() == EntityType.PIG && e.getRightClicked().getCustomName() != null && e.getRightClicked().getCustomName().contains("돼지")) {
            Pig pig = (Pig) e.getRightClicked();
            Player player = e.getPlayer();

            if (pigStorageData.containsKey(pig.getUniqueId())) {
                player.openInventory(pigStorageData.get(pig.getUniqueId()));
            } else {
                Inventory newPigStorage = Bukkit.createInventory(null, 9, "돼지");
                pigStorageData.put(pig.getUniqueId(), newPigStorage);
                player.openInventory(newPigStorage);
            }

        }
    }

    @EventHandler
    public void closeGui(InventoryCloseEvent e) {
        if (e.getView().getTitle().equals("돼지")) {
            Player p = (Player) e.getPlayer();
            p.playSound(p.getLocation(), Sound.BLOCK_CHEST_CLOSE, 0.3f, 1f);
        }

    }

}
