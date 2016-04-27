// _.forEach(s -> {
//     if (!s.isEmpty()) {
//         _
//     }
// });

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T21 {
    static List<String> list = new LinkedList<>();
    static List<String> strings = new ArrayList<>();

    static {
        list.forEach(s -> {
            if (!s.isEmpty()) {
                int w = 69;
                while (w > 0) --w;
            }
        });
        list.forEach(s -> {
            if (!s.isEmpty()) {
                double a = 69.69;
                while (a < 100) {
                    System.out.println(s);
                    a += 2;
                }
            }
        });
        list.forEach(s -> {
            if (!s.isEmpty()) {
                s = s.replaceAll(" ", "");
                System.exit(s.charAt(0));
            }
        });
        list.forEach(s -> {
            if (!s.isEmpty()) {
                char c = 'c';
                char d = 'd';
                s = s.replace(c, d);
            }
        });
        list.forEach(s -> {
            if (!s.isEmpty()) {
                List<String> l = new ArrayList<>();
                l.add(s);
            }
        });
        strings.forEach(s -> {
            if (!s.isEmpty()) {
                int k = 69;
                ++k;
                while (k > 5) --k;
            }
        });
        strings.forEach(s -> {
            if (!s.isEmpty()) {
                int b = 69;
                while (b >= 2) {
                    System.err.println(s);
                    b -= 4;
                }
            }
        });
        strings.forEach(s -> {
            if (!s.isEmpty()) {
                s = s.replaceAll("abc", "");
                System.exit(s.charAt(0));
            }
        });
        strings.forEach(s -> {
            if (!s.isEmpty()) {
                char d = 'd';
                char c = 'c';
                s = s.replace(d, c);
            }
        });
        strings.forEach(s -> {
            if (!s.isEmpty()) {
                List<String> l = new ArrayList<>();
                l.add(s);
                l.add(s);
            }
        });
    }
}
