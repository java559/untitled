package 面向对象.内部类.成员内部类;

public class MemberInnerClass {
    public static void main(String[] args) {

        Outer outer = new Outer();
        outer.t1();

        Outer.Inner inner = outer.new Inner();
        inner.say();

        Outer.Inner inner1 = outer.getInner();
        inner1.say();


    }
}

class Outer {
    private int n1 = 10;
    public String name = "张三";

    public class Inner {
        public void say() {
            System.out.println("Outer 的 n1 = " + n1 + " Outer 的 name = " + name);
            hi();
        }
    }

    public Inner getInner(){
        return new Inner();
    }

    public void t1(){
        Inner inner = new Inner();
        inner.say();
    }

    public void hi(){
        System.out.println("hi()...");
    }
}


