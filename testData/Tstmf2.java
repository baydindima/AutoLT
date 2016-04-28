import java.util.Random;
import java.util.function.Predicate;

public class Tstmf2 {
    static Predicate<Integer> predicate3 = j -> j == 0;
    static Predicate<Integer> predicate4 = j -> j != 0;

    static {
        do {
            Random random = new Random();
            int i = random.nextInt() * 690;
            System.out.println(i);
        } while (predicate3.test(4));
        do {
            Random random = new Random();
            int j = random.nextInt() * 50;
            System.out.println(j);
        } while (predicate4.test(5));
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
    }
}
