package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDAO;
import dept.DeptDAOImpl;

@WebServlet(name = "member/delete", urlPatterns = { "/member/delete.do" })
public class MemberDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		//1.요청정보추출
		PrintWriter del = response.getWriter();
		System.out.println("서블릿");
		String id = request.getParameter("id");
		//2.비지니스메소드 호출
		MemberDAO dao = new MemberDAO();
		int result = 0;
		result = dao.delete(id);
		System.out.println("DeleteServlet실행완료");
		//3.요청재지정
		response.sendRedirect("/serverweb/member/list.do");	
	}
}
