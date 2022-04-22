package 面向对象.接口_.接口;

public class 接口 {
    public static void main(String[] args) {
        A a = new A();
        a.hi();
        a.ok();
        System.out.println("a.age="+a.age);
        MyInterface.okk();

        System.out.println("IA.n1="+IA.n1);
//        IA.n1 = 200;

        MyInterface mi = new A();
        mi.hi();

        MyInterface[] mil = new MyInterface[2];
    }
}

interface MyInterface {
    int age = 10;

    void hi();

    default void ok() {
        System.out.println("ok...");
    }

    static void okk() {
        System.out.println("okk...");
    }
}

class A implements MyInterface {
    @Override
    public void hi() {
        System.out.println("hi()...");
    }
}

interface IA {
    int n1 = 100;
    void hi();
}

interface IB {
    void hello();
}

interface ID extends IA,IB{

}


class C implements IA, IB {

    @Override
    public void hi() {

    }

    @Override
    public void hello() {

    }
}
class D implements ID{

    @Override
    public void hi() {

    }

    @Override
    public void hello() {

    }
}
