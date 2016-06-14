package ru.egor69.lt.finder;

import com.intellij.openapi.util.Pair;

import java.util.HashMap;
import java.util.Map;

public abstract class Parameters {
    public interface Name {}

    public abstract Name[] names();

    protected static final Map<Name, String> TEXT_MAP;

    static {
        TEXT_MAP = new HashMap<>();
    }

    public static String getText(Name name) {
        return TEXT_MAP.get(name);
    }

    protected static final Map<Name, Pair<Integer, Integer>> BOUNDS_MAP;

    static {
        BOUNDS_MAP = new HashMap<>();
    }

    public static Pair<Integer, Integer> getBounds(Name name) {
        return BOUNDS_MAP.get(name);
    }

    protected static final Map<Name, Integer> DEFAULT_MAP;

    static {
        DEFAULT_MAP = new HashMap<>();
    }

    public static int getDefault(Name name) {
        return DEFAULT_MAP.get(name);
    }

    private Map<Name, Integer> values;

    public Parameters() {
        values = new HashMap<>();
    }

    public void setParameter(Name name, int value) {
        values.put(name, value);
    }

    public int getParameter(Name name) {
        Integer value = values.get(name);
        return value != null ? value : getDefault(name);
    }
}
