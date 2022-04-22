package tankGame.tankGame04;

import java.util.Vector;

@SuppressWarnings({"all"})
public class EnemyTank extends Tank implements Runnable {
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {

            if (isLive && shots.size() < 1000) {
                Shot s = null;
                switch (getDirect()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        s.speed = 10;
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        s.speed = 10;
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 30, 2);
                        s.speed = 10;
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20, 3);
                        s.speed = 10;
                        break;
                }
                shots.add(s);
                new Thread(s).start();
            }

            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 10; i++) {
                        if (getY() > 0)
                            moveUp();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 10; i++) {
                        if (getX() + 60 < 1000)
                            moveRight();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 10; i++) {
                        if (getY() + 60 < 750)
                            moveDown();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 10; i++) {
                        if (getX() > 0)
                            moveLeft();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }


            setDirect((int) (Math.random() * 4));
            if (!isLive) {
                break;
            }
        }
    }
}
