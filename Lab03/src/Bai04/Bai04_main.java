package Bai04;

import java.util.ArrayList;
import java.util.Comparator;

import Bai04.Student.StudentType;


public class Bai04_main {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		
		list.add(new Student("SV001", "Tuong", 4.0, Student.StudentType.REGULAR));
		list.add(new Student("SV002", "Linh", 2.5, Student.StudentType.PART_TIME));
		list.add(new Student("SV003", "An", 4.0, Student.StudentType.INTERNATIONAL));
		list.add(new Student("SV004", "Minh", 3.5, Student.StudentType.REGULAR));
		list.add(new Student("SV005", "Huy", 3.8, Student.StudentType.PART_TIME));
		list.add(new Student("SV006", "Trang", 2.8, Student.StudentType.INTERNATIONAL));
		
		
		System.out.println("Student who is REGULAR");
		list.stream()
			.filter(x -> x.getType() == StudentType.PART_TIME)
			.filter(x -> x.getGPA() > 3.2)
			.forEach(x -> x.printSV());
		
		list.stream()
			.sorted(Comparator.comparingDouble(Student::getGPA).reversed())
			.limit(3)
			.forEach(Student -> Student.printSV());
		
	}
}
