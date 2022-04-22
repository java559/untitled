package 面向对象.Pkg;

import java.util.Arrays;
import 面向对象.java.hello;

public class PkgStudy {
    public static void main(String[] args) {
        int[] arr = {9, 4, 8, 33, 6, 2, -8, 5};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();

        hello h = new hello();
        System.out.println(h.a);


    }
}
