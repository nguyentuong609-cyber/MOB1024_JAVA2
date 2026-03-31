package Bai02;

import java.util.Scanner;

public class Bai02_main {
	static void menu() {
		String menu = """ 
				1. Add Employee.
				2. Show employee list.
				3. Find employee via ID.
				4.Exit
				
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
		EmployeeService employeeList = new EmployeeService();
		int choice = 0;
		
		do {
			clearScreen();
			menu();
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
				case 1 :{
					clearScreen();
					System.out.println("Adding new employee");
					while(true) {
						Employee e = employeeList.addNewEmployee(sc);
						employeeList.addToList(e);
						
						System.out.println("Continue ? (y/n): ");
						if (sc.nextLine().equalsIgnoreCase("n")) {
							break;
						}
					}
					promptEnterKey(sc);
					break;
				}
				case 2 :{
					clearScreen();
					System.out.println("Display List:");
					employeeList.displayEmployeList();
					promptEnterKey(sc);
					break;
				}
				case 3: {
					clearScreen();
					while(true) {
						System.out.println("Search by ID:");
						String idInput = sc.nextLine();
						Employee search = employeeList.findByID(idInput);
						if(search == null) {
							System.out.println("Cant find employee with "+idInput);
						}else {
							System.out.println("Found: " + search);
						}
						
						
						System.out.println("Continue ? (y/n): ");
						if(sc.nextLine().equalsIgnoreCase("n")) {
							break;
						}
					}
					promptEnterKey(sc);
					break;
				}
				case 4: {
					clearScreen();
					System.out.println("Exit");
					break;
				}
				default:
					clearScreen();
					throw new IllegalArgumentException("Invalid value: " + choice);
			}
		}while(choice != 4);
		
	}
}
