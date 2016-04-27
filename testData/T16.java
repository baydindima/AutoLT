// double _ = _ / Math.sqrt(2.0 * Math.PI) * Math.max(_, Math.cos(_ + 1)) - (Math.sin(_) + 1.0) / Math.min(_ - Math.E, Math.abs(_));

public class T16 {
    static {
        double a = 1.0, b = 2.0, c = 3.0, d = 4.0, e = 5.0;

        double res1 = d / Math.sqrt(2.0 * Math.PI) * Math.max(a, Math.cos(b + 1)) - (Math.sin(c) + 1.0) / Math.min(a * 3 - Math.E, Math.abs(c + 5));
        double res2 = a / Math.sqrt(2.0 * Math.PI) * Math.max(b, Math.cos(e + 1)) - (Math.sin(a) + 1.0) / Math.min(b * 4 - Math.E, Math.abs(a));
        double res3 = b / Math.sqrt(2.0 * Math.PI) * Math.max(c, Math.cos(b + 1)) - (Math.sin(b) + 1.0) / Math.min(a / 5 - Math.E, Math.abs(a));
        double res4 = d / Math.sqrt(2.0 * Math.PI) * Math.max(d, Math.cos(c + 1)) - (Math.sin(a) + 1.0) / Math.min(b / 2 - Math.E, Math.abs(e));
        double res5 = e / Math.sqrt(2.0 * Math.PI) * Math.max(e, Math.cos(b + 1)) - (Math.sin(b) + 1.0) / Math.min(c * 4 - Math.E, Math.abs(e * 3));
        double res6 = e / Math.sqrt(2.0 * Math.PI) * Math.max(a + 1, Math.cos(a + 1)) - (Math.sin(c) + 1.0) / Math.min(b - Math.E, Math.abs(c / 4));
        double res7 = b / Math.sqrt(2.0 * Math.PI) * Math.max(b + 2, Math.cos(b + 1)) - (Math.sin(d) + 1.0) / Math.min(e - Math.E, Math.abs(b));
        double res8 = d / Math.sqrt(2.0 * Math.PI) * Math.max(c + 3, Math.cos(a + 1)) - (Math.sin(c) + 1.0) / Math.min(e - Math.E, Math.abs(c));
        double res9 = a / Math.sqrt(2.0 * Math.PI) * Math.max(d - 4, Math.cos(d + 1)) - (Math.sin(e) + 1.0) / Math.min(d - Math.E, Math.abs(b));
        double res0 = b / Math.sqrt(2.0 * Math.PI) * Math.max(e - 5, Math.cos(d + 1)) - (Math.sin(d) + 1.0) / Math.min(d - Math.E, Math.abs(d - 2));
    }
}
