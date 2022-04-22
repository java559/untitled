package 文件.transformation;

import java.io.*;

public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\aaa.txt";
//        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
//        BufferedReader br = new BufferedReader(isr);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "gbk"));
        String s = br.readLine();
        while (s != null) {
            System.out.println(s);
            s = br.readLine();
        }

        br.close();
    }
}
