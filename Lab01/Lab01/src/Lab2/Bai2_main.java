package Lab2;
import java.util.ArrayList;
import java.util.Scanner;

public class Bai2_main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		list.add(new FullTimeEmployee("FT001", "Alice Johnson", 1200, 200, 50));
		list.add(new FullTimeEmployee("FT002", "Michael Tran", 1500, 300, 100));
		list.add(new FullTimeEmployee("FT003", "Sophia Nguyen", 1800, 250, 0));
		list.add(new PartTimeEmployee("PT001", "David Lee", 0, 80, 12));
		list.add(new PartTimeEmployee("PT002", "Emma Pham", 0, 60, 15));
		
		
		
		for (Employee x : list) {
			x.printEmployee();
		}
	}
}
