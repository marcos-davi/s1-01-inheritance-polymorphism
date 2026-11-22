package level3.exercise1;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
        
    }

    private static void handleCalculateScore(Scanner scanner, NewsroomManager manager) {
        
    }

    private static void handleShowNewsByEditor(Scanner scanner, NewsroomManager manager) {
        
    }

    private static void handleRemoveNews(Scanner scanner, NewsroomManager manager) {
        
    }

    private static void handleAssignNews(Scanner scanner, NewsroomManager manager) {
        
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
            System.out.println("Error: DNI cannot be empty.");
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