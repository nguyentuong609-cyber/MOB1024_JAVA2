package Bai01;

import java.util.ArrayList;
import java.util.Scanner;


public class StudentService {	
	private ArrayList<Student> list = new ArrayList<Student>();

	
	// create a student
	public Student addNewStudent(Scanner sc) {	
		Student student = new Student();
		
		// Loop for ID
	    while (true) {
	        try {
	            System.out.print("Student's ID: ");
	            student.setID(sc.nextLine());
	            break; 
	        } catch (IllegalArgumentException e) {
	            System.out.println("Error: " + e.getMessage()); 
	        }
	    }
	    
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
	    
		 // Loop for type
	    while (true) {
	        try {
	            System.out.println("Student's type:");
	            System.out.println("1. REGULAR  2. PART_TIME  3. INTERNATIONAL");
	            switch (sc.nextLine()) {
	                case "1": student.setType(Student.StudentType.REGULAR); break;
	                case "2": student.setType(Student.StudentType.PART_TIME); break;
	                case "3": student.setType(Student.StudentType.INTERNATIONAL); break;
	                default: throw new IllegalArgumentException("Please choose 1, 2 or 3");
	            }
	            break;
	        } catch (IllegalArgumentException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
		
		return student;
	}
	
	// add to the list
	public void addStudentList(Student student) {
		list.add(student);
	}
	
	public void displayStudentList() {
		list.forEach(s -> System.out.println(s));
	}
	
	// boolean for id check
	public boolean isIdExisted(String id) {
		for(Student s : list) {
			if(s.getID().equalsIgnoreCase(id)) {
				return true;
			}
		}
		return false;
	}
	
//	public boolean isIdExists(String id) {
//	    return list.stream()
//	            .anyMatch(s -> s.getID().equalsIgnoreCase(id));
//	}
	
	public Student findByID(String id) {
		for(Student s : list) {
			if(s.getID().equalsIgnoreCase(id)) {
				return s;
			}
		}
		return null;
	}
	
}
