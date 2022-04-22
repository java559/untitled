package 文件.outputstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutStream_ {
    public static void main(String[] args) throws IOException {
        //序列化后，保存的文件格式，不是纯文本，二十按照他的格式来保存
        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\bbb.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeInt(100);
        oos.writeBoolean(true);
        oos.writeChar('a');
        oos.writeDouble(9.5);
        oos.writeUTF("韩顺平教育");

        oos.writeObject(new Dog("wangCai",20));

        oos.close();
        System.out.println("数据保存完毕(序列化形式)");

    }
}
