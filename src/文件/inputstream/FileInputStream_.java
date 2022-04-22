package 文件.inputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SuppressWarnings({"all"})
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() throws IOException {//效率低，不能读取中文字符

        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\ccc.txt";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        int readData = 0;
        while ((readData = fileInputStream.read()) != -1) {
            System.out.print((char) readData);
        }
        fileInputStream.close();

    }

    @Test
    public void readFile02() throws IOException {//效率高

        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\ccc.txt";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        int readLen = 0;
        byte[] buf = new byte[8];
        while ((readLen = fileInputStream.read(buf)) != -1) {
            System.out.print(new String(buf, 0, readLen));
        }
        fileInputStream.close();

    }
}
