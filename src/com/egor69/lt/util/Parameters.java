package com.egor69.lt.util;

import com.intellij.openapi.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Parameters {
    public enum Name {
        DEPTH_MINIMUM,
        MATCHES_PERCENTAGE_MINIMUM,
        MATCHES_MINIMUM,
        LENGTH_MINIMUM,
        NODES_MINIMUM,
        PLACEHOLDERS_LENGTH_PERCENTAGE_MAXIMUM,
        PLACEHOLDER_NODES_PERCENTAGE_MAXIMUM
    }

    private static final Map<Name, String> TEXT_MAP;

    static {
        TEXT_MAP = new HashMap<>();
        TEXT_MAP.put(Name.DEPTH_MINIMUM, "Depth Minimum");
        TEXT_MAP.put(Name.MATCHES_PERCENTAGE_MINIMUM, "Matches Percentage Minimum");
        TEXT_MAP.put(Name.MATCHES_MINIMUM, "Matches Minimum");
        TEXT_MAP.put(Name.LENGTH_MINIMUM, "Length Minimum");
        TEXT_MAP.put(Name.NODES_MINIMUM, "Nodes Minimum");
        TEXT_MAP.put(Name.PLACEHOLDERS_LENGTH_PERCENTAGE_MAXIMUM, "Placeholders Length Percentage Maximum");
        TEXT_MAP.put(Name.PLACEHOLDER_NODES_PERCENTAGE_MAXIMUM, "Placeholder Nodes Percentage Maximum");
    }

    public static String getText(Name name) {
        return TEXT_MAP.get(name);
    }

    private static final Map<Name, Pair<Integer, Integer>> BOUNDS_MAP;

    static {
        BOUNDS_MAP = new HashMap<>();
        BOUNDS_MAP.put(Name.DEPTH_MINIMUM, Pair.create(1, 7));
        BOUNDS_MAP.put(Name.MATCHES_PERCENTAGE_MINIMUM, Pair.create(0, 100));
        BOUNDS_MAP.put(Name.MATCHES_MINIMUM, Pair.create(1, 100));
        BOUNDS_MAP.put(Name.LENGTH_MINIMUM, Pair.create(1, 200));
        BOUNDS_MAP.put(Name.NODES_MINIMUM, Pair.create(1, 50));
        BOUNDS_MAP.put(Name.PLACEHOLDERS_LENGTH_PERCENTAGE_MAXIMUM, Pair.create(0, 100));
        BOUNDS_MAP.put(Name.PLACEHOLDER_NODES_PERCENTAGE_MAXIMUM, Pair.create(0, 100));
    }

    public static Pair<Integer, Integer> getBounds(Name name) {
        return BOUNDS_MAP.get(name);
    }

    private static final Map<Name, Integer> DEFAULT_MAP;

    static {
        DEFAULT_MAP = new HashMap<>();
        DEFAULT_MAP.put(Name.DEPTH_MINIMUM, 3);
        DEFAULT_MAP.put(Name.MATCHES_PERCENTAGE_MINIMUM, 10);
        DEFAULT_MAP.put(Name.MATCHES_MINIMUM, 10);
        DEFAULT_MAP.put(Name.LENGTH_MINIMUM, 20);
        DEFAULT_MAP.put(Name.NODES_MINIMUM, 5);
        DEFAULT_MAP.put(Name.PLACEHOLDERS_LENGTH_PERCENTAGE_MAXIMUM, 30);
        DEFAULT_MAP.put(Name.PLACEHOLDER_NODES_PERCENTAGE_MAXIMUM, 50);
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
