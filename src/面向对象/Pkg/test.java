package 面向对象.Pkg;

public class test {
    public static void main(String[] args) {

        System.out.println(Circle.S(6));

    }
}

class Circle{
    private double r;
    private final static double PI = 3.14;
    public static double S(double r){
        return PI*r*r;
    }
}
