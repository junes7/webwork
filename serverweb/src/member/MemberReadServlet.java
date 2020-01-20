package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "member/read", urlPatterns = { "/member/read.do" })
public class MemberReadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html;charset=euc-kr");
		//1.요청정보추출
		//-클라이언트가 직접 폼태그에 입력한 데이터 필요에 의해서 넘긴 파라미터 추출
		PrintWriter read = response.getWriter();
		System.out.println("서블릿");
		String id = request.getParameter("id");
		//2.비지니스메소드 호출
		// -DeptDAO클래스에 메소드 추가하고 호출하기	
		MemberDAO dao = new MemberDAO();
		MemberDTO member = dao.read(id);
		
		//3. jsp로 넘겨 줄 데이터 공유하기
		request.setAttribute("member", member);
		System.out.println("ReadServlet실행완료");	
		//4. 요청재지정 
		//RequestDispatcher클래스는 request 관리 클래스이다.
		RequestDispatcher rd = 
			request.getRequestDispatcher("/member/member_read.jsp");
		rd.forward(request, response);	
	}
}
