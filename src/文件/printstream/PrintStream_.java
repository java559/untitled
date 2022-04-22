package 文件.printstream;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        out.println("hello");
        out.write("hello,world".getBytes());
        out.close();

        //修改打印输出的位置
        System.setOut(new PrintStream("C:\\Users\\destiny\\Desktop\\新建文件夹\\fff.txt"));
        System.out.println("hello");
    }
}
