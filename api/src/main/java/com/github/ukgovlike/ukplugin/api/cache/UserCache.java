package com.github.ukgovlike.ukplugin.api.cache;

import com.github.ukgovlike.ukplugin.api.User;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class UserCache {

    private final Map<UUID, User> cache = new HashMap<>();

    @NotNull
    public User get(UUID id) {
        return cache.getOrDefault(id, new InvalidUser());
    }

    @NotNull
    public User getOrInsert(UUID id, User user) {
        if (has(id))
            return get(id);
        add(user);
        return user;
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

    public Collection<User> getUsers() {
        return new HashSet<>(cache.values());
    }
}
