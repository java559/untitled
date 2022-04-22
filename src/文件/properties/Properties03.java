package 文件.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Properties03 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("charset", "utf-8");
        properties.setProperty("user", "路飞");
        properties.setProperty("pwd", "a888");
        properties.store(new FileOutputStream("src\\mysql2.properties"), "hello,world");
        System.out.println("保存配置文件成功");
    }
}
