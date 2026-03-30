package Bai03;


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
	    if (iD == null || iD.isBlank()) {
	        throw new IllegalArgumentException("ID must not be null or empty");
	    }
	    this.ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("Nanme must not be null or empty");
		}
		this.name = name;
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
		
	
//	public void printSV() {
//		System.out.println("ID: " + getID());
//		System.out.println("Ten: "+ getName());
//		System.out.println("GPA: " +getGPA());
//		System.out.println("Type: " + getType());
//	}
	
	@Override
	public String toString() {
		return "Student [ID= " + getID() + ", name= " + getName() + ", GPA= " + getGPA() + ", type= " + getType() + "]";
	}
	
}