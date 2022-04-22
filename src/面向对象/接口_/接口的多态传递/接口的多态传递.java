package 面向对象.接口_.接口的多态传递;

public class 接口的多态传递 {
    public static void main(String[] args) {
        IB ib = new Person();
        IA ia = new Person();

        new E().px();
    }
}

interface IA{
    void hi();
}
interface IB extends IA{}
class Person implements IB{
    @Override
    public void hi() {
        System.out.println("hi()...");
    }
}



interface IC{
    int x = 1;
}
class D{
    int x = 2;
}
class E extends D implements IC{
    public void px(){
        System.out.println("super.x = "+super.x);
        System.out.println("IC.x = "+IC.x);
    }
}

