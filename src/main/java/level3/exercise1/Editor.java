package level3.exercise1;

import java.util.ArrayList;
import java.util.List;

public class Editor {
    private String name;
    private final String DNI;
    private static double salary = 1500.0;
    List<News> news;

    public Editor(String name, String dni) {
        this.name = name;
        DNI = dni;
        this.news = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDNI() {
        return DNI;
    }

    public static double getSalary() {
        return salary;
    }

    public static void setSalary(double salary) {
        Editor.salary = salary;
    }

    public List<News> getNews() {
        return news;
    }

    public void addNews(News news) {
        this.news.add(news);
    }
    public boolean removeNews(News news) {
        return this.news.remove(news);
    }
}
