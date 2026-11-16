package level1.exercise2;

public class Car {
    private static final String BRAND = "Toyota";
    private static String model;
    private final int power;


    public Car(int power) {
        this.power = power;
    }

    public static String getBRAND() {
        return BRAND;
    }

    public static void setModel(String model) {
        Car.model = model;
    }

    public static String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public  void accelerate(){
        System.out.println("The vehicle is accelerating");
    }

    public static void brake(){
        System.out.println("The vehicle is braking");
    }

}
