package 面向对象.内部类.匿名内部类;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.f1();
        System.out.println("main outer02.hashcode = "+outer02.hashCode());

    }
}

class Outer02{
    private int n1 = 99;
    public void f1(){
        Person p = new Person(){
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了 hi()方法");
            }
            @Override
            public void ok(String name) {
                super.ok(name);
            }
        };
        p.hi();
        p.ok("jack");

        new Person() {
            int n1 = 88;
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了 hi()方法,哈哈哈");
                System.out.println("n1 = "+n1);
                System.out.println("外部类的 n1 = "+Outer02.this.n1);
                System.out.println("Outer02.this.hashcode = "+Outer02.this.hashCode());
            }
        }.hi();

    }

}

class Person{
    public void hi(){
        System.out.println("Person hi()...");
    }
    public void ok(String name){
        System.out.println("Person ok()..." + name);
    }
}

