package 面向对象.Pkg;

public class FengZhuang {

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("你好你好你好");
        p.setAge(15);
        p.setSalary(10000);

        System.out.println("名字：" + p.getName() + " 年龄：" + p.getAge() + " 薪水：" + p.getSalary());


    }

}

class Person {
    public String name;
    private int age;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() < 6)
            this.name = name;
        else {
            System.out.println("名字长度不符合规则，将返回默认名字，请输入2-6个字");
            this.name = "无名小子";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18 && age <= 75)
            this.age = age;
        else {
            System.out.println("年龄不符合规则，将返回默认年龄，请输入18-75岁");
            this.age = 20;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
