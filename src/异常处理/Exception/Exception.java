package 异常处理.Exception;

import java.util.Scanner;

public class Exception {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1;
        while(true){
            try{
                n1 = Integer.parseInt(input.next());
                break;
            }catch (java.lang.Exception e){
                System.out.println(e.getMessage());
            }

        }
        System.out.println(n1);
    }
}

