public class Main {
    private static final Object mon = new Object();
    private static volatile char ch = 'A';
    private static int count = 0;

    public static void main(String[] args) {


        new Thread(() -> {
            synchronized (mon) {
                while (count < 5) {
                    if (ch != 'A') {
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        ch = 'B';
                        System.out.print('A');
                        mon.notifyAll();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (mon) {
                while (count < 5) {
                    if (ch != 'B') {
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        ch = 'C';
                        System.out.print('B');
                        mon.notifyAll();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (mon) {
                while (count < 5) {
                    if (ch != 'C') {
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        ch = 'A';
                        System.out.print('C');
                        count++;
                        mon.notifyAll();
                    }
                }
            }
        }).start();
    }
}
