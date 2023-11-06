package io.github.mcyoinet.auranelemental;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.mcyoinet.auranelemental.managers.ConfigurationManager;
import io.papermc.paper.plugin.configuration.PluginMeta;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class AuranElemental extends JavaPlugin {
    PluginMeta data = getPluginMeta();

    public final String name = data.getName();
    public final String version = data.getVersion();
    public final String description = data.getDescription();
    public final String website = data.getWebsite();
    public final String author = data.getAuthors().get(0);

    MiniMessage mm = MiniMessage.miniMessage();
    ConfigurationManager configManager = new ConfigurationManager(this);

    public final String defaultPrefix = "<dark_grey>[<aqua>AuranElemental<dark_grey>]<reset>";

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(mm.deserialize(defaultPrefix + " <white>Plugin enabled."));
        Bukkit.getConsoleSender().sendMessage(mm.deserialize(defaultPrefix + " <white>Version ➔ <light_purple>" + version));
        Bukkit.getConsoleSender().sendMessage(mm.deserialize(defaultPrefix + " <white>Developed by ➔ <light_purple>" + author));
        
        Bukkit.getConsoleSender().sendMessage(mm.deserialize(defaultPrefix + " <gold>Loading configuration files..." + author));

        configManager.loadConfig("config");

        Bukkit.getConsoleSender().sendMessage(mm.deserialize(defaultPrefix + " <gold>Loaded all configuration files successfully." + author));

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(mm.deserialize(defaultPrefix + " <white>Plugin disabled."));
        Bukkit.getConsoleSender().sendMessage(mm.deserialize(defaultPrefix + " <white>Version ➔ <light_purple>" + version));
        Bukkit.getConsoleSender().sendMessage(mm.deserialize(defaultPrefix + " <white>Developed by ➔ <light_purple>" + author));
    }
}
