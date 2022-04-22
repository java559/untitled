package 线程.method;

@SuppressWarnings({"all"})
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();

        for (int i = 1; i <= 10; i++) {
            System.out.println("hi");
            Thread.sleep(1000);
        }
    }
}

@SuppressWarnings({"all"})
class MyDaemonThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("hello world");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
