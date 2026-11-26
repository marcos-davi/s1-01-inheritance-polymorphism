package level2.exercise1;

public class Phone {
    private final String brand;
    private final String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }


    public String getModel() {
        return model;
    }


    public void call(String phoneNumber) {
        System.out.println("Calling " + phoneNumber + " from " + brand + " " + model);
    }
}
