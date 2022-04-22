package 面向对象.多态.多态参数;

public class PloyParameter {
    public static void main(String[] args) {

        Worker tom = new Worker("tom", 3500);
        Manager milan = new Manager("milan", 8000, 88888);
        PloyParameter ployParameter = new PloyParameter();
        ployParameter.showEmpAnnual(tom);
        ployParameter.showEmpAnnual(milan);
        ployParameter.testWork(tom);
        ployParameter.testWork(milan);

        tom.equals(milan);
        "aaa".equals("bbb");

        String a = "aaa";
        String b = "aaa";
        System.out.println(a == b);

    }

    public void showEmpAnnual(Employee e) {
        System.out.println(e.getAnnual());
    }

    public void testWork(Employee e) {
        if (e instanceof Worker) {
            ((Worker) e).work();
        } else if (e instanceof Manager) {
            ((Manager) e).manage();
        }
    }

}

class Employee {
    private String name;
    private double salary;


    public Employee(String name, double salary) {
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

    public double getAnnual() {
        return 12 * getSalary();
    }

}

class Worker extends Employee {

    public Worker(String name, double salary) {
        super(name, salary);
    }

    public void work() {
        System.out.println(getName() + " is working.");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }

}

class Manager extends Employee {

    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return this.bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void manage() {
        System.out.println(getName() + " is managing.");
    }

    public double getAnnual() {
        return super.getAnnual() + getBonus();
    }

}


