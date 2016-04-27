// if (_) {
//     _
// } else {
//     throw new _(_);
// }

public class T7 {
    static {
        int[] arr = {1, 2, 3};
        if (arr[0] == 1) {
            g("la");
            g("abc");
        } else {
            throw new ArrayIndexOutOfBoundsException("exc0");
        }
        if (35 > 23) {
            System.out.print(12345);
        } else {
            throw new ArithmeticException("exc1");
        }
        if (69 == 69) {
            int i = 69;
            f(i);
        } else {
            throw new IllegalStateException("exc2");
        }
        if ("null" != null) {
            f(5);
            f(69);
        } else {
            throw new NullPointerException("exc3");
        }
        if ("null".charAt(3) == 'l') {
            String s = "la";
            g(s);
        } else {
            throw new StringIndexOutOfBoundsException("exc4");
        }
        if (arr[1] == 2) {
            g("a");
            g("b");
        } else {
            throw new ArrayIndexOutOfBoundsException("exc5");
        }
        if (0 <69) {
            System.out.print(6969);
        } else {
            throw new ArithmeticException("exc6");
        }
        if (0 != 69) {
            int j = 0;
            f(j);
        } else {
            throw new IllegalStateException("exc7");
        }
        if ("null" != null) {
            f(500);
            f(0);
        } else {
            throw new NullPointerException("exc8");
        }
        if ("null".charAt(2) == 'l') {
            String str = "abc";
            g(str);
        } else {
            throw new StringIndexOutOfBoundsException("exc9");
        }
    }

    static void f(int i) {}
    static void g(String s) {}
}
