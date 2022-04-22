package 面向对象.OOP习题.test02;

public class test02 {

    public static void main(String[] args) {

        Teacher t1 = new Teacher("t1",24,"j1",3000);
        JiaoShou t2 = new JiaoShou("t2",45,"j2",30000);
        FuJiaoShou t3 = new FuJiaoShou("t3",35,"j3",25000);
        JiangShi t4 = new JiangShi("t4",20,"j4",2000);
        t1.introduce();
        t2.introduce();
        t3.introduce();
        t4.introduce();

    }

}
class Teacher {
    private String name;
    private int age;
    private String post;
    private double salary;

    public Teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void introduce() {
        System.out.println("name:" + getName() + " age:" + getAge() + " post:" + getPost() + " salary:" + getSalary());
    }

}

class JiaoShou extends Teacher {

    private double salaryLeven = 1.3;

    public JiaoShou(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    public double getSalaryLeven() {
        return salaryLeven;
    }

    public void setSalaryLeven(double salaryLeven) {
        this.salaryLeven = salaryLeven;
    }

    public void introduce() {
        System.out.println("name:" + getName() + " age:" + getAge() + " post:" + getPost() + " salary:" + getSalary() + " salaryLeven:" + getSalaryLeven());
    }

}

class FuJiaoShou extends Teacher {
    private double salaryLeven = 1.2;

    public FuJiaoShou(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    public double getSalaryLeven() {
        return salaryLeven;
    }

    public void setSalaryLeven(double salaryLeven) {
        this.salaryLeven = salaryLeven;
    }

    public void introduce() {
        System.out.println("name:" + getName() + " age:" + getAge() + " post:" + getPost() + " salary:" + getSalary() + " salaryLeven:" + getSalaryLeven());
    }

}

class JiangShi extends Teacher{
    private double salaryLeven = 1.1;

    public JiangShi(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    public double getSalaryLeven() {
        return salaryLeven;
    }

    public void setSalaryLeven(double salaryLeven) {
        this.salaryLeven = salaryLeven;
    }

    public void introduce() {
        System.out.println("name:" + getName() + " age:" + getAge() + " post:" + getPost() + " salary:" + getSalary() + " salaryLeven:" + getSalaryLeven());
    }

}
