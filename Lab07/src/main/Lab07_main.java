package main;

import java.util.Scanner;

import entity.Employee;
import repository.EmployeeRepository;

public class Lab07_main {
	public static void main(String[] args) {
		EmployeeRepository repo = new EmployeeRepository();
		boolean running = true;
		
		while (running) {
			menu2();
			int choice = getChoice();
			
			switch (choice) {
				case 1 -> {
					System.out.println("Add Employee:");
					System.out.print("Enter name: ");
					String nameAdd = scanner.nextLine();
					
					System.out.print("Enter Salary: ");
					Double salaryAdd = Double.parseDouble(scanner.nextLine());
					
					Employee emplAdd = new Employee();
					emplAdd.setName(nameAdd);
					emplAdd.setSalary(salaryAdd);
					
					repo.addNew(emplAdd);
				}
				
				case 2 -> {
					System.out.println("Display All Employee");
					repo.showAll();
				}
				
				case 3 -> {
					System.out.println("Find Employee via ID");
					System.out.print("Insert ID:" );
					int insertID = Integer.parseInt(scanner.nextLine());
					Employee found = repo.findByID(insertID);
					if (found == null) {
						System.out.println("Failed to find employee with " + insertID);
					}
					else {
						System.out.println(found);
					}
				}
				
				case 4 -> {
					System.out.println("4. Remove Employee");
					System.out.print("Insert ID:" );
					int insertID = Integer.parseInt(scanner.nextLine());
					boolean found = repo.deleteEmp(insertID);
					if (!found) {
						System.out.println("Failed to delete employee with " + insertID);
					}
					else {
						System.out.println("Successfully Deleted!");
					}
				}
				
				case 5 -> {
					System.out.println("Update");
					System.out.print("Enter name: ");
					String nameAdd = scanner.nextLine();
					
					System.out.print("Enter Salary: ");
					Double salaryAdd = Double.parseDouble(scanner.nextLine());
					
					Employee emplAdd = new Employee();
					emplAdd.setName(nameAdd);
					emplAdd.setSalary(salaryAdd);
					
					repo.addNew(emplAdd);
				}
				
				case 0 -> {
					System.out.println("Exiting");
					running = false;
				}
				
			}
		}
	}

	static Scanner scanner = new Scanner(System.in);

	static void printMenu() {
		System.out.println("\n===== MENU =====");
		System.out.println("1. Add Employee");
		System.out.println("2. Display All Employee");
		System.out.println("3. Find Employee via ID");
		System.out.println("4. Remove Employee");
		System.out.println("5. Update Employee");
		System.out.println("0. Exit");
		System.out.print("Your choice: ");
	}

	static void menu2() {
		String menu = """
				\n===== MENU =====
				1. Add Employee
				2. Display All Employee
				3. Find Employee via ID
				4. Remove Employee
				5. Update Employee
				0. Exit
				""";
		System.out.println(menu);
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
