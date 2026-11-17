package exemple;

import java.util.ArrayList;
import java.util.List;

// 1. INTERFAZ: Define una capacidad ("PUEDE-HACER"), sin estado ni constructor
interface Publishable {
    void publish();

    // Método default (Java 8+): ofrece comportamiento base opcional
    default String getPlatform() {
        return "Digital Sports Portal";
    }
}

// 2. CLASE ABSTRACTA: Define identidad ("ES-UN"), estado común y constructor
abstract class BaseArticle implements Publishable {
    private String headline;

    public BaseArticle(String headline) {
        this.headline = headline;
    }

    public String getHeadline() {
        return headline;
    }

    // Método abstracto: obliga a cada subclase a calcular su propio precio
    public abstract double calculatePrice();
}

// 3. SUBCLASES CONCRETAS
class FootballArticle extends BaseArticle {
    private String competition;

    public FootballArticle(String headline, String competition) {
        super(headline);
        this.competition = competition;
    }

    public String getCompetition() {
        return competition;
    }

    @Override
    public double calculatePrice() {
        return competition.equalsIgnoreCase("Champions League") ? 400.0 : 300.0;
    }

    @Override
    public void publish() {
        System.out.println("[" + getPlatform() + "] Football: " + getHeadline());
    }
}

class F1Article extends BaseArticle {
    private String team;

    public F1Article(String headline, String team) {
        super(headline);
        this.team = team;
    }

    @Override
    public double calculatePrice() {
        return team.equalsIgnoreCase("Ferrari") ? 150.0 : 100.0;
    }

    @Override
    public void publish() {
        System.out.println("[" + getPlatform() + "] Formula 1: " + getHeadline());
    }
}

// 4. DEMOSTRACIÓN DE POLIMORFISMO EN TIEMPO DE EJECUCIÓN
public class PolymorphismDemo {
    public static void main(String[] args) {
        // Lista tipada con la clase abstracta BaseArticle
        List<BaseArticle> articles = new ArrayList<>();
        articles.add(new FootballArticle("Final Preview", "Champions League"));
        articles.add(new F1Article("Monza Qualifying", "Ferrari"));

        for (BaseArticle article : articles) {
            // En tiempo de ejecución, la JVM elige el @Override exacto de cada objeto
            article.publish();
            System.out.println("Calculated price: " + article.calculatePrice() + " €");

            // Acceso seguro a un método exclusivo de una subclase mediante Pattern Matching
            if (article instanceof FootballArticle football) {
                System.out.println(" -> Competition detail: " + football.getCompetition());
            }
        }
    }
}