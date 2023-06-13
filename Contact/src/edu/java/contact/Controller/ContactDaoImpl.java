package edu.java.contact.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.java.contact.model.Contact;
import oracle.jdbc.OracleDriver;

import static edu.java.contact.model.Contact.Entity.*;
import static edu.java.contact.ojdbc.OracleConnect.*;

public class ContactDaoImpl implements ContactDao {

	private static ContactDaoImpl instance = null;
	private ContactDaoImpl() {};
	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	
	// 오라클 DB 접속한 Connection 객체 리턴
	private Connection getConnection() throws SQLException {
		// 오라클 jdbc 드라이버 (라이브러리)를 등록
		DriverManager.registerDriver(new OracleDriver());
		// 오라클 db에 접속
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
	
	
	// insert into contacts (name, phone, email) values (?, ?, ?)
		private static final String SQL_INSERT = 
			"insert into " + TBL_NAME + " (" + COL_NAME + ", " + COL_PHONE + ", " + COL_EMAIL + ") values (?, ?, ?)";
	@Override
	public int create(Contact contact) {
		int result = 0; //insert 결과를 저장하고 리턴할 변수.
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getPhone());
			stmt.setString(3, contact.getEmail());
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

	// select * from contacts order by cid
		private static final String SQL_SELECT_ALL = 
				"select * from " + TBL_NAME  + " order by " + COL_CID;
	@Override
	public List<Contact> read() {
		ArrayList<Contact> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			System.out.println(SQL_SELECT_ALL);
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();
			while (rs.next()) { // select 결과에서 행 데이터가 있으면
				// 각 컬럼의 값을 읽음.
				int cid = rs.getInt(COL_CID);
				String name = rs.getString(COL_NAME);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				
				Contact contact = new Contact(cid, name, phone, email);
				list.add(contact);
				
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

	// select * from contacts where cid = ?;
	private static final String SQL_SELECT_BY_ID =
			"select * from " + TBL_NAME + " where " + COL_CID  + " = ?";
	
	@Override
	public Contact read(int cid) {
		Contact contact = null; // select 결과를 저장하고 리턴하기 위한 변수
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			System.out.println(SQL_SELECT_BY_ID);
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, cid);
			rs = stmt.executeQuery();
			if (rs.next()) { // 검색된 행(row) 데이터가 있다면 
				int id = rs.getInt(COL_CID);
				String name = rs.getString(COL_NAME);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				contact = new Contact(id, name, phone, email);				
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
		
		
		return contact;
	}

	
	// update contacts set name = ?, phone = ?, email = ? where cid = ?
	private static final String SQL_UPDATE = 
			"UPDATE " + TBL_NAME + " set " + COL_NAME + " = ?, " + COL_PHONE + " = ?, " + COL_EMAIL + " = ? where " + COL_CID + " = ?";
	@Override
	public int update(Contact contact) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getPhone());
			stmt.setString(3, contact.getEmail());
			stmt.setInt(4, contact.getCid());
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

	// delete from contacts where cid = ?
	private static final String SQL_DELETE = 
			"delete from " + TBL_NAME + " where " + COL_CID + " = ?";
	@Override
	public int delete(int cid) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, cid);
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
	
//	SELECT * FROM contacts	
//	WHERE LOWER(name) like LOWER('%22%')
//	    or LOWER(phone) like LOWER('%22%')
//	    or LOWER(email) like LOWER('%22%')
//	ORDER BY cid;
	private static final String SQL_READ_BY_KEYWORD = 
			"select * from " + TBL_NAME + " where lower(" + COL_NAME + ") like lower(?)"
					+ " or lower(" + COL_PHONE + ") like lower(?)"
					+ " or lower(" + COL_EMAIL + ") like lower(?)"
							+ " order by " + COL_CID; 
	@Override
	public List<Contact> read(String keyword) {
		ArrayList<Contact> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_READ_BY_KEYWORD);
			
			String key = "%" + keyword + "%";
			System.out.println("keyword = " + keyword + ", key = " + key);
			
			stmt.setString(1, key);
			stmt.setString(2, key);
			stmt.setString(3, key);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt(COL_CID);
				String name = rs.getString(COL_NAME);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				Contact contact = new Contact(cid, name, phone, email);
				list.add(contact);
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
