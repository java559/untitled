//package tankGame.tankGame05;
//
//import javax.swing.*;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class HspTankGame05 extends JFrame {
//    MyPanel mp = null;
//    Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) throws IOException {
//        new HspTankGame05();
//    }
//
//    public HspTankGame05() throws IOException {
//        System.out.println("请输入选择 1: 新游戏 2: 继续上局");
//        String key = scanner.next();
//        mp = new MyPanel(key);
//        Thread thread = new Thread(mp);
//        thread.start();
//        this.add(mp);
//        this.setSize(1300, 750);
//        this.addKeyListener(mp);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
//
//        this.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
////                System.out.println("监听到关闭窗口了---------------------------------------------------------------");
//                try {
//                    Recorder.keepRecord();
//                } catch (IOException ioException) {
//                    ioException.printStackTrace();
//                }
//                System.exit(0);
//            }
//        });
//
//    }
//}
//
