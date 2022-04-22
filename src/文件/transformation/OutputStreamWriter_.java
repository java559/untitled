package 文件.transformation;

import java.io.*;

public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\fff.txt";
        String charSet = "gbk";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
        osw.write("hi,韩顺平教育");
        osw.close();
        System.out.println("保存文件成功");

    }
}
