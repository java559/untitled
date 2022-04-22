package selfTankGame_;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener, Runnable {
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 9;

    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {
        hero = new Hero(100, 100);
        hero.setSpeed(20);

        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 10);
            enemyTank.setDirect(2);
            new Thread(enemyTank).start();
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            new Thread(shot).start();
            enemyTanks.add(enemyTank);
        }

        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);

        for (int i = 0; i < hero.shots.size(); i++) {
            if (hero.shots.get(i) != null && hero.shots.get(i).isLive) {
                g.fillOval(hero.shots.get(i).x, hero.shots.get(i).y, 7, 7);
            }
        }

        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    if (shot.isLive) {
                        g.fillOval(shot.x, shot.y, 7, 7);
                    } else {
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }

        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            bomb.lifeDown();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }

    }

    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
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
            case 1://向右
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2://向下
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 60, x + 20, y + 30);
                break;
            case 3://向左
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("暂时不做处理");
        }

    }

    public void hitTank(Shot s, EnemyTank enemyTank) {
        if (enemyTank.isLive) {
            switch (enemyTank.getDirect()) {
                case 0:
                case 2:
                    if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40 && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60) {
                        s.isLive = false;
                        enemyTank.isLive = false;
                        enemyTanks.remove(enemyTank);
                        Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                        bombs.add(bomb);
                    }
                    break;
                case 1:
                case 3:
                    if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60 && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40) {
                        s.isLive = false;
                        enemyTank.isLive = false;
                        enemyTanks.remove(enemyTank);
                        Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                        bombs.add(bomb);
                    }
                    break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.shotEnemyTank();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            System.out.println("发射子弹数量=" + hero.shots.size());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < hero.shots.size(); i++) {
                if (hero.shots.get(i).isLive) {
                    for (int j = 0; j < enemyTanks.size(); j++) {
                        EnemyTank enemyTank = enemyTanks.get(j);
                        hitTank(hero.shots.get(i), enemyTank);
                    }
                }
            }

            this.repaint();
        }
    }
}
