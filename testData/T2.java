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
    }
}
