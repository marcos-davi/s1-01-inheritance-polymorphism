package level1.exercise1;

public class StringInstrument extends Instrument {

    public StringInstrument(String name, double price) {
        super(name, price);
        this.name = name;
        this.price = price;
    }

    @Override
    public void play() {
        System.out.println("Playing string instrument: " + name);
    }
}
