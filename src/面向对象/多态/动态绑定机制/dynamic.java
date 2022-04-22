package 面向对象.多态.动态绑定机制;

public class dynamic {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.sum());//30
        System.out.println(a.sum1());//20
    }
}

class A {
    public int i = 10;

    public int sum() {
        return getl() + 10;
    }

    public int sum1() {
        return i + 10;
    }

    public int getl() {
        return i;
    }
}

class B extends A {
    public int i = 20;

//    public int sum() {
//        return i + 20;
//    }

    public int getl() {
        return i;
    }

//    public int sum1() {
//        return i + 10;
//    }
}
