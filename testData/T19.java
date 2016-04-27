// for (Iterator<String> iterator = _.iterator(); iterator.hasNext(); ) {
//     String s = iterator.next();
//     _
// }

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class T19 {
    static List<String> list = new LinkedList<>();
    static List<String> strings = new ArrayList<>();

    static {
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            System.out.print(s);
        }
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            int i = 3;
            for (int j = 0; j < i; j++) {
                System.out.println(s);
            }
        }
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            s = s + s;
            System.err.println(s);
        }
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            if (s.isEmpty()) {
                System.exit(69);
            }
        }
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            if (!s.isEmpty()) {
                System.exit(s.charAt(0));
            }
        }
        for (Iterator<String> iterator = strings.iterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            System.out.print(s + s);
        }
        for (Iterator<String> iterator = strings.iterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            int i = 5;
            for (int j = 0; j < i; ++j) {
                System.out.println(s + s);
            }
        }
        for (Iterator<String> iterator = strings.iterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            s = s + s + s;
            System.err.println(s + s);
        }
        for (Iterator<String> iterator = strings.iterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            if (s.isEmpty()) {
                System.exit(6969);
            }
        }
        for (Iterator<String> iterator = strings.iterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            if (!s.isEmpty()) {
                System.exit(s.charAt(0) + 69);
            }
        }
    }
}
