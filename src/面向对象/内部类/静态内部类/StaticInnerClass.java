package 面向对象.内部类.静态内部类;

public class StaticInnerClass {
    public static void main(String[] args) {

        Outer outer = new Outer();
        outer.m1();

        Outer.Inner inner = new Outer.Inner();
        inner.say();

        Outer.Inner inner1 = outer.gerInner();
        inner1.say();

        Outer.Inner inner2 = Outer.gerInner_();
        inner2.say();

    }
}

class Outer {
    private int n1 = 10;
    private static String name = "张三";

    public static class Inner {
        private static String name = "李四";

        public void say() {
            System.out.println("name = " + name + " Outer.name = " + Outer.name);
        }
    }

    public Inner gerInner() {
        return new Inner();
    }

    public static Inner gerInner_() {
        return new Inner();
    }

    public void m1() {
        Inner inner = new Inner();
        inner.say();
    }
}
