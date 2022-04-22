package 文件.file;

import org.junit.jupiter.api.Test;

import java.io.File;

@SuppressWarnings({"all"})
public class Directory_ {
    public static void main(String[] args) {

    }

    @Test
    public void m1() {
        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\aaa.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("文件不存在");
        }
    }

    @Test
    public void m2() {
        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\bbb.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("目录不存在");
        }
    }

    @Test
    public void m3() {
        String directoryPath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\a\\b\\c";
        File file = new File(directoryPath);
        if (file.exists()) {
            System.out.println(directoryPath + "存在...");
        } else {
            if (file.mkdirs()) { //创建多级目录
                System.out.println(directoryPath + "创建成功...");
            } else {
                System.out.println(directoryPath + "创建失败...");
            }
        }
    }
}
