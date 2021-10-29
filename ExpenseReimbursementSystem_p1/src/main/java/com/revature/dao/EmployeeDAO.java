package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.util.List;

import com.revature.model.Employee;

public class EmployeeDAO {

	private static Connection conn = null;
	private static Statement stmt = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

public static List<Employee> findAll() {

		List<Employee> employees = new ArrayList<Employee>();
		String query = "select * from project1.employee";
		connect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Employee emp = new Employee ();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setPassword(rs.getString("password"));
				emp.setM_id(rs.getInt("m_id"));
				employees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return employees;
	}

public static Employee findById(int id) {
		Employee emp = new Employee ();
		String query = "select * from project1.employee where id=" + id;
		connect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setPassword(rs.getString("password"));
				emp.setM_id(rs.getInt("M_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return emp;
	}

	public static void save(Employee employee) {
		String query = "insert into project1.employee (name,email,password,m_id) values (?,?,?,?)";
		connect();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getEmail());
			pstmt.setString(3, employee.getPassword());
			pstmt.setInt(4, employee.getM_id());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
	}
	
	public static void update(int id, Employee employee) {
		
		String query = "update project1.employee set name=?, email=?, password=?, m_id=? where id=?";
		connect();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getEmail());
			pstmt.setString(3, employee.getPassword());
			pstmt.setInt(4, employee.getM_id());
			pstmt.setInt(5, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
	}
	
	public static void delete(int id) {
		String query = "delete from project1.employee where id="+id;
		connect();
		try {
			stmt=conn.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
	}

public static Connection connect() {
		String dbUrl = "jdbc:postgresql://revature.cgbxjgobnw7v.us-east-2.rds.amazonaws.com:5432/postgres";
		try {
			conn = DriverManager.getConnection(dbUrl, "postgres", "G3Hpapp!!24");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close() {

		try {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}