import java.util.Random;
import java.util.function.Predicate;

public class Tstmf1 {
    static Predicate<Integer> predicateT = i -> true;
    static Predicate<Integer> predicateF = i -> false;

    static {
        do {
            Random random = new Random();
            int i = random.nextInt() * 69;
            System.out.println(i);
        } while (predicateT.test(0));
        do {
            Random random = new Random();
            int j = random.nextInt() * 5;
            System.out.println(j);
        } while (predicateF.test(1));
        do {
            Random random = new Random();
            int k = random.nextInt() * 2;
            System.out.println(k);
        } while (predicateT.test(2));
        do {
            Random random = new Random();
            int l = random.nextInt() * 100;
            System.out.println(l);
        } while (predicateF.test(3));
    }
}
