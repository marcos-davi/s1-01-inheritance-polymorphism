package level3.exercise1;

public class BasketballNews extends News {
    private String competition;
    private String club;



    public BasketballNews(String headline, String competition, String club) {
        super(headline);
        this.competition = competition;
        this.club = club;
        this.calculatePrice();
        this.calculateScore();
    }

    public String getCompetition() {
        return competition;
    }

    public String getClub() {
        return club;
    }

    @Override
    public double calculatePrice() {
        double totalPrice = 250.0;
        if("Euroleague".equalsIgnoreCase(competition)){
            totalPrice += 75.0;
        }
        if("Barça".equalsIgnoreCase(club) || "Madrid".equalsIgnoreCase(club)){
            totalPrice += 75.0;
        }
        return totalPrice;

    }

    @Override
    public int calculateScore() {
        int  totalScore = 4;
        if("Euroleague".equalsIgnoreCase(competition)){
            totalScore += 3;
        }else if("Liga ACB".equalsIgnoreCase(competition)){
            totalScore += 2;
        }
        if("Barça".equalsIgnoreCase(club) || "Madrid".equalsIgnoreCase(club)){
            totalScore += 1;
        }
        return totalScore;


    }
}

