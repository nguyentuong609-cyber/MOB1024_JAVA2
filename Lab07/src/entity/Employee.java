package entity;

import java.text.DecimalFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
	private Integer id;
	private String name;
	private double salary;
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###");
        return "Employee(ID=" + id + ", name=" + name + ", salary=" + df.format(salary) + ")";
    }
}
