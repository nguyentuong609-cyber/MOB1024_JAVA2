package Bai01;

import java.util.Scanner;

public class Bai01_main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService studentList = new StudentService();
		
		while(true) {
			Student s = studentList.addNewStudent(sc);  // create new student
			studentList.addStudentList(s);				// add student to the list
			
			System.out.print("Continue ? (y/n): ");
			if(sc.nextLine().equalsIgnoreCase("n")) {
				break;
			}
		}
		
		studentList.displayStudentList();
	}
}
