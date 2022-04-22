package 面向对象.OOP习题.Homework05;

public class Homework05 {
    public static void main(String[] args) {

        Person tang = new Person("Tang", new Horse());
        tang.common();
        tang.passRiver();
        tang.passRiver();
        tang.common();
        tang.passFireMountain();

    }
}

interface Vehicles {
    void work();
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("run...");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("swim...");
    }
}

class Plane implements Vehicles{
    @Override
    public void work() {
        System.out.println("fly...");
    }
}

class VehiclesFactory {

    private VehiclesFactory(){}

    private static Horse horse = new Horse();

    public static Horse getHorse() {
        return horse;
    }

    public static Boat getBoat() {
        return new Boat();
    }

    public static Plane getPlane(){
        return new Plane();
    }
}

class Person {

    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRiver() {
        if (!(vehicles instanceof Boat)){
            vehicles = VehiclesFactory.getBoat();
            System.out.println(1);
        }
        vehicles.work();
    }


    public void common() {
        if (!(vehicles instanceof Horse)){
            vehicles = VehiclesFactory.getHorse();
            System.out.println(2);
        }
        vehicles.work();
    }

    public void passFireMountain(){
        if (!(vehicles instanceof Plane)){
            vehicles = VehiclesFactory.getPlane();
            System.out.println(3);
        }
        vehicles.work();
    }

}

