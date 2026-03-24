package Bai02;

import java.util.Scanner;

public class Employee {
	private String Id;
	private String Name;
	private int Salary;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		this.Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
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
}
