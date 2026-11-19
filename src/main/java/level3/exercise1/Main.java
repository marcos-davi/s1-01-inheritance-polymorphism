package level3.exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Main method implementation
        // En Main.java (Opción 1 del menú):
        System.out.print("Enter editor name: ");
        Scanner scanner = null;
        String name = scanner.nextLine();
        System.out.print("Enter editor DNI: ");
        String dni = scanner.nextLine();

        NewsroomManager manager = null;
        if (manager.addEditor(name, dni)) {
            System.out.println("Editor added successfully.");
        } else {
            System.out.println("Error: An editor with that DNI already exists.");
        }
    // REMOVE EDITOR
        if (manager.removeEditor(dni)) {
            System.out.println("Editor removed successfully.");
        } else {
            System.out.println("Error: Editor not found.");
        }
    }
}
