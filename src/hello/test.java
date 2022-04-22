package hello;

import java.util.*;

public class test {
    public static void main(String[] args) {

//        Thread thread1 = new Thread(new A());
//        Thread thread2 = new Thread(new A());
//        Thread thread3 = new Thread(new A());
//        Thread thread4 = new Thread(new A());
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();

//        A a = new A();
//        new Thread(a).start();
//        new Thread(a).start();
//        new Thread(a).start();
//        new Thread(a).start();

        String s = "http://img1.qunarzz.com/piao/fusion/1801/1a/94428c6dea109402.jpg_640x200_2cf590d8.jpg";
        System.out.println(s.length());

    }

}

class A implements Runnable {
    private static int i = 1;
    private boolean loop = true;

    public synchronized void print() {

        if (i > 100) {
            loop = false;
            return;
        }
        System.out.println(i++);

    }

    @Override
    public void run() {
        while (loop) {
            print();
        }
    }
}

class F implements Runnable {
    public static int i = 0;

    @Override
    public void run() {
        while (i < 20) {
            System.out.println((++i) + "线程2 " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class G implements Runnable {
    public static int i = 0;

    @Override
    public void run() {
        while (i < 20) {
            System.out.println((++i) + "线程3 " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
