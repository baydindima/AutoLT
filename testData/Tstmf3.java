import java.util.Random;
import java.util.function.Predicate;

public class Tstmf3 {
    static Predicate<Integer> predicate1 = k -> k > 0;
    static Predicate<Integer> predicate2 = k -> k < 0;

    static {
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
        } while (predicate1.test(10));
        do {
            Random random = new Random();
            int l = random.nextInt() * 1;
            System.out.println(l);
        } while (predicate2.test(11));
    }
}
