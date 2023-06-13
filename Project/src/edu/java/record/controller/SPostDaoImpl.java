package edu.java.record.controller;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.java.record.model.Culture;
import edu.java.record.model.Everyday;
import oracle.jdbc.OracleDriver;
import oracle.jdbc.proxy.annotation.Pre;

import static edu.java.record.model.Culture.Entity.*;
import static edu.java.record.model.Everyday.Entity.*;
import static edu.java.record.ojdbc.OracleConnect.*;

public class SPostDaoImpl implements SPostDao {

	private static SPostDaoImpl instance = null;

	private SPostDaoImpl() {
	};

	public static SPostDaoImpl getInstance() {
		if (instance == null) {
			instance = new SPostDaoImpl();
		}
		return instance;
	}

	private Connection getConnection() throws SQLException {
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

//	select * from everyday where content like '%?%' order by core;
	private static final String SQL_READE_BY_KEYWORD = 
			"select * from " + TBL_ENAME + " where " + COL_ECONTENT + " like ? order by " + COL_ECORE;

	@Override
	public List<Everyday> readE(String keyword) {
		ArrayList<Everyday> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			System.out.println("read" + conn);
			stmt = conn.prepareStatement(SQL_READE_BY_KEYWORD);
			System.out.println("read" + stmt);
			String kw = "%" + keyword + "%";
			stmt.setString(1, kw);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(COL_EID);
				int corenum = rs.getInt(COL_ECORE);
				String createdTime = rs.getString(COL_ECRETIME);
				String modifiedTime = rs.getString(COL_EMODTIME);
				String content = rs.getString(COL_ECONTENT);
				String mood = rs.getString(COL_EMOOD);
				String workout = rs.getString(COL_EWORKOUT);

				Everyday ed = new Everyday(id, corenum, createdTime, modifiedTime, content, mood, workout);
				System.out.println(ed);
				list.add(ed);
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

	// select * from culture where (CATEGORY||LOCATION||TITLE||GENRE||PRO_NM||CAST_NAME||CONTENT)
	// like ? order by core;
	private static final String SQL_CEADE_BY_KEYWORD = 
			"select * from " + TBL_CNAME + " where (" + COL_CATE + "||" + COL_CLOCA + "||" + COL_CTITLE + "||"
					+ COL_CGENRE + "||" + COL_CPRODNAME + "||" + COL_CCASTNAME + "||" + COL_CCONTENT + ")"
					+" like ? order by " + COL_ECORE;

	@Override
	public List<Culture> readC(String keyword) {
		ArrayList<Culture> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			System.out.println("read" + conn);
			stmt = conn.prepareStatement(SQL_CEADE_BY_KEYWORD);
			System.out.println("read" + stmt);
			String kw = "%" + keyword + "%";
			stmt.setString(1, kw);
			rs = stmt.executeQuery();

			while (rs.next()) {
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

				Culture cul = new Culture(id, corenum, createdTime, modifiedTime, category, startDate, visitedDate, location,
						title, genre, producerName, castName, content);
				System.out.println(cul);
				list.add(cul);
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

}
