package level1.exercise1;

public class PercussionInstrument extends Instrument {

    public PercussionInstrument(String name, double price) {
        super(name, price);

    }

    @Override
    public void play() {
        System.out.println("Playing percussion instrument: " + this.getName());
    }
}
