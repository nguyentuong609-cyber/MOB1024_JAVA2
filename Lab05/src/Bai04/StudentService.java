package Bai04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Bai03.Student;



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
	public void removeStudent(Scanner sc) {
	    if (StudentList.isEmpty()) {
	        System.out.println("No students to remove.");
	        return;
	    }

	    // Show the list with index numbers
	    System.out.println("\n--- Student List ---");
	    for (int i = 0; i < StudentList.size(); i++) {
	        System.out.println((i + 1) + ". " + StudentList.get(i));
	    }
	    System.out.println("--------------------");

	    // Ask which one to remove
	    while (true) {
	        try {
	            System.out.print("Enter number to remove (1-" + StudentList.size() + "): ");
	            int choice = Integer.parseInt(sc.nextLine());

	            if (choice < 1 || choice > StudentList.size()) {
	                System.out.println("Invalid number, please try again.");
	                continue;
	            }

	            Student removed = StudentList.remove(choice - 1);
	            System.out.println("Removed: " + removed);
	            break;

	        } catch (NumberFormatException e) {
	            System.out.println("Please enter a valid number.");
	        }
	    }
	}
	
	// add to the list
	public void addStudentList(Student student) {
		StudentList.add(student);
	}
	
	public void displayStudentList() {
		StudentList.forEach(s -> System.out.println(s));
	}
	
	public List<Student> getStudentList() {
	    return StudentList;
	}

	public void setStudentList(List<Student> list) {
	    this.StudentList = list;
	}
}
