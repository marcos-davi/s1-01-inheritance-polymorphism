package level3.exercise1;

public class BasketballNews extends News {
    private String competition;
    private String club;



    public BasketballNews(String headline, String competition, String club) {
        super(headline, 0, 0.0);
        this.competition = competition;
        this.club = club;
        setPrice(calculatePrice());
        setScore(calculateScore());
    }

    @Override
    public double calculatePrice() {
        double totalPrice = 250.0;
        if("Euro league".equalsIgnoreCase(competition)){
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
        if("Euro league".equalsIgnoreCase(competition)){
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

