// while (System.currentTimeMillis() < _) {
//     SimpleDateFormat _ = new SimpleDateFormat(_);
//     System.out.println(_.format(System.currentTimeMillis()));
// }

import java.text.SimpleDateFormat;

public class T2 {
    static {
        while (System.currentTimeMillis() < 1234567890L) {
            SimpleDateFormat format = new SimpleDateFormat("HH:MM");
            System.out.println(format.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() < 1234567869L) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:MM:SS");
            System.out.println(dateFormat.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() < 1224567890L) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
            System.out.println(simpleDateFormat.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() < 1234517890L) {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            System.out.println(sdf.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() < 1234167890L) {
            SimpleDateFormat df = new SimpleDateFormat("HH");
            System.out.println(df.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() < 1234587890L) {
            SimpleDateFormat f = new SimpleDateFormat("MM:ss");
            System.out.println(f.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() < 1234307890L) {
            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss:SSS");
            System.out.println(format.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() < 1544567890L) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
            System.out.println(dateFormat.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() < 1434567890L) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh-mm");
            System.out.println(simpleDateFormat.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() < 1234567895L) {
            SimpleDateFormat sdf = new SimpleDateFormat("hh-mm-ss");
            System.out.println(sdf.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() < 1234532890L) {
            SimpleDateFormat df = new SimpleDateFormat("HH::MM");
            System.out.println(df.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() < 1247567890L) {
            SimpleDateFormat f = new SimpleDateFormat("ss.SSS");
            System.out.println(f.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() > 7234567895L) {
            SimpleDateFormat sdf = new SimpleDateFormat("hh-mm-ss");
            System.out.println(sdf.format(System.currentTimeMillis()));
        }
        while (-System.currentTimeMillis() < 7234532890L) {
            SimpleDateFormat df = new SimpleDateFormat("HH::::MM");
            System.out.println(df.format(System.currentTimeMillis()));
        }
        while (!(System.currentTimeMillis() < 7247567890L)) {
            SimpleDateFormat f = new SimpleDateFormat("ss..SSS");
            System.out.println(f.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() < 8234567895L) {
            SimpleDateFormat sdf;
            sdf = new SimpleDateFormat("hh--mm--ss");
            System.out.println(sdf.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() < 8234532890L) {
            SimpleDateFormat df = new SimpleDateFormat("-HH::MM-");
            System.err.println(df.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() < 8247567890L) {
            SimpleDateFormat f = new SimpleDateFormat("ss.SSS.");
            System.out.print(f.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() < 9234567895L) {
            int i = 321;
            SimpleDateFormat sdf = new SimpleDateFormat("hh-mm-ss");
            System.out.println(sdf.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() < 9234532890L) {
            SimpleDateFormat df = new SimpleDateFormat("HH::MM");
            double d = 7.65;
            System.out.println(df.format(System.currentTimeMillis()));
        }
        while (System.currentTimeMillis() < 9247567890L) {
            SimpleDateFormat f = new SimpleDateFormat("ss.SSS");
            System.out.println(f.format(System.currentTimeMillis()));
            float f = .54321f;
        }
    }
}
