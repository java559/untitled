package 面向对象.OOP习题.Homework03;

public class Homework03 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new Computer() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        }, 1, 2);
    }
}

interface Computer {
    double work(double n1, double n2);
}

class Cellphone {
    public void testWork(Computer computer, double n1, double n2) {
        double result = computer.work(n1, n2);
        System.out.println(result);
    }
}


