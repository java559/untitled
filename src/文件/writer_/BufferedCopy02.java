package 文件.writer_;

import java.io.*;

public class BufferedCopy02 {
    public static void main(String[] args) throws IOException {
        String secFilePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\tk.png";
        String destFilePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\tk4.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(secFilePath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = bis.read(buf)) != -1) {
            bos.write(buf, 0, readLen);
        }
        bis.close();
        bos.close();


    }
}
