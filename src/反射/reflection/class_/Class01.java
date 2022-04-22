package 反射.reflection.class_;

import 反射.reflection.Cat;

@SuppressWarnings("all")
public class Class01 {
    public static void main(String[] args) throws Exception {

        Cat cat = new Cat();
        System.out.println(cat.hashCode());

        Class cls1 = Class.forName("反射.reflection.Cat");
        Class cls2 = Class.forName("反射.reflection.Cat");
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());

    }
}
