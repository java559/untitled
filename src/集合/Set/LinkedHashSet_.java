package 集合.Set;

import java.util.LinkedHashSet;
import java.util.Objects;

@SuppressWarnings({"all"})
public class LinkedHashSet_ {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        System.out.println(linkedHashSet.add(new Car("tom",1000)));
        System.out.println(linkedHashSet.add(new Car("oooo",123000)));
        System.out.println(linkedHashSet.add(new Car("oooo",123990)));
        System.out.println(linkedHashSet.add(new Car("tom",1000)));
        System.out.println(linkedHashSet);
    }
}

class Car{
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
