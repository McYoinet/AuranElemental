package io.github.mcyoinet.auranelemental.managers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import io.github.mcyoinet.auranelemental.AuranElemental;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;

public class ConfigurationManager {
    private AuranElemental instance;

    public ConfigurationManager(AuranElemental plugin) {
        this.instance = plugin;
    }

    MiniMessage mm = MiniMessage.miniMessage();

    private HashMap<String, FileConfiguration> configs = new HashMap<>();

    public void loadConfig(String configname) {
        configname += ".yml";

        File file = new File(instance.getDataFolder(), configname);

        if(!file.exists()) {
            file.getParentFile().mkdirs();
            instance.saveResource(configname, false);
        }

        FileConfiguration config = new YamlConfiguration();

        try {
            config.load(file);
            configs.put(configname, config);

            Bukkit.getConsoleSender().sendMessage(mm.deserialize(instance.defaultPrefix + " <green>Loaded '<dark_green><file><green>' configuration file successfully.", Placeholder.unparsed("file", configname)));
        } catch(IOException | InvalidConfigurationException e) {
            Bukkit.getConsoleSender().sendMessage(mm.deserialize(instance.defaultPrefix + " <dark_red>Couldn't load '<red><file><dark_red>' configuration file. Stacktrace:\n<stacktrace>", Placeholder.unparsed("file", configname), Placeholder.unparsed("stacktrace", e.toString())));
        }
    }

    public FileConfiguration getConfig(String configname) {
        return configs.get(configname);
    }
}
