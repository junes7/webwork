package fw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	//1.����̹� �ε� �� ���� �ϱ�
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����!!");
		} catch(ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����!!"+e.getMessage());
			e.printStackTrace();
		}
	}
	//2.Ŀ�ؼ��ϱ�
	public static Connection getConnect() {
		Connection con=null;
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="scott";
		String password="tiger";
		try {
			con=DriverManager.getConnection(url, user, password);
			System.out.println("DB���� ����!!");
		} catch(SQLException e) {
			System.out.println("DB���� ����!!"+e.getMessage());
			e.printStackTrace();
		}
		return con;
	}
	//3.�ڿ� �ݳ��ϱ�
	public static void Close(ResultSet rs,Statement stmt,Connection con) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
			System.out.println("�ڿ��ݳ� ����!!");
		} catch(SQLException e) {
			System.out.println("�ڿ��ݳ� ����!!"+e.getMessage());
			e.printStackTrace();
		}
	}
}
