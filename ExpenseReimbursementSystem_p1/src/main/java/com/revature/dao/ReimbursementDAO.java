package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Reimbursement;

public class ReimbursementDAO {

	private static Connection conn = null;
	private static Statement stmt = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

	public static List<Reimbursement> findAll() {

		List<Reimbursement> Reimbursements = new ArrayList<Reimbursement>();
		String query = "select * from project1.reimbursement";
		connect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Reimbursement rimb = new Reimbursement();
				rimb.setRid(rs.getInt("id"));
				rimb.setAmount(rs.getInt("amount"));
				rimb.setEmployee_note("employee_note");
				rimb.setManager_note(rs.getString("manager_note"));
				rimb.setTime(rs.getTimestamp("time"));
				Reimbursements.add(rimb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return Reimbursements;
	}

	public static Reimbursement findById(int id) {
		Reimbursement rimb = new Reimbursement();
		String query = "select * from project1.reimbursement where id=" + id;
		connect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				rimb.setRid(rs.getInt("id"));
				rimb.setAmount(rs.getInt("amount"));
				rimb.setEmployee_note("employee_note");
				rimb.setManager_note(rs.getString("manager_note"));
				rimb.setTime(rs.getTimestamp("time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return rimb;
	}

	public static void save(Reimbursement reimbursement) {
		String query = "insert into project1.reimbursement (amount,employee_note,manager_note,time) values (?,?,?,?)";
		connect();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reimbursement.getAmount());
			pstmt.setString(2, reimbursement.getEmployee_note());
			pstmt.setString(3, reimbursement.getManager_note());
			pstmt.setTimestamp(4, reimbursement.getTime());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
	}

	public static void update(int id, Reimbursement reimbursement) {

		String query = "update project1.reimbursement set amount=?, employee_note=?, manager_note=?, time=? where id=?";
		connect();
		try {
			pstmt.setInt(1, reimbursement.getAmount());
			pstmt.setString(2, reimbursement.getEmployee_note());
			pstmt.setString(3, reimbursement.getManager_note());
			pstmt.setTimestamp(4, reimbursement.getTime());
			pstmt.setInt(5, reimbursement.getRid());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
	}

	public static void delete(int id) {
		String query = "delete from reimbursement where id=" + id;
		connect();
		try {
			stmt = conn.createStatement();
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
