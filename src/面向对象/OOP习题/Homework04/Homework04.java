package 面向对象.OOP习题.Homework04;

public class Homework04 {
    public static void main(String[] args) {
        new A();
    }
}

class A {
    private String NAME = "tom";

    {
        class B {
            private final String NAME = "jack";

            public void show() {
                System.out.println("NAME = " + NAME);
                System.out.println("A.this.NAME = " + A.this.NAME);
            }
        }
        new B().show();
    }
}


