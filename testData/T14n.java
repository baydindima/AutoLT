// BiFunction<Integer, Integer, Integer> _ = (i1, i2) -> (_) ? _ : _;

import java.util.function.BiFunction;

public class T14 {
    static {
        BiFunction<Integer, Integer, Integer> biFunction0 = (i1, i2) -> (i1 > i2) ? i1 : i2;
        BiFunction<Integer, Integer, Integer> biFunction1 = (i1, i2) -> (i1 < i2) ? i2 : i1;
        BiFunction<Integer, Integer, Integer> biFunction2 = (i1, i2) -> (i1 != i2) ? i1 * 3 : i2 - 4;
        BiFunction<Integer, Integer, Integer> biFunction3 = (i1, i2) -> (i1 == i2) ? 23 + i1 : 6;
        BiFunction<Integer, Integer, Integer> biFunction4 = (i1, i2) -> (i1 > 0 && i2 < 0) ? 76 : 35;
        BiFunction<Integer, Integer, Integer> biFunction5 = (i1, i2) -> (i1 > 10 || i2 != 5) ? 57 - 67 + 799 : 10 * i2;
        BiFunction<Integer, Integer, Integer> biFunction6 = (i1, i2) -> (i1 - 7 < i2 + 6) ? i1 + 1 : 0;
        BiFunction<Integer, Integer, Integer> biFunction7 = (i1, i2) -> (i1 - 8 >= i2) ? 0 : 10;
        BiFunction<Integer, Integer, Integer> biFunction8 = (i1, i2) -> (i1 * i2 * 4 <= 0) ? i1 - 10 * (i2) : i1;
        BiFunction<Integer, Integer, Integer> biFunction9 = (i1, i2) -> (i1 >= i2) ? i2 : i2 - 49;
        BiFunction<Long, Integer, Integer> n1 = (i1, i2) -> (i1 - 8 >= i2) ? 0 : 10;
        BiFunction<Integer, Long, Integer>n2 = (i1, i2) -> (i1 * i2 * 4 <= 0) ? i1 - 10 * (i2) : i1;
        BiFunction<Integer, Integer, Long> n3 = (i1, i2) -> (i1 >= i2) ? i2 : i2 - 49;
        BiFunction<Integer, Integer, Integer> n4 = (i1, i2) -> i1 > i2 ? i1 : i2;
        BiFunction<Integer, Integer, Integer> n5 = (i, j) -> (i < j) ? i : j;
        BiFunction<Integer, Integer, Integer> n6 = (i1, i2) ->  { return (i1 != i2) ? i1 * 3 : i2 - 4; }
        BiFunction<Integer, Integer, Integer> n7;
    }
}
