package 反射.reflection;

@SuppressWarnings("all")
public class Car {

    public String brand = "BW";
    public int price = 1000000;
    public String color = "white";

//    public Car(){}
//    public Car(String brand){
//        this.brand = brand;
//    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
