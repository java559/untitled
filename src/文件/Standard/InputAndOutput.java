package 文件.Standard;

import java.util.Scanner;

public class InputAndOutput {
    public static void main(String[] args) {
        System.out.println(System.in.getClass());
        System.out.println(System.out.getClass());

        Scanner input = new Scanner(System.in);
        String next = input.next();
        System.out.println("next=" + next);
    }
}
