package 面向对象.内部类.局部内部类;

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println("outer 的 hashcode = " + outer.hashCode());
        outer.m1();
    }
}

class Outer {
    private int n1 = 100;

    private void m2() {
        System.out.println("私有方法 m2()");
    }

    public void m1() {
        int n1 = 800;       // 在 Inner 这个局部内部类里，如何访问这里的 n1 ?
        final class Inner {
            private int n1 = 900;

            public void f1() {
                System.out.println("n1 = " + n1);
                System.out.println("外部类的 n1 = " + Outer.this.n1);
                System.out.println("Outer.this 的 hashcode = " + Outer.this.hashCode());
                m2();
            }
        }
        new Inner().f1();
//        class Inner02 extends Inner{}
    }
}

