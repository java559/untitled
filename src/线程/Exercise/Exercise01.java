package 线程.Exercise;

import java.util.Scanner;

@SuppressWarnings({"all"})
public class Exercise01 {
    public static void main(String[] args) {
        T t = new T();
        T2 t2 = new T2(t);
        Thread thread1 = new Thread(t);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
    }
}
@SuppressWarnings({"all"})
class T implements Runnable {
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            int ran = (int) (Math.random() * 100 + 1);
            System.out.println(ran);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
@SuppressWarnings({"all"})
class T2 implements Runnable {
    private T t;
    private Scanner scanner = new Scanner(System.in);

    public T2(T t) {
        this.t = t;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入指令(Q表示退出)");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q'){
                t.setLoop(false);
                break;
            }
        }
    }
}
