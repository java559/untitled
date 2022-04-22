package 泛型;

import java.util.*;

@SuppressWarnings({"all"})
public class Exercise01 {
    public static void main(String[] args) {
        Student stu1 = new Student("stu1", 18);
        Student stu2 = new Student("stu2", 19);
        Student stu3 = new Student("stu3", 17);

        HashSet<Student> set = new HashSet<Student>();
        set.add(stu1);
        set.add(stu2);
        set.add(stu3);
        System.out.println(set);
        System.out.println("---------------------------------------------");
        for (Student stu : set) {
            System.out.println(stu);
        }
        System.out.println("---------------------------------------------");
        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()) {
            Student stu = iterator.next();
            System.out.println(stu);
        }
        System.out.println("---------------------------------------------");

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put(stu1.name, stu1.age);
        map.put(stu2.name, stu2.age);
        map.put(stu3.name, stu3.age);
        System.out.println(map);


        System.out.println("---------------------------------------------");
        Set<String> strings = map.keySet();
        for (String stu : strings) {
            System.out.println(stu + "-" + map.get(stu));
        }
        System.out.println("---------------------------------------------");
        Iterator<String> iterator1 = strings.iterator();
        while (iterator1.hasNext()) {
            String stu = iterator1.next();
            System.out.println(stu + "-" + map.get(stu));
        }

        System.out.println("---------------------------------------------");
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator2 = entries.iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, Integer> next = iterator2.next();
            System.out.println(next + "-" + map.get(next));

        }

    }
}

class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
