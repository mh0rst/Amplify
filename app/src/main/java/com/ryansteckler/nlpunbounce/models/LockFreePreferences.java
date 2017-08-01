package com.ryansteckler.nlpunbounce.models;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Lock free implementation of shared preference interface.
 */
public class LockFreePreferences implements SharedPreferences {

    public LockFreePreferences(Map<String, ?> backingMap) {
        this.backingMap = backingMap;
    }

    private Map<String, ?> backingMap;

    @Override
    public Map<String, ?> getAll() {
        return Collections.unmodifiableMap(backingMap);
    }

    @Nullable
    @Override
    public String getString(String key, @Nullable String defValue) {
        String value = (String) backingMap.get(key);
        return value == null ? defValue : value;
    }

    @Nullable
    @Override
    public Set<String> getStringSet(String key, @Nullable Set<String> defValues) {
        Set<String> value = (Set<String>) backingMap.get(key);
        return value == null ? defValues : value;
    }

    @Override
    public int getInt(String key, int defValue) {
        Integer value = (Integer) backingMap.get(key);
        return value == null ? defValue : value.intValue();
    }

    @Override
    public long getLong(String key, long defValue) {
        Long value = (Long) backingMap.get(key);
        return value == null ? defValue : value.longValue();
    }

    @Override
    public float getFloat(String key, float defValue) {
        Float value = (Float) backingMap.get(key);
        return value == null ? defValue : value.floatValue();
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        Boolean value = (Boolean) backingMap.get(key);
        return value == null ? defValue : value.booleanValue();
    }

    @Override
    public boolean contains(String key) {
        return backingMap.containsKey(key);
    }

    @Override
    public Editor edit() {
        throw new UnsupportedOperationException("read-only implementation");
    }

    @Override
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        throw new UnsupportedOperationException("listeners are not supported in this implementation");
    }

    @Override
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        throw new UnsupportedOperationException("listeners are not supported in this implementation");
    }
}
