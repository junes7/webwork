package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dept.DeptDTO;
import jdbc.member.exam.DBUtil;

public class MemberDAO {
	
	public int insert(MemberDTO member) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into member values(?,?,?,?,?,?,?)");
		//Ŭ���� �������� ����
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		try {
			//1.PrepareStatement��ü �����ϱ�
			con=DBUtil.getConnect();
			ptmt=con.prepareStatement(sql.toString());
			//2.?�� �����ϱ�
			ptmt.setString(1, member.getId());
			ptmt.setString(2, member.getPass());
			ptmt.setString(3, member.getName());
			ptmt.setString(4, member.getAddr());
			ptmt.setString(5, member.getDeptno());
			ptmt.setString(6, member.getGrade());
			ptmt.setInt(7, member.getPoint());
			//3.SQL�� �����ϱ�			
			result = ptmt.executeUpdate();
			System.out.println(result+"�� �� ���� ����!!");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	public ArrayList<MemberDTO> getMemberList(){
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from member");
		//Ŭ���� �������� ����
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			//1.PreparedStatement��ü �����ϱ�
			con=DBUtil.getConnect();
			ptmt=con.prepareStatement(sql.toString());
			rs=ptmt.executeQuery();
			while(rs.next()) {
				member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
				memberlist.add(member);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return memberlist;
	}
	
	public int delete(String id){
		Connection con=null;
		PreparedStatement ptmt=null;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from member where id=?");
		int result=0;
		try {
			//1.PreparedStatement��ü �����ϱ�
			con=DBUtil.getConnect();
			ptmt=con.prepareStatement(sql.toString());
			//2.?�� �����ϱ�
			ptmt.setString(1, id);
			//3.SQL�� �����ϱ�
			result = ptmt.executeUpdate();
			System.out.println(result+"�� �� ���� ����");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
	
		return result;
	}
	
	public MemberDTO read(String id){
		MemberDTO member = null;
		//Ŭ���� �������� ����
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from member where id=?");
		try {
			con=DBUtil.getConnect();
			ptmt=con.prepareStatement(sql.toString());
			ptmt.setString(1, id);
			rs=ptmt.executeQuery();
			if(rs.next()) {
				member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return member;
	}
}
