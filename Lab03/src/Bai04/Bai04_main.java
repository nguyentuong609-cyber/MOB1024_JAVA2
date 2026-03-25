package Bai04;

import java.util.ArrayList;

public class Bai04_main {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		
		list.add(new Student("SV001", "Tuong", Student.StudentType.REGULAR));
		list.add(new Student("SV002", "Linh", Student.StudentType.PART_TIME));
		list.add(new Student("SV003", "An", Student.StudentType.INTERNATIONAL));
		list.add(new Student("SV004", "Minh", Student.StudentType.REGULAR));
		list.add(new Student("SV005", "Huy", Student.StudentType.PART_TIME));
		list.add(new Student("SV006", "Trang", Student.StudentType.INTERNATIONAL));
		
		
		System.out.println("Student who is REGULAR");
		list.stream()
			.filter(x -> x.getType().equals(Student.StudentType.REGULAR))
			.forEach(x -> x.printSV());
	}
}
