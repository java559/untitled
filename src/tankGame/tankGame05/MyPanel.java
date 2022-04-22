//package tankGame.tankGame05;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.io.IOException;
//import java.util.Vector;
//
//@SuppressWarnings({"all"})
//public class MyPanel extends JPanel implements KeyListener, Runnable {
//    Hero hero = null;
//    Vector<EnemyTank> enemyTanks = new Vector<>();
//    Vector<Node> nodes = new Vector<>();
//    Vector<Bomb> bombs = new Vector<>();
//    int enemyTankSize = 9;
//
//    Image image1 = null;
//    Image image2 = null;
//    Image image3 = null;
//
//    public MyPanel(String key) throws IOException {
//        nodes = Recorder.getNodesAndEnemyTankRecord();
//        Recorder.setEnemyTanks(enemyTanks);
//        hero = new Hero(100, 500);
//        hero.setSpeed(30);
//
//        switch (key) {
//            case "1":
//                for (int i = 0; i < enemyTankSize; i++) {
//                    EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 10);
//                    enemyTank.setEnemyTanks(enemyTanks);
//                    enemyTank.setDirect(2);
//                    new Thread(enemyTank).start();
//                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
//                    shot.speed = 10;
//                    enemyTank.shots.add(shot);
//                    new Thread(shot).start();
//                    enemyTanks.add(enemyTank);
//                }
//                break;
//            case "2":
//                for (int i = 0; i < nodes.size(); i++) {
//                    Node node = nodes.get(i);
//                    EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY());
//                    enemyTank.setEnemyTanks(enemyTanks);
//                    enemyTank.setDirect(node.getDirect());
//                    new Thread(enemyTank).start();
//                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
//                    shot.speed = 10;
//                    enemyTank.shots.add(shot);
//                    new Thread(shot).start();
//                    enemyTanks.add(enemyTank);
//                }
//                break;
//            default:
//                System.out.println("输入有误");
//        }
//
//
//        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
//        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
//        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
//
//    }
//
//    public void showInfo(Graphics g) {
//        g.setColor(Color.BLACK);
//        Font font = new Font("宋体", Font.BOLD, 25);
//        g.setFont(font);
//
//        g.drawString("您累积击毁敌方坦克", 1020, 30);
//        drawTank(1020, 60, g, 0, 0);
//
//        g.setColor(Color.BLACK);
//        g.drawString(Recorder.getAllEnemyTankNum() + "", 1080, 100);
//    }
//
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        g.fillRect(0, 0, 1000, 750);
//        showInfo(g);
//
//        if (hero != null && hero.isLive) {
//            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
//        }
//
//        for (int i = 0; i < hero.shots.size(); i++) {
//            Shot shot = hero.shots.get(i);
//            if (shot != null && shot.isLive == true) {
//                g.fill3DRect(shot.x, shot.y, 3, 3, false);
//            } else {
//                hero.shots.remove(shot);
//            }
//        }
//
//        for (int i = 0; i < bombs.size(); i++) {
//            Bomb bomb = bombs.get(i);
//            if (bomb.life > 6) {
//                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
//            } else if (bomb.life > 3) {
//                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
//            } else {
//                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
//            }
//            bomb.lifeDown();
//            if (bomb.life == 0) {
//                bombs.remove(bomb);
//            }
//
//        }
//
//
//        for (int i = 0; i < enemyTanks.size(); i++) {
//            EnemyTank enemyTank = enemyTanks.get(i);
//
//            if (enemyTank.isLive) {
//                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
//
//                for (int j = 0; j < enemyTank.shots.size(); j++) {
//                    Shot shot = enemyTank.shots.get(j);
//                    if (shot.isLive) {
//                        g.fill3DRect(shot.x, shot.y, 3, 3, false);
//                    } else {
//                        enemyTank.shots.remove(shot);
//                    }
//                }
//            }
//        }
//    }
//
//    /**
//     * @param x      坦克左上角x坐标
//     * @param y      坦克左上角y坐标
//     * @param g      画笔
//     * @param direct 坦克方向（上下左右）
//     * @param type   坦克类型
//     */
//    public void drawTank(int x, int y, Graphics g, int direct, int type) {
//
//        switch (type) {
//            case 0://自己的坦克
//                g.setColor(Color.cyan);
//                break;
//            case 1://敌方坦克
//                g.setColor(Color.yellow);
//                break;
//        }
//
//        //0:上  1:右  2:下  3:左
//        switch (direct) {
//            case 0://向上
//                g.fill3DRect(x, y, 10, 60, false);
//                g.fill3DRect(x + 30, y, 10, 60, false);
//                g.fill3DRect(x + 10, y + 10, 20, 40, false);
//                g.fillOval(x + 10, y + 20, 20, 20);
//                g.drawLine(x + 20, y, x + 20, y + 30);
//                break;
//            case 1://向右
//                g.fill3DRect(x, y, 60, 10, false);
//                g.fill3DRect(x, y + 30, 60, 10, false);
//                g.fill3DRect(x + 10, y + 10, 40, 20, false);
//                g.fillOval(x + 20, y + 10, 20, 20);
//                g.drawLine(x + 30, y + 20, x + 60, y + 20);
//                break;
//            case 2://向下
//                g.fill3DRect(x, y, 10, 60, false);
//                g.fill3DRect(x + 30, y, 10, 60, false);
//                g.fill3DRect(x + 10, y + 10, 20, 40, false);
//                g.fillOval(x + 10, y + 20, 20, 20);
//                g.drawLine(x + 20, y + 60, x + 20, y + 30);
//                break;
//            case 3://向左
//                g.fill3DRect(x, y, 60, 10, false);
//                g.fill3DRect(x, y + 30, 60, 10, false);
//                g.fill3DRect(x + 10, y + 10, 40, 20, false);
//                g.fillOval(x + 20, y + 10, 20, 20);
//                g.drawLine(x + 30, y + 20, x, y + 20);
//                break;
//            default:
//                System.out.println("暂时不做处理");
//        }
//
//    }
//
//    public void hitHero() {
////        for (int i = 0; i < enemyTanks.size(); i++) {
////            EnemyTank enemyTank = enemyTanks.get(i);
////            for (int j = 0; j < enemyTank.shots.size(); j++) {
////                Shot shot = enemyTank.shots.get(j);
////                if (hero.isLive && shot.isLive) {
////                    hitTank(shot, hero);
////                }
////            }
////        }
//    }
//
//    public void hitEnemyTank() {
//        for (int j = 0; j < hero.shots.size(); j++) {
//            Shot shot = hero.shots.get(j);
//
//            if (shot != null && shot.isLive) {
//                for (int i = 0; i < enemyTanks.size(); i++) {
//                    EnemyTank enemyTank = enemyTanks.get(i);
//                    hitTank(shot, enemyTank);
//                }
//            }
//        }
//    }
//
//    public void hitTank(Shot s, Tank tank) {
//        if (tank.isLive) {
//            switch (tank.getDirect()) {
//                case 0:
//                case 2:
//                    if (s.x > tank.getX() && s.x < tank.getX() + 40 && s.y > tank.getY() && s.y < tank.getY() + 60) {
//                        s.isLive = false;
//                        tank.isLive = false;
//                        enemyTanks.remove(tank);
//                        if (tank instanceof EnemyTank) {
//                            Recorder.addAllEnemyTankNum();
//                        }
//                        Bomb bomb = new Bomb(tank.getX(), tank.getY());
//                        bombs.add(bomb);
//                    }
//                    break;
//                case 1:
//                case 3:
//                    if (s.x > tank.getX() && s.x < tank.getX() + 60 && s.y > tank.getY() && s.y < tank.getY() + 40) {
//                        s.isLive = false;
//                        tank.isLive = false;
//                        enemyTanks.remove(tank);
//                        if (tank instanceof EnemyTank) {
//                            Recorder.addAllEnemyTankNum();
//                        }
//                        Bomb bomb = new Bomb(tank.getX(), tank.getY());
//                        bombs.add(bomb);
//                    }
//                    break;
//            }
//        }
//    }
//
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_W) {
//            hero.setDirect(0);
//            if (hero.getY() > 0)
//                hero.moveUp();
//        } else if (e.getKeyCode() == KeyEvent.VK_D) {
//            hero.setDirect(1);
//            if (hero.getX() + 60 < 1000)
//                hero.moveRight();
//        } else if (e.getKeyCode() == KeyEvent.VK_S) {
//            hero.setDirect(2);
//            if (hero.getY() + 60 < 750)
//                hero.moveDown();
//        } else if (e.getKeyCode() == KeyEvent.VK_A) {
//            hero.setDirect(3);
//            if (hero.getX() > 0)
//                hero.moveLeft();
//        }
//        if (e.getKeyCode() == KeyEvent.VK_J) {
////            if (hero.shot == null || !hero.shot.isLive)
////                hero.shotEnemyTank();
//            hero.shotEnemyTank();
//        }
//        this.repaint();
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            hitEnemyTank();
//            hitHero();
//
//            this.repaint();
//        }
//    }
//}
