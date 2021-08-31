package com.github.ukgovlike.ukplugin;

import com.github.ukgovlike.ukplugin.api.cache.UserCache;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class UKPlugin extends JavaPlugin {

    private final UserCache userCache = new UserCache();
}
