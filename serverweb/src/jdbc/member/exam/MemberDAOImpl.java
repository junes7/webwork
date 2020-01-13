package jdbc.member.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.board.exam.BoardDTO;
import jdbc.board.exam.DBUtil;

//DAO(Data Access Object)�� DB ���� �۾��� �� �ִ� Ŭ�����̴�.
//tb_board ���̺��� �׼����ϴ� ����� ���ǵ� Ŭ����
//connection�� �� �޼ҵ帶�� �־�� �Ѵ�. Driver�� �� �� ���� ����ϸ� �ȴ�.
public class MemberDAOImpl implements MemberDAO {
	@Override
	public int insert(MemberDTO member) {
		System.out.println("DTO��� �޼ҵ�:" + member);
		// �Ѿ���� �����͸� Ȯ���ϱ� ���� ���� ���� ����غ���.
		// ���� ���ڿ� - � DBMS�� �����Ŀ� ���� ������ �޶�����.
		Connection con = null;
		PreparedStatement stmt = null;
		/*
		 * String sql = "insert into tb_board values(board_seq.nextval,'"+ id + "','"+
		 * title + "','" + content + "',sysdate,0)";
		 */
		StringBuffer sql = new StringBuffer();
		sql.append("insert into member ");
		sql.append("values(?,?,");
		sql.append("?,?,?,sysdate,1000)");
		// String sql = "insert into tb_board
		// values(board_seq.nextval,?,?,?,sysdate,0)";
		// "insert into tb_board values(1,'lee','prepared','����',sysdate,0)";
		// ���� ���� �������� ���� �Է��ϴ� �͵��� ���� sql�̶�� �Ѵ�.
		int result = 0;// �������� ���ϵǴ� ����
		try {
			con = DBUtil.getConnect();
			// 1. PreparedStatement ����
			stmt = con.prepareStatement(sql.toString());
			// 2. ?�� �� �����ϱ�
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPass());
			stmt.setString(3, member.getName());
			stmt.setString(4, member.getAddr());
			stmt.setString(5, member.getDeptno());

			// System.out.println("SQL�� �����ϱ� ���� ��ü����:"+stmt);
			// 3. SQL �����ϱ�
			result = stmt.executeUpdate();
			// 4. ���ó���ϱ�
			System.out.println(result + "�� �� ���Լ���");

		} catch (SQLException e) {
			System.out.println("���� ����:" + e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}

	@Override
	public int update(String id, String addr) {
		Connection con = null;
		PreparedStatement stmt = null;
		// update ��ɹ� ����
		StringBuffer sql = new StringBuffer();
		sql.append("Update member ");
		sql.append("set addr=? ");
		sql.append("where id=?");
		int result = 0;// ����� ������ ����
		try {
			con = DBUtil.getConnect();
			System.out.println("���� ����!!" + con);
			// 1. PreparedStatement ����
			stmt = con.prepareStatement(sql.toString());
			// 2. ?�� �� �����ϱ�
			stmt.setString(1, addr);
			stmt.setString(2, id);
			// 3. SQL �����ϱ�
			System.out.println(12);
			result = stmt.executeUpdate();
			// 4. ���ó���ϱ�
			System.out.println(result + "�� ���� �����ƽ��ϴ�.");

		} catch (SQLException e) {
			System.out.println("���� ����:" + e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}

	@Override
	public int delete(String id) {
		// ��ü ���� ����
		Connection con = null;
		PreparedStatement stmt = null;
		// update ��ɹ� ����
		StringBuffer sql = new StringBuffer();
		sql.append("delete member ");
		sql.append("where id=?");
		// String sql = "delete tb_board where boardnum=?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			System.out.println("���� ����!!" + con);
			// 1. PreparedStatement ����
			stmt = con.prepareStatement(sql.toString());
			// 2. ?�� �� �����ϱ�
			stmt.setString(1, id);
			// 3. SQL �����ϱ�
			result = stmt.executeUpdate();
			// 4. ���ó���ϱ�
			System.out.println(result + "�� ���� �����ƽ��ϴ�.");

		} catch (SQLException e) {
			System.out.println("���� ����:" + e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}

	@Override
	public ArrayList<MemberDTO> memberList() {
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		// Ŭ���� �������� ����
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from member");
		try {
			// ����̹� �ε��ϰ� Ŀ�ؼ� �����ϱ�
			con = DBUtil.getConnect();
			// Statement��ü �����ϱ�
			stmt = con.prepareStatement(sql.toString());
			// ResultSet�� statement ���๮ �־� �����ϱ�
			rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println();
				member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6), rs.getInt(7));
				memberlist.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, con);
		}
		return memberlist;
	}

	@Override
	public ArrayList<MemberDTO> findByAddr(String addr) {
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		// Ŭ���� �������� ����
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from member where addr like ?");
		try {
			// ����̹� �ε��ϰ� Ŀ�ؼ� �����ϱ�
			con = DBUtil.getConnect();
			// Statement��ü �����ϱ�
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, "%" + addr + "%");
			// ResultSet�� statement ���๮ �־� �����ϱ�
			rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println();
				member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6), rs.getInt(7));
				memberlist.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, con);
		}
		return memberlist;
	}

	@Override
	public MemberDTO login(String id, String pass) {
		MemberDTO member = null;
		// Ŭ���� �������� ����
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from member where id=? and pass=?");
		try {
			// ����̹� �ε��ϰ� Ŀ�ؼ� �����ϱ�
			con = DBUtil.getConnect();
			// Statement��ü �����ϱ�
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, id);
			stmt.setString(2, pass);
			// ResultSet�� statement ���๮ �־� �����ϱ�
			rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println();
				member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6), rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, con);
		}
		return member;
	}
}