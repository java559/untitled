package 面向对象.OOP习题.test08;

public class test08 {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("张飞", '男', 30, 5);
        teacher.info();
        teacher.teach();
        System.out.println(teacher.play());


        Student student = new Student("小明", '男', 15, "00023102");
        student.info();
        student.study();
        System.out.println(student.play());

        Person[] person = new Person[4];
        person[0] = new Teacher("p0", '男', 30, 5);
        person[1] = new Teacher("p1", '男', 25, 5);
        person[2] = new Student("p3", '男', 15, "00023102");
        person[3] = new Student("p4", '男', 19, "00023102");

        Person temp = null;
        for (int i = 0; i < person.length - 1; i++) {
            for (int j = 0; j < person.length - i - 1; j++) {
                if (person[j].getAge() > person[j + 1].getAge()) {
                    temp = person[j];
                    person[j] = person[j + 1];
                    person[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].toString());
        }

        test08 test = new test08();
        for (int i = 0; i < person.length; i++) {
            test.stu_tea(person[i]);
        }


    }

    public void stu_tea(Person p) {
        if (p instanceof Student)
            ((Student) p).study();
        else if (p instanceof Teacher)
            ((Teacher) p).teach();
    }

}

class Person {
    private String name;
    private char sex;
    private int age;

    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void info() {
        System.out.println("name:" + getName() + " sex:" + getSex() + " age:" + getAge());
    }

    public String play() {
        return " ";
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}

class Student extends Person {
    private String stu_id;

    public Student(String name, char sex, int age, String stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    @Override
    public void info() {
        System.out.println("name:" + getName() + " sex:" + getSex() + " age:" + getAge() + " stu_id:" + getStu_id());
    }

    public void study() {
        System.out.println("我承诺，我会好好学习。");
    }

    @Override
    public String play() {
        return getName() + "爱玩足球";
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + getName() + '\'' +
                ", sex=" + getSex() +
                ", age=" + getAge() +
                ", stu_id='" + stu_id + '\'' +
                '}';
    }
}

class Teacher extends Person {
    private int work_age;

    public Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    @Override
    public void info() {
        System.out.println("name:" + getName() + " sex:" + getSex() + " age:" + getAge() + " stu_id:" + getWork_age());
    }

    public void teach() {
        System.out.println("我承诺，我会认真教学。");
    }

    @Override
    public String play() {
        return getName() + "爱玩象棋";
    }

    @Override
    public String toString() {
        return "Teacher{" + "name='" + getName() + '\'' +
                ", sex=" + getSex() +
                ", age=" + getAge() +
                ", work_age=" + work_age +
                '}';
    }
}


