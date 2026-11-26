package level3.exercise1;

import java.util.List;
import java.util.Scanner;


public class Main {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NewsroomManager manager = new NewsroomManager();
        int option;

        do {
            printMenu();
            option = readInt(scanner, "Pick an option: ");

            switch (option) {
                case 1 -> handleAddEditor(scanner, manager);
                case 2 -> handleRemoveEditor(scanner, manager);
                case 3 -> handleAssignNews(scanner, manager);
                case 4 -> handleRemoveNews(scanner, manager);
                case 5 -> handleShowNewsByEditor(scanner, manager);
                case 6 -> handleCalculateScore(scanner, manager);
                case 7 -> handleCalculatePrice(scanner, manager);
                case 0 -> System.out.println("Exiting the program...");
                default -> System.out.println("Invalid option. Please choose between 0 and 7.");
            }
        } while (option != 0);

        scanner.close();
    }

    private static void handleCalculatePrice(Scanner scanner, NewsroomManager manager) {
        System.out.print("Enter the editor's DNI: ");
        String editorDni = scanner.nextLine().trim();
        if (editorDni.isEmpty()) {
            System.out.println("Error: DNI cannot be empty.");
            return;
        }
        System.out.println("Enter the headline: ");
        String newsHeadline = scanner.nextLine().trim();
        if (newsHeadline.isEmpty()) {
            System.out.println("Error: Headline cannot be empty.");
            return;
        }
        double newsPrice = manager.calculateNewsPrice(editorDni, newsHeadline);
        if(newsPrice < 0){
            System.out.println("Error: Editor or news not found.");
        } else {
            System.out.println("Total price is: " + newsPrice + "€");
        }

    }

    private static void handleCalculateScore(Scanner scanner, NewsroomManager manager) {
        System.out.print("Enter the editor's DNI: ");
        String editorDni = scanner.nextLine().trim();
        if (editorDni.isEmpty()) {
            System.out.println("Error: DNI cannot be empty.");
            return;
        }
        System.out.println("Enter the headline: ");
        String newsHeadline = scanner.nextLine().trim();
        if (newsHeadline.isEmpty()) {
            System.out.println("Error: Headline cannot be empty.");
            return;
        }
        int newsScore = manager.calculateNewsScore(editorDni, newsHeadline);
        if(newsScore < 0){
            System.out.println("Error: Editor or news not found.");
        } else {

            System.out.println("Total score is: " + newsScore + "Pts");
        }


    }

    private static void handleShowNewsByEditor(Scanner scanner, NewsroomManager manager) {
        System.out.print("Enter the editor's DNI: ");
        String editorDni = scanner.nextLine().trim();

        if (editorDni.isEmpty()) {
            System.out.println("Error: DNI cannot be empty.");
            return;
        }

        List<News> editorNews = manager.getNewsByEditor(editorDni);

        if (editorNews == null) {
            System.out.println("Error: Editor not found.");
        } else if (editorNews.isEmpty()) {
            System.out.println("This editor has no assigned news yet.");
        } else {
            System.out.println("--- News by Editor (" + editorDni + ") ---");
            for (News news : editorNews) {
                System.out.println("Headline: " + news.getHeadline());
                System.out.println("Price: " + news.getPrice() + "€");
                System.out.println("Score: " + news.getScore() + " pts");
                System.out.println("-----------------------------------");
            }
        }
    }

    private static void handleRemoveNews(Scanner scanner, NewsroomManager manager) {
        System.out.print("Enter the editor's DNI: ");
        String editorDni = scanner.nextLine().trim();
        if (editorDni.isEmpty()) {
            System.out.println("Error: DNI cannot be empty.");
            return;
        }
        System.out.println("Enter the headline: ");
        String newsHeadline = scanner.nextLine().trim();
        if (newsHeadline.isEmpty()) {
            System.out.println("Error: Headline cannot be empty.");
            return;
        }
        if (manager.removeNewsFromEditor(editorDni, newsHeadline)) {
            System.out.println("News removed successfully.");
        } else {
            System.out.println("Error: Editor or news not found.");
        }

    }

    private static void handleAssignNews(Scanner scanner, NewsroomManager manager) {
        System.out.print("Enter the editor's DNI: ");
        String editorDni = scanner.nextLine().trim();

        if (editorDni.isEmpty()) {
            System.out.println("Error: DNI cannot be empty.");
            return;
        }
        System.out.println("1. Football");
        System.out.println("2. Basketball");
        System.out.println("3. Tennis");
        System.out.println("4. F1");
        System.out.println("5. Motorcycling");
        int option = readInt(scanner, "Choose a sport: ");
        News news = null;
        switch (option) {
            case 1 -> {
                System.out.println("------------ FOOTBALL NEWS -----------");
                System.out.println("Enter the headline: ");
                String newsHeadline = scanner.nextLine().trim();
                if (newsHeadline.isEmpty()) {
                    System.out.println("Error: Headline cannot be empty.");
                    return;
                }

                System.out.println("Enter the competition: ");
                String newsCompetition = scanner.nextLine().trim();
                if (newsCompetition.isEmpty()) {
                    System.out.println("Error: Competition cannot be empty.");
                    return;
                }

                System.out.println("Enter the club: ");
                String newsClub = scanner.nextLine().trim();
                if (newsClub.isEmpty()) {
                    System.out.println("Error: Club cannot be empty.");
                    return;
                }
                System.out.println("Enter a player: ");
                String newsPlayer = scanner.nextLine().trim();
                if (newsPlayer.isEmpty()) {
                    System.out.println("Error: Player cannot be empty.");
                    return;
                }
                news = new FootballNews(newsHeadline, newsCompetition, newsClub, newsPlayer);

            }
            case 2 -> {
                System.out.println("------------ BASKETBALL NEWS -----------");
                System.out.println("Enter the headline: ");
                String newsHeadline = scanner.nextLine().trim();
                if (newsHeadline.isEmpty()) {
                    System.out.println("Error: Headline cannot be empty.");
                    return;
                }

                System.out.println("Enter the competition: ");
                String newsCompetition = scanner.nextLine().trim();
                if (newsCompetition.isEmpty()) {
                    System.out.println("Error: Competition cannot be empty.");
                    return;
                }

                System.out.println("Enter the club: ");
                String newsClub = scanner.nextLine().trim();
                if (newsClub.isEmpty()) {
                    System.out.println("Error: Club cannot be empty.");
                    return;
                }

                news = new BasketballNews(newsHeadline, newsCompetition, newsClub);

            }
            case 3 -> {
                System.out.println("------------ TENNIS NEWS -----------");
                System.out.println("Enter the headline: ");
                String newsHeadline = scanner.nextLine().trim();
                if (newsHeadline.isEmpty()) {
                    System.out.println("Error: Headline cannot be empty.");
                    return;
                }

                System.out.println("Enter the competition: ");
                String newsCompetition = scanner.nextLine().trim();
                if (newsCompetition.isEmpty()) {
                    System.out.println("Error: Competition cannot be empty.");
                    return;
                }

                System.out.println("Enter a player: ");
                String newsPlayer = scanner.nextLine().trim();
                if (newsPlayer.isEmpty()) {
                    System.out.println("Error: Player cannot be empty.");
                    return;
                }
                news = new TennisNews(newsHeadline, newsCompetition, newsPlayer);
            }
            case 4 -> {
                System.out.println("------------ F1 NEWS -----------");
                System.out.println("Enter the headline: ");
                String newsHeadline = scanner.nextLine().trim();
                if (newsHeadline.isEmpty()) {
                    System.out.println("Error: Headline cannot be empty.");
                    return;
                }

                System.out.println("Enter the Team: ");
                String newsTeam = scanner.nextLine().trim();
                if (newsTeam.isEmpty()) {
                    System.out.println("Error: Team cannot be empty.");
                    return;
                }
                news = new F1News(newsHeadline, newsTeam);
            }
            case 5 -> {
                System.out.println("------------ MOTORCYCLING NEWS -----------");
                System.out.println("Enter the headline: ");
                String newsHeadline = scanner.nextLine().trim();
                if (newsHeadline.isEmpty()) {
                    System.out.println("Error: Headline cannot be empty.");
                    return;
                }

                System.out.println("Enter the Team: ");
                String newsTeam = scanner.nextLine().trim();
                if (newsTeam.isEmpty()) {
                    System.out.println("Error: Team cannot be empty.");
                    return;
                }
                news = new MotorcyclingNews(newsHeadline, newsTeam);
            }
            default -> {
                System.out.println("Error: Invalid sport option.");
                return;
            }
        }

        if (manager.assignNewsToEditor(editorDni, news)) {
            System.out.println("News assigned successfully!");
        } else {
            System.out.println("Error: Editor with DNI " + editorDni + " was not found.");
        }
    }

    private static void handleRemoveEditor(Scanner scanner, NewsroomManager manager) {
        System.out.print("Enter the editor's DNI: ");
        String editorDni = scanner.nextLine().trim();

        if (editorDni.isEmpty()) {
            System.out.println("Error: DNI cannot be empty.");
            return;
        }

        if (manager.removeEditor(editorDni)) {
            System.out.println("Editor removed successfully.");
        } else {
            System.out.println("Error: Editor not found.");
        }
    }

    private static void handleAddEditor(Scanner scanner, NewsroomManager manager) {
        System.out.print("Enter the editor's name: ");
        String editorName = scanner.nextLine().trim();
        System.out.print("Enter the editor's DNI: ");
        String editorDni = scanner.nextLine().trim();

        if (editorName.isEmpty() || editorDni.isEmpty()) {
            System.out.println("Error: Name and DNI cannot be empty.");
            return;
        }

        if (manager.addEditor(editorName, editorDni)) {
            System.out.println("Editor added successfully.");
        } else {
            System.out.println("Error: An editor with that DNI already exists.");
        }
    }

    private static void printMenu() {
        System.out.println("\n--- SPORTS NEWSROOM MENU ---");
        System.out.println("1. Introduce editor");
        System.out.println("2. Remove editor");
        System.out.println("3. Assign news to an editor");
        System.out.println("4. Remove news");
        System.out.println("5. Show all news by editor");
        System.out.println("6. Calculate news score");
        System.out.println("7. Calculate news price");
        System.out.println("0. Exit");
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer number.");
            }
        }
    }
}