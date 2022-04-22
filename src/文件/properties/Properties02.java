package 文件.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@SuppressWarnings({"all"})
public class Properties02 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\mysql.properties"));
        properties.list(System.out);
        System.out.println("-------------------------------");
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("user=" + user);
        System.out.println("pwd=" + pwd);
    }
}
