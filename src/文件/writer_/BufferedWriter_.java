package 文件.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\aaa.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));

        bufferedWriter.write("hello, 韩顺平教育!");
        bufferedWriter.newLine();  //插入一个和系统相关的换行符
        bufferedWriter.write("hi, 韩顺平教育!");
        bufferedWriter.newLine();

        bufferedWriter.close();
        System.out.println("写入完毕");
    }
}
