package level3.exercise2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServiceCenterManager manager = new ServiceCenterManager();
        int option;

    }
    private static void printMenu() {
        System.out.println("\n--- SERVICE CENTER MENU ---");
        System.out.println("1. Register technician");
        System.out.println("2. Remove technician");
        System.out.println("3. Assign repair order to a technician");
        System.out.println("4. Remove repair order");
        System.out.println("5. Show all repair orders by technician");
        System.out.println("6. Calculate repair warranty (months)");
        System.out.println("7. Calculate repair total cost (€)");
        System.out.println("0. Exit");

    }
}
