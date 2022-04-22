package 集合.Exercise;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings({"all"})
public class Exercise02 {
    public static void main(String[] args) {
        Car car = new Car("BW",400000);
        Car car1 = new Car("BL",5000000);
        ArrayList arrayList = new ArrayList();
        arrayList.add(car);
        arrayList.add(car1);
        System.out.println(arrayList);

        arrayList.remove(car1);
        System.out.println(arrayList);

        System.out.println(arrayList.contains(car));
        System.out.println(arrayList.contains(car1));

        System.out.println(arrayList.size());

        System.out.println(arrayList.isEmpty());

        arrayList.clear();
        System.out.println(arrayList.isEmpty());

        arrayList.add(car);
        arrayList.addAll(arrayList);
        System.out.println(arrayList);

        System.out.println(arrayList.containsAll(arrayList));

        arrayList.removeAll(arrayList);
        System.out.println(arrayList);

        arrayList.add(car);
        arrayList.add(car1);
        Iterator iterator = arrayList.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}

class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

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

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

