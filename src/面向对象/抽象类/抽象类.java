package 面向对象.抽象类;

public class 抽象类 {
    public static void main(String[] args) {
        new CommonEmployee("a1", 1, 1000).work();
        new Manager("a2", 2, 2000, 10000).work();
    }
}

abstract class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract void work();

}

class CommonEmployee extends Employee {

    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    public void work() {
        System.out.println("普通员工" + getName() + "工作中");
    }

}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void work() {
        System.out.println("经理" + getName() + "工作中");
    }
}