package level3.exercise1;

public class MotorcyclingNews extends News{
    private String team;

    public MotorcyclingNews(String headline, String team) {
        super(headline);
        this.team = team;
    }

    @Override
    public double calculatePrice() {
        double totalPrice = 100.0;
        if("Yamaha".equalsIgnoreCase(team) || "Honda".equalsIgnoreCase(team)){
            totalPrice += 50.0;
        }
        return totalPrice;
    }

    @Override
    public int calculateScore() {
        int totalScore = 3;
        if("Yamaha".equalsIgnoreCase(team) || "Honda".equalsIgnoreCase(team)){
            totalScore += 3;
        }
        return totalScore;
    }
}
