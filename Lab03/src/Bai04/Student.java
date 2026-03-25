package Bai04;


public class Student {
	private String ID;
	private String name;
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
	public StudentType getType() {
		return type;
	}
	public void setType(StudentType type) {
		this.type = type;
	}
	public Student() {}
	
	public Student(String iD, String name, StudentType type) {
		setID(iD);
		setName(name);
		setType(type);
	}
	
	public void printSV() {
		System.out.println("ID: " + getID());
		System.out.println("Ten: "+ getName());
		System.out.println("Type: " + getType());
	}
}
