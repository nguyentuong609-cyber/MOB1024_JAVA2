package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import entity.Student;

public class StudentRepository {
	public List<Student> findAll(){
		List<Student> list = new ArrayList<>();
		
		try (Connection conn = DBConnect.getConnection()) {
			String sql = "select * from student";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = 	ps.executeQuery();
			while(rs.next()) {
//				int id = rs.getInt("student_iD");
				Student stu = new Student(
						rs.getInt("student_id"),
						rs.getString("student_name"),
						rs.getString("gender"),
						rs.getDouble("gpa"));
				list.add(stu);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return list;
		}
	}
	
	public void showAll() {
		this.findAll().stream().forEach(System.out :: println);
	}
	
	public Student findByID (int id) {
		try (Connection conn	 = DBConnect.getConnection()) {
			String sql = "select * from student where student_id =  ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
			    Student stu = new Student(
			        rs.getInt("student_id"),
			        rs.getString("student_name"),
			        rs.getString("gender"),
			        rs.getDouble("gpa")
			    );
			    return stu;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public void showByID (int id) {
		Student find = this.findByID(id);
		if(find != null) {
			System.out.println(find);
		}else {
			System.out.println("Student with ID " + id + " not found.");
		}
	}
	
	
	
	public boolean insertStudent(Student s) {
	    String sql = "INSERT INTO student (student_name, gender, gpa) VALUES (?, ?, ?)";

	    try (Connection conn = DBConnect.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setString(1, s.getStudent_name());
	        ps.setString(2, s.getGender());
	        ps.setDouble(3, s.getGpa());

	        return ps.executeUpdate() > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public void insertStatus (Student s) {
		boolean inserted = this.insertStudent(s);
		if(inserted) {
			System.out.println("Success!");
		}else {
			System.out.println("Can't inserted");
		}
	}
	
	public boolean updateStudent(Student s) {
	    String sql = "UPDATE student SET student_name = ?, gender = ?, gpa = ? WHERE student_id = ?";

	    try (Connection conn = DBConnect.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        // values to UPDATE
	        ps.setString(1, s.getStudent_name());
	        ps.setString(2, s.getGender());
	        ps.setDouble(3, s.getGpa());

	        // condition (WHICH student)
	        ps.setInt(4, s.getStudent_iD());

	        int rows = ps.executeUpdate();
	        return rows > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public boolean deleteStudent(int id) {
	    String sql = "DELETE FROM student WHERE student_id = ?";

	    try (Connection conn = DBConnect.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, id);

	        int rows = ps.executeUpdate();
	        return rows > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
}
