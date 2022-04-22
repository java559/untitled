package 面向对象.Pkg;

public class Extends {
    public static void main(String[] args) {

        Graduate graduate = new Graduate("大明", 20);
        graduate.name = "大明";
        graduate.age = 20;
        graduate.testing();
        graduate.setScore(59);
        graduate.showInfo();

        System.out.println("-----------------");

        Pupil pupil = new Pupil("小明", 10);
        pupil.name = "小明";
        pupil.age = 10;
        pupil.testing();
        pupil.setScore(100);
        pupil.showInfo();

        System.out.println("-----------------");

        Pupil pupil2 = new Pupil("小李", 12);
        pupil2.testing();
        pupil2.setScore(80);
        pupil2.showInfo();


    }
}

class Student {
    public String name;
    public int age;
    private double score;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void showInfo() {
        System.out.println("学生名：" + name + " 年龄：" + age + " 得分：" + score);
    }

}


class Graduate extends Student {
    public Graduate(String name, int age) {
        super("", 0);
        this.name = name;
        this.age = age;
    }

    public void testing() {
        System.out.println("大学生" + name + "正在考高数");
    }
}

class Pupil extends Student {
    public Pupil(String name, int age) {
        super("tom", 20);
        this.name = name;
        this.age = age;
    }

    public void testing() {
        System.out.println("小学生" + name + "正在考数学");
    }
}
