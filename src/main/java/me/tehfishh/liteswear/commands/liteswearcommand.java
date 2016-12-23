package me.tehfishh.liteswear.commands;

import me.tehfishh.liteswear.liteswear;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class liteswearcommand implements CommandExecutor {

    public static liteswear plugin;

    public liteswearcommand(liteswear instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("LiteSwear")) {
            if (sender.hasPermission("liteswear.admin")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', invalidarguement()));
                } else {
                    if (args[0].equalsIgnoreCase("reload")) {
                        plugin.reloadConfig();
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lLiteswear &8> &7Reloaded config successfully."));
                    } else if (args[0].equalsIgnoreCase("help")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lLiteswear &8> &7Valid arguements: Reload"));
                    }
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lLiteswear &8> &cNo permission!"));
            }
        }
        return false;
    }

    public String invalidarguement() {
        return "&9&lLiteswear &8> &cPlease enter a valid arguement (help)";
    }
}
