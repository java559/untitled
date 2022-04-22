package 线程.method;

@SuppressWarnings("all")
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();

        for (int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程 吃了 " + i + " 个包子");
            if (i==5){
                System.out.println("主线程让子线程先吃~~~~~~");
//                t2.join();//线程插队
                Thread.yield();//线程礼让，不一定成功
                System.out.println("子线程吃完主线程接着吃~~~~~~~");
            }
        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("子线程 吃了 " + i + " 个包子");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
