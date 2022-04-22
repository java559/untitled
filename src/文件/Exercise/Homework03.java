package 文件.Exercise;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

public class Homework03 {
    public static void main(String[] args) throws IOException {
        Dog dog = new Dog();
        Properties properties = new Properties();
        properties.load(new FileReader("src\\文件\\Exercise\\dog.properties"));
        String name = properties.getProperty("name");
        int age = Integer.parseInt(properties.getProperty("age"));
        String color = properties.getProperty("color");
        dog.setName(name);
        dog.setAge(age);
        dog.setColor(color);
        System.out.println(dog);

        String filePath = "src\\文件\\Exercise\\dog1.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(dog);
        oos.close();
        System.out.println("数据保存完毕(序列化形式)");
    }

    @Test
    public void m1() throws IOException, ClassNotFoundException {
        String filePath = "src\\文件\\Exercise\\dog1.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        System.out.println(ois.readObject());
        ois.close();
    }
}
