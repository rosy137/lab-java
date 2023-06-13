package edu.java.record.ojdbc;

public interface OracleConnect {
	// Oracle DB 접속 URL
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";//내놋북	
//	String URL = "jdbc:oracle:thin:@1.1.1.28.:1521:xe";
//	String URL = "jdbc:oracle:thin:@192.168.20.8:1521:xe";// 학원
	// Oracle DB 접속 계정
	String USER = "scott";
//	String USER = "SCOTT";
	// Oracle DB 접속 계정 비밀번호
	String PASSWORD = "tiger";
//	String PASSWORD = "TIGER";
}