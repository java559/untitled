package 绘图.Tank;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings({"all"})
public class DrawTank extends JFrame {
    private MyPanel mp = null;
    public static void main(String[] args) {
        new DrawTank();
    }
    public DrawTank(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
class MyPanel extends Panel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.blue);
        g.fillRect(10,10,10,80);
        g.fillRect(50,10,10,80);
        g.setColor(Color.green);
        g.fillRect(20,25,30,50);
        g.setColor(Color.red);
        g.fillOval(20,35,30,30);
        g.setColor(Color.black);
        g.drawLine(35,10,35,50);
    }
}
