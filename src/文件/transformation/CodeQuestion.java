package 文件.transformation;

import java.io.*;

public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\aaa.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String s = br.readLine();
        System.out.println(s);
        br.close();
    }
}
