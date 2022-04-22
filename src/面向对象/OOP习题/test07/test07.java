package 面向对象.OOP习题.test07;

public class test07 {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("tom",40,"waike",'m',50000);
        Doctor d2 = new Doctor("tom",40,"waike",'m',50000);
        System.out.println(d1.equals(d2));
    }
}

class Doctor {
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Doctor))
            return false;

        Doctor doctor = (Doctor) obj;
        return getName().equals(doctor.getName()) && getAge() == doctor.getAge() &&
                getJob().equals(doctor.getJob()) && getGender() == doctor.getGender() &&
                getSal() == doctor.getSal();

    }
}


