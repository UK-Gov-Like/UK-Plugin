package com.github.ukgovlike.ukplugin.api.cache;

import com.github.ukgovlike.ukplugin.api.User;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserCache {

    private final Map<UUID, User> cache = new HashMap<>();

    @NotNull
    public User get(UUID id) {
        return cache.getOrDefault(id, new InvalidUser());
    }

    public void add(User user) {
        cache.put(user.getId(), user);
    }

    public void remove(UUID id) {
        cache.remove(id);
    }

    public boolean has(UUID id) {
        return cache.containsKey(id);
    }
}
