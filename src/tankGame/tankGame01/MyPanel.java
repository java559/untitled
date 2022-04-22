package tankGame.tankGame01;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings({"all"})
public class MyPanel extends JPanel{
    Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        drawTank(hero.getX(), hero.getY(), g, 0, 0);
    }

    /**
     * @param x      坦克左上角x坐标
     * @param y      坦克左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向（上下左右）
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0://自己的坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌方坦克
                g.setColor(Color.yellow);
                break;
        }
        switch (direct) {
            case 0://向上
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y, x + 20, y + 30);
                break;
            default:
                System.out.println("暂时不做处理");
        }
    }

}
