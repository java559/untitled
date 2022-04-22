package Java8新特性.方法引用与构造器引用;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1001, "mahuateng", 6000.38));
        list.add(new Employee(1002, "mayun", 9876.12));
        list.add(new Employee(1003, "liuqiangdong", 3000.82));
        list.add(new Employee(1004, "leijun", 7657.37));
        list.add(new Employee(1005, "liyanhong", 5555.32));
        list.add(new Employee(1006, "begc", 9500.43));
        list.add(new Employee(1007, "renzhengfei", 4333.32));
        list.add(new Employee(1008, "zkbg", 2500.32));

        return list;
    }
}
