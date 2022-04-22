package 泛型.CustomGeneric_;

public class CustomGeneric_ {
    public static void main(String[] args) {

    }
}

class Tiger<T, R, M> {
    String name;
    R r;
    M m;
    T t;
//    T[] ts = new T[8];
    T[] ts;

//    public static void m1(M m){}

    public Tiger(String name, R r, M m, T t) {
        this.name = name;
        this.r = r;
        this.m = m;
        this.t = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
