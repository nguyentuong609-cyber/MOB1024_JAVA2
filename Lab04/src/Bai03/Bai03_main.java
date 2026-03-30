package Bai03;

import java.util.ArrayList;

public class Bai03_main {
	public static void main(String[] args) {
		GenericManager<Student> studentManager = new GenericManager<Student>();
		studentManager.addItem(new Student("SV001", "Dave", 3.1, Student.StudentType.REGULAR));
		studentManager.addItem(new Student("SV002", "Tony", 3.5, Student.StudentType.PART_TIME));
		studentManager.addItem(new Student("SV003", "Tuong", 3.2, Student.StudentType.INTERNATIONAL));
		
		studentManager.displayItem(); //method 1
		System.out.println("Method 2: ");
		System.out.println(studentManager.getAll()); //method 2 only prints in 1 line.
		System.out.println("Method 3: ");
		for(Student s : studentManager.getAll()) { //method 3 prints separate lines.
			System.out.println(s);
		}
		System.out.println("Method 4: "); //method 4 creates a whole new arrayList and prints it out
		ArrayList<Student> students = studentManager.getAll();
		System.out.println(students);
		
		
	}
}
