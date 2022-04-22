package 文件.inputstream;

import 文件.outputstream.Dog;

import java.io.*;

public class ObjectInputStream_{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "C:\\Users\\destiny\\Desktop\\新建文件夹\\bbb.dat";//指定反序列化的文件
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        //读取的顺序必须和保存顺序一致
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object dog = ois.readObject();
        System.out.println(dog.getClass());
        System.out.println(dog);

        Dog dog2 = (Dog) dog;
        System.out.println(dog2.getName());
        System.out.println(dog2.getAge());

        ois.close();

    }
}
