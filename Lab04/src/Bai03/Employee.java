package Bai03;

import java.util.Scanner;

public class Employee {
	private String Id;
	private String Name;
	private double Salary;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		if(id == null || id.isBlank()) {
			throw new IllegalArgumentException("ID must not be null or emptied");
		}
		this.Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("Name must not be null or emptied");
		}
		this.Name = name;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		if (salary < 0) {
			throw new IllegalArgumentException("InvalidSalaryException");
		}
		this.Salary = salary;
	}
	
	public Employee() {}
	
	public Employee(String id, String name, int salary) {
		this.Id = id;
		this.Name = name;
		this.Salary = salary;
	}
	
	public void inputEmployee(Scanner sc) {
		setId(sc.nextLine());
		setName(sc.nextLine());
		setSalary(sc.nextInt());
	}
	
	public void printEmployee() {
		System.out.println("ID: "+getId());
		System.out.println("Name: "+ getName());
		System.out.println("Salary: "+ getSalary());
	}
	@Override
	public String toString() {
		return "Employee [Id= " + this.Id + ", Name= " + this.Name + ", Salary= " + this.Salary + "]";
	}
	
	
}
