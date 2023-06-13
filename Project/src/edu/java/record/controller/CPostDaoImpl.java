package edu.java.record.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.java.record.model.Culture;
import oracle.jdbc.OracleDriver;
import oracle.jdbc.proxy.annotation.Pre;

import static edu.java.record.model.Culture.Entity.*;
import static edu.java.record.ojdbc.OracleConnect.*;

public class CPostDaoImpl implements CPostDao {
	
	private static CPostDaoImpl instance = null;
	private CPostDaoImpl() {};
	public static CPostDaoImpl getInstance() {
		if (instance == null) {
			instance = new CPostDaoImpl();
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
	// INSERT INTO culture (start, vidit, loca, title, genre, produ, cast, con) values (?, ?, ?, ?, ?, ?, ?, ?)
	private static final String SQL_INSERT = 
			"insert into " + TBL_CNAME + " (" + COL_CATE + ", " + COL_CSTARDATE + ", " + COL_CVISITDATE + ", " + COL_CLOCA + ", " + COL_CTITLE + ", " 
	+ COL_CGENRE + ", " + COL_CPRODNAME + ", " + COL_CCASTNAME + ", " + COL_CCONTENT + ", " + COL_CCORE +
				") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	@Override
	public int create(Culture cul) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, cul.getCategory());
			stmt.setString(2, cul.getStartDate());
			stmt.setString(3, cul.getVisitedDate());
			stmt.setString(4, cul.getLocation());
			stmt.setString(5, cul.getTitle());
			stmt.setString(6, cul.getGenre());
			stmt.setString(7, cul.getProducerName());
			stmt.setString(8, cul.getCastName());
			stmt.setString(9, cul.getContent());
			stmt.setInt(10, cul.getCore());
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
			"SELECT * FROM " + TBL_CNAME + " WHERE " + COL_CCORE + "= ?";
	@Override
	public Culture read(int core) {
		Culture cul = null;
		
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
				int id = rs.getInt(COL_CID);
				int corenum = rs.getInt(COL_CCORE);
				String createdTime = rs.getString(COL_CCRETIME);
				String modifiedTime = rs.getString(COL_CMODTIME);
				String category = rs.getString(COL_CATE);
				String startDate = rs.getString(COL_CSTARDATE);
				String visitedDate = rs.getString(COL_CVISITDATE);
				String location = rs.getString(COL_CLOCA);
				String title = rs.getString(COL_CTITLE);
				String genre = rs.getString(COL_CGENRE);
				String producerName = rs.getString(COL_CPRODNAME);
				String castName = rs.getString(COL_CCASTNAME);
				String content = rs.getString(COL_CCONTENT);
			
				cul = new Culture(id, corenum, createdTime, modifiedTime, category, startDate, visitedDate, location, title, genre, producerName, castName, content);
				System.out.println(cul);
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
		return cul;
	}
	
	// 내용 수정으로. 수정은 해당 날짜에만 가능
//	update  everyday set content = '?', modified_time = sysdate where core = '?';
	private static final String SQL_UPDATE = 
			"update " + TBL_CNAME + " set " + COL_CCONTENT + " = ?, " +COL_CMODTIME+ " = sysdate "
					+ "WHERE " + COL_CCORE + "= ?";
	@Override
	public int update(Culture cul, int core) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			System.out.println("update conn" + conn);
			stmt = conn.prepareStatement(SQL_UPDATE);
			System.out.println("update stmt" + stmt);
			stmt.setString(1, cul.getContent());
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
