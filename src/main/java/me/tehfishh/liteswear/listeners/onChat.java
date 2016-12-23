package me.tehfishh.liteswear.listeners;

import me.tehfishh.liteswear.liteswear;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class onChat implements Listener {

    public static liteswear plugin;

    public onChat(liteswear instance) {
        plugin = instance;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String message = e.getMessage();
        String servername = plugin.getConfig().getString("Server Name");
        String blocked = plugin.getConfig().getString("Blocked Message");
        List<String> blockedwords = plugin.getConfig().getStringList("Blocked Words");

        if (player.hasPermission("liteswear.check")) {
            blockedwords.forEach((blocker) -> {
                if (message.toLowerCase().contains(blocker.toLowerCase())) {
                    e.setCancelled(true);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', servername + " &8>&r " + blocked));
                }
            });

        }
    }
}
