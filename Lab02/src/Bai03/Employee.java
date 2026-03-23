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
		Id = id;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public double getSalary() {
		return Salary;
	}
	
	public void setSalary(double salary) {
		Salary = salary;
	}
	
	public Employee() {}
	
	public Employee(String id, String name, double salary) {
		Id = id;
		Name = name;
		Salary = salary;
	}
	
	public void inputEmployee(Scanner sc) {
		setId(sc.nextLine());
		setName(sc.nextLine());
		setSalary(sc.nextDouble());
	}
	
	public void printEmployee() {
		System.out.println("ID: "+getId());
		System.out.println("Name: "+ getName());
		System.out.println("Salary: "+ getSalary());
	}
}
