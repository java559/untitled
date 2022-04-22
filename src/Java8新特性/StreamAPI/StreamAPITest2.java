package Java8新特性.StreamAPI;

import Java8新特性.方法引用与构造器引用.Employee;
import Java8新特性.方法引用与构造器引用.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamAPITest2 {
    //匹配与查找
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();

        //是否所有员工的薪水都大于3000
        boolean allMatch = employees.stream().allMatch(emp -> emp.getSalary() > 3000);
        System.out.println(allMatch);
        System.out.println();


        //是否存在员工薪水大于3000
        boolean anyMatch = employees.stream().anyMatch(emp -> emp.getSalary() > 3000);
        System.out.println(anyMatch);
        System.out.println();


        //是否存在员工姓雷
        boolean noneMatch = employees.stream().noneMatch(emp -> emp.getName().startsWith("lei"));
        System.out.println(!noneMatch);
        System.out.println();


        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        System.out.println();


        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);
        System.out.println();


        //薪水大于5000的人数
        long count = employees.stream().filter(emp -> emp.getSalary() > 5000).count();
        System.out.println(count);
        System.out.println();


        //返回工资最大值
        Stream<Double> salaryStream = employees.stream().map(employee -> employee.getSalary());
        Optional<Double> max = salaryStream.max(Double::compare);
//        Optional<Double> max = salaryStream.max(new Comparator<Double>() {
//            @Override
//            public int compare(Double o1, Double o2) {
//                return Double.compare(o1, o2);
//            }
//        });
        System.out.println(max);
        System.out.println();


        //返回最低工资的员工
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        System.out.println(min);
        System.out.println();


        employees.stream().forEach(System.out::println);
//        employees.stream().forEach(new Consumer<Employee>() {
//            @Override
//            public void accept(Employee employee) {
//                System.out.println(employee);
//            }
//        });
        System.out.println();


        //使用集合的遍历操作
        employees.forEach(System.out::println);

    }

    //归约
    @Test
    public void test2() {
        //计算1-10的自然数之和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
//        Integer reduce = list.stream().reduce(0, new BinaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer integer, Integer integer2) {
//                return integer + integer2;
//            }
//        });
        System.out.println(reduce);
        System.out.println();

        //计算公司中所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
        Optional<Double> reduce1 = salaryStream.reduce(Double::sum);
//        Optional<Double> reduce1 = salaryStream.reduce(new BinaryOperator<Double>() {
//            @Override
//            public Double apply(Double aDouble, Double aDouble2) {
//                return aDouble + aDouble2;
//            }
//        });
        System.out.println(reduce1);

    }

    //收集
    @Test
    public void test3() {
        //查找工资大于6000的员工，结果返回一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();

        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);
        System.out.println();

        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);
        System.out.println();

        Collection<Employee> employeeCollection = employees.stream().filter(e -> e.getSalary() > 6000)
                .collect(Collectors.toCollection(ArrayList::new));
        employeeCollection.forEach(System.out::println);

    }
}
