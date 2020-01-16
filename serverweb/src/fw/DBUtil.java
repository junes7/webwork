package fw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	//1.드라이버 로딩 한 번만 하기
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공!!");
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!!"+e.getMessage());
			e.printStackTrace();
		}
	}
	//2.커넥션하기
	public static Connection getConnect() {
		Connection con=null;
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="scott";
		String password="tiger";
		try {
			con=DriverManager.getConnection(url, user, password);
			System.out.println("DB접속 성공!!");
		} catch(SQLException e) {
			System.out.println("DB접속 실패!!"+e.getMessage());
			e.printStackTrace();
		}
		return con;
	}
	//3.자원 반납하기
	public static void Close(ResultSet rs,Statement stmt,Connection con) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
			System.out.println("자원반납 성공!!");
		} catch(SQLException e) {
			System.out.println("자원반납 실패!!"+e.getMessage());
			e.printStackTrace();
		}
	}
}
