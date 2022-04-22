package 泛型.CustomGeneric_;


import java.util.ArrayList;

@SuppressWarnings({"all"})
public class CustomMethodGeneric_ {
    public static void main(String[] args) {
        new Car().fly("BW", 5.5f);
        new Fish<String, ArrayList>().hello(new ArrayList(),15.5f);
    }
}

class Car {
    public <T, R> void fly(T t, R r) {
        System.out.println(t.getClass());
        System.out.println(r.getClass());
    }
}

class Fish<T, R> {
    public <U, M> void eat(U u, M m) {
    }

    public void hi(T t) {
    }

    public <K> void hello(R r,K k){
        System.out.println(r.getClass());
        System.out.println(k.getClass());
    }
}
