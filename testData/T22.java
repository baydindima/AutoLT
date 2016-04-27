// _.stream().filter(_ -> !_.isEmpty()).forEach(StringOps::_);

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T22 {
    static List<String> list = new LinkedList<>();
    static List<String> strings = new ArrayList<>();

    static {
        list.stream().filter(s -> !s.isEmpty()).forEach(StringOps::O0);
        list.stream().filter(s -> !s.isEmpty()).forEach(StringOps::O1);
        list.stream().filter(s -> !s.isEmpty()).forEach(StringOps::O2);
        list.stream().filter(s -> !s.isEmpty()).forEach(StringOps::O3);
        list.stream().filter(s -> !s.isEmpty()).forEach(StringOps::O4);
        strings.stream().filter(str -> !str.isEmpty()).forEach(StringOps::O5);
        strings.stream().filter(str -> !str.isEmpty()).forEach(StringOps::O6);
        strings.stream().filter(str -> !str.isEmpty()).forEach(StringOps::O7);
        strings.stream().filter(str -> !str.isEmpty()).forEach(StringOps::O8);
        strings.stream().filter(str -> !str.isEmpty()).forEach(StringOps::O9);
    }
}

class StringOps {
    static void O0(String s) {}
    static void O1(String s) {}
    static void O2(String s) {}
    static void O3(String s) {}
    static void O4(String s) {}
    static void O5(String s) {}
    static void O6(String s) {}
    static void O7(String s) {}
    static void O8(String s) {}
    static void O9(String s) {}
}