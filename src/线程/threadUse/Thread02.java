package 线程.threadUse;

@SuppressWarnings({"all"})
public class Thread02 {
    public static void main(String[] args) throws InterruptedException {
        Dog2 dog2 = new Dog2();
        Thread thread = new Thread(dog2);
        thread.start();

        System.out.println("主线程" + Thread.currentThread().getName());
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程 i=" + i);
            Thread.sleep(1000);
        }
    }
}

@SuppressWarnings({"all"})
class Dog2 implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            if (count >= 80) break;
            System.out.println((++count) + " 延时1秒 线程名=" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
