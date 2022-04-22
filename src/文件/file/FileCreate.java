package 文件.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

@SuppressWarnings({"all"})
public class FileCreate {
    public static void main(String[] args) {

    }

    @Test
    public void create01() throws IOException {
        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\aaa.txt";
        File file = new File(filePath);
        file.createNewFile();
        System.out.println("文件创建成功");
    }

    @Test
    public void create02() throws IOException {
        File parentFile = new File("C:\\Users\\destiny\\Desktop\\新建文件夹\\");
        String fileName = "bbb.txt";
        File file1 = new File(parentFile, fileName);
        file1.createNewFile();
        System.out.println("文件创建成功");
    }

    @Test
    public void create03() throws IOException {
        String parentPath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\";
        String fileName = "ccc.txt";
        File file = new File(parentPath, fileName);
        file.createNewFile();
        System.out.println("文件创建成功");
    }

}
