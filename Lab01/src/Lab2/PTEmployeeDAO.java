package Lab2;
import java.util.Scanner;

public class PTEmployeeDAO extends PartTimeEmployee{
	public boolean nhapPartTimeEmployee(Scanner sc) {
		String Id;
		do {
			System.out.print("Nhap ID: ");
			Id = sc.nextLine();
		}while(!this.setId(Id));
		
		System.out.print("Nhap ten: ");
		this.setName(sc.nextLine());
		
		double salary;
		do {
			System.out.print("Nhap Luong: ");
			salary = sc.nextDouble();
		}while(!this.setSalary(salary));
		
		double workingHours;
		do {
			System.out.print("Nhap so gio lam: ");
			workingHours = sc.nextDouble();
		}while(!this.setWorkingHours(workingHours));
		
		double hourlyRates;
		do {
			System.out.print("Nhap hourly rates: ");
			hourlyRates = sc.nextDouble();
		}while(!this.setHourlyRates(hourlyRates));
		
		return true;
	}
}
