package Bai04;


public class Student {
	private String ID;
	private String name;
	private double GPA;
	private StudentType type;
	
	public enum StudentType {
		REGULAR,
		PART_TIME,
		INTERNATIONAL
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		this.ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double gpa) {
		this.GPA = gpa;
	}
	public StudentType getType() {
		return type;
	}
	public void setType(StudentType type) {
		this.type = type;
	}
	public Student() {}
	
	public Student(String iD, String name, double gpa,StudentType type) {
		setID(iD);
		setName(name);
		setGPA(gpa);
		setType(type);
	}
	
	public void printSV() {
		System.out.println("ID: " + getID());
		System.out.println("Ten: "+ getName());
		System.out.println("GPA: " +getGPA());
		System.out.println("Type: " + getType());
	}
}
