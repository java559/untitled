package 集合.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class MapExercise {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("123456", new Employee("tom", 50000, "123456"));
        map.put("123457", new Employee("to1", 5001, "123457"));
        map.put("123458", new Employee("to2", 50002, "123458"));
        Set keySet = map.keySet();
        for (Object key : keySet) {
            Employee emp = (Employee) map.get(key);
            if (emp.getSal()>18000)
                System.out.println(key + "-" + map.get(key));
        }
        System.out.println("-----------------------------------------------------------");

        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Employee emp = (Employee) map.get(key);
            if (emp.getSal()>18000)
                System.out.println(key + "-" + map.get(key));
        }
        System.out.println("-----------------------------------------------------------");

        Set entrySet = map.entrySet();
        for (Object entry : entrySet) {
            Map.Entry m = (Map.Entry) entry;
            Employee emp = (Employee) m.getValue();
            if (emp.getSal()>18000)
                System.out.println(m.getKey() + "-" + m.getValue());
        }

    }
}

class Employee {
    private String name;
    private double sal;
    private String id;

    public Employee(String name, double sal, String id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id='" + id + '\'' +
                '}';
    }
}
