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

import static edu.java.record.model.Dday.Entity.*;
import static edu.java.record.ojdbc.OracleConnect.*;

public class DPostDaoImpl implements DPostDao {

	private static DPostDaoImpl instance = null;
	private DPostDaoImpl() {};
	public static DPostDaoImpl getInstance() {
		if(instance == null) {
			instance = new DPostDaoImpl();
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
		"select * from " + TBL_DNAME + " order by " + COL_DID ;
	@Override
	public List<Dday> read() {
		ArrayList<Dday> list = new ArrayList<>();
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
				int mid = rs.getInt(COL_DID);
				String title = rs.getString(COL_DTITLE);
				String dcount = rs.getString(COL_DCOUNT);
				Dday mg = new Dday(mid, title, dcount);
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
	
	// insert into monthlygoal (goal,) values (?,?);
	private static final String SQL_INSERT = 
			"insert into " + TBL_DNAME + " (" + COL_DTITLE + ", " + COL_DCOUNT + ") values (?, ?)";
	@Override
	public int create(Dday d) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, d.getDtitle());
			stmt.setString(2, d.getDcount());
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
			"delete from " + TBL_DNAME + " where " + COL_DID + " = ?";
	@Override
	public int delete(int did) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, did);
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