// new Thread(new Runnable() {
//     @Override
//     public void run() {
//         f(_);
//     }
// }).start();

public class T5 {
    static {
        new Thread(new Runnable() {
            @Override
            public void run() {
                f(1);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                f(2);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                f(3);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                f(4);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                f(5);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                f(6);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                f(7);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                f(8);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                f(9);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                f(10);
            }
        }).start();
    }

    static void f(int arg) {}
}