package selfTankGame_;

import java.util.Vector;

public class Hero extends Tank {
    //    Shot[] shots = new Shot[100];
    Vector<Shot> shots = new Vector<>();
    public static int count = 0;

    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotEnemyTank() {
        switch (getDirect()) {
            case 0:
                shots.add(new Shot(getX() + 20, getY(), 0));
                count++;
                new Thread(shots.get(count - 1)).start();
                break;
            case 1:
                shots.add(new Shot(getX() + 60, getY() + 20, 1));
                count++;
                new Thread(shots.get(count - 1)).start();
                break;
            case 2:
                shots.add(new Shot(getX() + 20, getY() + 60, 2));
                count++;
                new Thread(shots.get(count - 1)).start();
                break;
            case 3:
                shots.add(new Shot(getX(), getY() + 20, 3));
                count++;
                new Thread(shots.get(count - 1)).start();
                break;
        }
//        new Thread(shot).start();
    }
}

