package 面向对象.OOP习题.test04;

public class test04 {
    public static void main(String[] args) {

//        Worker p1 = new Worker("p1",2000);
//        p1.printSalary();
//
//        Peasant p2 = new Peasant("p2",1000);
//        p2.printSalary();
//
//        Waiter p3 = new Waiter("p3",3500);
//        p3.printSalary();
//
//        Teacher p4 = new Teacher("p4",5000,120,100);
//        p4.printSalary();
//
//        Scientist p5 = new Scientist("p5",10000,888888);
//        p5.printSalary();

        YuanGong[] p = new YuanGong[5];
        p[0] = new Worker("p1",2000);
        p[0].printSalary();
        p[1] = new Peasant("p2",1000);
        p[1].printSalary();
        p[2] = new Waiter("p3",3500);
        p[2].printSalary();
        p[3] = new Teacher("p4",5000,120,100);
        p[3].printSalary();
        p[4] = new Scientist("p5",10000,888888);
        p[4].printSalary();

    }


}

class YuanGong {
    private String name;
    private double salary;
    private int salaryMonth = 12;

    public YuanGong(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSalaryMonth() {
        return salaryMonth;
    }

    public void setSalaryMonth(int salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    public void printSalary() {
        System.out.println("name:" + getName() + " salary:" + (getSalary() * getSalaryMonth()));
    }

}

class Worker extends YuanGong {
    public Worker(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printSalary() {
        super.printSalary();
    }
}

class Peasant extends YuanGong {
    public Peasant(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printSalary() {
        super.printSalary();
    }
}

class Waiter extends YuanGong {
    public Waiter(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printSalary() {
        super.printSalary();
    }
}

class Teacher extends YuanGong {
    private int classDay;
    private double classSal;

    public Teacher(String name, double salary, int classDay, double classSal) {
        super(name, salary);
        this.classDay = classDay;
        this.classSal = classSal;
    }

    public int getClassDay() {
        return classDay;
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    @Override
    public void printSalary() {
        System.out.println("name:" + getName() + " salary:" + (getSalary() * getSalaryMonth() + getClassSal() * getClassDay()));
    }

}

class Scientist extends YuanGong{
    private double bonus;

    public Scientist(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void printSalary() {
        System.out.println("name:" + getName() + " salary:" + (getSalary() * getSalaryMonth() + getBonus()));
    }
}

