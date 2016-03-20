package com.egor69.lt.finder.simple;

import com.intellij.openapi.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Parameters {
    public enum Name {
        DEPTH_MINIMUM,
        MATCH_PERCENTAGE,
        MATCH_MINIMUM
    }

    private static final Map<Name, String> TEXT_MAP;

    static {
        TEXT_MAP = new HashMap<>();
        TEXT_MAP.put(Name.DEPTH_MINIMUM, "Depth Minimum");
        TEXT_MAP.put(Name.MATCH_PERCENTAGE, "Match Percentage");
        TEXT_MAP.put(Name.MATCH_MINIMUM, "Match Minimum");
    }

    public static String getText(Name name) {
        return TEXT_MAP.get(name);
    }

    private static final Map<Name, Pair<Integer, Integer>> BOUNDS_MAP;

    static {
        BOUNDS_MAP = new HashMap<>();
        BOUNDS_MAP.put(Name.DEPTH_MINIMUM, Pair.create(1, 5));
        BOUNDS_MAP.put(Name.MATCH_PERCENTAGE, Pair.create(0, 100));
        BOUNDS_MAP.put(Name.MATCH_MINIMUM, Pair.create(1, 100));
    }

    public static Pair<Integer, Integer> getBounds(Name name) {
        return BOUNDS_MAP.get(name);
    }

    private static final Map<Name, Integer> DEFAULT_MAP;

    static {
        DEFAULT_MAP = new HashMap<>();
        DEFAULT_MAP.put(Name.DEPTH_MINIMUM, 3);
        DEFAULT_MAP.put(Name.MATCH_PERCENTAGE, 50);
        DEFAULT_MAP.put(Name.MATCH_MINIMUM, 10);
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
