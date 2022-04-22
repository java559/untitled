package 反射.reflection;

import java.lang.reflect.Method;

@SuppressWarnings("all")
public class ReflecAccessMethod {
    public static void main(String[] args) throws Exception {

        Class<?> bossCls = Class.forName("反射.reflection.Boss");
        Object o = bossCls.newInstance();

        Method hi = bossCls.getDeclaredMethod("hi", String.class);
        hi.invoke(o, "韩顺平教育");

        Method say = bossCls.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);
        System.out.println(say.invoke(o, 100, "张三", '男'));
        System.out.println(say.invoke(null, 200, "张三", '男'));

        //在反射中，如果方法有返回值，统一返回 Object , 但是运行类型和方法定义的返回类型一致
        Object reVal = say.invoke(null, 300, "李四", '女');
        System.out.println("reVal 的运行类型=" + reVal.getClass());


    }
}

class Boss {
    public int age;
    private static String name;

    public Boss() {
    }

    private static String say(int n, String s, char c) {
        return n + " " + s + " " + c;
    }

    public void hi(String s) {
        System.out.println("hi " + s);
    }

}
