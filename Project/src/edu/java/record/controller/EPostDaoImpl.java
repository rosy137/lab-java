package edu.java.record.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.java.record.model.Everyday;
import oracle.jdbc.OracleDriver;
import oracle.jdbc.proxy.annotation.Pre;

import static edu.java.record.model.Everyday.Entity.*;
import static edu.java.record.ojdbc.OracleConnect.*;

public class EPostDaoImpl implements EPostDao {
	
	private static EPostDaoImpl instance = null;
	private EPostDaoImpl() {};
	public static EPostDaoImpl getInstance() {
		if (instance == null) {
			instance = new EPostDaoImpl();
		}
		return instance;
	}
	
	private Connection getConnection() throws SQLException{
		DriverManager.deregisterDriver(new OracleDriver());
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
	
	// 하루에 새로운 내용 추가
	// INSERT INTO EVERYDAY (CONTENT, MOOD, WORKOUT)
	private static final String SQL_INSERT = 
			"insert into " + TBL_ENAME + " (" + COL_ECONTENT + ", " + COL_EMOOD + ", " + COL_EWORKOUT + ", " + COL_ECORE +
				") values (?, ?, ?, ?)" ;
	@Override
	public int create(Everyday day) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, day.getContent());
			stmt.setString(2, day.getTodaysMood());
			stmt.setString(3, day.getWorkout());
			stmt.setInt(4, day.getCore());
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
	
	// 저장 된 내용중에 해당 날짜만 소환
	// SELECT * FROM EVERYDAY WHERE core = ?
	private static final String SQL_READ = 
			"SELECT * FROM " + TBL_ENAME + " WHERE " + COL_ECORE + "= ?";
	@Override
	public Everyday read(int core) {
		System.out.println("core=" + core);
		Everyday ed = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			System.out.println("read" + conn);
			stmt = conn.prepareStatement(SQL_READ);
			System.out.println("read" + stmt);
			stmt.setInt(1, core);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				int id = rs.getInt(COL_EID);
				int corenum = rs.getInt(COL_ECORE);
				String createdTime = rs.getString(COL_ECRETIME);
				String modifiedTime = rs.getString(COL_EMODTIME);
				String content = rs.getString(COL_ECONTENT);
				String mood = rs.getString(COL_EMOOD);
				String workout = rs.getString(COL_EWORKOUT);
			
				ed = new Everyday(id, corenum, createdTime, modifiedTime, content, mood, workout);
				System.out.println(ed);
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
		return ed;
	}
	
	// 내용 수정으로. 수정은 해당 날짜에만 가능
//	update  everyday set content = ?, modified_time = sysdate where core = '?';
	private static final String SQL_UPDATE = 
			"update " + TBL_ENAME + " set " + COL_ECONTENT + " = ?, " +COL_EMODTIME+ " = sysdate "
					+ "WHERE " + COL_ECORE + "= ?";
	@Override
	public int update(Everyday day, int core) {
		System.out.println("core=" + core);
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			System.out.println("update conn" + conn);
			stmt = conn.prepareStatement(SQL_UPDATE);
			System.out.println("update stmt" + stmt);
			stmt.setString(1, day.getContent());
			stmt.setInt(2, core);
			result = stmt.executeUpdate();
			System.out.println("update" + result);
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
