package level3.exercise1;

public class F1News extends News{
    private String team;

    public F1News(String headline, String team) {
        super(headline,0, 0.0);
        this.team = team;
        setPrice(calculatePrice());
        setScore(calculateScore());
    }

    @Override
    public double calculatePrice() {
        double totalPrice = 100.0;
        if("Ferrari".equalsIgnoreCase(team) || "Mercedes".equalsIgnoreCase(team)){
            totalPrice += 50.0;
        }
        return totalPrice;
    }

    @Override
    public int calculateScore() {
        int totalScore = 4;
        if("Ferrari".equalsIgnoreCase(team) || "Mercedes".equalsIgnoreCase(team)){
            totalScore += 2;
        }
        return totalScore;
    }
}
