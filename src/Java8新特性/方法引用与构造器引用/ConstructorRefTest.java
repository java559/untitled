package Java8新特性.方法引用与构造器引用;

import Java8新特性.方法引用与构造器引用.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorRefTest {
    //构造器引用
    @Test
    public void test1() {
        Supplier<Employee> sup1 = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println("传统方式 " + sup1.get().getName());

        Supplier<Employee> sup2 = () -> new Employee();
        System.out.println("lambda表达式 " + sup2.get().getName());

        Supplier<Employee> sup3 = Employee::new;
        System.out.println("方法引用 " + sup3.get().getName());
    }

    @Test
    public void test2() {
        Function<Integer, Employee> func1 = new Function<Integer, Employee>() {
            @Override
            public Employee apply(Integer integer) {
                return new Employee(integer);
            }
        };
        Employee employee1 = func1.apply(1001);
        System.out.println("传统方式 " + employee1);

        Function<Integer, Employee> func2 = integer -> new Employee(integer);
        Employee employee2 = func2.apply(1002);
        System.out.println("lambda表达式 " + employee2);

        Function<Integer, Employee> func3 = Employee::new;
        Employee employee3 = func3.apply(1003);
        System.out.println("方法引用 " + employee3);
    }

    @Test
    public void test3() {
        BiFunction<Integer, String, Employee> func1 = new BiFunction<Integer, String, Employee>() {
            @Override
            public Employee apply(Integer integer, String s) {
                return new Employee(integer, s);
            }
        };
        System.out.println("传统方式 " + func1.apply(1001, "tom"));

        BiFunction<Integer, String, Employee> func2 = (integer, s) -> new Employee(integer, s);
        System.out.println("lambda表达式 " + func2.apply(1002, "smith"));

        BiFunction<Integer, String, Employee> func3 = Employee::new;
        System.out.println("方法引用 " + func3.apply(1003, "jack"));
    }

    //数组引用
    @Test
    public void test4() {
        Function<Integer, String[]> func1 = new Function<Integer, String[]>() {
            @Override
            public String[] apply(Integer integer) {
                return new String[integer];
            }
        };
        String[] arr1 = func1.apply(5);
        System.out.println("传统方式 " + Arrays.toString(arr1));

        Function<Integer, String[]> func2 = integer -> new String[integer];
        String[] arr2 = func2.apply(5);
        System.out.println("lambda表达式 " + Arrays.toString(arr2));

        Function<Integer, String[]> func3 = String[]::new;
        String[] arr3 = func3.apply(5);
        System.out.println("方法引用 " + Arrays.toString(arr3));

    }

}
