// for (int _ = _; _ < _; ++_) {
//     int sq = _ * _;
//     System.out.println(sq);
// }

public class T1n {
    static {
        for (int i = 0; i < 100; ++i) {
            int sq = i * i;
            System.out.println(sq);
        }
        for (int i = 3; i < 45; ++i) {
            int sq = i * i;
            System.out.println(sq);
        }
        for (int i = 3; i < 45; ++i) {
            int sq = i * i;
            System.err.println(sq);
        }
        for (int j = 4; j < 10; ++j) {
            int sq = j * j;
            System.out.println(sq);
        }
        for (int j = 5; j < 23; ++j) {
            int sq = j * j;
            System.out.println(sq);
        }
        for (int j = 5; j < 23; ++j) {
            int s = j / j;
            System.out.println(s);
        }
        for (int i = 80; i < 101; ++i) {
            int sq = i * i;
            System.out.println(sq);
        }
        for (int i = 9; i < 14; ++i) {
            int sq = i * i;
            System.out.println(sq);
        }
        for (int k = 50; k < 170; ++k) {
            int sq = k * k;
            System.out.println(sq);
        }
        for (int k = 50; k > 17; --k) {
            int sq = k * k;
            System.out.println(sq);
        }
        for (int k = 0; k < 100; ++k) {
            int sq = k * k;
            System.out.println(sq);
        }
        for (int i = 30; i < 1000; ++i) {
            int sq = i * i;
            System.out.println(sq);
        }
        for (int j = 20; j < 10000; ++j) {
            int sq = j * j;
            System.out.println(sq);
        }
        for (int j = 20; j < 10000; ++j) {
            for (int jj = 20; jj < 10000; ++jj) {
                int sq = jj * jjj;
                System.out.println(sq);
            }
        }
    }
}
