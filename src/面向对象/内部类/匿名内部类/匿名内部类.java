package 面向对象.内部类.匿名内部类;

public class 匿名内部类 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.method();
    }
}

class Outer{
    private int n1 = 10;
    public void method(){
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("老虎叫唤");
            }
        };
        System.out.println("tiger的运行类型 = "+tiger.getClass());
        tiger.cry();

        Father father = new Father("jack"){
            @Override
            public void test() {
                System.out.println("匿名内部类重写的test方法");
            }
        };
        System.out.println("father 对象的运行类型 = "+father.getClass());
        father.test();

        Animal animal = new Animal() {
            @Override
            void eat() {
                System.out.println("小狗吃骨头...");
            }
        };
        System.out.println("animal 对象的运行类型 = "+animal.getClass());
        animal.eat();

    }
}

interface IA{
    void cry();
}

class Father{
    public Father(String name){
        System.out.println("接收到 name = "+name);
    }
    public void test(){}
}

abstract class Animal{
    abstract void eat();
}


