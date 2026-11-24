package level1.exercise1;

public abstract class Instrument {
    private String name;
    private double price;

    { System.out.println("Initializing an Instrument instance"); }

    public Instrument(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void play();

    public static void playing(String name) {
        System.out.println("Playing a: " + name);
    }
    static {
        System.out.println("Executing static block");
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


}
