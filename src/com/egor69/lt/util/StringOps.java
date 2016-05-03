package com.egor69.lt.util;

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
}
