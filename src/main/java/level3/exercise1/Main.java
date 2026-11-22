package level3.exercise1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NewsroomManager manager = new NewsroomManager(new ArrayList<>());

        int option;

        do {

            printMenu();
            option = readInt(scanner, "Pick a option");
            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:

                    break;
                case 7:
                    break;
            }

        } while (option != 0);

    }

    private static void printMenu() {
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
                System.out.println("Entrada no válida. Por favor, introduce un número entero.");
            }
        }
    }
}
