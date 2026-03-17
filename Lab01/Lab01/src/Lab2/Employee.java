package Lab2;


public class Employee {
	private String Id;
    private String Name;
    private double Salary;


    public String getId() {
        return Id;
    }

//    public void setId(String Id) {
//        if(Id == null){
//            throw new IllegalArgumentException("Employee must have an ID!");
//        }
//        this.Id = Id;
//    }
    
    public boolean setId(String Id) {
    	if(Id == null) {
    		return false;
    	}
    	this.Id = Id;
    	return true;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getSalary() {
        return Salary;
    }

//    public void setSalary(double Salary) {
//        if(Salary <= 0){
//            throw new IllegalArgumentException("Employee's salary must over 0");
//        }
//        this.Salary = Salary;
//    }
    
    public boolean setSalary(double salary) {
    	if(salary <= 0 ) {
    		return false;
    	}
    	this.Salary = salary;
    	return true;
    }
    
    public double Income() {
    	return this.Salary;
    }
    
    public Employee() {
    	
    }

    public Employee(String id, String name, double salary) {
    	setId(id);
    	setName(name);
    	setSalary(salary);
    }
    
    public void printEmployee() {
    	System.out.println("Employee's name: " + getName());
    	System.out.println("Employee's ID: "+ getId());
    	System.out.println("Income: " + Income());
    }
}

