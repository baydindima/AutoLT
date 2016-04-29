// Calendar _ = new Calendar.Builder().setLocale(Locale._).setDate(_, _, _).setTimeOfDay(_, _, _).build();

import java.util.Calendar;
import java.util.Locale;

public class T11 {
    static {
        Calendar calendar1 = new Calendar.Builder().setLocale(Locale.CANADA).setDate(2016, 3, 10).setTimeOfDay(10, 48, 30).build();
        Calendar calendar2 = new Calendar.Builder().setLocale(Locale.CHINA).setDate(2014, 11, 20).setTimeOfDay(9, 48, 39).build();
        Calendar calendar3 = new Calendar.Builder().setLocale(Locale.FRANCE).setDate(2015, 3, 30).setTimeOfDay(8, 49, 40).build();
        Calendar calendar4 = new Calendar.Builder().setLocale(Locale.GERMANY).setDate(2016, 3, 15).setTimeOfDay(7, 48, 20).build();
        Calendar calendar5 = new Calendar.Builder().setLocale(Locale.UK).setDate(2013, 5, 16).setTimeOfDay(6, 24, 30).build();
        Calendar calendar6 = new Calendar.Builder().setLocale(Locale.US).setDate(2006, 3, 17).setTimeOfDay(10, 25, 20).build();
        Calendar calendar7 = new Calendar.Builder().setLocale(Locale.ITALY).setDate(2009, 8, 18).setTimeOfDay(5, 48, 10).build();
        Calendar calendar8 = new Calendar.Builder().setLocale(Locale.JAPAN).setDate(2010, 3, 9).setTimeOfDay(3, 48, 38).build();
        Calendar calendar9 = new Calendar.Builder().setLocale(Locale.KOREA).setDate(2011, 2, 2).setTimeOfDay(3, 18, 30).build();
        Calendar calendar0 = new Calendar.Builder().setLocale(Locale.TAIWAN).setDate(2017, 1, 1).setTimeOfDay(1, 8, 33).build();
        Calendar n1 = new Calendar.Builder().setDate(2006, 32, 10).setTimeOfDay(10, 48, 30).build();
        Calendar n2 = new Calendar.Builder().setLocale(Locale.FRANCE).setDate(2015, 9, 30).build();
        Calendar n3 = new Calendar.Builder().setLocale(Locale.GERMANY).setTimeOfDay(9, 48, 20).setDate(2016, 2, 15).build();
}
