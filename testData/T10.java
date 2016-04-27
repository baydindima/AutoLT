// switch (_) {
//     case N:
//         _
//         break;
//     case S:
//         _
//         break;
//     case W:
//         _
//         break;
//     case E:
//         _
//         break;
// }

public class T10 {
    static {
        Direction d1 = dir();
        Direction d2 = dir();
        Direction d3 = dir();

        switch (d1) {
            case N:
                int i = 0;
                break;
            case S:
                String s = "ss";
                break;
            case W:
                double d = 3.2;
                break;
            case E:
                char c = 'f';
                break;
        }
        switch (d1) {
            case N:
                int i = 4;
                ++i;
                break;
            case S:
                String s = "sss";
                s = s + s;
                break;
            case W:
                double d = 3.2;
                d = d / d;
                break;
            case E:
                char c = 'g';
                ++c;
                break;
        }
        switch (d1) {
            case N:
                dir();
                int t = -69;
                break;
            case S:
                dir();
                String s = "s";
                break;
            case W:
                dir();
                double d = 3.25;
                break;
            case E:
                dir();
                char c = 'c';
                break;
        }
        switch (d2) {
            case N:
                int ii = 6969;
                break;
            case S:
                String s = "ss" + "ss";
                f();
                break;
            case W:
                double dd = 3.2;
                break;
            case E:
                char cc = 'z';
                break;
        }
        switch (d2) {
            case N:
                f();
                f();
                int i = 4;
                ++i;
                break;
            case S:
                String s = "sss";
                s = s + s;
                break;
            case W:
                double d = 3.2;
                f();
                dir();
                d = d / d;
                break;
            case E:
                char c = 'g';
                ++c;
                break;
        }
        switch (d2) {
            case N:
                f();
                int tt = -69;
                break;
            case S:
                String s = "s";
                f();
                break;
            case W:
                double d = 0.25;
                f();
                break;
            case E:
                char c = 'a';
                f();
                break;
        }
        switch (d3) {
            case N:
                int ii = 6969;
                int w = 69;
                ii = ii - w;
                break;
            case S:
                f();
                String s = "ss" + "ss" + "ss";
                break;
            case W:
                double dd = 3.2;
                break;
            case E:
                char cc = 'e';
                break;
        }
        switch (d3) {
            case N:
                f();
                g();
                int i = 40;
                ++i;
                break;
            case S:
                String s = "sss";
                g();
                break;
            case W:
                g();
                break;
            case E:
                g();
                break;
        }
        switch (d3) {
            case N:
                f();
                int tt = -4;
                break;
            case S:
                g();
                String s = "s";
                f();
                break;
            case W:
                double d = 2;
                break;
            case E:
                char b = 'o';
                g();
                f();
                break;
        }
        switch (d3) {
            case N:
                break;
            case S:
                break;
            case W:
                f();
                double dd = 2;
                g();
                dir();
                break;
            case E:
                f();
                break;
        }
    }

    static Direction dir() {
        return Direction.E;
    }

    static void f() {}
    static void g() {}

    enum Direction {
        N, S, W, E
    }
}
