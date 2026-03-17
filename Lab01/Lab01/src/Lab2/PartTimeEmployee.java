package Lab2;

public class PartTimeEmployee extends Employee{
	private double workingHours;
	private double hourlyRates;
	
	
	public double getWorkingHours() {
		return workingHours;
	}
	public boolean setWorkingHours(double workingHours) {
		if(workingHours < 0) {
			return false;
		}
		this.workingHours = workingHours;
		return true;
	}
	public double getHourlyRates() {
		return hourlyRates;
	}
	public boolean setHourlyRates(double hourlyRates) {
		if(hourlyRates < 0) {
			return false;
		}
		this.hourlyRates = hourlyRates;
		return true;
	}
	
	public PartTimeEmployee() {}
	
	public PartTimeEmployee(String id, String name, double salary, double workinghours, double hourlyrates) {
		super(id, name, salary);
		setWorkingHours(workinghours);
		setHourlyRates(hourlyrates);
	}
	
	@Override
	public double Income() {
		return getWorkingHours() * getHourlyRates();
	}
	
	@Override
	public void printEmployee() {
		System.out.println("Employee's name: " + getName());
    	System.out.println("Employee's ID: "+ getId());
    	System.out.println("Salary: "+ Income());
	}
}
