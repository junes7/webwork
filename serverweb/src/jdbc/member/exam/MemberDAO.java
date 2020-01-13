package jdbc.member.exam;

import java.util.ArrayList;

public interface MemberDAO {
	int insert(MemberDTO user);						//사원등록
	int update(String id, String addr);				//사원정보수정
	int delete(String id);							//사원탈퇴
	ArrayList<MemberDTO> memberList();				//전체사원목록조회
	ArrayList<MemberDTO> findByAddr(String addr);	//주소로 검색하기
	MemberDTO login(String id, String pass); 		//로그인
}