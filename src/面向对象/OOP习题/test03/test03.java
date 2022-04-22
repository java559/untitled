package 面向对象.OOP习题.test03;

public class test03 {
    public static void main(String[] args) {

        BuMenJingLi p1 = new BuMenJingLi("p1",200,30);
        PuTongYuanGong p2 = new PuTongYuanGong("p2",120,60);
        p1.printGZ();
        p2.printGZ();

    }
}

class YuanGong {
    private String name;
    private double danSalary;
    private int days;

    public YuanGong(String name, double danSalary, int days) {
        this.name = name;
        this.danSalary = danSalary;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDanSalary() {
        return danSalary;
    }

    public void setDanSalary(double danSalary) {
        this.danSalary = danSalary;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void printGZ() {
        double GZ = getDanSalary() * getDays();
        System.out.println("salary:" + GZ);
    }

}

class BuMenJingLi extends YuanGong{
    private double leven = 1.2;

    public BuMenJingLi(String name, double danSalary, int days) {
        super(name, danSalary, days);
    }

    public double getLeven() {
        return leven;
    }

    public void setLeven(double leven) {
        this.leven = leven;
    }

    public void printGZ() {
        double GZ = 1000 + getDanSalary() * getDays() * getLeven();
        System.out.println("salary:" + GZ);
    }
}

class PuTongYuanGong extends YuanGong{
    private double leven = 1.0;

    public PuTongYuanGong(String name, double danSalary, int days) {
        super(name, danSalary, days);
    }

    public double getLeven() {
        return leven;
    }

    public void setLeven(double leven) {
        this.leven = leven;
    }

    public void printGZ() {
        double GZ = getDanSalary() * getDays() * getLeven();
        System.out.println("salary:" + GZ);
    }

}

