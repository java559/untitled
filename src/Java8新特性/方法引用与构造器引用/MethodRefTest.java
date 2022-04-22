package Java8新特性.方法引用与构造器引用;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefTest {
    //情况一: 对象::实例方法
    @Test
    public void test1() {
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("传统方式");

        Consumer<String> con2 = str -> System.out.println(str);
        con2.accept("lambda表达式");

        PrintStream ps = System.out;
        Consumer<String> con3 = ps::println;
        con3.accept("方法引用");

    }

    @Test
    public void test2() {
        Employee emp = new Employee(1001, "tom", 5600);

        Supplier<String> sup1 = new Supplier<String>() {
            @Override
            public String get() {
                return emp.getName();
            }
        };
        System.out.println("传统方式 " + sup1.get());

        Supplier<String> sup2 = () -> emp.getName();
        System.out.println("lambda表达式 " + sup2.get());

        Supplier<String> sup3 = emp::getName;
        System.out.println("方法引用 " + sup3.get());

    }

    //情况二: 类::静态方法
    @Test
    public void test3() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println("传统方式 " + com1.compare(12, 21));

        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println("lambda表达式 " + com2.compare(12, 21));

        Comparator<Integer> com3 = Integer::compare;
        System.out.println("方法引用 " + com3.compare(12, 21));

    }

    @Test
    public void test4() {
        Function<Double, Long> func1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println("传统方式 " + func1.apply(1.9990001));

        Function<Double, Long> func2 = d -> Math.round(d);
        System.out.println("lambda表达式 " + func2.apply(1.9990001));

        Function<Double, Long> func3 = Math::round;
        System.out.println("方法引用 " + func3.apply(1.9990001));
    }

    //情况三: 类::实例方法
    @Test
    public void test5() {
        Comparator<String> com1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("传统方式 " + com1.compare("abc", "abd"));

        Comparator<String> com2 = (s1, s2) -> s1.compareTo(s2);
        System.out.println("lambda表达式 " + com2.compare("abc", "abd"));

        Comparator<String> com3 = String::compareTo;
        System.out.println("方法引用 " + com3.compare("abc", "abd"));
    }

    @Test
    public void test6() {
        BiPredicate<String, String> pre1 = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s1, String s2) {
                return s1.equals(s2);
            }
        };
        System.out.println("传统方式 " + pre1.test("abc", "abc"));

        BiPredicate<String, String> pre2 = (s1, s2) -> s1.equals(s2);
        System.out.println("lambda表达式 " + pre2.test("abc", "abc"));

        BiPredicate<String, String> pre3 = String::equals;
        System.out.println("方法引用 " + pre3.test("abc", "abc"));
    }

    @Test
    public void test7() {
        Employee emp = new Employee(1001, "Jerry", 6000);

        Function<Employee, String> func1 = new Function<Employee, String>() {
            @Override
            public String apply(Employee employee) {
                return employee.getName();
            }
        };
        System.out.println("传统方式 " + func1.apply(emp));

        Function<Employee, String> func2 = employee -> employee.getName();
        System.out.println("lambda表达式 " + func2.apply(emp));

        Function<Employee, String> func3 = Employee::getName;
        System.out.println("方法引用 " + func3.apply(emp));

    }

}

