// try {
//    List<String> _ = Files.readAllLines(Paths.get(_));
//    _
// } catch (IOException e) {
//    _
// }

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class T8 {
    static {
        try {
            List<String> lines = Files.readAllLines(Paths.get("path1"));
            lines.add("lala");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            List<String> list = Files.readAllLines(Paths.get("path2"));
            if (!list.contains("lala")) list.add("lala");
        } catch (IOException e) {
            System.out.println(e);
        }
        try {
            List<String> stringList = Files.readAllLines(Paths.get("path3"));
            int i = 5;
            for (int j = 0; j < i; j++) {
                stringList.add(String.valueOf(j));
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        try {
            List<String> strings = Files.readAllLines(Paths.get("path4"));
            strings.remove(0);
            strings.remove(0);
        } catch (IOException e) {
            int i = 69;
            System.exit(i);
        }
        try {
            List<String> lines = Files.readAllLines(Paths.get("path5"));
            lines.add("abc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            List<String> list = Files.readAllLines(Paths.get("path6"));
            if (!list.contains("abc")) list.add("abc");
        } catch (IOException e) {
            System.out.println(e);
            System.exit(69);
        }
        try {
            List<String> stringList = Files.readAllLines(Paths.get("path7"));
            int k = 65;
            for (int j = k; j > 0; --j) {
                stringList.add(String.valueOf(k * j));
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        try {
            List<String> strings = Files.readAllLines(Paths.get("path8"));
            strings.remove(0);
            strings.remove(0);
            strings.remove(0);
        } catch (IOException e) {
            int i = 6969;
            System.exit(i);
        }
        try {
            List<String> stringList = Files.readAllLines(Paths.get("path9"));
            int k = 65;
            int i = k / 5;
            for (int j = i; j > 3; --j) {
                stringList.add(String.valueOf(k * j * i));
                stringList.add(String.valueOf(j * i));
            }
        } catch (IOException e) {
            String s = "qwerty";
            System.err.println(e + "\n" + s);
        }
        try {
            List<String> strings = Files.readAllLines(Paths.get("path0"));
            strings.add("a");
            strings.remove("a");
            strings.remove(0);
        } catch (IOException e) {
            int i = 6969;
            System.exit(i);
        }
    }
}
