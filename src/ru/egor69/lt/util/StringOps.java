package ru.egor69.lt.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringOps {
    private StringOps() {}

    public static String removeInsipidSequences(String s) {
        s = s.replaceAll("_(\\s|_)*_", "_");
        boolean changedOut = true;
        while (changedOut) {
            changedOut = false;
            boolean changed = true;
            while (changed) {
                changed = false;
                Pattern pattern = Pattern.compile("_((\\((\\s|_)*\\))|(\\[(\\s|_)*\\])|(<(\\s|_)*>)|(\\{(\\s|_)*\\}))");
                Matcher matcher = pattern.matcher(s);
                if (matcher.find()) {
                    s = s.substring(0, matcher.start()) + "_" + s.substring(matcher.end());
                    changedOut = changed = true;
                }
            }
            changed = true;
            while (changed) {
                changed = false;
                Pattern pattern = Pattern.compile("_[^()\\[\\]\\{\\}<>]_");
                Matcher matcher = pattern.matcher(s);
                if (matcher.find()) {
                    s = s.substring(0, matcher.start()) + "_" + s.substring(matcher.end());
                    changedOut = changed = true;
                }
            }
        }
        return s;
    }

    public static Set<String> product(List<Set<String>> parts) {
        if (parts.size() == 1) return parts.get(0);
        Set<String> firstPart = parts.get(0);
        Set<String> secondPart = parts.get(1);
        Set<String> newPart = new HashSet<>();
        for (String s1 :
                firstPart) {
            for (String s2 :
                    secondPart) {
                newPart.add((s1 + s2).replaceAll("_(_|\\s)*_", "_"));
            }
        }
        parts.remove(0);
        parts.remove(0);
        parts.add(0, newPart);
        return  product(parts);
    }
}
