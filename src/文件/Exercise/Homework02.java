package 文件.Exercise;

import java.io.*;

public class Homework02 {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\ddd.txt";
        String charset = "utf-8";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), charset));
        String s = "";
        int i = 1;
        while ((s = br.readLine()) != null) {
            System.out.println((i++) + " " + s);
        }
        br.close();
    }
}
