package 反射.reflection;

import java.lang.reflect.Constructor;

@SuppressWarnings("all")
public class ReflecCreateInstance {
    public static void main(String[] args) throws Exception {

        Class<?> userClass = Class.forName("反射.reflection.User");

        //通过public无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);

        //通过public有参构造器创建实例
        Constructor<?> constructor = userClass.getConstructor(String.class);
        Object hsp = constructor.newInstance("hsp");
        System.out.println("hsp=" + hsp);

        //通过非public有参数构造器创建实例
        Constructor<?> constructor1 = userClass.getDeclaredConstructor(int.class, String.class);
        constructor1.setAccessible(true);//暴破[暴力破解]，使用反射可以访问 private 构造器/方法/属性
        Object user2 = constructor1.newInstance(20, "张三");
        System.out.println(user2);

    }
}

class User {
    private int age = 10;
    private String name = "韩顺平教育";

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}