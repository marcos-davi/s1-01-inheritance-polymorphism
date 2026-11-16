package level1.exercise1;

public abstract class Instrument {
    String name;
    double price;

    public abstract void play();

    public Instrument(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
