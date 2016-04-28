import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.function.Predicate;

public class Tmtmf1 {
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
        for (int i = 0; i < 100; ++i) {
            int sq = i * i;
            System.out.println(sq);
        }
        for (int i = 3; i < 45; ++i) {
            int sq = i * i;
            System.out.println(sq);
        }
        for (int j = 4; j < 10; ++j) {
            int sq = j * j;
            System.out.println(sq);
        }
        for (int j = 5; j < 23; ++j) {
            int sq = j * j;
            System.out.println(sq);
        }
        Calendar calendar1 = new Calendar.Builder().setLocale(Locale.CANADA).setDate(2016, 3, 10).setTimeOfDay(10, 48, 30).build();
        Calendar calendar2 = new Calendar.Builder().setLocale(Locale.CHINA).setDate(2014, 11, 20).setTimeOfDay(9, 48, 39).build();
        int i1 = (34 > 23 && 23 < 45) ? 690 : 0;
        int i2 = (35 < 43 || 36 > 45) ? 169 : 0;
        int i3 = (36 > 24 && true) ? 269 : 0;
        int i4 = (37 < 25 && 23 < 115) ? 369 : 0;
    }
}
