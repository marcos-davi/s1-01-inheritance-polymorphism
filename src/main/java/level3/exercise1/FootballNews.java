package level3.exercise1;

public class FootballNews extends News {
    private String competition;
    private String club;
    private String player;

    public FootballNews(String headline, String competition, String club, String player) {
        super(headline, 0, 0.0);
        this.competition = competition;
        this.club = club;
        this.player = player;
        setPrice(calculatePrice());
        setScore(calculateScore());
    }

    @Override
    public double calculatePrice() {
        double totalPrice = 300.0;

        if ("Champions League".equalsIgnoreCase(competition)) {
            totalPrice += 100.0;
        }
        if ("Barça".equalsIgnoreCase(club) || "Madrid".equalsIgnoreCase(club)) {
            totalPrice += 100.0;
        }
        if ("Ferran Torres".equalsIgnoreCase(player) || "Benzema".equalsIgnoreCase(player)) {
            totalPrice += 50.0;
        }

        return totalPrice;
    }

    @Override
    public int calculateScore() {
        int totalScore = 5;

        if ("Champions League".equalsIgnoreCase(competition)) {
            totalScore += 3;
        } else if ("Liga".equalsIgnoreCase(competition)) {
            totalScore += 2;
        }

        if ("Barça".equalsIgnoreCase(club) || "Madrid".equalsIgnoreCase(club)) {
            totalScore += 1;
        }
        if ("Ferran Torres".equalsIgnoreCase(player) || "Benzema".equalsIgnoreCase(player)) {
            totalScore += 1;
        }

        return totalScore;
    }
}