package com.github.ukgovlike.ukplugin.task;

import com.github.ukgovlike.ukplugin.api.User;
import com.github.ukgovlike.ukplugin.api.cache.UserCache;
import lombok.RequiredArgsConstructor;
import org.bukkit.scheduler.BukkitRunnable;

@RequiredArgsConstructor
public class UpdateDatabaseTask extends BukkitRunnable {

    private final UserCache userCache;
    private final FakeExcelDatabase database;

    @Override
    public void run() {
        update(userCache, database);
    }

    public static void update(UserCache userCache, FakeExcelDatabase database) {
        for (User user : userCache.getUsers()) {
            if (user.isInDatabase() && !user.isDirty())
                continue;

            if (user.isInDatabase()) {
                //update user;
                user.setDirty(false);
                continue;
            }

            //create user
            user.setInDatabase(true);
            user.setDirty(false);
        }
    }
}
