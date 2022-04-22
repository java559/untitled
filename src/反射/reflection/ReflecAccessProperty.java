package 反射.reflection;

import java.lang.reflect.Field;

@SuppressWarnings("all")
public class ReflecAccessProperty {
    public static void main(String[] args) throws Exception {

        Class<?> stuClass = Class.forName("反射.reflection.Student");

        Object o = stuClass.newInstance();
        System.out.println(o.getClass());

        Field age = stuClass.getField("age");
        age.set(o, 88);
        System.out.println(o);
        System.out.println(age.get(o));

        Field name = stuClass.getDeclaredField("name");
        name.setAccessible(true);//暴破，操作 private
        name.set(o, "老");
        name.set(null,"老韩");//只有static才能用null
        System.out.println(o);
        System.out.println(name.get(o));
        System.out.println(name.get(null));

    }
}

class Student {
    public int age;
    private static String name;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }
}
