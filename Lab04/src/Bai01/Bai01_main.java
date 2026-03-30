package Bai01;

import java.util.Scanner;

public class Bai01_main {
	
	static void menu() {
		String menu = """ 
				1. Add student.
				2. Show student list.
				3. Exit.
				
				Choose a number: 
				""";
		System.out.print(menu);
	}
	
	static void clearScreen() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
	
	static void promptEnterKey(Scanner scanner){
	       System.out.println("Press \"ENTER\" to continue...");
	       scanner.nextLine();
	    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService studentList = new StudentService();
		int choice = 0;
		
		do {
			clearScreen();
			menu();
			choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1: {
				clearScreen();
				System.out.println("Function 1 adding student:");
				while(true) {
					Student s = studentList.addNewStudent(sc);  // create new student
					studentList.addStudentList(s);				// add student to the list
					
					System.out.print("Continue ? (y/n): ");
					if(sc.nextLine().equalsIgnoreCase("n")) {
						break;
					}
				}
				promptEnterKey(sc);
				break;
			}
			
			case 2: {
				clearScreen();
				System.out.println("Function 2 showing student list:");
				studentList.displayStudentList();
				promptEnterKey(sc);
				break;
			}
			
			case 3: {
				clearScreen();
				System.out.println("Goodbye!");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
			
		} while(choice != 3);
		
		
//		while(true) {
//			Student s = studentList.addNewStudent(sc);  // create new student
//			studentList.addStudentList(s);				// add student to the list
//			
//			System.out.print("Continue ? (y/n): ");
//			if(sc.nextLine().equalsIgnoreCase("n")) {
//				break;
//			}
//		}
//		
//		studentList.displayStudentList();
	}
}
