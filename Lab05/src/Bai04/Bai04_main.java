package Bai04;

import java.util.Scanner;
import Bai03.Student;

public class Bai04_main {
    static Scanner scanner = new Scanner(System.in);
    static StudentService service = new StudentService();

    public static void main(String[] args) {
        // Load existing data into service on startup
        service.setStudentList(FileService.loadFromFile());

        System.out.println("Welcome to Student Manager!");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = getChoice();

            switch (choice) {
            case 1 -> {
                Student student = service.addNewStudent(scanner);
                service.addStudentList(student);
                System.out.println("Student added successfully!");
            }
            case 2 -> service.displayStudentList();
            case 3 -> service.removeStudent(scanner);      // new
            case 4 -> {                                    // shifted
                FileService.saveToFile(service.getStudentList());
                System.out.println("Goodbye!");
                running = false;
            }
            default -> System.out.println("Invalid choice, please try again.");
        }
        }

        scanner.close();
    }

    static void printMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Remove Student");       // new
        System.out.println("4. Save & Exit");          // shifted
        System.out.print("Your choice: ");
    }

    static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}