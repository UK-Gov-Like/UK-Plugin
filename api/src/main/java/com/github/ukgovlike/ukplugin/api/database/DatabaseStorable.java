package com.github.ukgovlike.ukplugin.api.database;

public interface DatabaseStorable {

    boolean isDirty();
    void setDirty(boolean dirty);
    boolean isInDatabase();
    void setInDatabase(boolean inDatabase);
    boolean isDeleted();
    void setDeleted(boolean deleted);
}
