package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDAO;
import dept.DeptDAOImpl;
import dept.DeptDTO;

@WebServlet(name = "member/list", urlPatterns = { "/member/list.do" })
public class MemberListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
		HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");//POST방식에서만 적용이 된다.
		response.setContentType("text/html;charset=euc-kr");
		//1.요청정보추출
		System.out.println("서블릿");
		//2.비지니스메소드 호출
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> memberlist = dao.getMemberList();
		//데이터 공유
		request.setAttribute("memberlist", memberlist);
		System.out.println("ListServlet실행완료");	
		System.out.println("dao=>"+memberlist.size());
		//2. 요청재지정 
		RequestDispatcher rd = 
			request.getRequestDispatcher("/member/list.jsp");
		rd.forward(request, response);
		
	}
}
