// try (Scanner _ = new Scanner(_)) {
//     while (_.hasNext()) {
//         _
//     }
// } catch (IOException e) {
//     _
// }

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class T3 {
    static {
        try (Scanner sc = new Scanner(Paths.get("/d1/d2/d3/file.in"))) {
            while (sc.hasNext()) {
                System.out.print(sc.next().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Scanner scanner = new Scanner(Paths.get("fff.in"))) {
            while (scanner.hasNext()) {
                System.out.println("next");
            }
        } catch (IOException e) {
            System.out.println(e);
            System.out.println(e);
        }
        try (Scanner s = new Scanner(Paths.get("la.la"))) {
            while (s.hasNext()) {
                int i = s.next().length() + 1;
                --i;
                System.err.print(i);
                System.exit(32);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        try (Scanner scan = new Scanner(Paths.get("trw.in"))) {
            while (scan.hasNext()) {
                int k = 69;
                --k;
                --k;
                k = k + 3;
            }
        } catch (IOException e) {
            int j = 69;
            System.exit(j);
        }
        try (Scanner scnr = new Scanner(Paths.get("la/fff.file"))) {
            while (scnr.hasNext()) {
                double pi = Math.PI;
                double piSqrt = Math.sqrt(pi);
                System.out.print(piSqrt);
            }
        } catch (IOException e) {
            String msg = e.getMessage();
            System.err.println(msg);
        }
        try (Scanner sc = new Scanner(Paths.get("/d1/d2/file.in"))) {
            while (sc.hasNext()) {
                System.out.print(sc.next().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Scanner scanner = new Scanner(Paths.get("ff.in"))) {
            while (scanner.hasNext()) {
                System.out.println("next");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        try (Scanner s = new Scanner(Paths.get("lalala"))) {
            while (s.hasNext()) {
                int i = s.next().length();
                ++i;
                System.out.print(i);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        try (Scanner scan = new Scanner(Paths.get("trw.in"))) {
            while (scan.hasNext()) {
                int k = 0;
                ++k;
                ++k;
                k = k + 1;
            }
        } catch (IOException e) {
            int i = 69;
            System.exit(i);
        }
        try (Scanner scn = new Scanner(Paths.get("la/fff.file"))) {
            while (scn.hasNext()) {
                double pi = Math.PI;
                double a = Math.sqrt(pi);
            }
        } catch (IOException e) {
            String msg = e.getMessage();
            System.err.println(msg);
        }
    }
}
