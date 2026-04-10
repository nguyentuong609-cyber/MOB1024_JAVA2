package Bai04;


import java.io.*;
import java.util.*;

import Bai03.Student;

public class FileService {
	private static final String FILE_PATH = "Bai04.dat";
	
	// SAVE FILE
	public static void saveToFile(List<Student> students) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
			oos.writeObject(students);
			System.out.println("Saved " + students.size() +  "students to file");
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	// LOAD FILE
	@SuppressWarnings("unchecked")
	public static List<Student> loadFromFile() {
        File file = new File(FILE_PATH);

        // Check if file exists and has data
        if (!file.exists()) {
            System.out.println("No saved data found, starting fresh.");
            return new ArrayList<>(); // return empty list instead of null
        }

        if (file.length() == 0) {
            System.out.println("File is empty, starting fresh.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            List<Student> students = (List<Student>) ois.readObject();
            System.out.println("Loaded " + students.size() + " students from file.");
            return students;
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }

        return new ArrayList<>(); // return empty list if something went wrong
    }
	
	
}
