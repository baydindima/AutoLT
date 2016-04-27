// _ _ = _.filter(_ -> _).map(_ -> _).filter(_ -> _).collect(Collectors._());

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T6 {
    static {
        Stream<Integer> stream = new LinkedList<Integer>().stream();
        Stream<Integer> integerStream = new LinkedList<Integer>().stream();

        String result1 = stream
                .filter(i -> i < 69)
                .map(i -> i.toString() + "a")
                .filter(s -> s.length() > 5)
                .collect(Collectors.joining());
        List<String> result2 = stream
                .filter(i -> i > 690)
                .map(i -> "qwerty")
                .filter(s -> s.length() == 6)
                .collect(Collectors.toList());
        Set<String> result3 = stream
                .filter(i -> i == 0)
                .map(i -> i.toString() + i.toString())
                .filter(s -> !s.isEmpty() && s.length() > 3)
                .collect(Collectors.toSet());
        long result4 = stream
                .filter(i -> i != 35)
                .map(i -> "lal")
                .filter(s -> s.length() > 5)
                .collect(Collectors.counting());
        String result5 = stream
                .filter(i -> i * i > i)
                .map(i -> "abacaba")
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining());
        String result6 = integerStream
                .filter(k -> k < 690)
                .map(k -> k.toString() + "b")
                .filter(str -> str.length() > 4)
                .collect(Collectors.joining());
        List<String> result7 = integerStream
                .filter(k -> k < 60)
                .map(k -> "qwerty+qwerty")
                .filter(str -> str.length() == 13)
                .collect(Collectors.toList());
        Set<String> result8 = integerStream
                .filter(k -> k != 0)
                .map(k -> k.toString() + k.toString() + k.toString())
                .filter(str -> str.isEmpty() || str.length() > 3)
                .collect(Collectors.toSet());
        long result9 = integerStream
                .filter(k -> k != 350)
                .map(k -> "lol")
                .filter(str -> str.length() < 5)
                .collect(Collectors.counting());
        String result0 = integerStream
                .filter(k -> k * k <= k)
                .map(i -> "aba-aba")
                .filter(str -> !str.isEmpty())
                .collect(Collectors.joining());
    }
}
