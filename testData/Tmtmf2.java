import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.function.Predicate;

public class Tmtmf2 {
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
        for (int k = 0; k < 100; ++k) {
            int sq = k * k;
            System.out.println(sq);
        }
        Calendar calendar3 = new Calendar.Builder().setLocale(Locale.FRANCE).setDate(2015, 3, 30).setTimeOfDay(8, 49, 40).build();
        Calendar calendar4 = new Calendar.Builder().setLocale(Locale.GERMANY).setDate(2016, 3, 15).setTimeOfDay(7, 48, 20).build();
        Calendar calendar5 = new Calendar.Builder().setLocale(Locale.UK).setDate(2013, 5, 16).setTimeOfDay(6, 24, 30).build();
        Calendar calendar6 = new Calendar.Builder().setLocale(Locale.US).setDate(2006, 3, 17).setTimeOfDay(10, 25, 20).build();
        int i5 = (38 > 26) ? 469 : 0;
        int i6 = (39 < 27) ? 569 : 0;
    }
}
