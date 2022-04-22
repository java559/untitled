package 多态数组;

public class PloyArray {
    public static void main(String[] args) {
        Person[] person = new Person[5];
        person[0] = new Person("柯总", 21);
        person[1] = new Student("jia", 18, 59);
        person[2] = new Student("yi", 20, 80);
        person[3] = new Teacher("bing", 40, 2000);
        person[4] = new Teacher("ding", 24, 20000);

        for (int i = 0; i < 5; i++) {
            System.out.println(person[i].say());

            if (person[i] instanceof Student) {
                ((Student) person[i]).study();
            } else if (person[i] instanceof Teacher) {
                ((Teacher) person[i]).teach();
            }
        }

    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    public String say() {
        return name + " " + age;
    }
}

class Student extends Person {
    double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String say() {
        return getName() + " " + getAge() + " " + getScore();
    }

    public void study() {
        System.out.println(getName() + " is studying");
    }
}

class Teacher extends Person {
    double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String say() {
        return getName() + " " + getAge() + " " + getSalary();
    }

    public void teach() {
        System.out.println(getName() + " is teaching");
    }
}


