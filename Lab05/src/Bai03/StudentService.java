package Bai03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class StudentService {
	private List<Student> StudentList = new ArrayList<Student>();
	 private String filePath = "students.dat";
	
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
		if(StudentList.isEmpty()) { 
			System.out.println("No student in the list");
			return;
		}
		StudentList.forEach(s -> System.out.println(s));
	}
	
	// FILE Management 
	@SuppressWarnings("unchecked")
	public void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("No existing data found. Starting fresh.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
        	StudentList = (List<Student>) ois.readObject();
            System.out.println("Loaded " + StudentList.size() + " students from file.");
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
	
	public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(StudentList);
            System.out.println("Saved " + StudentList.size() + " students to file.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
