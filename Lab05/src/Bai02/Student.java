package Bai02;

import java.io.Serializable;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Name;
	private double GPA;
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("Nanme must not be null or empty");
		}
		this.Name = name;
	}
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double gpa) {
		if(gpa < 0 || gpa > 4) {
			throw new IllegalArgumentException("Invalid score");
		}
		this.GPA = gpa;
	}
	
	public Student() {}
	
	public Student(String name, double gPA) {
		this.Name = name;
		this.GPA = gPA;
	}
	@Override
	public String toString() {
		return "Student [Name= " + this.Name + ", GPA= " + this.GPA + "]";
	}
	
	
}