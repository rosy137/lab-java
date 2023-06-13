package edu.java.record.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.java.record.model.*;
import oracle.jdbc.OracleDriver;

import static edu.java.record.model.MonthlyGoal.Entity.*;
import static edu.java.record.ojdbc.OracleConnect.*;

public class MPostDaoImpl implements MPostDao {

	private static MPostDaoImpl instance = null;
	private MPostDaoImpl() {};
	public static MPostDaoImpl getInstance() {
		if(instance == null) {
			instance = new MPostDaoImpl();
		}
		return instance;
	}
	
	private Connection getConnection() throws SQLException{
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}
	
	private void closeResources(Connection conn, Statement stmt) throws SQLException {
		stmt.close();
		conn.close();	
	}
	
	private void closeResources(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		rs.close();
		closeResources(conn, stmt);
		
	}
	

	// select * from mongoal order by mid
	private static final String SQL_SELECT_ALL = 
		"select * from " + TBL_MNAME + " order by " + COL_MID ;
	@Override
	public List<MonthlyGoal> read() {
		ArrayList<MonthlyGoal> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
//			System.out.println("conn=" + conn);
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
//			System.out.println(stmt);
			rs = stmt.executeQuery();
//			System.out.println(rs);
			while (rs.next()) {
				int mid = rs.getInt(COL_MID);
				String goal = rs.getString(COL_MGOAL);
				
				MonthlyGoal mg = new MonthlyGoal(mid, goal);
				list.add(mg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	// insert into monthlygoal (goal) values (?);
	private static final String SQL_INSERT = 
			"insert into " + TBL_MNAME + " (" + COL_MGOAL + ") values (?)";
	@Override
	public int create(MonthlyGoal mg) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, mg.getGoal());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private static final String SQL_DELETE = 
			"delete from " + TBL_MNAME + " where " + COL_MID + " = ?";
	@Override
	public int delete(int mid) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, mid);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	

}