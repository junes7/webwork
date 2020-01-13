package jdbc.member.exam;
import java.util.ArrayList;
import java.util.Scanner;

import jdbc.board.exam.BoardDTO;

public class MenumUI {
	Scanner key = new Scanner(System.in);
	MemberDAO dao = new MemberDAOImpl();
	public void insertMenu(){
		//입사일은 오늘날짜 - sysdate, point = 1000가 삽입되도록
		
		System.out.println("*******사원등록********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("패스워드:");
		String pass = key.next();
		System.out.print("주소:");
		String addr = key.next();
		System.out.print("부서번호:");
		String deptno = key.next();
		System.out.print("성명:");
		String name = key.next();
		//여기에서 EmpDAO의 메소드를 호출하세요
		MemberDTO member = new MemberDTO(id,pass,name,addr,deptno);
		int result = dao.insert(member);
		//결과처리
		if(result>0) {
			System.out.println("게시글등록 성공");
		} else {
			 System.out.println("글 등록 실패");
		}
	}
	public void updateMenu(){
		System.out.println("*******사원수정********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("주소:");
		String addr = key.next();
		//여기에서 EmpDAO의 메소드를 호출하세요
		int result = dao.update(id,addr);
		//결과처리
		if(result>0) {
			System.out.println("게시글 수정 성공");
		} else {
			 System.out.println("글 수정 실패");
		}
	}
	public void deleteMenu(){
		System.out.println("*******사원삭제********");
		System.out.print("아이디:");
		String id = key.next();
		//여기에서 EmpDAO의 메소드를 호출하세요
		int result = dao.delete(id);
		//결과처리
		if(result>0) {
			System.out.println("게시글등록 성공");
		} else {
			 System.out.println("글 등록 실패");
		}
	}
	
	public void findByAddrMenu(){
		System.out.println("*******사원검색********");
		System.out.print("주소:");
		String addr = key.next();
		//여기에서 EmpDAO의 메소드를 호출하세요
		ArrayList<MemberDTO> memberlist = dao.findByAddr(addr);
		int size = memberlist.size();
		System.out.println("사이즈:"+size);
		for(int i=0; i<size; i++) {
			MemberDTO member = memberlist.get(i);
			System.out.println(member.getId()+"\t"+
			member.getPass()+"\t"+member.getName()+"\t"+member.getAddr()
			+"\t"+member.getDeptno()+"\t"+member.getHiredate()+"\t"+member.getPoint());
		}		
	}
	
	public void selectMenu(){
		System.out.println("*******사원조회********");
		//여기에서 EmpDAO의 메소드를 호출하세요 - 전체사원조회
		ArrayList<MemberDTO> memberlist = dao.memberList();
		int size = memberlist.size();
		System.out.println("사이즈:"+size);
		for(int i=0; i<size; i++) {
			MemberDTO member = memberlist.get(i);
			System.out.println(member.getId()+"\t"+
			member.getPass()+"\t"+member.getName()+"\t"+member.getAddr()
			+"\t"+member.getDeptno()+"\t"+member.getHiredate()+"\t"+member.getPoint());
		}
	}
	
	//사용자가 있으면 로그인 성공 사용자가 없으면 로그인 실패
	public void loginMenu(){
		//System.out.println("*******사원조회********");
		//여기에서 EmpDAO의 메소드를 호출하세요 - 전체사원조회
		System.out.println("******로그인*******");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("패스워드:");
		String pass = key.next();
		MemberDTO member = dao.login(id, pass);
		if(member==null) {
			System.out.println("로그인 실패!!조회된 데이터가 없습니다.");
		} else {
			System.out.println("로그인 성공");
			/*System.out.println("아이디:"+member.getId());
			System.out.println("패스워드:"+member.getPass());
			System.out.println("이름:"+member.getName());
			System.out.println("주소:"+member.getAddr());
			System.out.println("부서번호:"+member.getDeptno());
			System.out.println("고용날짜:"+member.getHiredate());
			System.out.println("조회수:"+member.getPoint());*/
		}		
	}
}
