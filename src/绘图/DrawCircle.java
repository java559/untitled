package 绘图;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings({"all"})
public class DrawCircle extends JFrame{

    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel{

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        System.out.println("paint()被调用");
        //画圆(椭圆)
        g.drawOval(10,10,100,100);
        //画直线
        g.drawLine(10,10,110,110);
        //画矩形边框
        g.drawRect(10,10,100,100);
        //填充矩形
        g.setColor(Color.blue);
        g.fillRect(120,10,100,100);
        //填充圆(椭圆)
        g.setColor(Color.red);
        g.fillOval(120,10,100,100);
        //画图片
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.png"));
        g.drawImage(image,230,10,175,221,this);
        //画字符串
        g.setColor(Color.pink);
        g.setFont(new Font("隶书",Font.BOLD,50));
        g.drawString("北京你好",10,150);

    }
}
