package Bai03;


public class Bai03_main {
	public static void main(String[] args) {
		StudentService student = new StudentService();
		
		student.loadFromFile();
		student.displayStudentList();
		
		student.addStudentList(new Student("Quoc Anh", 4.0));
		student.addStudentList(new Student("Duy Anh", 3.8));
		student.addStudentList(new Student("Cat Tuong", 3.8));
		
		student.displayStudentList();
		
		student.saveToFile();
	}
}
