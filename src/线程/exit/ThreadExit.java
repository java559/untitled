package 线程.exit;

@SuppressWarnings({"all"})
public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        t1.start();

        Thread.sleep(10 * 1000);
        t1.setLoop(false);

    }
}

@SuppressWarnings({"all"})
class T extends Thread {
    private int count = 0;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            System.out.println((++count) + " T 运行中...");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
