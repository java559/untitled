package 面向对象.Static;

public class test {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(Child.count++);
        }
        Child.print();
    }
}

class Child{
    public static int count = 0;
    public static void print(){
        System.out.println("helloWorld");
    }
}

