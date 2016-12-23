package me.tehfishh.liteswear;

import me.tehfishh.liteswear.commands.liteswearcommand;
import me.tehfishh.liteswear.listeners.onChat;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class liteswear extends JavaPlugin {

    public static liteswear plugin;

    @Override
    public void onEnable() {
        getLogger().info("Liteswear is starting.....");
        getProcess();
        liteswear.plugin = this;
        getLogger().info("Liteswear has started successfully!");
        getLogger().warning("Version 1.0 BETA // Report all bugs to GitHub // ~Fish");
    }

    @Override
    public void onDisable() {
        getLogger().info("Liteswear is disabling.....");
        liteswear.plugin = null;
        getLogger().info("Liteswear has disabled successfully!");
        getLogger().info("Version 1.0 BETA // ~Fish");
    }

    public void getProcess() {
        config();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new onChat(this), this);
        getCommand("liteswear").setExecutor(new liteswearcommand(this));
    }

    public void config() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                getLogger().warning("Config.yml not found, creating!");
                saveDefaultConfig();
            } else {
                getLogger().info("Config.yml found, loading!");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
