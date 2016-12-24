package me.tehfishh.liteswear.commands;

import me.tehfishh.liteswear.liteswear;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

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
                } else if (args.length >= 2) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', invalidarguement()));
                } else {
                    if (args[0].equalsIgnoreCase("reload")) {
                        plugin.reloadConfig();
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lLiteswear &8> &7Reloaded config successfully."));
                    } else if (args[0].equalsIgnoreCase("help")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lLiteswear &8> &7Valid arguements: reload, addword"));
                    } else if (args[0].equalsIgnoreCase("addword")) {
                        if (args.length < 2) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lLiteswear &8> &cCorrect syntax: /liteswear addword (word)"));
                        } else {
                            if (args.length == 2) {
                                String arg2 = args[1];
                                List<String> blockedwords = plugin.getConfig().getStringList("Blocked Words");
                                blockedwords.add(arg2);
                                plugin.getConfig().set("Blocked Words", blockedwords);
                                plugin.saveConfig();
                                plugin.reloadConfig();
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lLiteswear &8> &7Added &6" + arg2 + " &7blocked word list"));
                            }
                        }
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
