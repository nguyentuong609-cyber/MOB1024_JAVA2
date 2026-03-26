package Bai02;
import java.util.ArrayList;
import java.util.Comparator;

public class Bai02_main {
	public static void main(String[] args) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		list.add(new Employee("E001", "Nguyen Van An", 15000000));
		list.add(new Employee("E002", "Tran Thi Bich", 18500000));
		list.add(new Employee("E003", "Le Hoang Long", 22000000));
		list.add(new Employee("E004", "Pham Minh Duc", 12000000));
		list.add(new Employee("E005", "Vu Hoang Yen", 35000000));
		list.add(new Employee("E006", "Dang Thu Thao", 27500000));
		list.add(new Employee("E007", "Bui Quang Hai", 19000000));
		list.add(new Employee("E008", "Do Thanh Tung", 16800000));
		
		
		System.out.println("List of Employee:");
		list.forEach(x -> x.printEmployee());
		
		System.out.println("");
		System.out.println("All employee with over 15000000");
		list.stream()
			.filter(x -> x.getSalary() > 15000000)
			.forEach(x -> x.printEmployee());
		
		System.out.println("");
		System.out.println("Sorted by salary descending:");
		list.stream()
			.sorted((x,y) -> x.getSalary() - y.getSalary())
			.forEach(z -> z.printEmployee());
		
		list.stream()
			.sorted(Comparator.comparing(Employee :: getSalary).reversed())
			.forEach(System.out::println);;
		
		System.out.println("");
		System.out.println("Employee who has letter A in their name:");
		int count = (int) 
		list.stream()
			.filter(x -> x.getName().toLowerCase().contains("a"))
			.count();
		System.out.println(count);
		
		System.out.println("Count Employee who has letter A in their name:");
		int i = 0;
		for(Employee x : list) {
			if(x.getName().toLowerCase().contains("a")) {
				 i ++;
			}
		}
		System.out.println(i);
		
//		long count = list.stream()
//						.filter(employee -> !employee.getName().isEmpty() &&
//								(employee.getName().charAt(0) == "A") || employee.getName().charAt(0) == "a")
//						.count();
		
	}
}