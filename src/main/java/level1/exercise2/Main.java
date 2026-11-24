package level1.exercise2;

public class Main {
    public static void main(String[] args) {
        Car.brake();
        Car.setModel("Corolla");
        System.out.println(Car.getModel());


        Car car1 = new Car(150);
        Car car2 = new Car(200);
        System.out.println("Car1: " + Car.getBrand() + " " + Car.getModel() + " " + car1.getPower());
        car1.accelerate();
        Car.setModel("Camry");
        System.out.println("Car2: " + Car.getBrand() + " " + Car.getModel() + " " + car2.getPower());
        System.out.println("Car1: " + Car.getBrand() + " " + Car.getModel() + " " + car1.getPower());
        car2.accelerate();

    }
}
