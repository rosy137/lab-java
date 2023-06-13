package edu.java.jdbc.oracle;

// SCOTT	scott@//localhost:1521/xe // oracle 접속에서 확인 가능
//					server ip:port/SID service id

public interface OracleConnect {
	// 인터페이스의 필드는 public static final만 가능. public static final은 생략.
	// 오라클 데이터베이스 서버 접속 주소
	// local host: 현재 개인 PC // cmb 
	String URL = "jdbc:oracle:thin:@192.168.20.8:1521:xe";
//	String URL = "jdbc:oracle:thin:@192.168.20.31:1521:xe"; // 쌤
//	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	//								server ip:port:SID
	// 오라클 데이터베이스 서버 계정
	String USER = "scott";
	// 오라클 데이터베이스 서버 비밀번호
	String PASSWORD = "tiger";
	
}
