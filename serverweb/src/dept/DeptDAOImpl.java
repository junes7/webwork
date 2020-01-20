package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.member.exam.DBUtil;

public class DeptDAOImpl implements DeptDAO {

	
	
	//부서등록
	public int insert(DeptDTO dept) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into MYDEPT values(?,?,?,?,?)");
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		try {
			//1.PreparedStatement객체 생성하기
			con=DBUtil.getConnect();
			ptmt=con.prepareStatement(sql.toString());
			//2.?값 삽입하기
			ptmt.setString(1, dept.getDeptNo());
			ptmt.setString(2, dept.getDeptName());
			ptmt.setString(3, dept.getLoc());
			ptmt.setString(4, dept.getTel());
			ptmt.setString(5, dept.getMgr());
			//3.SQL문 실행하기
			result=ptmt.executeUpdate();
			System.out.println(result+"개 행 삽입 성공");

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	//전체목록출력
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
	//부서 목록 중 선택 삭제 및 확인출력
	@Override
	public int delete(String deptno) {
		Connection con = null;
		PreparedStatement ptmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from MYDEPT where deptno=?");
		int result=0;
		try {
			//1.PreparedStatement객체 생성하기
			con=DBUtil.getConnect();
			ptmt=con.prepareStatement(sql.toString());
			//2. ?값 삽입하기
			ptmt.setString(1, deptno);
			//3. SQL문 실행하기
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삭제 성공");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		
		return result;
	}
	@Override
	public DeptDTO read(String deptno) {
		System.out.println("dao의 read호출");
		DeptDTO dept = null;
		//클래스 참조변수 선언
		Connection con=null;
		PreparedStatement ptmt=null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from MYDEPT where deptno=?");
		try {
			//1.preparedStatement객체 생성하기
			con=DBUtil.getConnect();
			ptmt=con.prepareStatement(sql.toString());
			//2.?값 삽입하기
			ptmt.setString(1, deptno);
			//3.SQL문 실행하기
			rs=ptmt.executeQuery(); //select실행
			//실행결과를 자바객체로 변환
			// -레코드가 여러 개: DTO로 레코드를 변환하고 Arraylist에 add
			// -레코드가 한 개: DTO로 레코드 변환
			while(rs.next()) { //rs.next()가 레코드 검색하는 역할을 해준다.
				dept = new DeptDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5));
			}
			//레코드가 한 개인 경우에는 있는지 없는지를 판단해서 있으면 아래와 같이 DeptDTO레코드를 생성해준다.
/*			if(rs.next()) {
				dept = new DeptDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5));
			}*/
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return dept;
	}
}
