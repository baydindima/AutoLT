// for (int i = 0; i < _; ++i) {
//     for (int j = 0; j < _; ++j) {
//         _
//         _[i][j] = _;
//     }
// }

public class T9 {
    static {
        int[][] arr = new int[1000][1000];
        int[][] ar = new int[1000][1000];
        int[][] a = new int[1000][1000];
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 15; ++j) {
                int n = i * j;
                arr[i][j] = n;
            }
        }
        for (int i = 0; i < 11; ++i) {
            for (int j = 0; j < 25; ++j) {
                int k = i + j;
                --k;
                arr[i][j] = k;
            }
        }
        for (int i = 0; i < 100; ++i) {
            for (int j = 0; j < 5; ++j) {
                int z = (i + 1) * (j + 2);
                ++z;
                arr[i][j] = z;
            }
        }
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 500; ++j) {
                ++i;
                ++j;
                arr[i][j] = (i + j) * 2;
            }
        }
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 15; ++j) {
                int n = i * j;
                ar[i][j] = n;
            }
        }
        for (int i = 0; i < 11; ++i) {
            for (int j = 0; j < 25; ++j) {
                int k = (i + j) * 2;
                k--;
                ar[i][j] = k;
            }
        }
        for (int i = 0; i < 100; ++i) {
            for (int j = 0; j < 5; ++j) {
                int z = (i + 1) * (j + 2);
                z++;
                ar[i][j] = z;
            }
        }
        for (int i = 0; i < 110; ++i) {
            for (int j = 0; j < 52; ++j) {
                i++;
                j++;
                ar[i][j] = (i + j) * 3;
            }
        }
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 69; ++j) {
                int z = (i + 1) * (j + 2);
                z = z * z;
                --z;
                ar[i][j] = z + z + 1;
            }
        }
        for (int i = 0; i < 11; ++i) {
            for (int j = 0; j < 520; ++j) {
                j++;
                i++;
                ar[i][j] = (i + j) * 3 * i;
            }
        }
        for (int i = 0; i < 41; ++i) {
            for (int j = 0; j < 25; ++j) {
                int k = i + j + 1;
                arr[i][j] = k;
            }
        }
    }
}
