package level3.exercise1;

public abstract class News {
    private String headline;
    private String text;
    private int score;
    private double price;

    public News(String headline,int score, double price) {
        this.headline = headline;
        this.text = "";
        this.score = score;
        this.price = price;
    }

    public abstract  double calculatePrice();
    public abstract int calculateScore();

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
