package Bai02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class StudentService {
	private List<Student> StudentList = new ArrayList<Student>();
	
	// create a student
	public Student addNewStudent(Scanner sc) {	
		Student student = new Student();
	    
		// Loop for name
	    while (true) {
	        try {
	            System.out.print("Student's name: ");
	            student.setName(sc.nextLine());
	            break;
	        } catch (IllegalArgumentException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	    
	    // Loop for GPA
	    while (true) {
	        try {
	            System.out.print("Student's GPA: ");
	            student.setGPA(Double.parseDouble(sc.nextLine()));
	            break;
	        } catch (IllegalArgumentException e) {
	            System.out.println("Error: " + e.getMessage());
	        } 
	        
	    }
		return student;
	}
	
	// add to the list
	public void addStudentList(Student student) {
		StudentList.add(student);
	}
	
	public void displayStudentList() {
		StudentList.forEach(s -> System.out.println(s));
	}
}
