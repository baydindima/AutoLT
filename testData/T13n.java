// do {
//     Random random = new Random();
//     int _ = random.nextInt() * _;
//     System.out.println(_);
// } while (_.test(_));

import java.util.Random;
import java.util.function.Predicate;

public class T13 {
    static Predicate<Integer> predicate1 = i -> i > 0;
    static Predicate<Integer> predicate2 = i -> i < 0;
    static Predicate<Integer> predicate3 = i -> i == 0;
    static Predicate<Integer> predicate4 = i -> i != 0;

    static {
        do {
            Random random = new Random();
            int i = random.nextInt() * 69;
            System.out.println(i);
        } while (predicate1.test(0));
        do {
            Random random = new Random();
            int j = random.nextInt() * 5;
            System.out.println(j);
        } while (predicate2.test(1));
        do {
            Random random = new Random();
            int k = random.nextInt() * 2;
            System.out.println(k);
        } while (predicate3.test(2));
        do {
            Random random = new Random();
            int l = random.nextInt() * 100;
            System.out.println(l);
        } while (predicate4.test(3));
        do {
            Random random = new Random();
            int i = random.nextInt() * 690;
            System.out.println(i);
        } while (predicate1.test(4));
        do {
            Random random = new Random();
            int j = random.nextInt() * 50;
            System.out.println(j);
        } while (predicate2.test(5));
        do {
            Random random = new Random();
            int k = random.nextInt() * 20;
            System.out.println(k);
        } while (predicate3.test(6));
        do {
            Random random = new Random();
            int l = random.nextInt() * 10;
            System.out.println(l);
        } while (predicate4.test(7));
        do {
            Random random = new Random();
            int i = random.nextInt() * 169;
            System.out.println(i);
        } while (predicate1.test(8));
        do {
            Random random = new Random();
            int j = random.nextInt() * 15;
            System.out.println(j);
        } while (predicate2.test(9));
        do {
            Random random = new Random();
            int k = random.nextInt() * 12;
            System.out.println(k);
        } while (predicate3.test(10));
        do {
            Random random = new Random();
            int l = random.nextInt() * 1;
            System.out.println(l);
        } while (predicate4.test(11));
        do {
            Random random = new Random();
            int i = random.nextInt() + 1642;
            System.out.println(i);
        } while (predicate1.test(12));
        do {
            Random random = new Random();
            long j = random.nextInt() * 15;
            System.out.println(j);
        } while (predicate2.test(13));
        do {
            Random random = new Random();
            int k = random.nextInt() * 12;
            System.err.println(k);
        } while (predicate3.test(14));
        do {
            Random random = new Random();
            int l = random.nextInt() * 1;
            System.out.print(l);
        } while (predicate4.test(15));
        do {
            Random random = new Random();
            int i = random.nextInt() * 169;
            System.out.println(i);
        } while (!(predicate1.test(16)));
        do {
            Random random = new Random();
            int j = random.nextInt() * 15;
            System.out.println(j);
        } while (predicate2.negate().test(17));
        do {
            char c = 'y';
            Random random = new Random();
            int k = random.nextInt() * 12;
            System.out.println(k);
        } while (predicate3.test(18));
        do {
            Random random;
            random = new Random();
            int l = random.nextInt() * 1;
            System.out.println(l);
        } while (predicate4.test(19));
    }
}
