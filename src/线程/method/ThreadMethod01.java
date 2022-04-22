package 线程.method;

@SuppressWarnings({"all"})
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("老韩");
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }
        System.out.println(t.getName()+" 线程优先级="+t.getPriority());
        t.interrupt();//中断休眠
    }
}
@SuppressWarnings({"all"})
class T extends Thread {
    @Override
    public void run() {
        while (true) {

            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " 吃包子~~~~ " + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + " 休眠中~~~");
                Thread.sleep(20 * 1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被 interrupt 了");
            }
        }
    }
}
