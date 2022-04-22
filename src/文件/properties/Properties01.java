package 文件.properties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Properties01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] split = line.split("=");
            if ("ip".equals(split[0]))
                System.out.println(split[0] + "=" + split[1]);
        }
        br.close();
    }
}
