package 常用类.Math;

import sun.applet.Main;

public class Math01 {
    public static void main(String[] args) {

        System.out.println(Math.ceil(3.1));
        System.out.println(Math.floor(3.1));
        System.out.println(Math.floor(-3.1));
        System.out.println(Math.sqrt(2));

        int ran;
        for (int i = 0; i < 10; i++) {
            ran = (int) (Math.random() * 6 + 2);
            System.out.print(ran + "\t");
        }
        System.out.println();

        int min = Math.min(2, 9);
        int max = Math.max(6, 8);
        System.out.println(min + "\t" + max);

    }
}
