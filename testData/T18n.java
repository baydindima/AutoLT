// static {
//     _ = new HashMap<>();
//     _.put("default", 0);
// }

// static Map<String, Integer> _;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class T18 {
    static Map<String, Integer> map0;
    static Map<String, Integer> map1;
    static Map<String, Integer> map2;
    static Map<String, Integer> map3;
    static Map<String, Integer> map4;
    static Map<String, Integer> map5;
    static Map<String, Integer> map6;
    static Map<String, Integer> map7;
    static Map<String, Integer> map8;
    static Map<String, Integer> map9;
    Map<String, Integer> n1;
    static HashMap<String, Integer> n2;
    static Map<String, Long> n3;
    static Map<Long, Integer> n4;
    static Map<String, Integer> n5 = new HashMap<>();

    static {
        map0 = new HashMap<>();
        map0.put("default", 0);
    }
    static {
        map1 = new HashMap<>();
        map1.put("default", 0);
    }
    static {
        map2 = new HashMap<>();
        map2.put("default", 0);
    }
    static {
        map3 = new HashMap<>();
        map3.put("default", 0);
    }
    static {
        map4 = new HashMap<>();
        map4.put("default", 0);
    }
    static {
        map5 = new HashMap<>();
        map5.put("default", 0);
    }
    static {
        map6 = new HashMap<>();
        map6.put("default", 0);
    }
    static {
        map7 = new HashMap<>();
        map7.put("default", 0);
    }
    static {
        map8 = new HashMap<>();
        map8.put("default", 0);
    }
    static {
        map9 = new HashMap<>();
        map9.put("default", 0);
    }
    static {
        n2 = new HashMap<>();
        n2.put("default", 69);
    }
    static {
        n3 = new HashMap<>();
        n3.put("init", 0);
    }
    static {
        n4 = new HashMap<>(69, .69f);
        n4.put("default", 0);
    }
    static {
        n2 = new HashMap<String, Integer>();
        n2.put("default", 0);
    }
    static {
        n3 = new LinkedHashMap<>();
        n3.put("init", 0);
    }
    static {
        n4.put("default", 0);
    }
    static {
        n2 = new HashMap<>();
    }
    static {
        n3.put("default", 0);
    }
    static {
        n4 = new HashMap<>();
        n4.put("default", 0);
        double d = .5;
    }
    static {
        int i = 0;
        n4 = new HashMap<>();
        n4.put("default", 0);
    }
    static {
        char c = 'q';
        n4 = new HashMap<>();
        n4.put("default", 0);
        float f = 1.2f;
    }
}
