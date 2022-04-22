package 线程.threadUse;

@SuppressWarnings({"all"})
public class Thread03 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
    }
}
@SuppressWarnings({"all"})
class T1 implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            if (count >= 60) break;
            System.out.println((++count) + " hello world");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
@SuppressWarnings({"all"})
class T2 implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            if (count >= 60) break;
            System.out.println((++count) + " hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
