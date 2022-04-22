package 面向对象.Pkg;

public class overRide {
    public static void main(String[] args) {

        Person1 person1 = new Person1("大明", 24);
        person1.say();

        Student1 student1 = new Student1("小明", 18);
        student1.say();

    }
}

class Person1{
    String name;
    private int age;

    public Person1(){}

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void say(){
        System.out.println("name=" + name + " age=" + age);
    }

}

class Student1 extends Person1{
    String name;
    private int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void say(){
        System.out.println("name=" + name + " age=" + age);
    }

}

