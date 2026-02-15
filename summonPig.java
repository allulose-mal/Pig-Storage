package net.allulose.pigStorage;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class summonPig implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
            if (commandSender instanceof Player player) {
                World world = player.getWorld();
                Pig pig = world.spawn(player.getLocation(), Pig.class);
                pig.setCustomNameVisible(true);
                pig.setCustomName(ChatColor.LIGHT_PURPLE + "돼지" + ChatColor.BOLD);
            }
        return false;
    }
}
