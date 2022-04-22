package 泛型;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings({"all"})
public class Exercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("tom", 5000, new MyDate(4, 16, 2001)));
        list.add(new Employee("mike", 10000, new MyDate(8, 17, 2005)));
        list.add(new Employee("mike", 10000, new MyDate(8, 18, 2005)));
        list.add(new Employee("hsp", 7000, new MyDate(3, 26, 1991)));
        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (!(o1 instanceof Employee && o2 instanceof Employee))
                    return 0;

                int t = o1.getName().compareTo(o2.getName());
                if (t != 0)
                    return t;

                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        System.out.println(list);
    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate implements Comparable<MyDate>{
    private int month, day, year;

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        int year = this.year - o.getYear();
        if (year != 0)
            return year;

        int month = this.month - o.getMonth();
        if (month != 0)
            return month;

        return day - o.getDay();
    }
}