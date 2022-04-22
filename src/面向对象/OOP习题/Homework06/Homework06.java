package 面向对象.OOP习题.Homework06;

public class Homework06 {
    public static void main(String[] args) {
        Car car = new Car(58);
        car.new Air().flow();

        Car car1 = new Car(25);
        car1.new Air().flow();

        Car car2 = new Car(-55);
        car2.getAir().flow();

    }
}

class Car {
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public class Air {
        public void flow() {
            if (Car.this.temperature > 40) {
                System.out.println("吹冷气");
            } else if (Car.this.temperature < 0) {
                System.out.println("吹暖气");
            } else {
                System.out.println("关空调");
            }
        }
    }

    public Air getAir(){
        return new Air();
    }

}


