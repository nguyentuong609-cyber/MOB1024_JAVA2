package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import entity.Tree;

public class TreeRepository {
	public List<Tree> findAll(){
		
		List<Tree> list = new ArrayList<Tree>();
		
		try(Connection conn = DBConnect.getConnection()){
			String sql = "select * from tree";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Tree tree = new Tree(
							rs.getInt("node_id"),
							rs.getString("node_name"),
							rs.getInt("parent_id"),
							rs.getInt("level"));
				list.add(tree);
			}
			return list;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return list;
		}
	}
	
	public void showAll() {
		this.findAll().stream().forEach(System.out :: println);
	}
	
	public Tree findByID (int id) {
		try (Connection conn = DBConnect.getConnection()) {
			String sql = "select * from tree where node_id =  ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Tree tree = new Tree(
						rs.getInt("node_id"),
						rs.getString("node_name"),
						rs.getInt("parent_id"),
						rs.getInt("level"));
			    return tree;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public void showByID(int id) { 
		Tree find = findByID(id);
		if(find != null) {
			System.out.println(find);
		}else {
			System.out.println("Student with ID " + id + " not found.");
		}
	}
	
	public boolean insertTree (Tree tree) {
		String sql = "insert into tree (node_name, parent_id, level) values (? , ? ,?)";
		try(Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, tree.getNode_name());
			ps.setInt(2, tree.getParent_id());
			ps.setInt(3, tree.getLevel());
			
			return ps.executeUpdate() > 0;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public boolean deleteTree (int id) {
		String sql = "delete from tree where node_id = ? ";
		
		try (Connection conn = DBConnect.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			
//			int row = ps.executeUpdate();
//			return row > 0;
			return ps.executeUpdate() > 0;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
	public boolean updateTree(Tree tree) {
		String sql = "update tree set node_name = ?, parent_id = ?, level = ? where node_id = ?";
		
		try (Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, tree.getNode_name());
			ps.setInt(2, tree.getParent_id());
			ps.setInt(3, tree.getLevel());
			ps.setInt(4, tree.getNode_id());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return false;
	}
}
