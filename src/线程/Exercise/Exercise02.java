package 线程.Exercise;

public class Exercise02 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        new Thread(t3).start();
        new Thread(t3).start();
        new Thread(t3).start();
    }
}

class T3 implements Runnable {
    public static int money = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (money <= 0) {
                    break;
                }
                money -= 100;
                System.out.println(Thread.currentThread().getName() + "取一千块，当前还剩余 " + money);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
