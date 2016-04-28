import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.function.Predicate;

public class Tmtmf3 {
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
        for (int i = 30; i < 1000; ++i) {
            int sq = i * i;
            System.out.println(sq);
        }
        for (int j = 20; j < 10000; ++j) {
            int sq = j * j;
            System.out.println(sq);
        }
        Calendar calendar7 = new Calendar.Builder().setLocale(Locale.ITALY).setDate(2009, 8, 18).setTimeOfDay(5, 48, 10).build();
        Calendar calendar8 = new Calendar.Builder().setLocale(Locale.JAPAN).setDate(2010, 3, 9).setTimeOfDay(3, 48, 38).build();
        Calendar calendar9 = new Calendar.Builder().setLocale(Locale.KOREA).setDate(2011, 2, 2).setTimeOfDay(3, 18, 30).build();
        Calendar calendar0 = new Calendar.Builder().setLocale(Locale.TAIWAN).setDate(2017, 1, 1).setTimeOfDay(1, 8, 33).build();
        int i7 = (67 > 28 && false) ? 669 : 0;
        int i8 = (31 < 29 || 25 < 45) ? 769 : 0;
        int i9 = (32 < 20 && 26 > 45 || true) ? 869 : 0;
        int i0 = (36 < 10 && 27 > 45) ? 969 : 0;
    }
}
