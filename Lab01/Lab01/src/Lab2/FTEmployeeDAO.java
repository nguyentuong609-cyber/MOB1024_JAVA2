package Lab2;
import java.util.Scanner;


public class FTEmployeeDAO extends FullTimeEmployee{
	public boolean nhapFullTimeEmployee(Scanner sc) {
		String iD;
		do {
			System.out.print("Nhap ID: ");
			iD = sc.nextLine();
		}while(!this.setId(iD));
		
		System.out.print("Nhap Ten: ");
		this.setName(sc.nextLine());
		
		double salary;
		do {
			System.out.print("Nhap Luong: ");
			salary = sc.nextDouble();
		}while(!this.setSalary(salary));
		
		double bonus;
		do {
			System.out.print("NHap bonus: ");
			bonus = sc.nextDouble();
		}while(!this.setBonues(bonus));
		
		double penalty;
		do {
			System.out.print("Nhap penalty: ");
			penalty = sc.nextDouble();
		}while(!this.setPenalty(penalty));
		
		return true;
	}
}
