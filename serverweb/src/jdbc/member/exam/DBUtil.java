package jdbc.member.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DBMS에 접근하는 중복된 작업을 정의할 클래스
public class DBUtil {
	//1. 드라이버로딩은 클래스가 로딩될 때 같이 로딩되도록 처리
	//=> static{}안의 명령문은 클래스가 로딩될 때 한 번만 실행하는 코드
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//2. 커넥션하기 - DBMS와 접속 후에 접속정보를 저장하고 있는 Connection을 리턴
	public static Connection getConnect() {
		Connection con = null;
		// 원격에 있는 실제 DB서버 ip
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		// 접속계정
		String user = "scott";
		// 접속할 계정의 패스워드
		String password = "tiger";
		// 2. DBMS에 연결하기 - 연결정보를 정의
		// ==>DBMS에 연결하고 연결정보를 Connection타입으로 반환한다.
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	//3. 자원반납 - ResultSet, Statement, Connection객체 사용을 해제
	//		  => 각각의 객체를 해제할 수 있도록 메소드를 정의해도 좋다.
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
