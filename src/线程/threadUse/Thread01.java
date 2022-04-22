package 线程.threadUse;

@SuppressWarnings({"all"})
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start();

        Dog dog = new Dog();
        dog.start();

        System.out.println("主线程" + Thread.currentThread().getName());
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程 i=" + i);
            Thread.sleep(1000);
        }

    }
}

@SuppressWarnings({"all"})
class Cat extends Thread {
    int time = 0;

    @Override
    public void run() {
        while (true) {
            if (time >= 80) break;
            System.out.println((++time) + " 延时1秒 线程名=" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
@SuppressWarnings({"all"})
class Dog extends Thread {
    int time = 0;

    @Override
    public void run() {
        while (true) {
            if (time >= 80) break;
            System.out.println((++time) + " 延时1秒 " + "线程名=" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
