package 事件;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings({"all"})
public class BallMove extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();

    }

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//KeyListener可以监听键盘事件
class MyPanel extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    //有字符输出时触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //某个键按下时触发
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println((char) e.getKeyCode());

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {//KeyEvent.VK_DOWN 为向下箭头
            y += 3;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y -= 3;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x -= 3;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x += 3;
        }

        this.repaint();

    }

    //某个键松开时触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
