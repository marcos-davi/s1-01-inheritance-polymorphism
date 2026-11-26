package level1.exercise2;

public record Car(int power) {
    private static final String brand = "Toyota";
    private static String model;

    public static String getBrand() {
        return brand;
    }

    public static void setModel(String model) {
        Car.model = model;
    }

    public static String getModel() {
        return model;
    }

    public void accelerate() {
        System.out.println("The vehicle is accelerating");
    }

    public static void brake() {
        System.out.println("The vehicle is braking");
    }

}
