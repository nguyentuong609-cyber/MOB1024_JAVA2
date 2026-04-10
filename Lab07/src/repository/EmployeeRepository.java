package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import entity.Employee;

public class EmployeeRepository {
	
	public List<Employee> findAll(){
		String sql = "select * from employee";
		
		List<Employee> list = new ArrayList<Employee>();
		
		try(Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				Employee employee = new Employee(
									rs.getInt("id"),
									rs.getString("name"),
									rs.getDouble("salary"));
				list.add(employee);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}
	}
	
	public void showAll() {
		this.findAll().stream().forEach(System.out::println);
	}
	
	public Employee findByID(int id) {
		String sql = "select * from employee where id = ? ";
		try (Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery(); 
			if (rs.next()) {
				Employee emp = new Employee(
								rs.getInt("id"),
								rs.getString("name"),
								rs.getDouble("salary"));
				return emp;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean addNew (Employee employee) {
		String sql = "insert into employee (name, salary) values (? , ?)";
		try (Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, employee.getName());
			ps.setDouble(2, employee.getSalary());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteEmp (int id) {
		String sql = "delte from tree where id = ? ";
		try (Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setInt(1, id);
				
				return ps.executeUpdate() > 0;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
	}
	public boolean updateEmp (Employee employee) {
		String sql = "insert into employee (name, salary) values (? , ?)";
		try (Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, employee.getName());
			ps.setDouble(2, employee.getSalary());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
