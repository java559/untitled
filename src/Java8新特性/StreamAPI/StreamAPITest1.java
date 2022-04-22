package Java8新特性.StreamAPI;

import Java8新特性.方法引用与构造器引用.Employee;
import Java8新特性.方法引用与构造器引用.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamAPITest1 {
    //筛选与切片
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();

        //查询员工薪资大于7000的员工信息
        //filter(Predicate p)
//        stream.filter(new Predicate<Employee>() {
//            @Override
//            public boolean test(Employee employee) {
//                return employee.getSalary() > 7000;
//            }
//        });
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
        System.out.println();

        //limit(n)
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();

        //skip(n)
        list.stream().skip(3).forEach(System.out::println);
        System.out.println();

        //distinct(n)
        list.add(new Employee(1010, "liuqiangdong", 8000));
        list.add(new Employee(1010, "liuqiangdong", 8000));
        list.add(new Employee(1010, "liuqiangdong", 8000));
        list.add(new Employee(1010, "liuqiangdong", 8000));
        list.add(new Employee(1010, "liuqiangdong", 8000));
        list.add(new Employee(1010, "liuqiangdong", 8000));
        list.add(new Employee(1010, "liuqiangdong", 8000));
        list.add(new Employee(1010, "liuqiangdong", 8000));
        list.stream().distinct().forEach(System.out::println);
    }

    //映射
    @Test
    public void test2() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");

        //map(Function f)
//        list.stream().map(new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s.toUpperCase();
//            }
//        }).forEach(System.out::println);
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
//        list.stream().map(String::toUpperCase).forEach(System.out::println);

        //获取员工姓名长度大于6的员工姓名
        List<Employee> employees = EmployeeData.getEmployees();
//        Stream<String> stringStream = employees.stream().map(str -> str.getName());
        Stream<String> nameStream = employees.stream().map(Employee::getName);
//        nameStream.filter(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.length() > 6;
//            }
//        }).forEach(System.out::println);
        nameStream.filter(s -> s.length() > 6).forEach(System.out::println);
        System.out.println();

        //取出list中每一个字符
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
//        Stream<Stream<Character>> streamStream = list.stream().map(new Function<String, Stream<Character>>() {
//            @Override
//            public Stream<Character> apply(String s) {
//                return fromStringToStream(s);
//            }
//        });
        streamStream.forEach(characterStream -> characterStream.forEach(System.out::println));
//        streamStream.forEach(new Consumer<Stream<Character>>() {
//            @Override
//            public void accept(Stream<Character> characterStream) {
//                characterStream.forEach(new Consumer<Character>() {
//                    @Override
//                    public void accept(Character character) {
//                        System.out.println(character);
//                    }
//                });
//            }
//        });
        System.out.println();


        //flatMap(Function f)
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out::println);


    }

    //将字符串中多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3() {
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

//        list1.add(list2);
        list1.addAll(list2);
        System.out.println(list1);
    }

    //排序
    @Test
    public void test4() {
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        list.stream().sorted().forEach(System.out::println);

        //抛异常
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted(
                (e1,e2) -> Double.compare(e1.getSalary(),e2.getSalary())
        ).forEach(System.out::println);
//        employees.stream().sorted(
//                new Comparator<Employee>() {
//                    @Override
//                    public int compare(Employee o1, Employee o2) {
//                        return Double.compare(o1.getSalary(), o2.getSalary());
//                    }
//                }
//        ).forEach(System.out::println);

    }
}
