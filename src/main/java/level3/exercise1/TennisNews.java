package level3.exercise1;

public class TennisNews extends News{
    private String competition;
    private String player;
    public TennisNews(String headline,  String competition, String player) {
        super(headline, 0, 0.0);
        this.competition = competition;
        this.player = player;
        setPrice(calculatePrice());
        setScore(calculateScore());
    }

    public String getCompetition() {
        return competition;
    }

    public String getPlayer() {
        return player;
    }

    @Override
    public double calculatePrice() {
        double totalPrice = 150.0;
        if("Federer".equalsIgnoreCase(player) || "Nadal".equalsIgnoreCase(player) || "Djokovic".equalsIgnoreCase(player)){
            return totalPrice + 100.0;
        }
        return totalPrice;
    }

    @Override
    public int calculateScore() {
        int totalScore = 4;
        if("Federer".equalsIgnoreCase(player) || "Nadal".equalsIgnoreCase(player) || "Djokovic".equalsIgnoreCase(player)){
            return totalScore + 3;
        }

        return totalScore;
    }
}

