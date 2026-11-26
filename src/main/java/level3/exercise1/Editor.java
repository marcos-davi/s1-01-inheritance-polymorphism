package level3.exercise1;

import java.util.ArrayList;
import java.util.List;

public class Editor {
    private final String name;
    private final String dni;
    private static final double salary = 1500.0;
    private final List<News> newsList;

    public Editor(String name, String dni) {
        this.name = name;
        this.dni = dni;
        this.newsList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public String getDni() {
        return dni;
    }


    public List<News> getNewsList() {
        return newsList;
    }

    public void addNews(News news) {
        if (news != null) {
            this.newsList.add(news);
        }
    }

    public boolean removeNews(String headline) {
        if (headline == null) {
            return false;
        }
        return this.newsList.removeIf(news -> headline.equalsIgnoreCase(news.getHeadline()));
    }
}