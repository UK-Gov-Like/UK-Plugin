package com.github.ukgovlike.ukplugin.api;

import com.github.ukgovlike.ukplugin.api.database.DatabaseStorable;

import java.util.Set;
import java.util.UUID;

/**
 * The interface that held the user.
 * If got from {@link com.github.ukgovlike.ukplugin.api.cache.UserCache#get(UUID)} it won't be null.
 *
 * Each 10 minutes the plugin do some checks if this user must be updated in database or insert there.
 * The checks are:
 * <ul>
 *     If the user is in the database, then
 *     <li>If isDirty() is true, the user will be updated and marked as not dirty, otherwise nothing happens</li>
 *     If the user is not in the database, then
 *     <li>The user will be created in the database and marked as in database and as not dirty</li>
 * </ul>
 */
public interface User extends DatabaseStorable {

    UUID getId();
    String getName();

    double getBalance();
    void setBalance(double balance);
    void addBalance(double balance);
    void removeBalance(double balance);
    default boolean hasBalance(double balance) {
        return getBalance() >= balance;
    }

    double getDeposited();
    void setDeposited(double deposited);
    void addDeposited(double deposited);
    void removeDeposited(double deposited);

    Set<Transaction> getTransactions();
}
