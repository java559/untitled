package 文件.outputstream;

import net.sf.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressWarnings({"all"})
public class FileOutputStream01 {
    public static void main(String[] args) {

    }

    @Test
    public void writeFile01() throws IOException {

        JSONObject json = new JSONObject();
        json.put("username","zhangSan");
        json.put("password","123456");

        String filePath = "C:\\Users\\destiny\\Desktop\\IOStudy\\index.json";
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);//覆盖
//        fileOutputStream.write('H');

        String str = json.toString();
//        fileOutputStream.write(str.getBytes());
        fileOutputStream.write(str.getBytes(), 0, str.length());
        fileOutputStream.close();

    }

    @Test
    public void writeFile02() throws IOException {

        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\ccc.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);//追加
        String str = "HI,WORLD";
        fileOutputStream.write(str.getBytes(), 0, str.length());
        fileOutputStream.close();

    }
}
