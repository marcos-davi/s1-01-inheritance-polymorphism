package level2.exercise1;

public class SmartPhone extends Phone implements Camera, Clock{
    public SmartPhone(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void takePhoto() {
        System.out.println("Taking a photo with " + getBrand() + " " + getModel());
    }

    @Override
    public void alarm() {
        System.out.println("The alarm is ringing on " + getBrand() + " " + getModel());
    }
}
