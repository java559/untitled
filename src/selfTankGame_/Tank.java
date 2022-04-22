package selfTankGame_;

public class Tank {
    private int x;
    private int y;
    private int direct = 0;
    private int speed = 10;

    public void moveUp() {
        y -= speed;
        if (y < 0)
            y = 0;
    }

    public void moveRight() {
        x += speed;
        if (x > 1000 - 60)
            x = 1000 - 60;
    }

    public void moveDown() {
        y += speed;
        if (y > 750 - 60)
            y = 750 - 60;
    }

    public void moveLeft() {
        x -= speed;
        if (x < 0)
            x = 0;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
