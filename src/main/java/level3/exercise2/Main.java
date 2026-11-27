package level3.exercise2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServiceCenterManager manager = new ServiceCenterManager();
        int option;

        do{
            printMenu();
            option = readInt(scanner, "Choose a option:");
            switch (option){
                case 1 -> handleRegisterTechnician(scanner, manager);
                case 2 ->handleRemoveTechnician(scanner, manager);
                case 3 ->handleAssignRepairOrderTechnician(scanner, manager);
                case 4 ->handleRemoveRepairOrder(scanner, manager);
                case 5->handleShowAllRepairOrdersByTechnician(scanner, manager);
                case 6 ->handleCalculateRepairWarranty(scanner, manager);
                case 7 ->handleCalculateRepairTotalCost(scanner, manager);
                case 0 -> System.out.println("Exiting the program...");
                default -> System.out.println("Invalid option. Please choose between 0 and 7.");

            }

        }while (option == 0);
        scanner.close();

    }

    private static void handleCalculateRepairTotalCost(Scanner scanner, ServiceCenterManager manager) {
        System.out.println("Main.handleCalculateRepairTotalCost");
    }

    private static void handleCalculateRepairWarranty(Scanner scanner, ServiceCenterManager manager) {
        System.out.println("Main.handleCalculateRepairWarranty");
    }

    private static void handleShowAllRepairOrdersByTechnician(Scanner scanner, ServiceCenterManager manager) {
        System.out.println("Main.handleShowAllRepairOrdersByTechnician");
    }

    private static void handleRemoveRepairOrder(Scanner scanner, ServiceCenterManager manager) {
        System.out.println("Main.handleRemoveRepairOrder");
    }

    private static void handleAssignRepairOrderTechnician(Scanner scanner, ServiceCenterManager manager) {
        System.out.println("Main.handleAssignRepairOrderTechnician");
    }

    private static void handleRemoveTechnician(Scanner scanner, ServiceCenterManager manager) {
        System.out.println("Main.handleRemoveTechnician");
    }

    private static void handleRegisterTechnician(Scanner scanner, ServiceCenterManager manager) {
        System.out.println("handleRegisterTechnician");
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

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer number.");
            }
        }
    }
}





