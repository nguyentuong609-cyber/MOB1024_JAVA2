package Lab2;

public class FullTimeEmployee extends Employee{
	private double Bonues;
	private double Penalty;
	
	
	public double getBonues() {
		return Bonues;
	}
	public boolean setBonues(double bonues) {
		if(bonues <0) {
			return false;
		}
		this.Bonues = bonues;
		return true;
	}
	public double getPenalty() {
		return Penalty;
	}
	public boolean setPenalty(double penalty) {
		if(penalty < 0 ) {
			return false;
		}
		this.Penalty = penalty;
		return true;
	}
	
	public FullTimeEmployee() {}
	
	public FullTimeEmployee (String id, String name, double salary, double bonues, double penalty) {
		super(id, name, salary);
		setBonues(bonues);
		setPenalty(penalty);
	}
	
	@Override
	public double Income() {
		return super.getSalary() + this.Bonues - this.Penalty;
	}
	
	@Override
	public void printEmployee() {
		System.out.println("Employee's name: " + getName());
    	System.out.println("Employee's ID: "+ getId());
    	System.out.println("Salary: "+ Income());
	}
}