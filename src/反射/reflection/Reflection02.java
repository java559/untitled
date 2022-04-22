package 反射.reflection;

import java.lang.reflect.Method;

@SuppressWarnings("all")
public class Reflection02 {
    public static void main(String[] args) throws Exception {
        m1();
        m2();
        m3();
    }

    public static void m1() {

        Cat cat = new Cat();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方法调用hi() 耗时=" + (end - start));

    }

    public static void m2() throws Exception {

        Class cls = Class.forName("反射.reflection.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i++) {
            hi.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射机制调用hi() 耗时=" + (end - start));

    }

    public static void m3() throws Exception {

        Class cls = Class.forName("反射.reflection.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");

        hi.setAccessible(true);// 在反射调用方法时，取消访问检查

        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i++) {
            hi.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射机制优化后调用hi() 耗时=" + (end - start));

    }

}
