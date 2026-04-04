package Bai02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bai02_main {
	static String filePath = "Student.dat";
	
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Tuong", 3.8));
        students.add(new Student("Tony", 3.5));
        students.add(new Student("Dave", 3.2));
		
        saveToFile(students);
        
        loadFromFile();
		
	}
	
	// Serialize - write objects to file
    static void saveToFile(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(students);
            System.out.println("Successfully saved " + students.size() + " students to " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        } finally {
            System.out.println("Finished saving.");
        }
    }
    
 // Deserialize - read objects from file
    static void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            List<Student> loaded = (List<Student>) ois.readObject();
            System.out.println("\nLoaded " + loaded.size() + " students from " + filePath + ":");
            for (Student s : loaded) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } finally {
            System.out.println("Finished loading.");
        }
    }
}
