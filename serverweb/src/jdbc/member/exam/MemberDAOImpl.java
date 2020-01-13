package jdbc.member.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.board.exam.BoardDTO;
import jdbc.board.exam.DBUtil;

//DAO(Data Access Object)는 DB 관련 작업만 해 주는 클래스이다.
//tb_board 테이블을 액세스하는 기능이 정의된 클래스
//connection은 각 메소드마다 있어야 한다. Driver는 딱 한 번만 사용하면 된다.
public class MemberDAOImpl implements MemberDAO {
	@Override
	public int insert(MemberDTO member) {
		System.out.println("DTO사용 메소드:" + member);
		// 넘어오는 데이터를 확인하기 위해 위와 같이 출력해본다.
		// 연결 문자열 - 어떤 DBMS를 쓰느냐에 따라 형식이 달라진다.
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
		// "insert into tb_board values(1,'lee','prepared','연습',sysdate,0)";
		// 위와 같이 정적으로 값을 입력하는 것들을 정적 sql이라고 한다.
		int result = 0;// 실행결과가 리턴되는 변수
		try {
			con = DBUtil.getConnect();
			// 1. PreparedStatement 생성
			stmt = con.prepareStatement(sql.toString());
			// 2. ?에 값 전달하기
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPass());
			stmt.setString(3, member.getName());
			stmt.setString(4, member.getAddr());
			stmt.setString(5, member.getDeptno());

			// System.out.println("SQL을 실행하기 위한 객체정보:"+stmt);
			// 3. SQL 실행하기
			result = stmt.executeUpdate();
			// 4. 결과처리하기
			System.out.println(result + "개 행 삽입성공");

		} catch (SQLException e) {
			System.out.println("연결 실패:" + e.getMessage());
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
		// update 명령문 선언
		StringBuffer sql = new StringBuffer();
		sql.append("Update member ");
		sql.append("set addr=? ");
		sql.append("where id=?");
		int result = 0;// 결과값 저장할 변수
		try {
			con = DBUtil.getConnect();
			System.out.println("연결 성공!!" + con);
			// 1. PreparedStatement 생성
			stmt = con.prepareStatement(sql.toString());
			// 2. ?에 값 전달하기
			stmt.setString(1, addr);
			stmt.setString(2, id);
			// 3. SQL 실행하기
			System.out.println(12);
			result = stmt.executeUpdate();
			// 4. 결과처리하기
			System.out.println(result + "개 행이 수정됐습니다.");

		} catch (SQLException e) {
			System.out.println("연결 실패:" + e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}

	@Override
	public int delete(String id) {
		// 객체 변수 선언
		Connection con = null;
		PreparedStatement stmt = null;
		// update 명령문 선언
		StringBuffer sql = new StringBuffer();
		sql.append("delete member ");
		sql.append("where id=?");
		// String sql = "delete tb_board where boardnum=?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			System.out.println("연결 성공!!" + con);
			// 1. PreparedStatement 생성
			stmt = con.prepareStatement(sql.toString());
			// 2. ?에 값 전달하기
			stmt.setString(1, id);
			// 3. SQL 실행하기
			result = stmt.executeUpdate();
			// 4. 결과처리하기
			System.out.println(result + "개 행이 삭제됐습니다.");

		} catch (SQLException e) {
			System.out.println("연결 실패:" + e.getMessage());
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
		// 클래스 참조변수 선언
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from member");
		try {
			// 드라이버 로딩하고 커넥션 설정하기
			con = DBUtil.getConnect();
			// Statement객체 생성하기
			stmt = con.prepareStatement(sql.toString());
			// ResultSet에 statement 실행문 넣어 실행하기
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
		// 클래스 참조변수 선언
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from member where addr like ?");
		try {
			// 드라이버 로딩하고 커넥션 설정하기
			con = DBUtil.getConnect();
			// Statement객체 생성하기
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, "%" + addr + "%");
			// ResultSet에 statement 실행문 넣어 실행하기
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
		// 클래스 참조변수 선언
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from member where id=? and pass=?");
		try {
			// 드라이버 로딩하고 커넥션 설정하기
			con = DBUtil.getConnect();
			// Statement객체 생성하기
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, id);
			stmt.setString(2, pass);
			// ResultSet에 statement 실행문 넣어 실행하기
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