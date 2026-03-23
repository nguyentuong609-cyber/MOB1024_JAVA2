package Bai03;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeDS {
	ArrayList<Employee> dsnv = new ArrayList<Employee>();
	
	
	public void listEmployeeInput(Scanner sc) {
		do {
			Employee nhap = new Employee();
			System.out.println("here to input :");
			dsnv.add(nhap);
			
		}while(true);
	}
}
