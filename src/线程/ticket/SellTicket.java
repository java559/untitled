package 线程.ticket;

@SuppressWarnings({"all"})
public class SellTicket {
    public static void main(String[] args) {

//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();

//        SellTicket02 sellTicket02 = new SellTicket02();
//        new Thread(sellTicket02).start();
//        new Thread(sellTicket02).start();
//        new Thread(sellTicket02).start();

        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();

    }
}

@SuppressWarnings({"all"})
class SellTicket01 extends Thread {
    private static int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票 剩余票数=" + (--ticketNum));

        }
    }
}

@SuppressWarnings({"all"})
class SellTicket02 implements Runnable {
    private static int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票 剩余票数=" + (--ticketNum));

        }
    }
}

@SuppressWarnings({"all"})
class SellTicket03 implements Runnable {
    private static int ticketNum = 100;
    private boolean loop = true;

    public /*synchronized*/ void sell() {
        synchronized (this) {
            if (ticketNum <= 0) {
                System.out.println("售票结束");
                loop = false;
                return;
            }

//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票 剩余票数=" + (--ticketNum));
        }
    }

    @Override
    public void run() {//线程同步
        while (loop) {
            sell();
        }
    }
}
