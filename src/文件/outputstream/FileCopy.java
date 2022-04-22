package 文件.outputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressWarnings({"all"})
public class FileCopy {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\tk.png";
        String filePathCopy = "C:\\Users\\destiny\\Desktop\\新建文件夹\\tk3.png";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(filePathCopy);
        int readLen = 0;
        byte[] buf = new byte[1024];
        while ((readLen = fileInputStream.read(buf)) != -1) {
            fileOutputStream.write(buf, 0, readLen);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
