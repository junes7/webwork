package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.member.exam.DBUtil;

public class DeptDAOImpl implements DeptDAO {

	
	
	//�μ����
	public int insert(DeptDTO dept) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into MYDEPT values(?,?,?,?,?)");
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		try {
			//1.PreparedStatement��ü �����ϱ�
			con=DBUtil.getConnect();
			ptmt=con.prepareStatement(sql.toString());
			//2.?�� �����ϱ�
			ptmt.setString(1, dept.getDeptNo());
			ptmt.setString(2, dept.getDeptName());
			ptmt.setString(3, dept.getLoc());
			ptmt.setString(4, dept.getTel());
			ptmt.setString(5, dept.getMgr());
			//3.SQL�� �����ϱ�
			result=ptmt.executeUpdate();
			System.out.println(result+"�� �� ���� ����");

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	//��ü������
	@Override
	public ArrayList<DeptDTO> getDeptList() {
		ArrayList<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		DeptDTO dept = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from MYDEPT");
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			con=DBUtil.getConnect();
			ptmt=con.prepareStatement(sql.toString());
			rs=ptmt.executeQuery();
			while(rs.next()) {
				dept = new DeptDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5));
				deptlist.add(dept);
			}
			System.out.println("dao=>"+deptlist.size());
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return deptlist;
	}
	//�μ� ��� �� ���� ���� �� Ȯ�����
	@Override
	public int delete(String deptno) {
		Connection con = null;
		PreparedStatement ptmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from MYDEPT where deptno=?");
		int result=0;
		try {
			//1.PreparedStatement��ü �����ϱ�
			con=DBUtil.getConnect();
			ptmt=con.prepareStatement(sql.toString());
			//2. ?�� �����ϱ�
			ptmt.setString(1, deptno);
			//3. SQL�� �����ϱ�
			result = ptmt.executeUpdate();
			System.out.println(result+"�� �� ���� ����");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		
		return result;
	}
}
