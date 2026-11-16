package level1.exercise1;

public class WindInstrument extends Instrument {

    public WindInstrument(String name, double price) {
        super(name, price);
        this.name = name;
        this.price = price;
    }

     @Override
    public void play() {
        System.out.println("Playing wind instrument: " + name);
    }
}

