package Bai02;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeService {
	private ArrayList<Employee> list = new ArrayList<Employee>();
	
	//check if ID already exists in list
	
//	public Boolean isIdExists (String id) {
//		for (Employee e : list) {
//			if(e.getId().equalsIgnoreCase(id)) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	public Boolean isIdExists (String id) {
		return list.stream()
					.anyMatch(e -> e.getId().equalsIgnoreCase(id));
	}
	
	//create a single employee
	public Employee addNewEmployee(Scanner sc) {
		Employee employee = new Employee();
		
		//loop ID
		while(true) {
			try {
				System.out.print("Employee's ID: ");
				String inputID = sc.nextLine();
				if(isIdExists(inputID)) {
					throw new IllegalArgumentException("DuplicateEmployeeException");
				}
				
				employee.setId(inputID);
				break;
			}catch(IllegalArgumentException e) {
				System.out.println("Error: " +e.getMessage());
			}
		}
		
		//loop name
		while(true) {
			try {
				System.out.print("Employee's name: ");
				employee.setName(sc.nextLine());
				break;
			}catch(IllegalArgumentException e) {
				System.out.println("Error: " +e.getMessage());
			}
		}
		
		//loop salary
		while(true) {
			try {
				System.out.print("Employee 's salary :");
				employee.setSalary(Double.parseDouble(sc.nextLine()));
				break;
			}catch (IllegalArgumentException e) {
				System.out.println("Error: " +e.getMessage());
			}
		}
		
		return employee;
	}
	
	public void addToList(Employee employee) {
		list.add(employee);
	}
	
	public void displayEmployeList() {
		list.forEach(e -> System.out.println(e));
	}
	
	public Employee findByID(String id) {
		for (Employee search : list) {
			if(search.getId().equalsIgnoreCase(id)) {
				return search;
			}
		}
		return null;
	}
}
