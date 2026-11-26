package level1.exercise1;

public  class Main {
    static void main(String[] args) {
        Instrument.playing("Trumpet");
        Instrument.playing("Guitar");
        Instrument.playing("Drum");

        Instrument trumpet = new WindInstrument("Trumpet", 200.00);
        trumpet.play();
        Instrument guitar = new StringInstrument("Guitar", 500.00);
        guitar.play();
        Instrument drum = new PercussionInstrument("Drum", 300.00);
        drum.play();
    }
}
