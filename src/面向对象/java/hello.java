package 面向对象.java;

import java.util.Random;

public class hello {
    public int a = 1;
    int b = 2;
    protected int c = 3;
    private int d = 4;


    public static void main(String[] args) {
//        int[][] map = new int[8][7];
//        int i, j;
//        for (i = 0; i < map.length; i++) {
//            for (j = 0; j < map[i].length; j++) {
//                if (i == 0 || i == 7 || j == 0 || j == 6)
//                    map[i][j] = 1;
//            }
//        }
//        map[3][1] = 1;
//        map[3][2] = 1;
//        map[2][2] = 1;
//
//        for (i = 0; i < map.length; i++) {
//            for (j = 0; j < map[i].length; j++) {
//                System.out.print(map[i][j] + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println("===============================");
//        DiGui miGong = new DiGui();
//        miGong.findWay(map, 1, 1);
//        for (i = 0; i < map.length; i++) {
//            for (j = 0; j < map[i].length; j++) {
//                System.out.print(map[i][j] + "\t");
//            }
//            System.out.println();
//        }

//        DiGui tools = new DiGui();
//        tools.hanoi(7,'A','B','C');

//        Person p1 = new Person();
//        System.out.println(p1.name+" "+p1.age);

//        People person1 = new People("Tom",18);
//        People person2 = new People("Tom",19);
//        System.out.println(person1.compareTo(person2));
//
//        System.out.println(person1.name=="Tom");
//        System.out.println(person1.name.equals("Tom"));

        System.out.println("第一题==========================");
        DuiXiang duiXiang = new DuiXiang();
        double[] a = {6.1, 3.2, 4.8, 3.5, 9.1, 77.4};
        System.out.println(duiXiang.max(a));

        System.out.println("\n第二题==========================");
        String[] b = {"tom", "smith", "jack", "mike", "ke"};
        System.out.println(duiXiang.find(b, "smith"));
        System.out.println(duiXiang.find(b, "ke"));
        System.out.println(duiXiang.find(b, "to"));

        System.out.println("\n第三题==========================");
        Book book = new Book("高数", 149.9);
        System.out.println(book.price);
        book.updatePrice();
        System.out.println(book.price);

        System.out.println("\n第四题==========================");
        int[] arr = {9, 6, 4, 3, 2, 4};
        int[] cpArr = duiXiang.copyArr(arr);
        System.out.println("原数组元素：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("\n新数组元素：");
        for (int i = 0; i < cpArr.length; i++) {
            System.out.print(cpArr[i] + "\t");
        }
        System.out.println("\n第五题==========================");
        Circle circle = new Circle(6.5);
        System.out.println("圆的周长为" + circle.L());
        System.out.println("圆的面积为" + circle.S());

        System.out.println("\n第六题==========================");
        Cale cale = new Cale(65, 24);
        System.out.println("和:" + cale.he());
        System.out.println("差:" + cale.jian());
        System.out.println("积:" + cale.cheng());
        System.out.println("商:" + cale.chu());
        Cale cale1 = new Cale(65, 0);
        System.out.println("和:" + cale1.he());
        System.out.println("差:" + cale1.jian());
        System.out.println("积:" + cale1.cheng());
        System.out.println("商:" + cale1.chu());

        System.out.println("\n第七题==========================");
        Dog dog = new Dog("旺财", "花色", 4);
        dog.show();

        System.out.println("\n第八题==========================");
        Employee employee = new Employee("tom", "male", 22, "cxy", 5000);
        employee.show();
        Employee employee1 = new Employee("smith", "female", 24);
        employee1.show();
        Employee employee2 = new Employee("qjg", 2000);
        employee2.show();

        System.out.println("\n第九题==========================");
        PassObject passObject = new PassObject();
        passObject.printArea(circle, 5);

        System.out.println("\n扩展题==========================");
        CaiQuan caiQuan = new CaiQuan();
        int dn, y = 0, s = 0, p = 0;
        for (int i = 0; i < 500; i++) {
            Random r1 = new Random();
            dn = r1.nextInt(3);
            caiQuan.suiJi();
            System.out.println("电脑:" + dn + " Tom:" + caiQuan.jsb);
            if ((dn == 0 && caiQuan.jsb == 1) || (dn == 1 && caiQuan.jsb == 2) || (dn == 2 && caiQuan.jsb == 0)) {
                s++;
            } else if (dn == caiQuan.jsb) {
                i -= 1;
                p++;
            } else {
                y++;
            }
        }
        System.out.println("赢:" + y + " 输:" + s + " 平:" + p);


    }
}

class DuiXiang {

    public double max(double[] a) {
        double temp = a[0];
        for (int i = 0; i < a.length; i++) {
            if (temp < a[i])
                temp = a[i];
        }
        return temp;
    }

    public int find(String[] b, String a) {
        int index;
        for (int i = 0; i < b.length; i++) {
            if (b[i].equals(a)) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    public int[] copyArr(int[] arr) {
        int[] ints = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ints[i] = arr[i];
        }
        return ints;
    }

}

class Book {

    String name;
    double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void updatePrice() {
        if (this.price > 150)
            this.price = 150;
        else if (this.price > 100)
            this.price = 100;
    }

}

class Circle {
    double r;

    public Circle(double r) {
        this.r = r;
    }

    public double L() {
        return 2 * Math.PI * this.r;
    }

    public double S() {
        return Math.PI * this.r * this.r;
    }

    public void huoQu(double r) {
        this.r = r;
    }

}

class PassObject {
    public void printArea(Circle c, int times) {
        System.out.println("Radius\tArea");
        for (int i = 0; i < times; i++) {
            c.huoQu(i + 1);
            System.out.println((i + 1) + "\t\t" + c.S());
        }
    }
}

class Cale {
    double num1, num2;

    public Cale(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double he() {
        return this.num1 + this.num2;
    }

    public double jian() {
        return this.num1 - this.num2;
    }

    public double cheng() {
        return this.num1 * this.num2;
    }

    public double chu() {
        if (this.num2 == 0) {
            System.out.println("除数不能为0");
            return 0;
        }
        return this.num1 / this.num2;
    }

}

class Dog {
    String name;
    String color;
    int age;

    public Dog(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void show() {
        System.out.println("名字:" + this.name + " 颜色:" + this.color + " 年龄:" + this.age);
    }

}

class Employee {
    String name, xinbie, zhiwei;
    int age, sarial;

    public Employee(String name, String xinbie, int age) {
        this.name = name;
        this.xinbie = xinbie;
        this.age = age;
    }

    public Employee(String zhiwei, int sarial) {
        this.zhiwei = zhiwei;
        this.sarial = sarial;
    }

    public Employee(String name, String xinbie, int age, String zhiwei, int sarial) {
        this(name, xinbie, age);
        this.zhiwei = zhiwei;
        this.sarial = sarial;
    }


    public void show() {
        System.out.println("名字:" + this.name + " 性别:" + this.xinbie + " 年龄:" + this.age + " 职位:" + this.zhiwei + " 薪水:" + this.sarial);
    }

}

class CaiQuan {

    int jsb;

    public void suiJi() {
        Random r = new Random();
        this.jsb = r.nextInt(3);
    }

}

class People {

    String name;
    int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean compareTo(People p) {
        return (this.name.equals(p.name) && this.age == p.age);
    }
}

class Person {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        this("jack", 100);
        System.out.println("以上是Person()构造器");
    }

    public void info() {
        System.out.println(this.hashCode());
    }

}

class DiGui {

    public void hanoi(int n, char a, char b, char c) {
        if (n == 1)
            System.out.println(a + "->" + c);
        else {
            hanoi(n - 1, a, c, b);
            System.out.println(a + "->" + c);
            hanoi(n - 1, b, a, c);
        }
    }

    public boolean findWay(int[][] map, int i, int j) {
        if (map[6][5] == 2)
            return true;
        else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (findWay(map, i + 1, j))
                    return true;
                else if (findWay(map, i, j + 1))
                    return true;
                else if (findWay(map, i - 1, j))
                    return true;
                else if (findWay(map, i, j - 1))
                    return true;
                else {
                    map[i][j] = 3;
                    return false;
                }
            } else
                return false;
        }
    }

    public int jiecheng(int n) {
        if (n == 1)
            return 1;
        else
            return jiecheng(n - 1) * n;
    }

    public int rabit_shulie(int n) {
        if (n == 1 || n == 2)
            return 1;
        else
            return rabit_shulie(n - 1) + rabit_shulie(n - 2);
    }

    public int peach(int day) {
        if (day == 10)
            return 1;
        else
            return ((peach(day + 1) + 1) * 2);
    }
}
