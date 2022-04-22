package 文件.reader_;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings({"all"})
public class FileReader_ {
    public static void main(String[] args) {


    }

    @Test
    public void readFile01() throws IOException {
        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\ddd.txt";
        FileReader fileReader = new FileReader(filePath);
        int data = 0;
        while ((data = fileReader.read()) != -1) {
            System.out.print((char) data);
        }
        if (fileReader != null) {
            fileReader.close();
        }
    }

    @Test
    public void readFile02() throws IOException {
        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\ddd.txt";
        FileReader fileReader = new FileReader(filePath);
        int readLen = 0;
        char[] buf = new char[8];
        while ((readLen = fileReader.read(buf)) != -1) {
            System.out.print(new String(buf, 0, readLen));
        }
        if (fileReader != null) {
            fileReader.close();
        }
    }
}
