package Bai03;

import java.util.ArrayList;
import Bai02.Employee;

public class Bai03_main {
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
		
		
		System.out.println("Tong so Luong cua nhan vien: ");
		int total =  list.stream().mapToInt(x -> x.getSalary())
					.sum();
		System.out.println(total);
		
		System.out.println("Luong trung binh: ");
		int avg = total / list.size();
		System.out.println(avg);
		
		double average = list.stream()
							.mapToLong(Employee :: getSalary)
							.average()
							.orElse(0);
		System.out.println(average);
		
		System.out.println("Max salary: ");
		int max = list.stream().mapToInt(x -> x.getSalary())
				.max().getAsInt();
		System.out.println(max);
		
//		System.out.println("Max salary 2: ");
//		Employee maxSalary = list.stream()
//								.max(Com)
		
		
	}
}
