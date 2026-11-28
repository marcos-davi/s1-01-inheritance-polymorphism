package level3.exercise2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServiceCenterManager manager = new ServiceCenterManager();
        int option;

        do {
            printMenu();
            option = readInt(scanner, "Choose an option: ");
            switch (option) {
                case 1 -> handleRegisterTechnician(scanner, manager);
                case 2 -> handleRemoveTechnician(scanner, manager);
                case 3 -> handleAssignRepairOrderTechnician(scanner, manager);
                case 4 -> handleRemoveRepairOrder(scanner, manager);
                case 5 -> handleShowAllRepairOrdersByTechnician(scanner, manager);
                case 6 -> handleCalculateRepairWarranty(scanner, manager);
                case 7 -> handleCalculateRepairTotalCost(scanner, manager);
                case 0 -> System.out.println("Exiting the program...");
                default -> System.out.println("Invalid option. Please choose between 0 and 7.");
            }

        } while (option != 0);
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
        System.out.println("Enter the employee's id: ");
        String employeeId = scanner.nextLine().trim();

        if (employeeId.isEmpty()) {
            System.out.println("Error: Employee Id cannot be empty.");
            return;
        }
        if (!manager.hasTechnician(employeeId)) {
            System.out.println("Error: There is no Employee with this id.");
            return;
        }

        System.out.println("1. Smartphone Repair");
        System.out.println("2. Laptop Repair");
        System.out.println("3. Console Repair");
        System.out.println("4. Smartwatch Repair");
        System.out.println("5. Tablet Repair");
        int option = readInt(scanner, "Choose a repair type: ");
        RepairOrder order = null;
        String ticketCode = readTicketCode(scanner);
        if (ticketCode == null) return;

        switch (option) {
            case 1 -> {
                String brand = readRequiredInput(scanner, "Enter the Brand: ", "Brand");
                if (brand == null) return;
                String component = readRequiredInput(scanner, "Enter the component: ", "Component");
                if (component == null) return;
                order = new SmartphoneRepair(ticketCode, brand, component);
            }
            case 2 -> {
                String brand = readRequiredInput(scanner, "Enter the Brand: ", "Brand");
                if (brand == null) return;
                String repairType = readRequiredInput(scanner, "Enter the repair type: ", "Repair type");
                if (repairType == null) return;
                order = new LaptopRepair(ticketCode, brand, repairType);
            }
            case 3 -> {
                String consoleModel = readRequiredInput(scanner, "Enter the Console Model: ", "Console Model");
                if (consoleModel == null) return;
                String fault = readRequiredInput(scanner, "Enter the fault: ", "Fault");
                if (fault == null) return;
                order = new ConsoleRepair(ticketCode, consoleModel, fault);
            }
            case 4 -> {
                String brand = readRequiredInput(scanner, "Enter the Brand: ", "Brand");
                if (brand == null) return;
                order = new SmartwatchRepair(ticketCode, brand);
            }
            case 5 -> {
                String brand = readRequiredInput(scanner, "Enter the Brand: ", "Brand");
                if (brand == null) return;
                String component = readRequiredInput(scanner, "Enter the component: ", "Component");
                if (component == null) return;
                order = new TabletRepair(ticketCode, brand, component);
            }
            default -> {
                System.out.println("Error: Invalid repair type.");
                return;
            }
        }

        if (manager.assignOrderToTechnician(employeeId, order)) {
            System.out.println("Repair order assigned successfully.");
        } else {
            System.out.println("Error: Ticket code already exists.");
        }
    }

    private static String readTicketCode(Scanner scanner) {
        return readRequiredInput(scanner, "Enter the ticket code: ", "Ticket code");
    }

    private static String readRequiredInput(Scanner scanner, String prompt, String fieldName) {
        System.out.println(prompt);
        String value = scanner.nextLine().trim();
        if (value.isEmpty()) {
            System.out.println("Error: " + fieldName + " cannot be empty.");
            return null;
        }
        return value;
    }

    private static void handleRemoveTechnician(Scanner scanner, ServiceCenterManager manager) {
        System.out.println("Enter the employee's id: ");
        String employeeId = scanner.nextLine().trim();

        if (employeeId.isEmpty()) {
            System.out.println("Error: Employee Id cannot be empty.");
            return;
        }

        if (manager.removeTechnician(employeeId)) {
            System.out.println("Technician removed successfully.");
        } else {
            System.out.println("Error: There is not a technician with that Id.");

        }
    }

    private static void handleRegisterTechnician(Scanner scanner, ServiceCenterManager manager) {
        System.out.println("Enter the technician's name: ");
        String name = scanner.nextLine().trim();

        System.out.println("Enter the employee's id: ");
        String employeeId = scanner.nextLine().trim();

        if (name.isEmpty() || employeeId.isEmpty()) {
            System.out.println("Error: Name and employee Id cannot be empty.");
            return;
        }
        if (manager.addTechnician(name, employeeId)) {
            System.out.println("Technician added successfully.");
        } else {
            System.out.println("Error: A technician with that Id already exists.");
        }
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
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer number.");
            }
        }
    }
}





